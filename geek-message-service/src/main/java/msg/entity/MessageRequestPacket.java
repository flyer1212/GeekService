package msg.entity;

import lombok.Data;

@Data
public class MessageRequestPacket {


    /**
     * 1 标识 登录
     * 2.给客服发送消息
     */
    private int commandType;

    // 消息发送方的用户名和id
    private String fromUserId;
    private String fromUserName;

    // 消息接收方的用户名和id
    private String toUserId;
    private String toUserName;

    private String message;

}
