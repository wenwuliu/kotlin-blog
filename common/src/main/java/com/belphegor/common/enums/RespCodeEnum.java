package com.belphegor.common.enums;

public enum RespCodeEnum {
    SUCCESS(0,"处理成功"),
    LOGINFAILED(-4,"登录失败"),
    UNAUTHORIZED(-1,"token验证失败"),
    INVALIDPARAM(-2,"参数校验失败"),
    DEALFAILED(-3,"处理失败");
    int code;
    String message;

    RespCodeEnum(int code,String message){
        this.code = code;
        this.message = message;
    }

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
}
