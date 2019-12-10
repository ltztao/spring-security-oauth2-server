package com.example.oauth2.model;

public class CodeMessage<T> {
    private int code;
    private String msg;
    private T data;

    public static final int LOGIN_FAILURE_CODE = 20005;


    public static CodeMessage AccessDenied = new CodeMessage(20003,"权限拒绝");
    public static CodeMessage NoLogin = new CodeMessage(20004,"未登录");
    public static CodeMessage LoginFailure = new CodeMessage(20005,"登录失败");
    public static CodeMessage LoginExpired = new CodeMessage(20006,"登录过期");
    public static CodeMessage LoginSuccess = new CodeMessage(2007,"登录成功");
    public static CodeMessage LogoutSuccess = new CodeMessage(2008,"登出成功");

    public static CodeMessage ERROR = new CodeMessage(-1,"系统异常");
    public static CodeMessage SUCCESS = new CodeMessage(200,"处理成功");

    public static CodeMessage SUCCESS(Object obj) {
        return new CodeMessage<>(200,"处理成功", obj);
    }

    public CodeMessage(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public CodeMessage(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
