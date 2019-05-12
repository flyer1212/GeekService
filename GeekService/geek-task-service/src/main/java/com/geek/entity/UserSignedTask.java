package com.geek.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserSignedTask")
public class UserSignedTask {


    @Id
    @Column(name = "signedId")
    @GeneratedValue(generator = "IdStrategy")
    @GenericGenerator(name = "IdStrategy", strategy = "assigned")
    private String signedId;


    @Column(name = "userId")
    private String userId;

    @Column(name = "taskId")
    private String taskId;

    @Column(name = "reason")
    private String reason; // 报名原因

    @Column(name = "submitTime")
    private Date  submitTime; // 报名时间
}
