package com.archivesManagementSystem.springboot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 学位学历信息详细表(EducationInfo)实体类
 *
 * @author makejava
 * @since 2021-01-20 22:15:04
 */
public class EducationInfo implements Serializable {
    private static final long serialVersionUID = -73540393479813199L;
    /**
    * 员工ID
    */
    private Integer employeeId;
    /**
    * 员工姓名
    */
    private String employeeName;
    /**
    * 最高学位
    */
    private String educationDegree;
    /**
    * 最高学历
    */
    private String educationBackgroud;
    /**
    * 学历问题分类
    */
    private String educationProblemCategory;
    /**
    * 学历问题描述
    */
    private String educationProblemDetail;
    /**
    * 学历认定结果描述
    */
    private String educationCheckResult;
    /**
    * 最高学历认定
    */
    private String educationBackgroudJudgment;
    /**
    * 最高学位认定
    */
    private String educationDegreeeJudgment;
    /**
    * 学历小结
    */
    private String educationRemark;
    
    private String updateBy;
    
    private Date updateTime;


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

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getEducationBackgroud() {
        return educationBackgroud;
    }

    public void setEducationBackgroud(String educationBackgroud) {
        this.educationBackgroud = educationBackgroud;
    }

    public String getEducationProblemCategory() {
        return educationProblemCategory;
    }

    public void setEducationProblemCategory(String educationProblemCategory) {
        this.educationProblemCategory = educationProblemCategory;
    }

    public String getEducationProblemDetail() {
        return educationProblemDetail;
    }

    public void setEducationProblemDetail(String educationProblemDetail) {
        this.educationProblemDetail = educationProblemDetail;
    }

    public String getEducationCheckResult() {
        return educationCheckResult;
    }

    public void setEducationCheckResult(String educationCheckResult) {
        this.educationCheckResult = educationCheckResult;
    }

    public String getEducationBackgroudJudgment() {
        return educationBackgroudJudgment;
    }

    public void setEducationBackgroudJudgment(String educationBackgroudJudgment) {
        this.educationBackgroudJudgment = educationBackgroudJudgment;
    }

    public String getEducationDegreeeJudgment() {
        return educationDegreeeJudgment;
    }

    public void setEducationDegreeeJudgment(String educationDegreeeJudgment) {
        this.educationDegreeeJudgment = educationDegreeeJudgment;
    }

    public String getEducationRemark() {
        return educationRemark;
    }

    public void setEducationRemark(String educationRemark) {
        this.educationRemark = educationRemark;
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