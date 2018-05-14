package com.cn.wctx.model;

/**
 * Created by chuyoule on 2017/4/10.
 */
public class Resp {
    private Integer status;
    private String error;
    private Object msg;

    public Resp(Integer status, Object data) {
        this.status = status;
        this.msg = data;
    }

    public Resp(Integer status, String error) {
        this.status = status;
        this.error = error;
    }

    public Resp() {

    }

    public static final Integer SUCCESS = 1;
    public static final Integer FAILD = 0;

    public static Resp showSuccess(Object data) {
        Resp resp = new Resp(SUCCESS, data);
        return resp;
    }

    public static Resp showSuccess() {
        Resp resp = new Resp(SUCCESS, "");
        return resp;
    }

    public static Resp showFaild(Object data) {
        return new Resp(FAILD, data);
    }

    public static Resp showFaild(String error) {
        return showFaild(error, false);
    }

    public static Resp showFaild(String error, Boolean needLog) {
        return new Resp(FAILD, error);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    /*查找上层调用类，拼接error详情*/
    private static String getSuperErrorInfo(String error) {
        StackTraceElement stack[] = Thread.currentThread().getStackTrace();
        StackTraceElement element = stack[3];
        if (element == null) {
            return error;
        }
        StringBuffer callName = new StringBuffer();
        callName.append(element.getClassName());
        callName.append("[");
        callName.append(element.getLineNumber());
        callName.append("]: ");
        callName.append(error);
        return callName.toString();
    }
}
