package msg.attribute;


import io.netty.util.AttributeKey;
import msg.session.Session;

public interface Attributes {
    // 客户端登录成功标志位

    // 使用session 后注释掉这个了
   // AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
