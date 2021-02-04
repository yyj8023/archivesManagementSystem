package com.archivesManagementSystem.springboot.util;

public class GeneralResult implements Result {
    private static final long serialVersionUID = -940139127925466172L;
    private String msg;
    private String code;
    private boolean success = false;
    private int totalCount;
    private int current;
    private Object data;
    private Object idData;

    public GeneralResult() {
    }

    public GeneralResult(boolean succ) {
        this.success = succ;
    }

    public void setSuccess(boolean ok) {
        this.success = ok;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrent() {
        return this.current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getIdData() {
        return this.idData;
    }

    public void setIdData(Object idData) {
        this.idData = idData;
    }

}
