package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.entity.*;
import com.archivesManagementSystem.springboot.qo.DeleteQO;
import com.archivesManagementSystem.springboot.service.*;
import com.archivesManagementSystem.springboot.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.util.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 员工基本信息表(EmployeeInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-20 22:14:49
 */
@CrossOrigin
@RestController
@RequestMapping("employeeInfo")
public class EmployeeInfoController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeInfoService employeeInfoService;
    @Resource
    private BirthdayInfoService birthdayInfoService;
    @Resource
    private EducationInfoService educationInfoService;
    @Resource
    private JoinPartyTimeInfoService joinPartyTimeInfoService;
    @Resource
    private StartingJobTimeInfoService startingJobTimeInfoService;
    @Resource
    private WorkExperienceInfoService workExperienceInfoService;
    @Resource
    private  OrdinaryOperateLogService ordinaryOperateLogService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Result selectOne(Integer id) {
        Result res = new GeneralResult(true);

        if(this.employeeInfoService.queryById(id)!=null){
            res.setData(this.employeeInfoService.queryById(id));
            res.setMsg("查询成功");
        }else{
            res.setMsg("没有找到对应的值");
            res.setSuccess(false);
        }
        return  res;
    }

    /**
     * 单条插入员工信息
     *
     * @param employeeInfo
     * @return Result
     */
    @PostMapping("insert")
    @ResponseBody
    public Result insert(@RequestBody EmployeeInfo employeeInfo) {
        Result res = new GeneralResult(true);
        EmployeeInfo employeeInfo1 = this.employeeInfoService.queryByEmployeeId(employeeInfo.getEmployeeId());
        if (employeeInfo1 == null) {
            int count = 0;
            //TODO 将导入的数据做保存数据库操作,先将所有数据id设置为null
            count += this.employeeInfoService.insert(employeeInfo);
            //生成出生日期认定表基本信息
            BirthdayInfo birthdayInfo = new BirthdayInfo();
            birthdayInfo.setEmployeeId(employeeInfo.getEmployeeId());
            birthdayInfo.setEmployeeName(employeeInfo.getEmployeeName());
            birthdayInfo.setBirthdayCard(employeeInfo.getBirthdayCard());
            birthdayInfo.setBirthdayArchives(employeeInfo.getBirthdayArchives());
            birthdayInfo.setBirthdayJudgment(employeeInfo.getBirthdayJudgment());
            birthdayInfo.setBirthdayProblemDetail(employeeInfo.getBirthdayProblemDetail());
            birthdayInfo.setBirthdayCheckResult(employeeInfo.getBirthdayCheckResult());
            birthdayInfo.setBirthdayProblemCategory(employeeInfo.getBirthdayProblemCategory());
            birthdayInfo.setBirthdayCheckRule(employeeInfo.getBirthdayCheckRule());
            birthdayInfo.setBirthdayCheckRemark(employeeInfo.getBirthdayCheckRemark());
            birthdayInfo.setBirthdayHaveProblem(employeeInfo.getBirthdayHaveProblem());
            birthdayInfo.setUpdateBy(employeeInfo.getUpdateBy());
            birthdayInfo.setUpdateTime(new Date());
            count += this.birthdayInfoService.insert(birthdayInfo);
            //学历信息认定表基本信息
            EducationInfo educationInfo = new EducationInfo();
            educationInfo.setEmployeeId(employeeInfo.getEmployeeId());
            educationInfo.setEmployeeName(employeeInfo.getEmployeeName());
            educationInfo.setEducationDegree(employeeInfo.getEducationDegree());
            educationInfo.setEducationBackgroud(employeeInfo.getEducationBackgroud());
            educationInfo.setEducationBackgroudJudgment(employeeInfo.getEducationBackgroudJudgment());
            educationInfo.setEducationDegreeeJudgment(employeeInfo.getEducationDegreeJudgment());
            educationInfo.setEducationProblemCategory(employeeInfo.getEducationProblemCategory());
            educationInfo.setEducationProblemDetail(employeeInfo.getEducationProblemDetail());
            educationInfo.setEducationCheckResult(employeeInfo.getEducationCheckResult());
            educationInfo.setEducationRemark(employeeInfo.getEducationRemark());
            educationInfo.setEducationHaveProblem(educationInfo.getEducationHaveProblem());
            educationInfo.setUpdateBy(employeeInfo.getUpdateBy());
            educationInfo.setUpdateTime(new Date());

            educationInfo.setHighestDegree(employeeInfo.getHighestDegree());
            educationInfo.setHighestEducation(employeeInfo.getHighestEducation());
            educationInfo.setHighestDegreeSecond(employeeInfo.getHighestDegreeSecond());
            educationInfo.setHighestEducationSecond(employeeInfo.getHighestEducationSecond());
            educationInfo.setHighestDegreeThird(employeeInfo.getHighestDegreeThird());
            educationInfo.setHighestEducationThird(employeeInfo.getHighestEducationThird());

            count += this.educationInfoService.insert(educationInfo);
            //入党时间认定表基本信息
            JoinPartyTimeInfo joinPartyTimeInfo = new JoinPartyTimeInfo();
            joinPartyTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
            joinPartyTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
            joinPartyTimeInfo.setPoliticalStatus(employeeInfo.getPoliticalStatus());
            joinPartyTimeInfo.setJoinPartyTime(employeeInfo.getJoinPartyTime());
            joinPartyTimeInfo.setJoinPartyIntroducer(employeeInfo.getJoinPartyIntroducer());
            joinPartyTimeInfo.setJoinGroupTime(employeeInfo.getJoinGroupTime());
            joinPartyTimeInfo.setJoinPartyTimeProblemDetail(employeeInfo.getJoinPartyTimeProblemDetail());
            joinPartyTimeInfo.setJoinPartyTimeCheckResult(employeeInfo.getJoinPartyTimeCheckResult());
            joinPartyTimeInfo.setJoinPartyTimeResearchSituation(employeeInfo.getJoinPartyTimeResearchSituation());
            joinPartyTimeInfo.setJoinPartyTimeRemark(employeeInfo.getJoinPartyTimeRemark());
            joinPartyTimeInfo.setJoinPartyTimeHaveProblem(employeeInfo.getJoinPartyTimeHaveProblem());
            joinPartyTimeInfo.setUpdateBy(employeeInfo.getUpdateBy());
            joinPartyTimeInfo.setUpdateTime(new Date());
            count += this.joinPartyTimeInfoService.insert(joinPartyTimeInfo);
            //工作开始时间认定表
            StartingJobTimeInfo startingJobTimeInfo = new StartingJobTimeInfo();
            startingJobTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
            startingJobTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
            startingJobTimeInfo.setStartingJobTimeOwn(employeeInfo.getStartingJobTimeOwn());
            startingJobTimeInfo.setStartingJobTimeArchvies(employeeInfo.getStartingJobTimeArchvies());
            startingJobTimeInfo.setStartingJobTimeJudgment(employeeInfo.getStartingJobTimeJudgment());
            startingJobTimeInfo.setStartingJobTime(employeeInfo.getStartingJobTime());
            startingJobTimeInfo.setLaborDispatchTime(employeeInfo.getLaborDispatchTime());
            startingJobTimeInfo.setStartingJobTimeThiscompany(employeeInfo.getStartingJobTimeThiscompany());
            startingJobTimeInfo.setStartingJobTimeProblemDetail(employeeInfo.getStartingJobTimeProblemDetail());
            startingJobTimeInfo.setStartingJobTimeProblemCategory(employeeInfo.getStartingJobTimeProblemCategory());
            startingJobTimeInfo.setStartingJobTimeCheckResult(employeeInfo.getStartingJobTimeCheckResult());
            startingJobTimeInfo.setStartingJobTimeCheckRemark(employeeInfo.getStartingJobTimeCheckRemark());
            startingJobTimeInfo.setStartingJobTimeHaveProblem(employeeInfo.getStartingJobTimeHaveProblem());
            startingJobTimeInfo.setUpdateBy(employeeInfo.getUpdateBy());
            startingJobTimeInfo.setUpdateTime(new Date());
            count += this.startingJobTimeInfoService.insert(startingJobTimeInfo);
            //工作经历认定表
            WorkExperienceInfo workExperienceInfo = new WorkExperienceInfo();
            workExperienceInfo.setEmployeeId(employeeInfo.getEmployeeId());
            workExperienceInfo.setEmployeeName(employeeInfo.getEmployeeName());
            workExperienceInfo.setWorkExperienceProblemDetail(employeeInfo.getWorkExperienceProblemDetail());
            workExperienceInfo.setWorkExperienceProblemCategory(employeeInfo.getWorkExperienceProblemCategory());
            workExperienceInfo.setWorkExperienceCheckResult(employeeInfo.getWorkExperienceCheckResult());
            workExperienceInfo.setWorkExperienceRemark(employeeInfo.getWorkExperienceRemark());
            workExperienceInfo.setWorkExperienceHaveProblem(employeeInfo.getWorkExperienceHaveProblem());
            workExperienceInfo.setUpdateBy(employeeInfo.getUpdateBy());
            workExperienceInfo.setUpdateTime(new Date());
            count += this.workExperienceInfoService.insert(workExperienceInfo);
         /*   //学历详情表
            EducationDetailInfo educationDetailInfo=new EducationDetailInfo();
            educationDetailInfo.setEmployeeId(employeeInfo.getEmployeeId());
            educationDetailInfo.setEmployeeName(employeeInfo.getEmployeeName());*/

/*            count +=this.educationDetailInfoService.insert(educationDetailInfo);*/
            if (count == 6) {
                res.setMsg("新增员工信息成功！");
            } else {
                res.setMsg("新增失败!");
            }
        } else {
            res.setMsg("已存在员工编号为" + employeeInfo1.getEmployeeId() + "的员工信息，请你进行更新操作！");
            res.setSuccess(false);
        }
        return res;

    }

    /**
     * 根据主键删除数据
     *
     * @param deleteQO
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Result delete(@RequestBody DeleteQO deleteQO) {
        Result res = new GeneralResult(true);
        //只传入一个id
        if (deleteQO.getIds() == null || deleteQO.getIds().length <1) {
            int id = deleteQO.getId();
            EmployeeInfo employeeInfo = new EmployeeInfo();
            employeeInfo = this.employeeInfoService.queryById(id);
            if (employeeInfo != null) {
                res.setData(employeeInfo);
                try {
                    this.birthdayInfoService.deleteByEmployee(employeeInfo.getEmployeeId(), employeeInfo.getEmployeeName());
                } catch (Exception e) {
                    res.setMsg("删除出生日期信息出现异常");
                    res.setSuccess(false);
                    e.printStackTrace();
                }
                try {
                    this.startingJobTimeInfoService.deleteByEmployee(employeeInfo.getEmployeeId(), employeeInfo.getEmployeeName());
                } catch (Exception e) {
                    res.setMsg("删除开始工作时间信息出现异常");
                    res.setSuccess(false);
                    e.printStackTrace();
                }
                try {
                    this.joinPartyTimeInfoService.deleteByEmployee(employeeInfo.getEmployeeId(), employeeInfo.getEmployeeName());
                } catch (Exception e) {
                    e.printStackTrace();
                    res.setMsg("删除入党时间出现异常");
                    res.setSuccess(false);
                }
                try {
                    this.educationInfoService.deleteByEmployee(employeeInfo.getEmployeeId(), employeeInfo.getEmployeeName());
                } catch (Exception e) {
                    res.setMsg("删除学历信息出现异常");
                    res.setSuccess(false);
                    e.printStackTrace();
                }
                try {
                    this.workExperienceInfoService.deleteByEmployee(employeeInfo.getEmployeeId(), employeeInfo.getEmployeeName());
                } catch (Exception e) {
                    res.setMsg("删除工作经历信息出现异常");
                    res.setSuccess(false);
                    e.printStackTrace();
                }
/*                try {
                    this.educationDetailInfoService.deleteByEmployee(employeeInfo.getEmployeeId(), employeeInfo.getEmployeeName());
                } catch (Exception e) {
                    res.setMsg("删除学历详情表信息出现异常");
                    res.setSuccess(false);
                    e.printStackTrace();
                }*/

                if (!res.isSuccess()) {
                    res.setMsg("关联的认定表删除失败！员工信息表无法删除");
                } else {
                    this.employeeInfoService.deleteById(id);
                    res.setMsg("删除成功，绑定的5个认定表信息已删除");
                }
            } else {
                res.setMsg("id" + id + "该员工相关信息不存在");
                res.setSuccess(false);
            }
        }else {
            // 删除多个ids
            List<EmployeeInfo> employeeInfoList = new ArrayList<>();
            employeeInfoList = this.employeeInfoService.queryByIds(deleteQO.getIds());
            if (employeeInfoList != null || employeeInfoList.size()>1) {
                String[] ids = new String[employeeInfoList.size()];
                int index = 0;
                for (EmployeeInfo employeeInfo:employeeInfoList) {
                    ids[index++] = employeeInfo.getEmployeeId();
                }
                res.setData(employeeInfoList);
                try {
                    this.birthdayInfoService.deleteByEmployeeIds(ids);
                } catch (Exception e) {
                    res.setMsg("删除出生日期信息出现异常");
                    res.setSuccess(false);
                    e.printStackTrace();
                }
                try {
                    this.startingJobTimeInfoService.deleteByEmployeeIds(ids);
                } catch (Exception e) {
                    res.setMsg("删除开始工作时间信息出现异常");
                    res.setSuccess(false);
                    e.printStackTrace();
                }
                try {
                    this.joinPartyTimeInfoService.deleteByEmployeeIds(ids);
                } catch (Exception e) {
                    e.printStackTrace();
                    res.setMsg("删除入党时间出现异常");
                    res.setSuccess(false);
                }
                try {
                    this.educationInfoService.deleteByEmployeeIds(ids);
                } catch (Exception e) {
                    res.setMsg("删除学历信息出现异常");
                    res.setSuccess(false);
                    e.printStackTrace();
                }
                try {
                    this.workExperienceInfoService.deleteByEmployeeIds(ids);
                } catch (Exception e) {
                    res.setMsg("删除工作经历信息出现异常");
                    res.setSuccess(false);
                    e.printStackTrace();
                }
                if (!res.isSuccess()) {
                    res.setMsg("关联的认定表删除失败！员工信息表无法删除");
                } else {
                    this.employeeInfoService.deleteByEmployeeIds(ids);
                    res.setMsg("删除成功，绑定的5个认定表信息已删除");
                }
            } else {
                //这里批量删除的提示有问题，待修改
                res.setMsg("id" + Arrays.toString(deleteQO.getIds()) + "该员工相关信息不存在");
                res.setSuccess(false);
            }
        }
        return res;
    }

    /**
     * 根据某个字段查询所有的实体集合
     *
     * @param employeeInfo
     * @return List集合
     */

    @GetMapping("selectAll")
    public List<EmployeeInfo> selectAll(EmployeeInfo employeeInfo) {
        return this.employeeInfoService.queryAll(employeeInfo);
    }

    /**
     * 查询全部数据分页展示
     *
     * @return
     * @throws Exception
     */
    @PostMapping("selectAllForPage")
    @ResponseBody
    public PageInfo<EmployeeInfo> selectAllForPage(@RequestBody EmployeeInfo employeeInfo) throws Exception {
        PageHelper.startPage(employeeInfo.getStart(), employeeInfo.getSize());
        List<EmployeeInfo> employeeInfoList = new Vector<EmployeeInfo>();
        List<EmployeeInfo> employeeInfo1list=new Vector<EmployeeInfo>();
        EmployeeInfo employeeInfo1 = new EmployeeInfo();
        EmployeeInfo employeeInfo2 = new EmployeeInfo();
        if(employeeInfo.getEmployeeId()==""){
            employeeInfo.setEmployeeId(null);
        }
        if(employeeInfo.getEmployeeName()==""){
            employeeInfo.setEmployeeName(null);
        }
        if ((employeeInfo.getEmployeeName() != null) && (employeeInfo.getEmployeeId() == null)) {
            String[] employeeNameArray = employeeInfo.getEmployeeName().split(" ");
            for (int i = 0; i < employeeNameArray.length; i++) {
                System.out.println("员工NAME" + employeeNameArray[i]);
                employeeInfo2.setEmployeeName(employeeNameArray[i]);
                employeeInfo1list = this.employeeInfoService.queryAll(employeeInfo2);
                if (employeeInfo1list.size() != 0) {
                    employeeInfoList.addAll(employeeInfo1list);
                }
            }
            PageInfo<EmployeeInfo> page = new PageInfo<>(employeeInfoList);
            return page;
        } else if ((employeeInfo.getEmployeeName() == null) && employeeInfo.getEmployeeId() != null) {
            String[] employeeIdArray = employeeInfo.getEmployeeId().split(" ");
            for (int i = 0; i < employeeIdArray.length; i++) {
                System.out.println("员工Id" + employeeIdArray[i]);
                employeeInfo1 = this.employeeInfoService.queryByEmployeeId(employeeIdArray[i]);
                if (employeeInfo1 != null) {
                    employeeInfoList.add(employeeInfo1);
                }
            }
            PageInfo<EmployeeInfo> page = new PageInfo<>(employeeInfoList);
            return page;
        } else if ((employeeInfo.getEmployeeName() != null) && (employeeInfo.getEmployeeId() != null)) {
            String[] employeeNameArray = employeeInfo.getEmployeeName().split(" ");
            String[] employeeIdArray = employeeInfo.getEmployeeId().split(" ");
            if (employeeIdArray.length > 1 || employeeNameArray.length > 1) {
                //为空。两个都有且超过1，太多了，返回为空值
            } else if (employeeIdArray.length == 1 && employeeNameArray.length == 1) {
                //两个都为一个值时。精准查询
                employeeInfo2.setEmployeeId(employeeIdArray[0]);
                employeeInfo2.setEmployeeName(employeeNameArray[0]);
                employeeInfoList = this.employeeInfoService.queryAll(employeeInfo2);
            }
            PageInfo<EmployeeInfo> page = new PageInfo<>(employeeInfoList);
            return  page;
        } else {
            List<EmployeeInfo> cs = this.employeeInfoService.queryAll(employeeInfo);
            PageInfo<EmployeeInfo> page = new PageInfo<>(cs);
            return page;
        }

        /*   List<EmployeeInfo> cs=this.employeeInfoService.queryAll(employeeInfo);*/

        /*m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;*/
    }



    /**
     * 根据实体类做更新
     * @param employeeInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  Result update(@RequestBody EmployeeInfo employeeInfo,HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println("sessiond id"+session.getId());
        String userName = String.valueOf(session.getAttribute("userName"));
        System.out.println("username is "+userName);
        OrdinaryOperateLog ordinaryOperateLog=new OrdinaryOperateLog();
        EmployeeInfo target =this.employeeInfoService.queryById(employeeInfo.getId());
        employeeInfo.setUpdateBy(userName);
        employeeInfo.setUpdateTime(new Date());
        employeeInfo= this.employeeInfoService.update(employeeInfo);
        //更新操作日志记录
        ChangeRecordUtil<EmployeeInfo> t= new ChangeRecordUtil<EmployeeInfo>();
        List<changePojo> list = t.contrastObj(target,employeeInfo);
        System.out.println("lenth is"+list.size());
        for(changePojo changePojolist:list){
            Object param1=changePojolist.getOldValue();
            Object param2=changePojolist.getNewValue();
            if(param1 instanceof Date){
                String pattern = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                 param1= simpleDateFormat.format(param1);
            }
            if(param2 instanceof Date){
                String pattern = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                param1= simpleDateFormat.format(param2);
            }
            ordinaryOperateLog.setEmployeeId(target.getEmployeeId());
            ordinaryOperateLog.setEmployeeName(target.getEmployeeName());
            ordinaryOperateLog.setCheckTableName("员工信息表");
            ordinaryOperateLog.setOperateType("修改");
            ordinaryOperateLog.setCheckColumnName(changePojolist.getCheckColumnName());
            ordinaryOperateLog.setOldValue(String.valueOf(changePojolist.getOldValue()));
            ordinaryOperateLog.setNewValue(String.valueOf(changePojolist.getNewValue()));
            ordinaryOperateLog.setOperateTime(new Date());
            ordinaryOperateLog.setOperator(userName);
            this.ordinaryOperateLogService.insert(ordinaryOperateLog);
        }

        //也将更新后的数据重新赋值到五个认定小表中
        //生成出生日期认定表基本信息
        BirthdayInfo birthdayInfo = new BirthdayInfo();
        birthdayInfo.setEmployeeId(employeeInfo.getEmployeeId());
        birthdayInfo.setEmployeeName(employeeInfo.getEmployeeName());
        birthdayInfo.setBirthdayCard(employeeInfo.getBirthdayCard());
        birthdayInfo.setBirthdayArchives(employeeInfo.getBirthdayArchives());
        birthdayInfo.setBirthdayJudgment(employeeInfo.getBirthdayJudgment());
        birthdayInfo.setBirthdayProblemDetail(employeeInfo.getBirthdayProblemDetail());
        birthdayInfo.setBirthdayCheckResult(employeeInfo.getBirthdayCheckResult());
        birthdayInfo.setBirthdayProblemCategory(employeeInfo.getBirthdayProblemCategory());
        birthdayInfo.setBirthdayCheckRule(employeeInfo.getBirthdayCheckRule());
        birthdayInfo.setBirthdayCheckRemark(employeeInfo.getBirthdayCheckRemark());
        birthdayInfo.setBirthdayHaveProblem(employeeInfo.getBirthdayHaveProblem());
        birthdayInfo.setUpdateBy(employeeInfo.getUpdateBy());
        birthdayInfo.setUpdateTime(new Date());
        //学历信息认定表基本信息
        EducationInfo educationInfo = new EducationInfo();
        educationInfo.setEmployeeId(employeeInfo.getEmployeeId());
        educationInfo.setEmployeeName(employeeInfo.getEmployeeName());
        educationInfo.setEducationDegree(employeeInfo.getEducationDegree());
        educationInfo.setEducationBackgroud(employeeInfo.getEducationBackgroud());
        educationInfo.setEducationBackgroudJudgment(employeeInfo.getEducationBackgroudJudgment());
        educationInfo.setEducationDegreeeJudgment(employeeInfo.getEducationDegreeJudgment());
        educationInfo.setHighestDegree(employeeInfo.getHighestDegree());
        educationInfo.setHighestEducation(employeeInfo.getHighestEducation());
        educationInfo.setHighestDegreeSecond(employeeInfo.getHighestDegreeSecond());
        educationInfo.setHighestEducationSecond(employeeInfo.getHighestEducationSecond());
        educationInfo.setHighestDegreeThird(employeeInfo.getHighestDegreeThird());
        educationInfo.setHighestEducationThird(employeeInfo.getHighestEducationThird());
        educationInfo.setEducationProblemCategory(employeeInfo.getEducationProblemCategory());
        educationInfo.setEducationProblemDetail(employeeInfo.getEducationProblemDetail());
        educationInfo.setEducationCheckResult(employeeInfo.getEducationCheckResult());
        educationInfo.setEducationRemark(employeeInfo.getEducationRemark());
        educationInfo.setEducationHaveProblem(employeeInfo.getEducationHaveProblem());
        educationInfo.setUpdateBy(employeeInfo.getUpdateBy());
        educationInfo.setUpdateTime(new Date());
        //入党时间认定表基本信息
        JoinPartyTimeInfo joinPartyTimeInfo = new JoinPartyTimeInfo();
        joinPartyTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
        joinPartyTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
        joinPartyTimeInfo.setPoliticalStatus(employeeInfo.getPoliticalStatus());
        joinPartyTimeInfo.setJoinPartyTime(employeeInfo.getJoinPartyTime());
        joinPartyTimeInfo.setJoinPartyIntroducer(employeeInfo.getJoinPartyIntroducer());
        joinPartyTimeInfo.setJoinGroupTime(employeeInfo.getJoinGroupTime());
        joinPartyTimeInfo.setJoinPartyTimeProblemDetail(employeeInfo.getJoinPartyTimeProblemDetail());
        joinPartyTimeInfo.setJoinPartyTimeCheckResult(employeeInfo.getJoinPartyTimeCheckResult());
        joinPartyTimeInfo.setJoinPartyTimeResearchSituation(employeeInfo.getJoinPartyTimeResearchSituation());
        joinPartyTimeInfo.setJoinPartyTimeRemark(employeeInfo.getJoinPartyTimeRemark());
        joinPartyTimeInfo.setJoinPartyTimeHaveProblem(employeeInfo.getJoinPartyTimeHaveProblem());
        joinPartyTimeInfo.setUpdateBy(employeeInfo.getUpdateBy());
        joinPartyTimeInfo.setUpdateTime(new Date());
        //工作开始时间认定表
        StartingJobTimeInfo startingJobTimeInfo = new StartingJobTimeInfo();
        startingJobTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
        startingJobTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
        startingJobTimeInfo.setStartingJobTimeOwn(employeeInfo.getStartingJobTimeOwn());
        startingJobTimeInfo.setStartingJobTimeArchvies(employeeInfo.getStartingJobTimeArchvies());
        startingJobTimeInfo.setStartingJobTimeJudgment(employeeInfo.getStartingJobTimeJudgment());
        startingJobTimeInfo.setStartingJobTime(employeeInfo.getStartingJobTime());
        startingJobTimeInfo.setLaborDispatchTime(employeeInfo.getLaborDispatchTime());
        startingJobTimeInfo.setStartingJobTimeThiscompany(employeeInfo.getStartingJobTimeThiscompany());
        startingJobTimeInfo.setStartingJobTimeProblemDetail(employeeInfo.getStartingJobTimeProblemDetail());
        startingJobTimeInfo.setStartingJobTimeProblemCategory(employeeInfo.getStartingJobTimeProblemCategory());
        startingJobTimeInfo.setStartingJobTimeCheckResult(employeeInfo.getStartingJobTimeCheckResult());
        startingJobTimeInfo.setStartingJobTimeCheckRemark(employeeInfo.getStartingJobTimeCheckRemark());
        startingJobTimeInfo.setStartingJobTimeHaveProblem(employeeInfo.getStartingJobTimeHaveProblem());
        startingJobTimeInfo.setUpdateBy(employeeInfo.getUpdateBy());
        startingJobTimeInfo.setUpdateTime(new Date());
        //工作经历认定表
        WorkExperienceInfo workExperienceInfo = new WorkExperienceInfo();
        workExperienceInfo.setEmployeeId(employeeInfo.getEmployeeId());
        workExperienceInfo.setEmployeeName(employeeInfo.getEmployeeName());
        workExperienceInfo.setWorkExperienceProblemDetail(employeeInfo.getWorkExperienceProblemDetail());
        workExperienceInfo.setWorkExperienceProblemCategory(employeeInfo.getWorkExperienceProblemCategory());
        workExperienceInfo.setWorkExperienceCheckResult(employeeInfo.getWorkExperienceCheckResult());
        workExperienceInfo.setWorkExperienceRemark(employeeInfo.getWorkExperienceRemark());
        workExperienceInfo.setUpdateBy(employeeInfo.getUpdateBy());
        workExperienceInfo.setWorkExperienceHaveProblem(employeeInfo.getWorkExperienceHaveProblem());
        workExperienceInfo.setUpdateTime(new Date());
/*        //学历详情表
        EducationDetailInfo educationDetailInfo=new EducationDetailInfo();
        educationDetailInfo.setEmployeeId(employeeInfo.getEmployeeId());
        educationDetailInfo.setEmployeeName(employeeInfo.getEmployeeName());
        educationDetailInfo.setHighestDegree(employeeInfo.getHighestDegree());
        educationDetailInfo.setHighestEducation(employeeInfo.getHighestEducation());
        educationDetailInfo.setHighestDegreeSecond(employeeInfo.getHighestDegreeSecond());
        educationDetailInfo.setHighestEducationSecond(employeeInfo.getHighestEducationSecond());
        educationDetailInfo.setHighestEducationThird(employeeInfo.getHighestEducationThird());
        educationDetailInfo.setHighestDegreeThird(employeeInfo.getHighestDegreeThird());
        educationDetailInfo.setUpdateBy(employeeInfo.getUpdateBy());
        educationDetailInfo.setUpdateTime(new Date());*/

        birthdayInfo.setId(this.birthdayInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
        educationInfo.setId(this.educationInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
        joinPartyTimeInfo.setId(this.joinPartyTimeInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
        startingJobTimeInfo.setId(this.startingJobTimeInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
        workExperienceInfo.setId(this.workExperienceInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
   /*     educationDetailInfo.setId(this.educationInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());*/
        this.birthdayInfoService.update(birthdayInfo);
        this.educationInfoService.update(educationInfo);
        this.joinPartyTimeInfoService.update(joinPartyTimeInfo);
        this.startingJobTimeInfoService.update(startingJobTimeInfo);
        this.workExperienceInfoService.update(workExperienceInfo);
/*        this.educationDetailInfoService.update(educationDetailInfo);*/
        Result res=new GeneralResult(true);
        res.setMsg("更新成功！");
        res.setData(employeeInfo);
        if(employeeInfo==null){
            res.setSuccess(false);
            res.setMsg("更新失败！");
        }
        return  res;
    }

    @PostMapping("importExcel")
    @ResponseBody
    public Result importExcel(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        HttpSession session = request.getSession();
        OrdinaryOperateLog ordinaryOperateLog=new OrdinaryOperateLog();
        Result res=new GeneralResult(true);
        ImportParams importParams = new ImportParams();
        // 数据处理
        //表格标题行数,默认0
        importParams.setTitleRows(0);
        //表头行数,默认1
        importParams.setHeadRows(2);
        //是否需要校验上传的Excel,默认false
        importParams.setNeedVerfiy(false);

        try {
            ExcelImportResult<EmployeeInfo> result = ExcelImportUtil.importExcelMore(file.getInputStream(), EmployeeInfo.class, importParams);
            if(result.isVerfiyFail()){
                res.setSuccess(false);
                res.setMsg("导入失败");
            }else{
                List<EmployeeInfo> employeeInfoList = result.getList();
               Iterator<EmployeeInfo> employeeInfoIterator=employeeInfoList.iterator();
                while(employeeInfoIterator.hasNext()){
                    EmployeeInfo employeeInfo=employeeInfoIterator.next();
                    if(employeeInfo.getEmployeeName()==null){
                        employeeInfoIterator.remove();
                    }
                }
                for (EmployeeInfo employeeInfo: employeeInfoList) {
                    int count=0;
                    String userName = String.valueOf(session.getAttribute("userName"));
                    employeeInfo.setUpdateBy(userName);
                    employeeInfo.setUpdateTime(new Date());
                    //TODO 将导入的数据做保存数据库操作,先将所有数据id设置为null
                    //生成出生日期认定表基本信息
                    BirthdayInfo birthdayInfo = new BirthdayInfo();
                    birthdayInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    birthdayInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    birthdayInfo.setBirthdayCard(employeeInfo.getBirthdayCard());
                    birthdayInfo.setBirthdayArchives(employeeInfo.getBirthdayArchives());
                    birthdayInfo.setBirthdayJudgment(employeeInfo.getBirthdayJudgment());
                    birthdayInfo.setBirthdayProblemDetail(employeeInfo.getBirthdayProblemDetail());
                    birthdayInfo.setBirthdayCheckResult(employeeInfo.getBirthdayCheckResult());
                    birthdayInfo.setBirthdayProblemCategory(employeeInfo.getBirthdayProblemCategory());
                    birthdayInfo.setBirthdayCheckRule(employeeInfo.getBirthdayCheckRule());
                    birthdayInfo.setBirthdayCheckRemark(employeeInfo.getBirthdayCheckRemark());
                    birthdayInfo.setBirthdayHaveProblem(employeeInfo.getBirthdayHaveProblem());
                    birthdayInfo.setUpdateBy(employeeInfo.getUpdateBy());
                    birthdayInfo.setUpdateTime(new Date());
                    //学历信息认定表基本信息
                    EducationInfo educationInfo = new EducationInfo();
                    educationInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    educationInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    educationInfo.setEducationDegree(employeeInfo.getEducationDegree());
                    educationInfo.setEducationBackgroud(employeeInfo.getEducationBackgroud());
                    educationInfo.setEducationBackgroudJudgment(employeeInfo.getEducationBackgroudJudgment());
                    educationInfo.setEducationDegreeeJudgment(employeeInfo.getEducationDegreeJudgment());

                    educationInfo.setHighestDegree(employeeInfo.getHighestDegree());
                    educationInfo.setHighestEducation(employeeInfo.getHighestEducation());
                    educationInfo.setHighestDegreeSecond(employeeInfo.getHighestDegreeSecond());
                    educationInfo.setHighestEducationSecond(employeeInfo.getHighestEducationSecond());
                    educationInfo.setHighestDegreeThird(employeeInfo.getHighestDegreeThird());
                    educationInfo.setHighestEducationThird(employeeInfo.getHighestEducationThird());

                    educationInfo.setEducationProblemCategory(employeeInfo.getEducationProblemCategory());
                    educationInfo.setEducationProblemDetail(employeeInfo.getEducationProblemDetail());
                    educationInfo.setEducationCheckResult(employeeInfo.getEducationCheckResult());
                    educationInfo.setEducationRemark(employeeInfo.getEducationRemark());
                    educationInfo.setEducationHaveProblem(employeeInfo.getEducationHaveProblem());
                    educationInfo.setUpdateBy(employeeInfo.getUpdateBy());
                    educationInfo.setUpdateTime(new Date());
                    //入党时间认定表基本信息
                    JoinPartyTimeInfo joinPartyTimeInfo = new JoinPartyTimeInfo();
                    joinPartyTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    joinPartyTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    joinPartyTimeInfo.setPoliticalStatus(employeeInfo.getPoliticalStatus());
                    joinPartyTimeInfo.setJoinPartyTime(employeeInfo.getJoinPartyTime());
                    joinPartyTimeInfo.setJoinPartyIntroducer(employeeInfo.getJoinPartyIntroducer());
                    joinPartyTimeInfo.setJoinGroupTime(employeeInfo.getJoinGroupTime());
                    joinPartyTimeInfo.setJoinPartyTimeProblemDetail(employeeInfo.getJoinPartyTimeProblemDetail());
                    joinPartyTimeInfo.setJoinPartyTimeCheckResult(employeeInfo.getJoinPartyTimeCheckResult());
                    joinPartyTimeInfo.setJoinPartyTimeResearchSituation(employeeInfo.getJoinPartyTimeResearchSituation());
                    joinPartyTimeInfo.setJoinPartyTimeRemark(employeeInfo.getJoinPartyTimeRemark());
                    joinPartyTimeInfo.setJoinPartyTimeHaveProblem(employeeInfo.getJoinPartyTimeHaveProblem());
                    joinPartyTimeInfo.setUpdateBy(employeeInfo.getUpdateBy());
                    joinPartyTimeInfo.setUpdateTime(new Date());
                    //工作开始时间认定表
                    StartingJobTimeInfo startingJobTimeInfo = new StartingJobTimeInfo();
                    startingJobTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    startingJobTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    startingJobTimeInfo.setStartingJobTimeOwn(employeeInfo.getStartingJobTimeOwn());
                    startingJobTimeInfo.setStartingJobTimeArchvies(employeeInfo.getStartingJobTimeArchvies());
                    startingJobTimeInfo.setStartingJobTimeJudgment(employeeInfo.getStartingJobTimeJudgment());
                    startingJobTimeInfo.setStartingJobTime(employeeInfo.getStartingJobTime());
                    startingJobTimeInfo.setLaborDispatchTime(employeeInfo.getLaborDispatchTime());
                    startingJobTimeInfo.setStartingJobTimeThiscompany(employeeInfo.getStartingJobTimeThiscompany());
                    startingJobTimeInfo.setStartingJobTimeProblemDetail(employeeInfo.getStartingJobTimeProblemDetail());
                    startingJobTimeInfo.setStartingJobTimeProblemCategory(employeeInfo.getStartingJobTimeProblemCategory());
                    startingJobTimeInfo.setStartingJobTimeCheckResult(employeeInfo.getStartingJobTimeCheckResult());
                    startingJobTimeInfo.setStartingJobTimeCheckRemark(employeeInfo.getStartingJobTimeCheckRemark());
                    startingJobTimeInfo.setStartingJobTimeHaveProblem(employeeInfo.getStartingJobTimeHaveProblem());
                    startingJobTimeInfo.setUpdateBy(employeeInfo.getUpdateBy());
                    startingJobTimeInfo.setUpdateTime(new Date());
                    //工作经历认定表
                    WorkExperienceInfo workExperienceInfo = new WorkExperienceInfo();
                    workExperienceInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    workExperienceInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    workExperienceInfo.setWorkExperienceProblemDetail(employeeInfo.getWorkExperienceProblemDetail());
                    workExperienceInfo.setWorkExperienceProblemCategory(employeeInfo.getWorkExperienceProblemCategory());
                    workExperienceInfo.setWorkExperienceCheckResult(employeeInfo.getWorkExperienceCheckResult());
                    workExperienceInfo.setWorkExperienceRemark(employeeInfo.getWorkExperienceRemark());
                    workExperienceInfo.setWorkExperienceHaveProblem(employeeInfo.getWorkExperienceHaveProblem());
                    workExperienceInfo.setUpdateBy(employeeInfo.getUpdateBy());
                    workExperienceInfo.setUpdateTime(new Date());
/*                    //学历详情表
                    EducationDetailInfo educationDetailInfo=new EducationDetailInfo();
                    educationDetailInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    educationDetailInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    educationDetailInfo.setHighestDegree(employeeInfo.getHighestDegree());
                    educationDetailInfo.setHighestEducation(employeeInfo.getHighestEducation());
                    educationDetailInfo.setHighestDegreeSecond(employeeInfo.getHighestDegreeSecond());
                    educationDetailInfo.setHighestEducationSecond(employeeInfo.getHighestEducationSecond());
                    educationDetailInfo.setHighestEducationThird(employeeInfo.getHighestEducationThird());
                    educationDetailInfo.setHighestDegreeThird(employeeInfo.getHighestDegreeThird());
                    educationDetailInfo.setUpdateBy(employeeInfo.getUpdateBy());
                    educationDetailInfo.setUpdateTime(new Date());*/
                    //有重复员工编号的值直接覆盖掉
                    if(employeeInfoService.queryByEmployeeId(employeeInfo.getEmployeeId())!=null){
                        employeeInfo.setId(employeeInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
                        birthdayInfo.setId(birthdayInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
                        educationInfo.setId(educationInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
                        joinPartyTimeInfo.setId(joinPartyTimeInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
                        startingJobTimeInfo.setId(startingJobTimeInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
                        workExperienceInfo.setId(workExperienceInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
              /*          educationDetailInfo.setId(this.educationInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());*/
                        EmployeeInfo target =this.employeeInfoService.queryById(employeeInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
                        EmployeeInfo e= this.employeeInfoService.update(employeeInfo);
                        this.birthdayInfoService.update(birthdayInfo);
                        this.educationInfoService.update(educationInfo);
                        this.joinPartyTimeInfoService.update(joinPartyTimeInfo);
                        this.startingJobTimeInfoService.update(startingJobTimeInfo);
                        this.workExperienceInfoService.update(workExperienceInfo);
           /*             this.educationDetailInfoService.update(educationDetailInfo);*/
                        //更新操作日志记录
                        ChangeRecordUtil<EmployeeInfo> t= new ChangeRecordUtil<EmployeeInfo>();
                        List<changePojo> list = t.contrastObj(target,e);
                        System.out.println("lenth is"+list.size());
                        for(changePojo changePojolist:list){
                            Object param1=changePojolist.getOldValue();
                            Object param2=changePojolist.getNewValue();
                            if(param1 instanceof Date){
                                String pattern = "yyyy-MM-dd HH:mm:ss";
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                                param1= simpleDateFormat.format(param1);
                            }
                            if(param2 instanceof Date){
                                String pattern = "yyyy-MM-dd HH:mm:ss";
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                                param2= simpleDateFormat.format(param2);
                            }
                            ordinaryOperateLog.setEmployeeId(target.getEmployeeId());
                            ordinaryOperateLog.setEmployeeName(target.getEmployeeName());
                            ordinaryOperateLog.setCheckTableName("员工信息表");
                            ordinaryOperateLog.setOperateType("修改");
                            ordinaryOperateLog.setCheckColumnName(changePojolist.getCheckColumnName());
                            ordinaryOperateLog.setOldValue(String.valueOf(param1));
                            ordinaryOperateLog.setNewValue(String.valueOf(param2));
                            ordinaryOperateLog.setOperateTime(new Date());

                            String userName1 = String.valueOf(session.getAttribute("userName"));
                             ordinaryOperateLog.setOperator(userName1);
                            this.ordinaryOperateLogService.insert(ordinaryOperateLog);
                        }
                    }else {
                        count += this.employeeInfoService.insert(employeeInfo);
                        count += this.birthdayInfoService.insert(birthdayInfo);
                        count += this.educationInfoService.insert(educationInfo);
                        count += this.joinPartyTimeInfoService.insert(joinPartyTimeInfo);
                        count += this.startingJobTimeInfoService.insert(startingJobTimeInfo);
                        count += this.workExperienceInfoService.insert(workExperienceInfo);
       /*                 count += this.educationDetailInfoService.insert(educationDetailInfo);*/
                        if (count == 6) {
                            System.out.println("成功");
                        }
                    }
                }
                res.setMsg("导入成功");
                res.setTotalCount(employeeInfoList.size());
                if(employeeInfoList.size()==0){
                    res.setSuccess(false);
                    res.setMsg("导入失败！没有对应的数据！");
                }
                System.out.println("从Excel导入数据一共 {} 行 "+employeeInfoList.size());
            } }catch (IOException e) {
             System.out.println("导入失败：{}"+e.getMessage());
             res.setMsg("导入失败！出现异常！");
             res.setSuccess(false);
        } catch (Exception e1) {
            System.out.println("导入失败：{}"+e1.getMessage());
            res.setMsg("导入失败！出现异常");
            res.setSuccess(false);
        }
        return res;
    }

    /**
     *
     * @Title: export
     * @Description: 导出excel
     * @Description: 导出excel
     * @param response,request
     * @return void
     */
    @PostMapping("exportExcel")
    public void export(HttpServletResponse response, @RequestBody EmployeeInfo employeeInfo) throws Exception {
        System.out.println("开始导出");
        // 模拟从数据库获取需要导出的数据 (偷懒，嘻嘻！)
        List<EmployeeInfo> personList = this.employeeInfoService.queryAll(employeeInfo);
        //设置序号（将id字段作为序号，导出后实现序号递增）
        Integer i =1;
        for (EmployeeInfo employeeInfo1 : personList) {
            employeeInfo1.setId(i++);
        }
        // 导出操作
        ExcelUtils.exportExcel(personList, "员工信息导出功能(员工表)", "导出sheet1", EmployeeInfo.class, "员工基本信息表.xls", response);
    }

    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/template/employee.xlsx");
        try (OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            //显示下载进度
            response.setHeader("Content-Length", String.valueOf(this.getClass().getResourceAsStream("/template/employee.xlsx")));
            response.setContentType("application/octet-stream");
            // 指定下载的文件名
            response.setHeader("Content-disposition", "attachment; filename=" + new String("employee.xlsx".getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            outputStream.flush();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}