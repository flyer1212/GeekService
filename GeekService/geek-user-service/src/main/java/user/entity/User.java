package user.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UUID userId;

    private String userName;

    private String password;

    private int sex;

    private String major;

    private String idCard;

    private String mobilePhone;

    private String wechat;

    private String qqNumber;

    private String registerTime;


}
