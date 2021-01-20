package com.archivesManagementSystem.springboot.entity;

import java.io.Serializable;

/**
 * 系统用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2021-01-20 22:03:31
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 861249816588495580L;
    /**
    * 用户id
    */
    private Integer id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 用户密码
    */
    private String userPassword;
    /**
    * 用户角色
    */
    private String userRole;
    /**
    * 用户状态是否可用
    */
    private Boolean userFlag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Boolean getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(Boolean userFlag) {
        this.userFlag = userFlag;
    }

}