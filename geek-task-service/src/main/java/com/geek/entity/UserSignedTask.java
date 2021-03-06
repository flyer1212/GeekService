package com.geek.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserSignedTask")
public class UserSignedTask implements Serializable {


    private static final long serialVersionUID = 7432028413928815673L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "IdStrategy")
    @GenericGenerator(name = "IdStrategy", strategy = "identity")
    private int id;

    @Column(name = "signedId")
    private String signedId;

    @Column(name = "userId")
    private String userId;


    @Column(name = "taskId")
    private String taskId;

    @Column(name = "reason")
    private String reason; // 报名原因

    @Column(name = "submitTime")
    private Date  submitTime; // 报名时间

    @Column(name = "signedPeopleNum")
    private int  signedPeopleNum; // 报名人数  去了个巧
}
