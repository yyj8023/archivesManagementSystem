package com.archivesManagementSystem.springboot.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 入党时间信息认定表(JoinPartyTimeInfo)实体类
 *
 * @author makejava
 * @since 2021-01-27 23:32:23
 */
public class JoinPartyTimeInfo implements Serializable {
    private static final long serialVersionUID = -32724639815683385L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 员工ID
    */
    @Excel(name = "员工ID")
    private String employeeId;
    /**
    * 员工姓名
    */
    @Excel(name = "员工姓名")
    private String employeeName;
    /**
    * 入党时间
    */
    @Excel(name = "入党时间",exportFormat = "yyyy/MM/dd")
    private Date joinPartyTime;
    /**
    * 入党介绍人
    */
    @Excel(name = "入党介绍人")
    private String joinPartyIntroducer;
    /**
    * 入团时间
    */
    @Excel(name = "入团时间",exportFormat = "yyyy/MM/dd")
    private Date joinGroupTime;
    /**
    * 入党时间问题描述
    */
    @Excel(name = "入党时间问题描述")
    private String joinPartyTimeProblemDetail;
    /**
    * 入党时间认定结果描述
    */
    @Excel(name = "入党时间认定结果描述")
    private String joinPartyTimeCheckResult;
    /**
    * 入党时间调研情况
    */
    @Excel(name = "入党时间调研情况")
    private String joinPartyTimeResearchSituation;
    /**
    * 入党时间小结
    */
    @Excel(name = "入党时间小结")
    private String joinPartyTimeRemark;

    //@Excel(name = "更新人")
    private String updateBy;

    //@Excel(name = "更新时间",exportFormat = "yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    int start;
    int size;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getJoinPartyTime() {
        return joinPartyTime;
    }

    public void setJoinPartyTime(Date joinPartyTime) {
        this.joinPartyTime = joinPartyTime;
    }

    public String getJoinPartyIntroducer() {
        return joinPartyIntroducer;
    }

    public void setJoinPartyIntroducer(String joinPartyIntroducer) {
        this.joinPartyIntroducer = joinPartyIntroducer;
    }

    public Date getJoinGroupTime() {
        return joinGroupTime;
    }

    public void setJoinGroupTime(Date joinGroupTime) {
        this.joinGroupTime = joinGroupTime;
    }

    public String getJoinPartyTimeProblemDetail() {
        return joinPartyTimeProblemDetail;
    }

    public void setJoinPartyTimeProblemDetail(String joinPartyTimeProblemDetail) {
        this.joinPartyTimeProblemDetail = joinPartyTimeProblemDetail;
    }

    public String getJoinPartyTimeCheckResult() {
        return joinPartyTimeCheckResult;
    }

    public void setJoinPartyTimeCheckResult(String joinPartyTimeCheckResult) {
        this.joinPartyTimeCheckResult = joinPartyTimeCheckResult;
    }

    public String getJoinPartyTimeResearchSituation() {
        return joinPartyTimeResearchSituation;
    }

    public void setJoinPartyTimeResearchSituation(String joinPartyTimeResearchSituation) {
        this.joinPartyTimeResearchSituation = joinPartyTimeResearchSituation;
    }

    public String getJoinPartyTimeRemark() {
        return joinPartyTimeRemark;
    }

    public void setJoinPartyTimeRemark(String joinPartyTimeRemark) {
        this.joinPartyTimeRemark = joinPartyTimeRemark;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}