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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 员工基本信息表(EmployeeInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-20 22:14:49
 */
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
     * @return int 若为6,则插入成功！(增加员工表的同时也增加了五个认定表初始值）
     */
    @PostMapping("insert")
    @ResponseBody
    public int insert(@RequestBody EmployeeInfo employeeInfo)
    {
        int count=0;
        count+=this.employeeInfoService.insert(employeeInfo);
        //生成出生日期认定表基本信息
        BirthdayInfo birthdayInfo=new BirthdayInfo();
        birthdayInfo.setEmployeeId(employeeInfo.getEmployeeId());
        birthdayInfo.setEmployeeName(employeeInfo.getEmployeeName());
        birthdayInfo.setBirthdayCard(employeeInfo.getBirthdayCard());
        birthdayInfo.setBirthdayArchives(employeeInfo.getBirthdayArchives());
        birthdayInfo.setBirthdayJudgment(employeeInfo.getBirthdayJudgment());
        birthdayInfo.setUpdateBy(employeeInfo.getUpdateBy());
        birthdayInfo.setUpdateTime(new Date());
        count+=this.birthdayInfoService.insert(birthdayInfo);
        //学历信息认定表基本信息
        EducationInfo educationInfo=new EducationInfo();
        educationInfo.setEmployeeId(employeeInfo.getEmployeeId());
        educationInfo.setEmployeeName(employeeInfo.getEmployeeName());
        educationInfo.setEducationDegree(employeeInfo.getEducationDegree());
        educationInfo.setEducationBackgroud(employeeInfo.getEducationBackgroud());
        educationInfo.setEducationBackgroudJudgment(employeeInfo.getEducationBackgroudJudgment());
        educationInfo.setEducationDegreeeJudgment(employeeInfo.getEducationDegreeJudgment());
        educationInfo.setUpdateBy(educationInfo.getUpdateBy());
        educationInfo.setUpdateTime(new Date());
        count+=this.educationInfoService.insert(educationInfo);
        //入党时间认定表基本信息
        JoinPartyTimeInfo joinPartyTimeInfo=new JoinPartyTimeInfo();
        joinPartyTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
        joinPartyTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
        joinPartyTimeInfo.setJoinPartyTime(employeeInfo.getJoinPartyTime());
        joinPartyTimeInfo.setJoinPartyIntroducer(employeeInfo.getJoinPartyIntroducer());
        joinPartyTimeInfo.setJoinGroupTime(employeeInfo.getJoinGroupTime());
        joinPartyTimeInfo.setUpdateBy(employeeInfo.getUpdateBy());
        joinPartyTimeInfo.setUpdateTime(new Date());
        count+=this.joinPartyTimeInfoService.insert(joinPartyTimeInfo);
        //工作开始时间认定表
        StartingJobTimeInfo startingJobTimeInfo=new StartingJobTimeInfo();
        startingJobTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
        startingJobTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
        startingJobTimeInfo.setStartingJobTimeOwn(employeeInfo.getStartingJobTimeOwn());
        startingJobTimeInfo.setStartingJobTimeArchvies(employeeInfo.getStartingJobTimeArchvies());
        startingJobTimeInfo.setStartingJobTimeJudgment(employeeInfo.getStartingJobTimeJudgment());
        startingJobTimeInfo.setUpdateBy(employeeInfo.getUpdateBy());
        startingJobTimeInfo.setUpdateTime(new Date());
        count+=this.startingJobTimeInfoService.insert(startingJobTimeInfo);
        //工作经历认定表
        WorkExperienceInfo workExperienceInfo=new WorkExperienceInfo();
        workExperienceInfo.setEmployeeId(employeeInfo.getEmployeeId());
        workExperienceInfo.setEmployeeName(employeeInfo.getEmployeeName());
        workExperienceInfo.setUpdateBy(employeeInfo.getUpdateBy());
        workExperienceInfo.setUpdateTime(new Date());
        count+=this.workExperienceInfoService.insert(workExperienceInfo);
        return  count;

    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Boolean delete(int id){
        EmployeeInfo employeeInfo=new EmployeeInfo();
        employeeInfo=this.employeeInfoService.queryById(id);
        try {
            this.birthdayInfoService.deleteByEmployee(employeeInfo.getEmployeeId(), employeeInfo.getEmployeeName());
            this.startingJobTimeInfoService.deleteByEmployee(employeeInfo.getEmployeeId(), employeeInfo.getEmployeeName());
            this.joinPartyTimeInfoService.deleteByEmployee(employeeInfo.getEmployeeId(), employeeInfo.getEmployeeName());
            this.educationInfoService.deleteByEmployee(employeeInfo.getEmployeeId(), employeeInfo.getEmployeeName());
            this.workExperienceInfoService.deleteByEmployee(employeeInfo.getEmployeeId(), employeeInfo.getEmployeeName());
        }catch (Exception e){
            e.printStackTrace();
        }
        return this.employeeInfoService.deleteById(id);
    }

    /**
     * 根据某个字段查询所有的实体集合
     * @param employeeInfo
     * @return List集合
     */

    @GetMapping("selectAll")
    public List<EmployeeInfo> selectAll(EmployeeInfo employeeInfo){
        return  this.employeeInfoService.queryAll(employeeInfo);
    }

    /**
     * 查询全部数据分页展示
     * @param m
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("selectAllForPage")
    public PageInfo<EmployeeInfo> selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<EmployeeInfo> cs=this.employeeInfoService.queryAllByPage();
        PageInfo<EmployeeInfo> page = new PageInfo<>(cs);
        return page;
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
    public  EmployeeInfo update(@RequestBody EmployeeInfo employeeInfo){
        return this.employeeInfoService.update(employeeInfo);
    }

    @PostMapping("importExcel")
    @ResponseBody
    public Result importExcel(@RequestParam("file") MultipartFile file) {
        Result res=new GeneralResult(true);
        ImportParams importParams = new ImportParams();
        // 数据处理
        //表格标题行数,默认0
        importParams.setHeadRows(1);
        //表头行数,默认1
        importParams.setTitleRows(1);
        //是否需要校验上传的Excel,默认false
        importParams.setNeedVerfiy(false);

        try {
            ExcelImportResult<EmployeeInfo> result = ExcelImportUtil.importExcelMore(file.getInputStream(), EmployeeInfo.class, importParams);
            if(result.isVerfiyFail()){
                res.setSuccess(false);
                res.setMsg("导入失败");
            }else{
                List<EmployeeInfo> employeeInfoList = result.getList();
                for (EmployeeInfo employeeInfo: employeeInfoList) {
                    int count=0;
                    //TODO 将导入的数据做保存数据库操作,先将所有数据id设置为null
                    count+=this.employeeInfoService.insert(employeeInfo);
                    //生成出生日期认定表基本信息
                    BirthdayInfo birthdayInfo=new BirthdayInfo();
                    birthdayInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    birthdayInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    birthdayInfo.setBirthdayCard(employeeInfo.getBirthdayCard());
                    birthdayInfo.setBirthdayArchives(employeeInfo.getBirthdayArchives());
                    birthdayInfo.setBirthdayJudgment(employeeInfo.getBirthdayJudgment());
                    birthdayInfo.setUpdateBy(employeeInfo.getUpdateBy());
                    birthdayInfo.setUpdateTime(new Date());
                    count+=this.birthdayInfoService.insert(birthdayInfo);
                    //学历信息认定表基本信息
                    EducationInfo educationInfo=new EducationInfo();
                    educationInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    educationInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    educationInfo.setEducationDegree(employeeInfo.getEducationDegree());
                    educationInfo.setEducationBackgroud(employeeInfo.getEducationBackgroud());
                    educationInfo.setEducationBackgroudJudgment(employeeInfo.getEducationBackgroudJudgment());
                    educationInfo.setEducationDegreeeJudgment(employeeInfo.getEducationDegreeJudgment());
                    educationInfo.setUpdateBy(educationInfo.getUpdateBy());
                    educationInfo.setUpdateTime(new Date());
                    count+=this.educationInfoService.insert(educationInfo);
                    //入党时间认定表基本信息
                    JoinPartyTimeInfo joinPartyTimeInfo=new JoinPartyTimeInfo();
                    joinPartyTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    joinPartyTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    joinPartyTimeInfo.setJoinPartyTime(employeeInfo.getJoinPartyTime());
                    joinPartyTimeInfo.setJoinPartyIntroducer(employeeInfo.getJoinPartyIntroducer());
                    joinPartyTimeInfo.setJoinGroupTime(employeeInfo.getJoinGroupTime());
                    joinPartyTimeInfo.setUpdateBy(employeeInfo.getUpdateBy());
                    joinPartyTimeInfo.setUpdateTime(new Date());
                    count+=this.joinPartyTimeInfoService.insert(joinPartyTimeInfo);
                    //工作开始时间认定表
                    StartingJobTimeInfo startingJobTimeInfo=new StartingJobTimeInfo();
                    startingJobTimeInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    startingJobTimeInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    startingJobTimeInfo.setStartingJobTimeOwn(employeeInfo.getStartingJobTimeOwn());
                    startingJobTimeInfo.setStartingJobTimeArchvies(employeeInfo.getStartingJobTimeArchvies());
                    startingJobTimeInfo.setStartingJobTimeJudgment(employeeInfo.getStartingJobTimeJudgment());
                    startingJobTimeInfo.setUpdateBy(employeeInfo.getUpdateBy());
                    startingJobTimeInfo.setUpdateTime(new Date());
                    count+=this.startingJobTimeInfoService.insert(startingJobTimeInfo);
                    //工作经历认定表
                    WorkExperienceInfo workExperienceInfo=new WorkExperienceInfo();
                    workExperienceInfo.setEmployeeId(employeeInfo.getEmployeeId());
                    workExperienceInfo.setEmployeeName(employeeInfo.getEmployeeName());
                    workExperienceInfo.setUpdateBy(employeeInfo.getUpdateBy());
                    workExperienceInfo.setUpdateTime(new Date());
                    count+=this.workExperienceInfoService.insert(workExperienceInfo);
                    if(count==6){
                        System.out.println("成功");
                    }
                }
                res.setMsg("导入成功");
                res.setData(employeeInfoList.size());
                System.out.println("从Excel导入数据一共 {} 行 "+employeeInfoList.size());
            } }catch (IOException e) {
            System.out.println("导入失败：{}"+e.getMessage());
        } catch (Exception e1) {
            System.out.println("导入失败：{}"+e1.getMessage());
        }
        return res;
    }

    /**
     *
     * @Title: export
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
}