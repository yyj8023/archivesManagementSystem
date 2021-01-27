package com.archivesManagementSystem.springboot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 学历学位信息认定表(EducationCareerInfo)实体类
 *
 * @author makejava
 * @since 2021-01-27 23:32:05
 */
public class EducationCareerInfo implements Serializable {
    private static final long serialVersionUID = -63376157672846408L;
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
    * 大专学校
    */
    private String associateSchool;
    /**
    * 大专学院
    */
    private String associateCollege;
    /**
    * 大专专业
    */
    private String associateMajor;
    /**
    * 大专学历
    */
    private String associateCareer;
    /**
    * 大专学位
    */
    private String associateDegree;
    /**
    * 本科学校
    */
    private String undergraduateSchool;
    /**
    * 本科学院
    */
    private String undergraduateCollege;
    /**
    * 本科专业
    */
    private String undergraduateMajor;
    /**
    * 本科第二专业
    */
    private String undergraduateMajorSecond;
    /**
    * 本科学历
    */
    private String undergraduateCareer;
    /**
    * 本科学位
    */
    private String undergraduateDegree;
    /**
    * 本科第二学位
    */
    private String undergraduateDegreeSecond;
    /**
    * 硕士学校
    */
    private String masterSchool;
    /**
    * 硕士学院
    */
    private String masterCollege;
    /**
    * 硕士专业
    */
    private String masterMajor;
    /**
    * 硕士学历
    */
    private String masterCareer;
    /**
    * 硕士学位
    */
    private String masterDegree;
    /**
    * 博士学校
    */
    private String phdSchool;
    /**
    * 博士学院
    */
    private String phdCollege;
    /**
    * 博士专业
    */
    private String phdMajor;
    /**
    * 博士学历
    */
    private String phdCareer;
    /**
    * 博士学位
    */
    private String phdDegree;
    /**
    * 最新的更新人
    */
    private String updateBy;
    /**
    * 更新时间
    */
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

    public String getAssociateSchool() {
        return associateSchool;
    }

    public void setAssociateSchool(String associateSchool) {
        this.associateSchool = associateSchool;
    }

    public String getAssociateCollege() {
        return associateCollege;
    }

    public void setAssociateCollege(String associateCollege) {
        this.associateCollege = associateCollege;
    }

    public String getAssociateMajor() {
        return associateMajor;
    }

    public void setAssociateMajor(String associateMajor) {
        this.associateMajor = associateMajor;
    }

    public String getAssociateCareer() {
        return associateCareer;
    }

    public void setAssociateCareer(String associateCareer) {
        this.associateCareer = associateCareer;
    }

    public String getAssociateDegree() {
        return associateDegree;
    }

    public void setAssociateDegree(String associateDegree) {
        this.associateDegree = associateDegree;
    }

    public String getUndergraduateSchool() {
        return undergraduateSchool;
    }

    public void setUndergraduateSchool(String undergraduateSchool) {
        this.undergraduateSchool = undergraduateSchool;
    }

    public String getUndergraduateCollege() {
        return undergraduateCollege;
    }

    public void setUndergraduateCollege(String undergraduateCollege) {
        this.undergraduateCollege = undergraduateCollege;
    }

    public String getUndergraduateMajor() {
        return undergraduateMajor;
    }

    public void setUndergraduateMajor(String undergraduateMajor) {
        this.undergraduateMajor = undergraduateMajor;
    }

    public String getUndergraduateMajorSecond() {
        return undergraduateMajorSecond;
    }

    public void setUndergraduateMajorSecond(String undergraduateMajorSecond) {
        this.undergraduateMajorSecond = undergraduateMajorSecond;
    }

    public String getUndergraduateCareer() {
        return undergraduateCareer;
    }

    public void setUndergraduateCareer(String undergraduateCareer) {
        this.undergraduateCareer = undergraduateCareer;
    }

    public String getUndergraduateDegree() {
        return undergraduateDegree;
    }

    public void setUndergraduateDegree(String undergraduateDegree) {
        this.undergraduateDegree = undergraduateDegree;
    }

    public String getUndergraduateDegreeSecond() {
        return undergraduateDegreeSecond;
    }

    public void setUndergraduateDegreeSecond(String undergraduateDegreeSecond) {
        this.undergraduateDegreeSecond = undergraduateDegreeSecond;
    }

    public String getMasterSchool() {
        return masterSchool;
    }

    public void setMasterSchool(String masterSchool) {
        this.masterSchool = masterSchool;
    }

    public String getMasterCollege() {
        return masterCollege;
    }

    public void setMasterCollege(String masterCollege) {
        this.masterCollege = masterCollege;
    }

    public String getMasterMajor() {
        return masterMajor;
    }

    public void setMasterMajor(String masterMajor) {
        this.masterMajor = masterMajor;
    }

    public String getMasterCareer() {
        return masterCareer;
    }

    public void setMasterCareer(String masterCareer) {
        this.masterCareer = masterCareer;
    }

    public String getMasterDegree() {
        return masterDegree;
    }

    public void setMasterDegree(String masterDegree) {
        this.masterDegree = masterDegree;
    }

    public String getPhdSchool() {
        return phdSchool;
    }

    public void setPhdSchool(String phdSchool) {
        this.phdSchool = phdSchool;
    }

    public String getPhdCollege() {
        return phdCollege;
    }

    public void setPhdCollege(String phdCollege) {
        this.phdCollege = phdCollege;
    }

    public String getPhdMajor() {
        return phdMajor;
    }

    public void setPhdMajor(String phdMajor) {
        this.phdMajor = phdMajor;
    }

    public String getPhdCareer() {
        return phdCareer;
    }

    public void setPhdCareer(String phdCareer) {
        this.phdCareer = phdCareer;
    }

    public String getPhdDegree() {
        return phdDegree;
    }

    public void setPhdDegree(String phdDegree) {
        this.phdDegree = phdDegree;
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