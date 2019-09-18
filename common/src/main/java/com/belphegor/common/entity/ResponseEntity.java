package com.belphegor.common.entity;

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
        responseEntity.code = 0;
        responseEntity.message = "success";
        responseEntity.data = data;
        return responseEntity;
    }
}
