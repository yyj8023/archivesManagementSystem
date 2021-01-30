package com.archivesManagementSystem.springboot.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 员工基本信息表(EmployeeInfo)实体类
 *
 * @author makejava
 * @since 2021-01-30 12:28:40
 */
public class EmployeeInfo implements Serializable {
    private static final long serialVersionUID = -35955808928706803L;
    
    private Integer id;
    /**
    * 员工ID
    */
    @Excel(name = "员工号")
    private Integer employeeId;
    /**
    * 员工姓名
    */
    @Excel(name = "姓名")
    private String employeeName;
    /**
    * 所在部门
    */
    @Excel(name = "所在部门")
    private String departmentName;
    /**
     * 所属线条
     */
    @Excel(name = "所属线条")
    private String departmentLine;
    /**
    * 岗位性质
    */
    @Excel(name = "岗位性质")
    private String jobProperty;

    /**
    * 认定表是否有内容
    */
    @Excel(name = "认定表是否有内容")
    private Boolean confirmationContentFlag;
    /**
    * 认定表是否已签字
    */
    @Excel(name = "认定表是否已签字")
    private Boolean confirmationSignatureFlag;
    /**
    * 出生日期问题描述
    */
    @Excel(name = "问题描述",fixedIndex = 7)
    private String birthdayProblemDetail;
    /**
    * 出生日期认定结果描述
    */
    @Excel(name = "出生认定结果描述",fixedIndex = 8)
    private String birthdayCheckResult;
    /**
    * 身份证出生日期
    */
    @Excel(name = "身份证日期")
    private Date birthdayCard;
    /**
    * 档案中的出生日期
    */
    private Date birthdayArchives;
    /**
    * 认定出生日期
    */
    @Excel(name = "认定出生日期")
    private Date birthdayJudgment;
    /**
    * 出生日期问题分类
    */
    @Excel(name = "问题分类",fixedIndex = 11)
    private String birthdayProblemCategory;
    /**
    * 出生日期认定规则
    */
    @Excel(name = "认定规则")
    private String birthdayCheckRule;
    /**
    * 出生日期小结
    */
    @Excel(name = "小结",fixedIndex = 13)
    private String birthdayCheckRemark;
    /**
    * 入党时间问题描述
    */
    @Excel(name = "问题描述",fixedIndex = 14)
    private String joinPartyTimeProblemDetail;
    /**
    * 入党时间认定结果描述
    */
    @Excel(name = "认定结果描述",fixedIndex = 15)
    private String joinPartyTimeCheckResult;
    /**
    * 入党时间调研情况
    */
    @Excel(name = "调研情况")
    private String joinPartyTimeResearchSituation;
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
    * 入党时间小结
    */
    @Excel(name = "小结",fixedIndex = 20)
    private String joinPartyTimeRemark;
    /**
    * 参加工作时间问题描述
    */
    @Excel(name = "问题描述",fixedIndex = 21)
    private String startingJobTimeProblemDetail;
    /**
    * 参加工作时间认定结果描述
    */
    @Excel(name = "认定结果描述",fixedIndex = 22)
    private String startingJobTimeCheckResult;
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
    private Date startingJobTimeJudgment;
    /**
    * 参加工作时间问题分类
    */
    @Excel(name = "问题分类",fixedIndex = 25)
    private String startingJobTimeProblemCategory;
    /**
    * 参加工作时间小结
    */
    @Excel(name = "小结",fixedIndex = 26)
    private String startingJobTimeCheckRemark;
    /**
    * 学历问题描述
    */
    @Excel(name = "问题描述",fixedIndex = 27)
    private String educationProblemDetail;
    /**
    * 学历认定结果描述
    */
    @Excel(name = "认定结果描述",fixedIndex = 28)
    private String educationCheckResult;
    /**
    * 最高学位
    */
    private String educationDegree;
    /**
    * 最高学历
    */
    private String educationBackgroud;
    /**
    * 认定后最高学历
    */
    @Excel(name = "认定后最高学历")
    private String educationBackgroudJudgment;
    /**
    * 认定后最高学位
    */
    @Excel(name = "认定后最高学位")
    private String educationDegreeJudgment;
    /**
    * 学历问题分类
    */

