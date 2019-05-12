package user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

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
