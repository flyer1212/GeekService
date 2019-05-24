package com.geek.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignedTaskPrimaryKey implements Serializable {

    private String userId;

    private String taskId;
}
