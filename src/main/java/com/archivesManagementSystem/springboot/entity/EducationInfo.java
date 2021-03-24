package com.archivesManagementSystem.springboot.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 学位学历信息详细表(EducationInfo)实体类
 *
 * @author makejava
 * @since 2021-01-27 23:32:14
 */
public class EducationInfo implements Serializable {
    private static final long serialVersionUID = 495458996571285429L;
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
    * 最高学位
    */
    //@Excel(name = "最高学位")
    private String educationDegree;
    /**
    * 最高学历
    */
    //@Excel(name = "最高学历")
    private String educationBackgroud;
    /**
    * 学历问题分类
    */
    @Excel(name = "学历问题分类")
    private String educationProblemCategory;
    /**
    * 学历问题描述
    */
    @Excel(name = "学历问题描述")
    private String educationProblemDetail;
    /**
    * 学历认定结果描述
    */
    @Excel(name = "学历认定结果描述")
    private String educationCheckResult;
    /**
    * 最高学历认定
    */
    @Excel(name = "最高学历认定")
    private String educationBackgroudJudgment;
    /**
    * 最高学位认定
    */
    @Excel(name = "最高学位认定")
    private String educationDegreeeJudgment;
    /**
     * 最高学历
     */
    @Excel(name = "最高学历")
    private String highestEducation;
    /**
     * 最高学位
     */
    @Excel(name = "最高学位")
    private String highestDegree;
    /**
     * 次高学历
     */
    @Excel(name = "次高学历")
    private String highestEducationSecond;
    /**
     * 次高学位
     */
    @Excel(name = "次高学位")
    private String highestDegreeSecond;
    /**
     * 第三高学历
     */
    @Excel(name = "第三高学历")
    private String highestEducationThird;
    /**
     * 第三高学位
     */
    @Excel(name = "第三高学位")
    private String highestDegreeThird;

    @Excel(name = "学历小结")
    private String educationRemark;

    /**
     * 学历小结
     */
    @Excel(name="学历模块是否有问题")
    private String educationHaveProblem;

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

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public String getHighestEducationSecond() {
        return highestEducationSecond;
    }

    public void setHighestEducationSecond(String highestEducationSecond) {
        this.highestEducationSecond = highestEducationSecond;
    }

    public String getHighestDegreeSecond() {
        return highestDegreeSecond;
    }

    public void setHighestDegreeSecond(String highestDegreeSecond) {
        this.highestDegreeSecond = highestDegreeSecond;
    }

    public String getHighestEducationThird() {
        return highestEducationThird;
    }

    public void setHighestEducationThird(String highestEducationThird) {
        this.highestEducationThird = highestEducationThird;
    }

    public String getHighestDegreeThird() {
        return highestDegreeThird;
    }

    public void setHighestDegreeThird(String highestDegreeThird) {
        this.highestDegreeThird = highestDegreeThird;
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

    public String getEducationHaveProblem() {
        return educationHaveProblem;
    }

    public void setEducationHaveProblem(String educationHaveProblem) {
        this.educationHaveProblem = educationHaveProblem;
    }
}