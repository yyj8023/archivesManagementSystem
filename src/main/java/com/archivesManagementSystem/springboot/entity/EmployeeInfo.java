package com.archivesManagementSystem.springboot.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;
import java.io.Serializable;

/**
 * 员工基本信息表(EmployeeInfo)实体类
 *
 * @author makejava
 * @since 2021-01-20 22:14:49
 */
public class EmployeeInfo implements Serializable {
    private static final long serialVersionUID = 990829080018187400L;
    
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
    * 所在部门
    */
    @Excel(name = "所在部门")
    private String departmentName;
    /**
    * 岗位性质
    */
    @Excel(name = "岗位性质")
    private String jobProperty;
    /**
    * 所属线条
    */
    @Excel(name = "所属线条")
    private String departmentLine;
    /**
    * 认定表是否有内容
    */
    @Excel(name = "认定表是否有内容(true表示是)")
    private Boolean confirmationContentFlag;
    /**
    * 认定表是否已签字
    */
    @Excel(name = "认定表是否已签字(true表示是)")
    private Boolean confirmationSignatureFlag;
    /**
    * 身份证出生日期
    */
    @Excel(name = "身份证出生日期")
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
    * 入党时间
    */
    @Excel(name = "入党时间")
    private Date joinPartyTime;
    /**
    * 入党介绍人
    */
    @Excel(name = "入党介绍人")
    private String joinPartyIntroducer;
    /**
    * 入团时间
    */
    @Excel(name = "入团时间")
    private Date joinGroupTime;
    /**
    * 自填工作时间
    */
    @Excel(name = "自填工作时间")
    private Date startingJobTimeOwn;
    /**
    * 档案材料中有效工作时间
    */
    @Excel(name = "档案材料中有效工作时间")
    private Date startingJobTimeArchvies;
    /**
    * 参加工作时间认定时间
    */
    @Excel(name = "参加工作时间认定时间")
    private Date startingJobTimeJudgment;
    /**
    * 最高学位
    */
    @Excel(name = "最高学位")
    private String educationDegree;
    /**
    * 最高学历
    */
    @Excel(name = "最高学历")
    private String educationBackgroud;
    /**
    * 最高学历认定
    */
    @Excel(name = "最高学历认定")
    private String educationBackgroudJudgment;
    /**
    * 最高学位认定
    */
    @Excel(name = "最高学位认定")
    private String educationDegreeJudgment;
    /**
    * 补充材料情况
    */
    @Excel(name = "材料补充情况")
    private String marterialSupplementRemark;
    /**
    * 是否已核对纸质电子版一致性
    */
    @Excel(name = "是否已核对纸质电子版一致性(true表示是)")
    private Boolean electronicPaperCheckFlag;
    /**
    * 核对人
    */
    @Excel(name = "核对人")
    private String checkUser;
    /**
    * 最后的更新人
    */
    @Excel(name = "更新人")
    private String updateBy;
    /**
    * 更新时间
    */
    @Excel(name = "更新时间")
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getJobProperty() {
        return jobProperty;
    }

    public void setJobProperty(String jobProperty) {
        this.jobProperty = jobProperty;
    }

    public String getDepartmentLine() {
        return departmentLine;
    }

    public void setDepartmentLine(String departmentLine) {
        this.departmentLine = departmentLine;
    }

    public Boolean getConfirmationContentFlag() {
        return confirmationContentFlag;
    }

    public void setConfirmationContentFlag(Boolean confirmationContentFlag) {
        this.confirmationContentFlag = confirmationContentFlag;
    }

    public Boolean getConfirmationSignatureFlag() {
        return confirmationSignatureFlag;
    }

    public void setConfirmationSignatureFlag(Boolean confirmationSignatureFlag) {
        this.confirmationSignatureFlag = confirmationSignatureFlag;
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

    public String getEducationBackgroudJudgment() {
        return educationBackgroudJudgment;
    }

    public void setEducationBackgroudJudgment(String educationBackgroudJudgment) {
        this.educationBackgroudJudgment = educationBackgroudJudgment;
    }

    public String getEducationDegreeJudgment() {
        return educationDegreeJudgment;
    }

    public void setEducationDegreeJudgment(String educationDegreeJudgment) {
        this.educationDegreeJudgment = educationDegreeJudgment;
    }

    public String getMarterialSupplementRemark() {
        return marterialSupplementRemark;
    }

    public void setMarterialSupplementRemark(String marterialSupplementRemark) {
        this.marterialSupplementRemark = marterialSupplementRemark;
    }

    public Boolean getElectronicPaperCheckFlag() {
        return electronicPaperCheckFlag;
    }

    public void setElectronicPaperCheckFlag(Boolean electronicPaperCheckFlag) {
        this.electronicPaperCheckFlag = electronicPaperCheckFlag;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
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