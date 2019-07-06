package com.geek.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserTask")
public class UserTask implements Serializable {

    private static final long serialVersionUID = -2475842737089120820L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "IdStrategy")
    @GenericGenerator(name = "IdStrategy", strategy = "identity")
    private int id;

    @Column(name = "taskId")
    private String taskId;


    @Column(name = "userId")
    private String userId;  // 创建者

    @Column(name = "userName")
    private String userName;  // 创建者

    @Column(name = "taskTitle")
    private String taskTitle;

    // 1开发团队 2 开发任务 3 知识交流 4 家教 5 其它
    @Column(name = "taskType")
    private String taskType;

    // 1. 全部状态 2 招募中 3 报名截止
    @Column(name = "taskState")
    private Integer taskState;

    @Column(name = "taskRequire")
    private String taskRequire;

    @Column(name = "taskDescribe")
    private String taskDescribe;

    @Column(name = "reward")
    private Integer reward;

    @Column(name = "taskEndTime")
    private Date taskEndTime;

    @Column(name = "taskSubmitTime")
    private Date taskSubmitTime;

}
