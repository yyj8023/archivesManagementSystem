package com.archivesManagementSystem.springboot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 工作经历信息认定表(WorkExperienceInfo)实体类
 *
 * @author makejava
 * @since 2021-01-27 23:33:11
 */
public class WorkExperienceInfo implements Serializable {
    private static final long serialVersionUID = 452581834248924198L;
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
    * 工作经历问题描述
    */
    private String workExperienceProblemDetail;
    /**
    * 工作经历问题分类
    */
    private String workExperienceProblemCategory;
    /**
    * 工作经历认定结果描述
    */
    private String workExperienceCheckResult;
    /**
    * 工作经历小结
    */
    private String workExperienceRemark;
    
    private String updateBy;
    
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

    public String getWorkExperienceProblemDetail() {
        return workExperienceProblemDetail;
    }

    public void setWorkExperienceProblemDetail(String workExperienceProblemDetail) {
        this.workExperienceProblemDetail = workExperienceProblemDetail;
    }

    public String getWorkExperienceProblemCategory() {
        return workExperienceProblemCategory;
    }

    public void setWorkExperienceProblemCategory(String workExperienceProblemCategory) {
        this.workExperienceProblemCategory = workExperienceProblemCategory;
    }

    public String getWorkExperienceCheckResult() {
        return workExperienceCheckResult;
    }

    public void setWorkExperienceCheckResult(String workExperienceCheckResult) {
        this.workExperienceCheckResult = workExperienceCheckResult;
    }

    public String getWorkExperienceRemark() {
        return workExperienceRemark;
    }

    public void setWorkExperienceRemark(String workExperienceRemark) {
        this.workExperienceRemark = workExperienceRemark;
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