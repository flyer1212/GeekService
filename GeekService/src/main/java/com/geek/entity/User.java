package com.geek.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select uuid()")
    private String u_id;
    private String name;
    private String password;
    private Integer sex;
    private String major;
    private String idCard;
    private String mobilePhone;
    private String wechat;
    private String qqNumber;
    private Date registerTime;
    private Date lastLoginTime;


}
