package com.archivesManagementSystem.springboot.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 出生日期信息认定表(BirthdayInfo)实体类
 *
 * @author makejava
 * @since 2021-01-27 23:31:38
 */
public class BirthdayInfo implements Serializable {
    private static final long serialVersionUID = -96184375331934118L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 员工ID
    */
    @Excel(name = "员工ID")
    private Integer employeeId;
    /**
    * 员工姓名
    */
    @Excel(name = "员工姓名")
    private String employeeName;
    /**
    * 身份证中的出生日期
    */
    @Excel(name = "身份证中的出生日期")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date birthdayCard;
    /**
    * 档案中的出生日期
    */
    @Excel(name = "档案中的出生日期")
    private Date birthdayArchives;
    /**
    * 认定出生日期
    */
    @Excel(name = "认定出生日期")
    private Date birthdayJudgment;
    /**
    * 出生日期问题描述
    */
    @Excel(name = "出生日期问题描述")
    private String birthdayProblemDetail;
    /**
    * 出生日期认定结果描述
    */
    @Excel(name = "出生日期认定结果描述")
    private String birthdayCheckResult;
    /**
    * 出生日期问题分类
    */
    @Excel(name = "出生日期问题分类")
    private String birthdayProblemCategory;
    /**
    * 出生日期认定规则
    */
    @Excel(name = "出生日期认定规则")
    private String birthdayCheckRule;
    /**
    * 出生日期小结
    */
    @Excel(name = "出生日期小结")
    private String birthdayCheckRemark;

    @Excel(name = "更新人")
    private String updateBy;

    @Excel(name = "更新时间")
    @JsonFormat(pattern="yyyy-MM-dd hh:MM:ss",timezone="GMT+8")
    private Date updateTime;


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

    public Date getBirthdayCard() {
        return birthdayCard;
    }

    public void setBirthdayCard(Date birthdayCard) {
        this.birthdayCard = birthdayCard;
    }

    public Date getBirthdayArchives() {
        return birthdayArchives;
    }

    public void setBirthdayArchives(Date birthdayArchives) {
        this.birthdayArchives = birthdayArchives;
    }

    public Date getBirthdayJudgment() {
        return birthdayJudgment;
    }

    public void setBirthdayJudgment(Date birthdayJudgment) {
        this.birthdayJudgment = birthdayJudgment;
    }

    public String getBirthdayProblemDetail() {
        return birthdayProblemDetail;
    }

    public void setBirthdayProblemDetail(String birthdayProblemDetail) {
        this.birthdayProblemDetail = birthdayProblemDetail;
    }

    public String getBirthdayCheckResult() {
        return birthdayCheckResult;
    }

    public void setBirthdayCheckResult(String birthdayCheckResult) {
        this.birthdayCheckResult = birthdayCheckResult;
    }

    public String getBirthdayProblemCategory() {
        return birthdayProblemCategory;
    }

    public void setBirthdayProblemCategory(String birthdayProblemCategory) {
        this.birthdayProblemCategory = birthdayProblemCategory;
    }

    public String getBirthdayCheckRule() {
        return birthdayCheckRule;
    }

    public void setBirthdayCheckRule(String birthdayCheckRule) {
        this.birthdayCheckRule = birthdayCheckRule;
    }

    public String getBirthdayCheckRemark() {
        return birthdayCheckRemark;
    }

    public void setBirthdayCheckRemark(String birthdayCheckRemark) {
        this.birthdayCheckRemark = birthdayCheckRemark;
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