package com.vuebg.admin.exception;

/**
 * 自定义异常
 * @author suphowe
 * @date 2018-12-12
 */
public class DefinitionException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public DefinitionException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public DefinitionException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public DefinitionException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public DefinitionException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
