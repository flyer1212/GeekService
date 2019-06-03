package com.geek.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSignedInfo {
    private Date taskSubmitTime;
    private String userName;
    private int sex; // 0 男  1女
    private String major;
    private String qqNumber;
    private String reason;
}
