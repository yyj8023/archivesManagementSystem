package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.entity.*;
import com.archivesManagementSystem.springboot.service.*;
import com.archivesManagementSystem.springboot.util.ExcelUtils;
import com.archivesManagementSystem.springboot.util.GeneralResult;
import com.archivesManagementSystem.springboot.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.util.IOUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

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


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public EmployeeInfo selectOne(Integer id) {
        return this.employeeInfoService.queryById(id);
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
            educationInfo.setUpdateBy(employeeInfo.getUpdateBy());
            educationInfo.setUpdateTime(new Date());
            count += this.educationInfoService.insert(educationInfo);
            //入党时间认定表基本信息
            JoinPartyTimeInfo joinPartyTimeInfo = new JoinPartyTimeInfo();
            joinPartyTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
            joinPartyTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
            joinPartyTimeInfo.setJoinPartyTime(employeeInfo.getJoinPartyTime());
            joinPartyTimeInfo.setJoinPartyIntroducer(employeeInfo.getJoinPartyIntroducer());
            joinPartyTimeInfo.setJoinGroupTime(employeeInfo.getJoinGroupTime());
            joinPartyTimeInfo.setJoinPartyTimeProblemDetail(employeeInfo.getJoinPartyTimeProblemDetail());
            joinPartyTimeInfo.setJoinPartyTimeCheckResult(employeeInfo.getJoinPartyTimeCheckResult());
            joinPartyTimeInfo.setJoinPartyTimeResearchSituation(employeeInfo.getJoinPartyTimeResearchSituation());
            joinPartyTimeInfo.setJoinPartyTimeRemark(employeeInfo.getJoinPartyTimeRemark());
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
            startingJobTimeInfo.setStartingJobTimeProblemDetail(employeeInfo.getStartingJobTimeProblemDetail());
            startingJobTimeInfo.setStartingJobTimeProblemCategory(employeeInfo.getStartingJobTimeProblemCategory());
            startingJobTimeInfo.setStartingJobTimeCheckResult(employeeInfo.getStartingJobTimeCheckResult());
            startingJobTimeInfo.setStartingJobTimeCheckRemark(employeeInfo.getStartingJobTimeCheckRemark());
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
            workExperienceInfo.setUpdateBy(employeeInfo.getUpdateBy());
            workExperienceInfo.setUpdateTime(new Date());
            count += this.workExperienceInfoService.insert(workExperienceInfo);
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
     * @param id
     * @return boolean
     */
    @GetMapping("delete")
    @ResponseBody
    public Result delete(int id) {
        Result res = new GeneralResult(true);
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
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @PostMapping("selectAllForPage")
    @ResponseBody
    public PageInfo<EmployeeInfo> selectAllForPage(@RequestBody EmployeeInfo employeeInfo, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size);
        List<EmployeeInfo> employeeInfoList = new Vector<EmployeeInfo>();
        EmployeeInfo employeeInfo1 = new EmployeeInfo();
        EmployeeInfo employeeInfo2 = new EmployeeInfo();
        if (employeeInfo.getEmployeeName() != null && employeeInfo.getEmployeeId() == null) {
            String[] employeeNameArray = employeeInfo.getEmployeeName().split(" ");
            for (int i = 0; i < employeeNameArray.length; i++) {
                System.out.println("员工NAME" + employeeNameArray[i]);
                employeeInfo1 = this.employeeInfoService.queryByEmployeeName(employeeNameArray[i]);
                if (employeeInfo1 != null) {
                    employeeInfoList.add(employeeInfo1);
                }
            }
            PageInfo<EmployeeInfo> page = new PageInfo<>(employeeInfoList);
            return page;
        } else if (employeeInfo.getEmployeeName() == null && employeeInfo.getEmployeeId() != null) {
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
        } else if (employeeInfo.getEmployeeName() != null && employeeInfo.getEmployeeId() != null) {
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
    public  Result update(@RequestBody EmployeeInfo employeeInfo){
        employeeInfo= this.employeeInfoService.update(employeeInfo);
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
    public Result importExcel(@RequestParam("file") MultipartFile file) {
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
                    educationInfo.setEducationProblemCategory(employeeInfo.getEducationProblemCategory());
                    educationInfo.setEducationProblemDetail(employeeInfo.getEducationProblemDetail());
                    educationInfo.setEducationCheckResult(employeeInfo.getEducationCheckResult());
                    educationInfo.setEducationRemark(employeeInfo.getEducationRemark());
                    educationInfo.setUpdateBy(employeeInfo.getUpdateBy());
                    educationInfo.setUpdateTime(new Date());
                    //入党时间认定表基本信息
                    JoinPartyTimeInfo joinPartyTimeInfo = new JoinPartyTimeInfo();
                    joinPartyTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    joinPartyTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    joinPartyTimeInfo.setJoinPartyTime(employeeInfo.getJoinPartyTime());
                    joinPartyTimeInfo.setJoinPartyIntroducer(employeeInfo.getJoinPartyIntroducer());
                    joinPartyTimeInfo.setJoinGroupTime(employeeInfo.getJoinGroupTime());
                    joinPartyTimeInfo.setJoinPartyTimeProblemDetail(employeeInfo.getJoinPartyTimeProblemDetail());
                    joinPartyTimeInfo.setJoinPartyTimeCheckResult(employeeInfo.getJoinPartyTimeCheckResult());
                    joinPartyTimeInfo.setJoinPartyTimeResearchSituation(employeeInfo.getJoinPartyTimeResearchSituation());
                    joinPartyTimeInfo.setJoinPartyTimeRemark(employeeInfo.getJoinPartyTimeRemark());
                    joinPartyTimeInfo.setUpdateBy(employeeInfo.getUpdateBy());
                    joinPartyTimeInfo.setUpdateTime(new Date());
                    //工作开始时间认定表
                    StartingJobTimeInfo startingJobTimeInfo = new StartingJobTimeInfo();
                    startingJobTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    startingJobTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    startingJobTimeInfo.setStartingJobTimeOwn(employeeInfo.getStartingJobTimeOwn());
                    startingJobTimeInfo.setStartingJobTimeArchvies(employeeInfo.getStartingJobTimeArchvies());
                    startingJobTimeInfo.setStartingJobTimeJudgment(employeeInfo.getStartingJobTimeJudgment());
                    startingJobTimeInfo.setStartingJobTimeProblemDetail(employeeInfo.getStartingJobTimeProblemDetail());
                    startingJobTimeInfo.setStartingJobTimeProblemCategory(employeeInfo.getStartingJobTimeProblemCategory());
                    startingJobTimeInfo.setStartingJobTimeCheckResult(employeeInfo.getStartingJobTimeCheckResult());
                    startingJobTimeInfo.setStartingJobTimeCheckRemark(employeeInfo.getStartingJobTimeCheckRemark());
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
                    workExperienceInfo.setUpdateTime(new Date());
                    //有重复员工编号的值直接覆盖掉
                    if(employeeInfoService.queryByEmployeeId(employeeInfo.getEmployeeId())!=null){
                        this.employeeInfoService.update(employeeInfo);
                        this.birthdayInfoService.update(birthdayInfo);
                        this.educationInfoService.update(educationInfo);
                        this.joinPartyTimeInfoService.update(joinPartyTimeInfo);
                        this.startingJobTimeInfoService.update(startingJobTimeInfo);
                        this.workExperienceInfoService.update(workExperienceInfo);
                    }else {
                        count += this.employeeInfoService.insert(employeeInfo);
                        count += this.birthdayInfoService.insert(birthdayInfo);
                        count += this.educationInfoService.insert(educationInfo);
                        count += this.joinPartyTimeInfoService.insert(joinPartyTimeInfo);
                        count += this.startingJobTimeInfoService.insert(startingJobTimeInfo);
                        count += this.workExperienceInfoService.insert(workExperienceInfo);
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
    @GetMapping("exportExcel")
    public void export(HttpServletResponse response, HttpServletRequest request, EmployeeInfo employeeInfo) throws Exception {
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