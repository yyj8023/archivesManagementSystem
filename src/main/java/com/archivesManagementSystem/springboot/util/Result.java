package com.archivesManagementSystem.springboot.util;

import java.io.Serializable;

public interface Result extends Serializable {
    void setSuccess(boolean var1);

    boolean isSuccess();

    String getMsg();

    void setMsg(String var1);

    Object getData();

    void setData(Object var1);
}
