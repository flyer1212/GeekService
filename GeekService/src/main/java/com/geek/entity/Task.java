package com.geek.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select uuid()")
    private String task_id;
    private String u_id;
    private String taskTitle;
    private String taskType;
    private String taskRequire;
    private String taskDescribe;
    private Integer reward;
    private Integer taskState;
    private Date taskEndTime;
    private Date taskSubmitTime;

}
