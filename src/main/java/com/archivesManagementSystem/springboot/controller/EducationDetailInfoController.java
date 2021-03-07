package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.common.CommonController;
import com.archivesManagementSystem.springboot.entity.*;
import com.archivesManagementSystem.springboot.service.EducationDetailInfoService;
import com.archivesManagementSystem.springboot.service.EmployeeInfoService;
import com.archivesManagementSystem.springboot.service.OrdinaryOperateLogService;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * (EducationDetailInfo)表控制层
 *
 * @author makejava
 * @since 2021-03-07 17:12:28
 */
@RestController
@RequestMapping("educationDetailInfo")
public class EducationDetailInfoController {
    /**
     * 服务对象
     */
    @Resource
    private EducationDetailInfoService educationDetailInfoService;
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
        if(this.educationDetailInfoService.queryById(id)!=null){
            res.setData(this.educationDetailInfoService.queryById(id));
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
     * @param educationDetailInfo
     * @return 实体对象，若为空，则插入不成功
     */
    @PostMapping("insert")
    @ResponseBody
    public Result insert(@RequestBody EducationDetailInfo educationDetailInfo){
        Result res=new GeneralResult(true);
        this.educationDetailInfoService.insert(educationDetailInfo);
        res.setCode(CommonController.SUCCESS);
        res.setMsg("新增学历详情信息成功！");
        return  res;
    }
    /**
     * 根据某个字段查询所有的实体集合
     * @param educationDetailInfo
     * @return List集合
     */

    @GetMapping("selectAll")
    public List<EducationDetailInfo> selectAll(EducationDetailInfo educationDetailInfo){
        return  this.educationDetailInfoService.queryAll(educationDetailInfo);
    }
    /**
     * 查询全部数据分页展示
     * @return
     * @throws Exception
     */
    @PostMapping("selectAllForPage")
    @ResponseBody
    public PageInfo<EducationDetailInfo> selectAllForPage(@RequestBody EducationDetailInfo educationDetailInfo) throws Exception {
        PageHelper.startPage(educationDetailInfo.getStart(), educationDetailInfo.getSize());
        List<EducationDetailInfo> educationDetailInfoList = new Vector<EducationDetailInfo>();
        List<EducationDetailInfo> educationDetailInfoList1=new Vector<>();
        EducationDetailInfo workExperienceInfo1 = new EducationDetailInfo();
        EducationDetailInfo workExperienceInfo2 = new EducationDetailInfo();
        if(educationDetailInfo.getEmployeeId()==""){
            educationDetailInfo.setEmployeeId(null);
        }
        if(educationDetailInfo.getEmployeeName()==""){
            educationDetailInfo.setEmployeeName(null);
        }
        if (educationDetailInfo.getEmployeeName() != null && educationDetailInfo.getEmployeeId() == null) {
            String[] employeeNameArray = educationDetailInfo.getEmployeeName().split(" ");
            for (int i = 0; i < employeeNameArray.length; i++) {
                System.out.println("员工NAME" + employeeNameArray[i]);
                workExperienceInfo2.setEmployeeName(employeeNameArray[i]);
                educationDetailInfoList1 = this.educationDetailInfoService.queryAll(workExperienceInfo2);
                if (educationDetailInfoList1.size() != 0) {
                    educationDetailInfoList.addAll(educationDetailInfoList1);
                }
            }
            PageInfo<EducationDetailInfo> page = new PageInfo<>(educationDetailInfoList);
            return page;
        } else if (educationDetailInfo.getEmployeeName() == null &&educationDetailInfo.getEmployeeId() != null) {
            String[] employeeIdArray = educationDetailInfo.getEmployeeId().split(" ");
            for (int i = 0; i < employeeIdArray.length; i++) {
                System.out.println("员工Id" + employeeIdArray[i]);
                workExperienceInfo1 = this.educationDetailInfoService.queryByEmployeeId(employeeIdArray[i]);
                if (workExperienceInfo1 != null) {
                    educationDetailInfoList.add(workExperienceInfo1);
                }
            }
            PageInfo<EducationDetailInfo> page = new PageInfo<>(educationDetailInfoList);
            return page;
        } else if (educationDetailInfo.getEmployeeName() != null && educationDetailInfo.getEmployeeId() != null) {
            String[] employeeNameArray = educationDetailInfo.getEmployeeName().split(" ");
            String[] employeeIdArray = educationDetailInfo.getEmployeeId().split(" ");
            if (employeeIdArray.length > 1 || employeeNameArray.length > 1) {
                //为空。两个都有且超过1，太多了，返回为空值
            } else if (employeeIdArray.length == 1 && employeeNameArray.length == 1) {
                //两个都为一个值时。精准查询
                workExperienceInfo2.setEmployeeId(employeeIdArray[0]);
                workExperienceInfo2.setEmployeeName(employeeNameArray[0]);
                educationDetailInfoList = this.educationDetailInfoService.queryAll(workExperienceInfo2);
            }
            PageInfo<EducationDetailInfo> page = new PageInfo<>(educationDetailInfoList);
            return  page;
        } else {
            List<EducationDetailInfo> cs = this.educationDetailInfoService.queryAll(educationDetailInfo);
            PageInfo<EducationDetailInfo> page = new PageInfo<>(cs);
            return page;
        }

    }
    /**
     * 根据实体类做更新
     * @param educationDetailInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  Result update(@RequestBody EducationDetailInfo educationDetailInfo, HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = String.valueOf(session.getAttribute("userName"));
        educationDetailInfo.setUpdateTime(new Date());
        educationDetailInfo.setUpdateBy(userName);
        educationDetailInfo= this.educationDetailInfoService.update(educationDetailInfo);
        Result res=new GeneralResult(true);
        EmployeeInfo employeeInfo=new EmployeeInfo();
        EmployeeInfo target=this.employeeInfoService.queryByEmployeeId(educationDetailInfo.getEmployeeId());
        //也对大表做更新
        employeeInfo.setUpdateBy(userName);
        employeeInfo.setUpdateTime(new Date());
        employeeInfo.setEmployeeId(educationDetailInfo.getEmployeeId());
        employeeInfo.setEmployeeName(educationDetailInfo.getEmployeeName());
        employeeInfo.setWorkExperienceCheckResult(employeeInfo.getWorkExperienceCheckResult());
        employeeInfo.setWorkExperienceProblemCategory(employeeInfo.getWorkExperienceProblemCategory());
        employeeInfo.setWorkExperienceProblemDetail(employeeInfo.getWorkExperienceProblemDetail());
        employeeInfo.setWorkExperienceProblemDetail(employeeInfo.getWorkExperienceProblemDetail());
        employeeInfo.setWorkExperienceHaveProblem(employeeInfo.getWorkExperienceHaveProblem());
        employeeInfo.setId(this.employeeInfoService.queryByEmployeeId(employeeInfo.getEmployeeId()).getId());
        //更新大表对应模块
        this.employeeInfoService.update(employeeInfo);
        ChangeRecordUtil<EmployeeInfo> t= new ChangeRecordUtil<EmployeeInfo>();
        List<changePojo> list = t.contrastObj(target,employeeInfo);
        System.out.println("lenth is"+list.size());
        OrdinaryOperateLog ordinaryOperateLog=new OrdinaryOperateLog();
        for(changePojo changePojolist:list){
            ordinaryOperateLog.setEmployeeId(target.getEmployeeId());
            ordinaryOperateLog.setEmployeeName(target.getEmployeeName());
            ordinaryOperateLog.setCheckTableName("学历详情模块");
            ordinaryOperateLog.setOperateType("修改");
            ordinaryOperateLog.setCheckColumnName(changePojolist.getCheckColumnName());
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
            ordinaryOperateLog.setOldValue(String.valueOf(param1));
            ordinaryOperateLog.setNewValue(String.valueOf(param2));
            ordinaryOperateLog.setOperateTime(new Date());
            ordinaryOperateLog.setOperator(userName);
            this.ordinaryOperateLogService.insert(ordinaryOperateLog);
        }
        res.setCode(CommonController.SUCCESS);
        res.setMsg("更新成功！");
        res.setData(educationDetailInfo);
        if(educationDetailInfo==null){
            res.setSuccess(false);
            res.setCode(CommonController.ERROR);
            res.setMsg("更新失败！");
        }
        return  res;
    }
    /**
     *
     * @Title: export
     * @Description: 导出excel
     * @param response,request
     * @return void
     */
    @GetMapping("exportExcel")
    public void export(HttpServletResponse response, HttpServletRequest request, EducationDetailInfo educationDetailInfo) throws Exception {
        System.out.println("开始导出");
        // 模拟从数据库获取需要导出的数据 (偷懒，嘻嘻！)
        List<EducationDetailInfo> personList = this.educationDetailInfoService.queryAll(educationDetailInfo);
        //设置序号（将id字段作为序号，导出后实现序号递增）
        Integer i =1;
        for (EducationDetailInfo educationDetailInfo1 : personList) {
            educationDetailInfo1.setId(i++);
        }
        // 导出操作
        ExcelUtils.exportExcel(personList, "学历详情表", "导出sheet1",EducationDetailInfo.class, "学历详情信息表.xls", response);
    }
    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/template/educationDetailInfo.xlsx");
        try (OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            //显示下载进度
            response.setHeader("Content-Length", String.valueOf(this.getClass().getResourceAsStream("/template/educationDetailInfo.xlsx")));
            response.setContentType("application/octet-stream");
            // 指定下载的文件名
            response.setHeader("Content-disposition", "attachment; filename=" + new String("educationDetailInfo.xlsx".getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @PostMapping("importExcel")
    @ResponseBody
    public Result importExcel(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        HttpSession session = request.getSession();
        OrdinaryOperateLog ordinaryOperateLog=new OrdinaryOperateLog();
        Result res=new GeneralResult(true);
        ImportParams importParams = new ImportParams();
        // 数据处理
        //表格标题行数,默认0
        importParams.setTitleRows(1);
        //表头行数,默认1
        importParams.setHeadRows(1);
        //是否需要校验上传的Excel,默认false
        importParams.setNeedVerfiy(false);

        try {
            ExcelImportResult<EducationDetailInfo> result = ExcelImportUtil.importExcelMore(file.getInputStream(), EducationDetailInfo.class, importParams);
            if(result.isVerfiyFail()){
                res.setSuccess(false);
                res.setMsg("导入失败");
            }else{
                List<EducationDetailInfo> educationDetailInfoList = result.getList();
                Iterator<EducationDetailInfo> educationDetailInfoIterator=educationDetailInfoList.iterator();
                while(educationDetailInfoIterator.hasNext()){
                    EducationDetailInfo educationDetailInfo=educationDetailInfoIterator.next();
                    if(educationDetailInfo.getEmployeeName()==null){
                        educationDetailInfoIterator.remove();
                    }
                }
                for (EducationDetailInfo educationDetailInfo:educationDetailInfoList ) {
                    int count=0;
                    String userName = String.valueOf(session.getAttribute("userName"));
                    educationDetailInfo.setUpdateBy(userName);
                    educationDetailInfo.setUpdateTime(new Date());
                    //有重复员工编号的值直接覆盖掉
                    if(educationDetailInfoService.queryByEmployeeId(educationDetailInfo.getEmployeeId())!=null){
                        EducationDetailInfo target =this.educationDetailInfoService.queryById(educationDetailInfoService.queryByEmployeeId(educationDetailInfo.getEmployeeId()).getId());
                        EducationDetailInfo e= this.educationDetailInfoService.update(educationDetailInfo);
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
                        count += this.educationDetailInfoService.insert(educationDetailInfo);
                        if (count == 1) {
                            System.out.println("成功");
                        }
                    }
                }
                res.setMsg("导入成功");
                res.setTotalCount(educationDetailInfoList.size());
                if(educationDetailInfoList.size()==0){
                    res.setSuccess(false);
                    res.setMsg("导入失败！没有对应的数据！");
                }
                System.out.println("从Excel导入数据一共 {} 行 "+educationDetailInfoList.size());
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
}