package com.belphegor.common.entity;

import com.belphegor.common.enums.RespCodeEnum;

import java.io.Serializable;

public class ResponseEntity implements Serializable {
    private static final long serialVersionUID = -4705814091010712140L;
    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseEntity success(Object data){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.code = RespCodeEnum.SUCCESS.getCode();
        responseEntity.message = RespCodeEnum.SUCCESS.getMessage();
        responseEntity.data = data;
        return responseEntity;
    }

    public static ResponseEntity success(){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.code = RespCodeEnum.SUCCESS.getCode();
        responseEntity.message = RespCodeEnum.SUCCESS.getMessage();
        return responseEntity;
    }

    public static ResponseEntity failed(RespCodeEnum respCodeEnum,Object o){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.code = respCodeEnum.getCode();
        responseEntity.message = respCodeEnum.getMessage();
        responseEntity.data = o;
        return responseEntity;
    }

    public static ResponseEntity failed(RespCodeEnum respCodeEnum){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.code = respCodeEnum.getCode();
        responseEntity.message = respCodeEnum.getMessage();
        return responseEntity;
    }

}
