package com.raytine.message.controller;


import com.raytine.message.vo.Resp;
import com.raytine.message.vo.RespFactory;

import static com.raytine.message.constants.CoreConstant.*;

public class BaseController {

    public static <T> Resp<T> success(T data){
        return RespFactory.createResp(SUCCESS_CODE,SUCCESS_MSG,data);
    }

    public static Resp<Void> fail(){
        return RespFactory.createVoidResp(FAIL_CODE,FAIL_MSG);
    }

    public static <T> Resp<T> customer(int code,String mes,T data){
        return RespFactory.createResp(code,mes,data);
    }
}
