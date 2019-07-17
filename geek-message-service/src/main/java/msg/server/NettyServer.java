package msg.server;

import com.google.common.util.concurrent.ExecutionError;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;

import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import msg.server.handler.MsgRequestHandler;


import java.util.Date;


public class NettyServer {

    public void run(int port) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap
                    .group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    //  设置当服务端线程全满的时候，用于临时存放已完成的3次握手的请求队列的最大长度
                    //  如果没设置，或设置的值小于1，则默认值为50
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    //  是否启用心跳保活机制。在双方TCP套接字建立连接后（即都进入ESTABLISHED状态）
                    //  并且在两个小时左右上层没有任何数据传输的情况下，这套机制才会被激活。
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    //   在TCP/IP协议中，无论发送多少数据，总是要在数据前面加上协议头，
                    //   同时，对方接收到数据，也需要发送ACK表示确认。
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast("http-codec", new HttpServerCodec());
                            ch.pipeline().addLast("aggregator", new HttpObjectAggregator(1024));// http消息的组装
                            ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());// WebScoket 的支持
                            // 用于处理websocket, /ws为访问websocket时的uri
                            ch.pipeline().addLast("webSocketServerProtocolHandler", new WebSocketServerProtocolHandler("/ws"));
                            ch.pipeline().addLast(new MsgRequestHandler());
                        }
                    });

            bind(serverBootstrap, port);
        } catch (Exception e){
            System.out.println("---client 退出异常 ---");
        }
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + " : 端口[ " + port + " ] 绑定成功！");
            } else {
                System.out.println("端口{ " + port + " ] 绑定失败！");
            }
        });
    }
}
