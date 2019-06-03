package user.entity;


import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private String userId;

    private String userName;

    private String password;

    private int sex; // 0 男  1女

    private String major;

    private String idCard;

    private String mobilePhone;

    private String wechat;

    private String qqNumber;

    private String registerTime;
}
