package com.xy.t_net.bean;

public class CommonResult {


    /**
     * code : 0
     * body : null
     * message : success
     */

    private int code;
    private Object body;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
