package com.raytine.message.vo;

import lombok.Data;

@Data
public class Resp<T> {

    private int code;
    private String message;
    private T data;
}
