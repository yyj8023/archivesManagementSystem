package com.archivesManagementSystem.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 日常操作记录表，主要用于记录增加、修改、删除认定表的更新前和更新后每一个字段内容。不做太详细的记录（因为没给钱）(OrdinaryOperateLog)实体类
 *
 * @author makejava
 * @since 2021-01-27 23:32:33
 */
public class OrdinaryOperateLog implements Serializable {
    private static final long serialVersionUID = -22019719523819698L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 员工ID
    */
    private Integer employeeId;
    /**
    * 员工姓名
    */
    private String employeeName;
    /**
    * 操作的数据表名称
    */
    private String checkTableName;
    /**
    * 更新的字段
    */
    private String checkColumnName;
    /**
    * 字段旧值
    */
    private String oldValue;
    /**
    * 字段新值
    */
    private String newValue;
    /**
    * 操作类型（新增、修改、删除）
    */
    private String operateType;
    /**
    * 操作人
    */
    private String operator;
    /**
    * 操作时间
    */
    @JsonFormat(pattern="yyyy-MM-dd hh:MM:ss",timezone="GMT+8")
    private Date operateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCheckTableName() {
        return checkTableName;
    }

    public void setCheckTableName(String checkTableName) {
        this.checkTableName = checkTableName;
    }

    public String getCheckColumnName() {
        return checkColumnName;
    }

    public void setCheckColumnName(String checkColumnName) {
        this.checkColumnName = checkColumnName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

}