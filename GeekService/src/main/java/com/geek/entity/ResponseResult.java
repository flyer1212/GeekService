package com.geek.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {
    private boolean statusCode;
    private String msg;
    private List<T> objectList;
}
