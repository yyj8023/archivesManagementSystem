package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.common.CommonController;
import com.archivesManagementSystem.springboot.entity.*;
import com.archivesManagementSystem.springboot.service.EducationInfoService;
import com.archivesManagementSystem.springboot.service.EmployeeInfoService;
import com.archivesManagementSystem.springboot.service.OrdinaryOperateLogService;
import com.archivesManagementSystem.springboot.util.*;
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
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * 学历学位信息认定表(EducationInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:32:14
 */
@CrossOrigin
@RestController
@RequestMapping("educationInfo")
public class EducationInfoController {
    /**
     * 服务对象
     */
    @Resource
    private EducationInfoService educationInfoService;
    @Resource
    private EmployeeInfoService employeeInfoService;
    @Resource
    private OrdinaryOperateLogService ordinaryOperateLogService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Result selectOne(Integer id) {
        Result res = new GeneralResult(true);

        if(this.educationInfoService.queryById(id)!=null){
            res.setData(this.educationInfoService.queryById(id));
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
     * @param educationInfo
     * @return 实体对象，若为空，则插入不成功
     */
    @PostMapping("insert")
    @ResponseBody
    public Result insert(@RequestBody EducationInfo educationInfo){
        Result res=new GeneralResult(true);
        this.educationInfoService.insert(educationInfo);
        res.setCode(CommonController.SUCCESS);
        res.setMsg("新增学历信息成功！");
        return  res;
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Result delete(@RequestBody  int id){
        Result res=new GeneralResult(true);
        EducationInfo educationInfo=new EducationInfo();
        educationInfo=this.educationInfoService.queryById(id);
        if(educationInfo!=null) {
            res.setData(educationInfo);
            this.educationInfoService.deleteById(id);
            res.setCode(CommonController.SUCCESS);
            res.setMsg("删除成功！");
        }else{
            res.setCode(CommonController.ERROR);
            res.setMsg("删除失败！");
            res.setSuccess(false);
        }
        return res;

    }

    /**
     * 根据某个字段查询所有的实体集合
     * @param employeeInfo
     * @return List集合
     */

    @GetMapping("selectAll")
    public List<EducationInfo> selectAll(EducationInfo employeeInfo){
        return this.educationInfoService.queryAll(employeeInfo);
    }

    /**
     * 查询全部数据分页展示
     * @return
     * @throws Exception
     */
    @PostMapping("selectAllForPage")
    @ResponseBody
    public PageInfo<EducationInfo> selectAllForPage(@RequestBody EducationInfo educationInfo ) throws Exception {
        PageHelper.startPage(educationInfo.getStart(), educationInfo.getSize());
        List<EducationInfo> educationInfoList = new Vector<EducationInfo>();
        List<EducationInfo> educationInfoList1= new Vector<>();
        EducationInfo educationInfo1 = new EducationInfo();
        EducationInfo educationInfo2 = new EducationInfo();
        if(educationInfo.getEmployeeId()==""){
            educationInfo.setEmployeeId(null);
        }
        if(educationInfo.getEmployeeName()==""){
            educationInfo.setEmployeeName(null);
        }
        if (educationInfo.getEmployeeName() != null && educationInfo.getEmployeeId() == null) {
            String[] employeeNameArray = educationInfo.getEmployeeName().split(" ");
            for (int i = 0; i < employeeNameArray.length; i++) {
                System.out.println("员工NAME" + employeeNameArray[i]);
                educationInfo2.setEmployeeName(employeeNameArray[i]);
                educationInfoList1 = this.educationInfoService.queryAll(educationInfo2);
                if (educationInfo1 != null) {
                    educationInfoList.addAll(educationInfoList1);
                }
            }
            PageInfo<EducationInfo> page = new PageInfo<>(educationInfoList);
            return page;
        } else if (educationInfo.getEmployeeName() == null && educationInfo.getEmployeeId() != null) {
            String[] employeeIdArray = educationInfo.getEmployeeId().split(" ");
            for (int i = 0; i < employeeIdArray.length; i++) {
                System.out.println("员工Id" + employeeIdArray[i]);
                educationInfo1 = this.educationInfoService.queryByEmployeeId(employeeIdArray[i]);
                if (educationInfo1 != null) {
                    educationInfoList.add(educationInfo1);
                }
            }
            PageInfo<EducationInfo> page = new PageInfo<>(educationInfoList);
            return page;
        } else if (educationInfo.getEmployeeName() != null && educationInfo.getEmployeeId() != null) {
            String[] employeeNameArray = educationInfo.getEmployeeName().split(" ");
            String[] employeeIdArray = educationInfo.getEmployeeId().split(" ");
            if (employeeIdArray.length > 1 || employeeNameArray.length > 1) {
                //为空。两个都有且超过1，太多了，返回为空值
            } else if (employeeIdArray.length == 1 && employeeNameArray.length == 1) {
                //两个都为一个值时。精准查询
                educationInfo2.setEmployeeId(employeeIdArray[0]);
                educationInfo2.setEmployeeName(employeeNameArray[0]);
                educationInfoList = this.educationInfoService.queryAll(educationInfo2);
            }
            PageInfo<EducationInfo> page = new PageInfo<>(educationInfoList);
            return  page;
        } else {
            List<EducationInfo> cs = this.educationInfoService.queryAll(educationInfo);
            PageInfo<EducationInfo> page = new PageInfo<>(cs);
            return page;
        }
    }
/*    public PageInfo<EducationInfo> selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<EducationInfo> cs=this.educationInfoService.queryAllByPage();
        PageInfo<EducationInfo> page = new PageInfo<>(cs);
        return page;
        *//*m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;*//*
    }*/

    /**
     * 根据实体类做更新
     * @param educationInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  Result update(@RequestBody EducationInfo educationInfo,HttpServletRequest request){
        String userName=request.getHeader("token");
        Result res=new GeneralResult(true);
        educationInfo.setUpdateBy(userName);
        educationInfo.setUpdateTime(new Date());
        educationInfo=this.educationInfoService.update(educationInfo);
        EmployeeInfo employeeInfo=new EmployeeInfo();
        EmployeeInfo target=this.employeeInfoService.queryByEmployeeId(educationInfo.getEmployeeId());
        //也对大表做更新
        employeeInfo.setEducationProblemDetail(educationInfo.getEducationProblemDetail());
        employeeInfo.setEducationProblemCategory(educationInfo.getEducationProblemCategory());
        employeeInfo.setEmployeeName(educationInfo.getEmployeeName());
        employeeInfo.setEmployeeId(educationInfo.getEmployeeId());
        employeeInfo.setEducationCheckResult(educationInfo.getEducationCheckResult());
        employeeInfo.setEducationBackgroudJudgment(educationInfo.getEducationBackgroudJudgment());
        employeeInfo.setEducationDegreeJudgment(educationInfo.getEducationDegreeeJudgment());

        employeeInfo.setHighestDegree(educationInfo.getHighestDegree());
        employeeInfo.setHighestEducation(educationInfo.getHighestEducationSecond());
        employeeInfo.setHighestDegreeSecond(educationInfo.getHighestEducationSecond());
        employeeInfo.setHighestEducationSecond(educationInfo.getHighestDegreeSecond());
        employeeInfo.setHighestDegreeThird(educationInfo.getHighestEducationThird());
        employeeInfo.setHighestEducationThird(educationInfo.getHighestDegreeThird());

        employeeInfo.setEducationRemark(educationInfo.getEducationRemark());
        employeeInfo.setEducationDegree(educationInfo.getEducationDegree());
        employeeInfo.setEducationBackgroud(educationInfo.getEducationBackgroud());
        employeeInfo.setId(this.employeeInfoService.queryByEmployeeId(educationInfo.getEmployeeId()).getId());
        employeeInfo.setEducationHaveProblem(educationInfo.getEducationHaveProblem());
        employeeInfo.setUpdateTime(new Date());
        educationInfo.setUpdateBy(userName);
        //更新大表对应模块
        this.employeeInfoService.update(employeeInfo);
        ChangeRecordUtil<EmployeeInfo> t= new ChangeRecordUtil<EmployeeInfo>();
        List<changePojo> list = t.contrastObj(target,employeeInfo);
        System.out.println("lenth is"+list.size());
        OrdinaryOperateLog ordinaryOperateLog=new OrdinaryOperateLog();
        for(changePojo changePojolist:list){
            ordinaryOperateLog.setEmployeeId(target.getEmployeeId());
            ordinaryOperateLog.setEmployeeName(target.getEmployeeName());
            ordinaryOperateLog.setCheckTableName("学历模块");
            ordinaryOperateLog.setOperateType("修改");
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
            ordinaryOperateLog.setCheckColumnName(changePojolist.getCheckColumnName());
            ordinaryOperateLog.setOldValue(String.valueOf(param1));
            ordinaryOperateLog.setNewValue(String.valueOf(param2));
            ordinaryOperateLog.setOperateTime(new Date());
            ordinaryOperateLog.setOperator(userName);
            this.ordinaryOperateLogService.insert(ordinaryOperateLog);
        }
        res.setCode(CommonController.SUCCESS);
       res.setMsg("更新成功！");
       res.setData(educationInfo);
       if(educationInfo==null){
           res.setCode(CommonController.ERROR);
           res.setMsg("更新失败！");
           res.setSuccess(false);
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
        importParams.setHeadRows(1);
        //表头行数,默认1
        importParams.setTitleRows(1);
        //是否需要校验上传的Excel,默认false
        importParams.setNeedVerfiy(false);

        try {
            ExcelImportResult<EducationInfo> result = ExcelImportUtil.importExcelMore(file.getInputStream(), EducationInfo.class, importParams);
            if(result.isVerfiyFail()){
                res.setSuccess(false);
                res.setCode(CommonController.ERROR);
                res.setMsg("导入失败");
            }else{
                int count=0;
                List<EducationInfo> educationInfos = result.getList();
                Iterator<EducationInfo> employeeInfoIterator=educationInfos.iterator();
                while(employeeInfoIterator.hasNext()){
                    EducationInfo employeeInfo=employeeInfoIterator.next();
                    if(employeeInfo.getEmployeeName()==null){
                        employeeInfoIterator.remove();
                    }
                }
                for (EducationInfo educationInfo: educationInfos) {
                    //TODO 将导入的数据做保存数据库操作,先将所有数据id设置为null
                    count=this.educationInfoService.insert(educationInfo);
                    if(count==1){
                        System.out.println("成功");
                    }
                }
                res.setCode(CommonController.SUCCESS);
                res.setMsg("导入成功");
                res.setTotalCount(educationInfos.size());
                if(educationInfos.size()==0){
                    res.setSuccess(false);
                }
                System.out.println("从Excel导入数据一共 {} 行 "+educationInfos.size());
            } }catch (IOException e) {
            System.out.println("导入失败：{}"+e.getMessage());
            res.setCode(CommonController.ERROR);
            res.setMsg("导入失败！出现异常！");
            res.setSuccess(false);
        } catch (Exception e1) {
            System.out.println("导入失败：{}"+e1.getMessage());
            res.setCode(CommonController.ERROR);
            res.setMsg("导入失败！出现异常！");
            res.setSuccess(false);
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
    @PostMapping("exportExcel")
    public void export(HttpServletResponse response, @RequestBody EducationInfo educationInfo) throws Exception {
        System.out.println("开始导出");
        // 模拟从数据库获取需要导出的数据 (偷懒，嘻嘻！)
        List<EducationInfo> personList = this.educationInfoService.queryAll(educationInfo);
        //设置序号（将id字段作为序号，导出后实现序号递增）
        Integer i =1;
        for (EducationInfo educationInfo1 : personList) {
            educationInfo1.setId(i++);
        }
        // 导出操作
        ExcelUtils.exportExcel(personList, "学历认定表", "导出sheet1", EducationInfo.class, "学历认定基本信息表.xls", response);
    }

    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/template/educationInfo.xlsx");
        try (OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            //显示下载进度
            response.setHeader("Content-Length", String.valueOf(this.getClass().getResourceAsStream("/template/educationInfo.xlsx")));
            response.setContentType("application/octet-stream");
            // 指定下载的文件名
            response.setHeader("Content-disposition", "attachment; filename=" + new String("educationInfo.xlsx".getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}