package msg.util;

import io.netty.channel.Channel;
import msg.attribute.Attributes;
import msg.session.Session;


import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class SessionUtil {

    /**
     * 我们这里只有客服和用户之间的聊天
     * userId -> channel 的映射
     */
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentSkipListMap<>();

    // 把session  和 channel 绑定
    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    // 用户退出，既要清除map, 也要在channel 上移除
    public static void unBindSession(Channel channel) {
        Session session = getSession(channel);
        userIdChannelMap.remove(getSession(channel).getUserId());
        channel.attr(Attributes.SESSION).set(null);
        System.out.println(session + " 退出登录！");
    }

    public static Session getSession(Channel channel) {
        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId) {
        return userIdChannelMap.get(userId);
    }


}
