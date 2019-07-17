package msg.server.handler;

import com.google.gson.Gson;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import msg.entity.MessageRequestPacket;
import msg.session.Session;
import msg.util.SessionUtil;

import java.time.LocalDateTime;

/**
 * WebSocket在 6中帧里面发送数据
 * CloseWebSocketFrame
 * PingWebSocketFrame
 * PongWebSocketFrame
 * TextWebSocketFrame
 * <p>
 * 只需要处理TextWebSocketFrame ，其他的由 WebSocketServerProtocolHandler  自动处理
 */
@ChannelHandler.Sharable
public class MsgRequestHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        // ui 发送数据的格式
//      "{'commandType': '1','fromUserId':'" +
//            userId +
//            "','fromUserName':'I am tom'}"

//        /127.0.0.1:59165:{'toUserId':'12233','message':'hello sdsw'}
//        hello sdsw
//       来自服务端：2019-07-16T20:19:32.619   web控制台显示
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + ":" + msg.text());

        Gson gson = new Gson();
        MessageRequestPacket mrp = gson.fromJson(msg.text(), MessageRequestPacket.class);

        if (mrp.getCommandType() == 1) { // 登录 用户的id, 用户名
            Session session = new Session(mrp.getFromUserId().split("-")[0], mrp.getFromUserName());
            // 把用户的消息和channle 绑定在一起
            SessionUtil.bindSession(session, channel);


            channel.writeAndFlush(new TextWebSocketFrame("{ \"status\" :\"1\", \"message\" :\"success\"}"));


            // 测试通过id 拿channel ,结果是可以的
//            Channel channel1 = SessionUtil.getChannel(mrp.getFromUserId().split("-")[0]);
//            channel1.writeAndFlush(new TextWebSocketFrame("{'status':'2','message':'success'}"));

            System.out.println(" ------登录成功-----");
        } else { // 发送消息的  toUserId  和 message
            String toUserId = mrp.getToUserId().split("-")[0];
            String message = mrp.getMessage();

            Channel toUserChannel = SessionUtil.getChannel(toUserId);
            toUserChannel.writeAndFlush(new TextWebSocketFrame("{ \"status\" : \"1\", \"message\" : "+ "\""+message+"\"}"));
            System.out.println("----消息已经发送到对方-----");
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
        System.out.println("----- 出现异常 ------");
    }
}