    @Excel(name = "问题分类",fixedIndex = 31)
    private String educationProblemCategory;
    /**
    * 学历小结
    */
    @Excel(name = "小结",fixedIndex = 32)
    private String educationRemark;
    /**
    * 工作经历问题描述
    */
    @Excel(name = "问题描述",fixedIndex = 33)
    private String workExperienceProblemDetail;
    /**
    * 工作经历认定结果描述
    */
    @Excel(name = "认定结果描述",fixedIndex = 34)
    private String workExperienceCheckResult;
    /**
    * 工作经历问题分类
    */
    @Excel(name = "问题分类",fixedIndex = 35)
    private String workExperienceProblemCategory;
    /**
    * 工作经历小结
    */
    @Excel(name = "小结",fixedIndex = 36)
    private String workExperienceRemark;
    /**
    * 补充材料情况
    */
    @Excel(name = "补充材料情况")
    private String marterialSupplementRemark;
    /**
    * 是否已核对纸质电子版一致性
    */
    @Excel(name = "是否已核对纸质电子版一致性")
    private Boolean electronicPaperCheckFlag;
    /**
    * 核对人
    */
    @Excel(name = "核对人")
    private String checkUser;
    /**
    * 最后的更新人
    */
    private String updateBy;
    /**
    * 更新时间
    */
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

    public String getJoinPartyTimeRemark() {
        return joinPartyTimeRemark;
    }

    public void setJoinPartyTimeRemark(String joinPartyTimeRemark) {
        this.joinPartyTimeRemark = joinPartyTimeRemark;
    }

    public String getStartingJobTimeProblemDetail() {
        return startingJobTimeProblemDetail;
    }

    public void setStartingJobTimeProblemDetail(String startingJobTimeProblemDetail) {
        this.startingJobTimeProblemDetail = startingJobTimeProblemDetail;
    }

    public String getStartingJobTimeCheckResult() {
        return startingJobTimeCheckResult;
    }

    public void setStartingJobTimeCheckResult(String startingJobTimeCheckResult) {
        this.startingJobTimeCheckResult = startingJobTimeCheckResult;
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

    public String getStartingJobTimeProblemCategory() {
        return startingJobTimeProblemCategory;
    }

    public void setStartingJobTimeProblemCategory(String startingJobTimeProblemCategory) {
        this.startingJobTimeProblemCategory = startingJobTimeProblemCategory;
    }

    public String getStartingJobTimeCheckRemark() {
        return startingJobTimeCheckRemark;
    }

    public void setStartingJobTimeCheckRemark(String startingJobTimeCheckRemark) {
        this.startingJobTimeCheckRemark = startingJobTimeCheckRemark;
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

    public String getEducationProblemCategory() {
        return educationProblemCategory;
    }

    public void setEducationProblemCategory(String educationProblemCategory) {
        this.educationProblemCategory = educationProblemCategory;
    }

    public String getEducationRemark() {
        return educationRemark;
    }

    public void setEducationRemark(String educationRemark) {
        this.educationRemark = educationRemark;
    }

    public String getWorkExperienceProblemDetail() {
        return workExperienceProblemDetail;
    }

    public void setWorkExperienceProblemDetail(String workExperienceProblemDetail) {
        this.workExperienceProblemDetail = workExperienceProblemDetail;
    }

    public String getWorkExperienceCheckResult() {
        return workExperienceCheckResult;
    }

    public void setWorkExperienceCheckResult(String workExperienceCheckResult) {
        this.workExperienceCheckResult = workExperienceCheckResult;
    }

    public String getWorkExperienceProblemCategory() {
        return workExperienceProblemCategory;
    }

    public void setWorkExperienceProblemCategory(String workExperienceProblemCategory) {
        this.workExperienceProblemCategory = workExperienceProblemCategory;
    }

    public String getWorkExperienceRemark() {
        return workExperienceRemark;
    }

    public void setWorkExperienceRemark(String workExperienceRemark) {
        this.workExperienceRemark = workExperienceRemark;
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