package com.archivesManagementSystem.springboot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 业务流程操作记录表，用于记录该员工哪些认定步骤已走完。(ProcessOperateLog)实体类
 *
 * @author makejava
 * @since 2021-01-27 23:32:54
 */
public class ProcessOperateLog implements Serializable {
    private static final long serialVersionUID = 431890288096042828L;
    /**
    * 操作流程记录ID号
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
    * 当前操作状态（日期认定..)
    */
    private String operateState;
    /**
    * 操作人
    */
    private String operator;
    /**
    * 操作时间
    */
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

    public String getOperateState() {
        return operateState;
    }

    public void setOperateState(String operateState) {
        this.operateState = operateState;
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