package com.archivesManagementSystem.springboot.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (EducationDetailInfo)实体类
 *
 * @author makejava
 * @since 2021-03-07 17:12:28
 */
public class EducationDetailInfo implements Serializable {
    private static final long serialVersionUID = -80639706422432371L;
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
    /**
    * 最后的更新人
    */
    private String updateBy;
    /**
    * 更新时间
    */
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