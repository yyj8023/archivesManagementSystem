package com.archivesManagementSystem.springboot.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String employeeId;
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
    private String confirmationContentFlag;
    /**
    * 认定表是否已签字
    */
    @Excel(name = "认定表是否已签字")
    private String confirmationSignatureFlag;
    /**
    * 出生日期问题描述
    */
    @Excel(name = "问题描述",fixedIndex = 8)
    private String birthdayProblemDetail;
    /**
    * 出生日期认定结果描述
    */
    @Excel(name = "出生认定结果描述",fixedIndex = 9)
    private String birthdayCheckResult;
    /**
    * 身份证出生日期
    */
    @Excel(name = "身份证日期",exportFormat = "yyyy/MM/dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date birthdayCard;
    /**
    * 档案中的出生日期
    */
    private Date birthdayArchives;
    /**
    * 认定出生日期
    */
    @Excel(name = "认定出生日期",exportFormat = "yyyy/MM/dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date birthdayJudgment;
    /**
    * 出生日期问题分类
    */
    @Excel(name = "问题分类",fixedIndex = 12)
    private String birthdayProblemCategory;
    /**
    * 出生日期认定规则
    */
    @Excel(name = "认定规则")
    private String birthdayCheckRule;
    /**
    * 出生日期小结
    */
    @Excel(name = "小结",fixedIndex = 14)
    private String birthdayCheckRemark;

    @Excel(name="是否有问题",fixedIndex=15)
    private String birthdayHaveProblem;

    @Excel(name="政治面貌")
    private String politicalStatus;
    /**
    * 入党时间问题描述
    */
    @Excel(name = "问题描述",fixedIndex = 17)
    private String joinPartyTimeProblemDetail;
    /**
    * 入党时间认定结果描述
    */
    @Excel(name = "认定结果描述",fixedIndex = 18)
    private String joinPartyTimeCheckResult;
    /**
    * 入党时间调研情况
    */
    @Excel(name = "调研情况")
    private String joinPartyTimeResearchSituation;
    /**
    * 入党时间
    */
    @Excel(name = "入党时间",exportFormat = "yyyy/MM/dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
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
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date joinGroupTime;
    /**
    * 入党时间小结
    */
    @Excel(name = "小结",fixedIndex = 23)
    private String joinPartyTimeRemark;

    /*
    入党时间是否有问题
     */
    @Excel(name="是否有问题",fixedIndex=24)
    private String joinPartyTimeHaveProblem;

    /**
    * 参加工作时间问题描述
    */
    @Excel(name = "问题描述",fixedIndex = 25)
    private String startingJobTimeProblemDetail;
    /**
    * 参加工作时间认定结果描述
    */
    @Excel(name = "认定结果描述",fixedIndex = 26)
    private String startingJobTimeCheckResult;
    /**
    * 自填工作时间
    */
    @Excel(name = "自填工作时间",exportFormat = "yyyy/MM/dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date startingJobTimeOwn;
    /**
    * 档案材料中有效工作时间
    */
    @Excel(name = "档案材料中有效工作时间",exportFormat = "yyyy/MM/dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date startingJobTimeArchvies;
    /**
    * 参加工作时间认定时间
    */
    private Date startingJobTimeJudgment;
    /**
    * 参加工作时间问题分类
    */
    /**
     * 参加工作时间
     */
    @Excel(name = "参加工作时间",exportFormat = "yyyy/MM/dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date startingJobTime;

    /**
     * 劳务派遣时间
     */
    @Excel(name = "劳务派遣时间",exportFormat = "yyyy/MM/dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date laborDispatchTime;
    /**
     * 劳务派遣时间
     */
    @Excel(name = "本单位工作时间",exportFormat = "yyyy/MM/dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date startingJobTimeThiscompany;

    @Excel(name = "问题分类",fixedIndex = 32)
    private String startingJobTimeProblemCategory;
    /**
    * 参加工作时间小结
    */
    @Excel(name = "小结",fixedIndex = 33)
    private String startingJobTimeCheckRemark;

    @Excel(name = "是否有问题",fixedIndex = 34)
    private String startingJobTimeHaveProblem;
    /**
    * 学历问题描述
    */
    @Excel(name = "问题描述",fixedIndex = 35)
    private String educationProblemDetail;
    /**
    * 学历认定结果描述
    */
    @Excel(name = "认定结果描述",fixedIndex = 36)
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
     * 最高学历
     */
    @Excel(name = "最高学历",fixedIndex = 39)
    private String highestEducation;
    /**
     * 最高学位
     */
    @Excel(name = "最高学位",fixedIndex = 40)
    private String highestDegree;
    /**
     * 次高学历
     */
    @Excel(name = "次高学历",fixedIndex = 41)
    private String highestEducationSecond;
    /**
     * 次高学位
     */
    @Excel(name = "次高学位",fixedIndex = 42)
    private String highestDegreeSecond;
    /**
     * 第三高学历
     */
    @Excel(name = "第三高学历",fixedIndex = 43)
    private String highestEducationThird;
    /**
     * 第三高学位
     */
    @Excel(name = "第三高学位",fixedIndex = 44)
    private String highestDegreeThird;
    /**
     * 学历问题分类
     */

    @Excel(name = "问题分类",fixedIndex = 45)
    private String educationProblemCategory;
    /**
     * 学历小结
     */
    @Excel(name = "小结",fixedIndex = 46)
    private String educationRemark;

    @Excel(name="是否有问题",fixedIndex = 47)
    private String educationHaveProblem;


    /**
    * 工作经历问题描述
    */
    @Excel(name = "问题描述",fixedIndex = 48)
    private String workExperienceProblemDetail;
    /**
    * 工作经历认定结果描述
    */
    @Excel(name = "认定结果描述",fixedIndex = 49)
    private String workExperienceCheckResult;
    /**
    * 工作经历问题分类
    */
    @Excel(name = "问题分类",fixedIndex = 50)
    private String workExperienceProblemCategory;
    /**
    * 工作经历小结
    */
    @Excel(name = "小结",fixedIndex = 51)
    private String workExperienceRemark;

    @Excel(name="是否有问题",fixedIndex=52)
    private String workExperienceHaveProblem;

    /**
    * 补充材料情况
    */
    @Excel(name = "补充材料情况")
    private String marterialSupplementRemark;
    /**
    * 是否已核对纸质电子版一致性
    */
    @Excel(name = "是否已核对纸质电子版一致性")
    private String electronicPaperCheckFlag;
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

    public String getConfirmationContentFlag() {
        return confirmationContentFlag;
    }

    public void setConfirmationContentFlag(String confirmationContentFlag) {
        this.confirmationContentFlag = confirmationContentFlag;
    }

    public String getConfirmationSignatureFlag() {
        return confirmationSignatureFlag;
    }

    public void setConfirmationSignatureFlag(String confirmationSignatureFlag) {
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

    public String getElectronicPaperCheckFlag() {
        return electronicPaperCheckFlag;
    }

    public void setElectronicPaperCheckFlag(String electronicPaperCheckFlag) {
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



    public String getBirthdayHaveProblem() {
        return birthdayHaveProblem;
    }

    public void setBirthdayHaveProblem(String birthdayHaveProblem) {
        this.birthdayHaveProblem = birthdayHaveProblem;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getJoinPartyTimeHaveProblem() {
        return joinPartyTimeHaveProblem;
    }

    public void setJoinPartyTimeHaveProblem(String joinPartyTimeHaveProblem) {
        this.joinPartyTimeHaveProblem = joinPartyTimeHaveProblem;
    }

    public Date getStartingJobTime() {
        return startingJobTime;
    }

    public void setStartingJobTime(Date startingJobTime) {
        this.startingJobTime = startingJobTime;
    }

    public Date getLaborDispatchTime() {
        return laborDispatchTime;
    }

    public void setLaborDispatchTime(Date laborDispatchTime) {
        this.laborDispatchTime = laborDispatchTime;
    }

    public Date getStartingJobTimeThiscompany() {
        return startingJobTimeThiscompany;
    }

    public void setStartingJobTimeThiscompany(Date startingJobTimeThiscompany) {
        this.startingJobTimeThiscompany = startingJobTimeThiscompany;
    }

    public String getStartingJobTimeHaveProblem() {
        return startingJobTimeHaveProblem;
    }

    public void setStartingJobTimeHaveProblem(String startingJobTimeHaveProblem) {
        this.startingJobTimeHaveProblem = startingJobTimeHaveProblem;
    }

    public String getEducationHaveProblem() {
        return educationHaveProblem;
    }

    public void setEducationHaveProblem(String educationHaveProblem) {
        this.educationHaveProblem = educationHaveProblem;
    }

    public String getWorkExperienceHaveProblem() {
        return workExperienceHaveProblem;
    }

    public void setWorkExperienceHaveProblem(String workExperienceHaveProblem) {
        this.workExperienceHaveProblem = workExperienceHaveProblem;
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
}