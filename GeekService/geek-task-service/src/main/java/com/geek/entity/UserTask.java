package com.geek.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserTask")
public class UserTask {

    @Id
    @Column(name = "taskId")
    private String taskId;
//    @GeneratedValue(generator  = "IdStrategy")
//    @GenericGenerator(name = "IdStrategy", strategy = "assigned")


    @Column(name = "userId")
    private String userId;  // 创建者

    @Column(name = "taskTitle")
    private String taskTitle;

    @Column(name = "taskType")
    private String taskType;

    @Column(name = "taskRequire")
    private String taskRequire;

    @Column(name = "taskDescribe")
    private String taskDescribe;

    @Column(name = "reward")
    private Integer reward;

    @Column(name = "taskState")
    private Integer taskState;

    @Column(name = "taskEndTime")
    private Date taskEndTime;

    @Column(name = "taskSubmitTime")
    private Date taskSubmitTime;

}
