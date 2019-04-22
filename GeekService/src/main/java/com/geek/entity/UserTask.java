package com.geek.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTask {
    private String u_id;
    private String task_id;
    private String reason;
    private Date  submitTime;
}
