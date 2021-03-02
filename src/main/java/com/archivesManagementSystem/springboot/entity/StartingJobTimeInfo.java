package com.archivesManagementSystem.springboot.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 参加工作时间基本信息认定表(StartingJobTimeInfo)实体类
 *
 * @author makejava
 * @since 2021-01-27 23:33:03
 */
public class StartingJobTimeInfo implements Serializable {
    private static final long serialVersionUID = -99329263722836961L;
    
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
    * 自填工作时间
    */
    @Excel(name = "自填工作时间",exportFormat = "yyyy年MM月dd日")
    private Date startingJobTimeOwn;
    /**
    * 档案材料中有效工作时间
    */
    @Excel(name = "档案材料中有效工作时间",exportFormat = "yyyy年MM月dd日")
    private Date startingJobTimeArchvies;
    /**
    * 参加工作时间认定时间
    */
    @Excel(name = "参加工作时间认定时间",exportFormat = "yyyy年MM月dd日")
    private Date startingJobTimeJudgment;
    /**
    * 参加工作问题描述
    */
    @Excel(name = "参加工作问题描述")
    private String startingJobTimeProblemDetail;
    /**
    * 参加工作时间问题分类
    */
    @Excel(name = "参加工作时间问题分类")
    private String startingJobTimeProblemCategory;
    /**
    * 参加工作时间认定结果描述
    */
    @Excel(name = "参加工作时间认定结果描述")
    private String startingJobTimeCheckResult;
    /**
    * 参加工作时间小结
    */
    @Excel(name = "参加工作时间小结")
    private String startingJobTimeCheckRemark;

    @Excel(name = "更新人")
    private String updateBy;

    @Excel(name = "更新时间",exportFormat = "yyyy年MM月dd日 HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd hh:MM:ss",timezone="GMT+8")
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

    public Date getStartingJobTimeOwn() {
        return startingJobTimeOwn;
    }

    public void setStartingJobTimeOwn(Date startingJobTimeOwn) {
        this.startingJobTimeOwn = startingJobTimeOwn;
    }

    public Date getStartingJobTimeArchvies() {
        return startingJobTimeArchvies;
    }

    public void setStartingJobTimeArchvies(Date startingJobTimeArchvies) {
        this.startingJobTimeArchvies = startingJobTimeArchvies;
    }

    public Date getStartingJobTimeJudgment() {
        return startingJobTimeJudgment;
    }

    public void setStartingJobTimeJudgment(Date startingJobTimeJudgment) {
        this.startingJobTimeJudgment = startingJobTimeJudgment;
    }

    public String getStartingJobTimeProblemDetail() {
        return startingJobTimeProblemDetail;
    }

    public void setStartingJobTimeProblemDetail(String startingJobTimeProblemDetail) {
        this.startingJobTimeProblemDetail = startingJobTimeProblemDetail;
    }

    public String getStartingJobTimeProblemCategory() {
        return startingJobTimeProblemCategory;
    }

    public void setStartingJobTimeProblemCategory(String startingJobTimeProblemCategory) {
        this.startingJobTimeProblemCategory = startingJobTimeProblemCategory;
    }

    public String getStartingJobTimeCheckResult() {
        return startingJobTimeCheckResult;
    }

    public void setStartingJobTimeCheckResult(String startingJobTimeCheckResult) {
        this.startingJobTimeCheckResult = startingJobTimeCheckResult;
    }

    public String getStartingJobTimeCheckRemark() {
        return startingJobTimeCheckRemark;
    }

    public void setStartingJobTimeCheckRemark(String startingJobTimeCheckRemark) {
        this.startingJobTimeCheckRemark = startingJobTimeCheckRemark;
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