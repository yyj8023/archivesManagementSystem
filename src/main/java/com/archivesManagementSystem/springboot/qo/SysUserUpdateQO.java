package com.archivesManagementSystem.springboot.qo;

/**
 * 用于用户修改密码
 */
public class SysUserUpdateQO {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 旧的用户密码
     */
    private String oldUserPassword;
    /**
     * 新的用户密码
     */
    private String newUserPassword;

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

    public String getOldUserPassword() {
        return oldUserPassword;
    }

    public void setOldUserPassword(String oldUserPassword) {
        this.oldUserPassword = oldUserPassword;
    }

    public String getNewUserPassword() {
        return newUserPassword;
    }

    public void setNewUserPassword(String newUserPassword) {
        this.newUserPassword = newUserPassword;
    }
}
