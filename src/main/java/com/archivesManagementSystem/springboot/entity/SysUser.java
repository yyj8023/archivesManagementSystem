package com.archivesManagementSystem.springboot.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * 系统用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2021-01-20 22:03:31
 */
/**
 * @ExcelTarget限定一个到处实体的注解, 以及一些通用设置, 作用于最外面的实体
 *
 * @Excel注解的字段表示与Excel列映射,不添加此注解不会映射
 *  name:列标题
 *  orderNum:第几列
 *  width:列宽
 *  exportFormat:日期类型格式化，可指定格式（适用于Date类型）
 *  format 时间格式,相当于同时设置了exportFormat 和 importFormat（适用于Date类型）
 *  databaseFormat: 导出时间设置,如果字段是Date类型则不需要设置 数据库如果是string 类型,这个需要设置这个数据库格式,用以转换时间格式输出（适用于String类型）
 *  replace: String[]类型，值得替换  导出是{"男_1", "女_2"} 导入反过来
 *  suffix: 文字后缀,如%  90变成90%
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
    @Excel(name = "姓名")
    private String userName;
    /**
    * 用户密码
    */
    @Excel(name = "密码")
    private String userPassword;
    /**
    * 用户角色
    */
    @Excel(name = "角色")
    private String userRole;
    /**
    * 用户状态是否可用
    */
    @Excel(name = "可用标志")
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