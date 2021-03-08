package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.common.CommonController;
import com.archivesManagementSystem.springboot.entity.*;
import com.archivesManagementSystem.springboot.service.BirthdayInfoService;
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
 * 出生日期信息认定表(BirthdayInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:31:38
 */
@CrossOrigin
@RestController
@RequestMapping("birthdayInfo")
public class BirthdayInfoController {
    /**
     * 服务对象
     */
    @Resource
    private BirthdayInfoService birthdayInfoService;
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

        if(this.birthdayInfoService.queryById(id)!=null){
            res.setData(this.birthdayInfoService.queryById(id));
            res.setMsg("查询成功");
        }else{
            res.setMsg("没有找到对应的值");
            res.setSuccess(false);
        }
        return  res;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param birthdayInfo 实例对象
     * @return 对象列表
     */
    @GetMapping("selectAll")
    @ResponseBody
    public List<BirthdayInfo> selectAll(BirthdayInfo birthdayInfo) {
        List<BirthdayInfo> result = this.birthdayInfoService.queryAll(birthdayInfo);
        return result;
    }

    /**
     * 查询全部数据分页展示
     * @return
     * @throws Exception
     */
    @PostMapping("selectAllForPage")
    @ResponseBody
    public PageInfo<BirthdayInfo> selectAllForPage(@RequestBody BirthdayInfo birthdayInfo) throws Exception {
        PageHelper.startPage(birthdayInfo.getStart(), birthdayInfo.getSize());
        List<BirthdayInfo> birthdayInfoList = new Vector<BirthdayInfo>();
        List<BirthdayInfo> birthdayInfoList1=new Vector<>();
        BirthdayInfo birthdayInfo1 = new BirthdayInfo();
        BirthdayInfo birthdayInfo2 = new BirthdayInfo();
        if(birthdayInfo.getEmployeeId()==""){
            birthdayInfo.setEmployeeId(null);
        }
        if(birthdayInfo.getEmployeeName()==""){
            birthdayInfo.setEmployeeName(null);
        }
        if (birthdayInfo.getEmployeeName() != null && birthdayInfo.getEmployeeId() == null) {
            String[] employeeNameArray = birthdayInfo.getEmployeeName().split(" ");
            for (int i = 0; i < employeeNameArray.length; i++) {
                System.out.println("员工NAME" + employeeNameArray[i]);
                birthdayInfo2.setEmployeeName(employeeNameArray[i]);
                birthdayInfoList1 = this.birthdayInfoService.queryAll(birthdayInfo2);
                if (birthdayInfoList1.size()!= 0) {
                    birthdayInfoList.addAll(birthdayInfoList1);
                }
            }
            PageInfo<BirthdayInfo> page = new PageInfo<>(birthdayInfoList);
            return page;
        } else if (birthdayInfo.getEmployeeName() == null && birthdayInfo.getEmployeeId() != null) {
            String[] employeeIdArray = birthdayInfo.getEmployeeId().split(" ");
            for (int i = 0; i < employeeIdArray.length; i++) {
                System.out.println("员工Id" + employeeIdArray[i]);
                birthdayInfo1 = this.birthdayInfoService.queryByEmployeeId(employeeIdArray[i]);
                if (birthdayInfo1 != null) {
                    birthdayInfoList.add(birthdayInfo1);
                }
            }
            PageInfo<BirthdayInfo> page = new PageInfo<>(birthdayInfoList);
            return page;
        } else if (birthdayInfo.getEmployeeName() != null && birthdayInfo.getEmployeeId() != null) {
            String[] employeeNameArray = birthdayInfo.getEmployeeName().split(" ");
            String[] employeeIdArray = birthdayInfo.getEmployeeId().split(" ");
            if (employeeIdArray.length > 1 || employeeNameArray.length > 1) {
                //为空。两个都有且超过1，太多了，返回为空值
            } else if (employeeIdArray.length == 1 && employeeNameArray.length == 1) {
                //两个都为一个值时。精准查询
                birthdayInfo2.setEmployeeId(employeeIdArray[0]);
                birthdayInfo2.setEmployeeName(employeeNameArray[0]);
                birthdayInfoList = this.birthdayInfoService.queryAll(birthdayInfo2);
            }
            PageInfo<BirthdayInfo> page = new PageInfo<>(birthdayInfoList);
            return page;
        } else {
            List<BirthdayInfo> cs = this.birthdayInfoService.queryAll(birthdayInfo);
            PageInfo<BirthdayInfo> page = new PageInfo<>(cs);
            return page;
        }
    }
/*    public PageInfo<BirthdayInfo> selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<BirthdayInfo> cs = this.birthdayInfoService.queryAllByPage();
        PageInfo<BirthdayInfo> page = new PageInfo<>(cs);
        return page;
        *//*m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;*//*
    }*/
    /**
     * 单条插入员工信息
     *
     * @param birthdayInfo
     * @return 实体对象，若为空，则插入不成功
     */
    @PostMapping("insert")
    @ResponseBody
    public Result insert(@RequestBody BirthdayInfo birthdayInfo){
        Result res=new GeneralResult(true);
        this.birthdayInfoService.insert(birthdayInfo);
        res.setCode(CommonController.SUCCESS);
        res.setMsg("新增出生认定信息成功！");
        return  res;
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @GetMapping("delete")
    @ResponseBody
    public Result delete(int id){
        Result res=new GeneralResult(true);
        BirthdayInfo birthdayInfo=new BirthdayInfo();
        birthdayInfo=this.birthdayInfoService.queryById(id);
        if(birthdayInfo!=null) {
            res.setData(birthdayInfo);
            this.birthdayInfoService.deleteById(id);
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
     * 根据实体类做更新
     * @param birthdayInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public Result update(@RequestBody BirthdayInfo birthdayInfo,HttpServletRequest request){

        HttpSession session = request.getSession();
        String userName = String.valueOf(session.getAttribute("userName"));
        birthdayInfo.setUpdateTime(new Date());
        birthdayInfo.setUpdateBy(userName);
        BirthdayInfo birthdayInfoNew= this.birthdayInfoService.update(birthdayInfo);

        EmployeeInfo employeeInfo=new EmployeeInfo();
        EmployeeInfo target=this.employeeInfoService.queryByEmployeeId(birthdayInfo.getEmployeeId());
        //也对大表做更新
        employeeInfo.setUpdateBy(userName);
        employeeInfo.setUpdateTime(new Date());
        employeeInfo.setBirthdayArchives(birthdayInfoNew.getBirthdayArchives());
        employeeInfo.setBirthdayCard(birthdayInfoNew.getBirthdayCard());
        employeeInfo.setBirthdayCheckRemark(birthdayInfoNew.getBirthdayCheckRemark());
        employeeInfo.setBirthdayCheckRule(birthdayInfoNew.getBirthdayCheckRule());
        employeeInfo.setBirthdayJudgment(birthdayInfoNew.getBirthdayJudgment());
        employeeInfo.setBirthdayCheckResult(birthdayInfoNew.getBirthdayCheckResult());
        employeeInfo.setBirthdayProblemCategory(birthdayInfoNew.getBirthdayProblemCategory());
        employeeInfo.setBirthdayProblemDetail(birthdayInfoNew.getBirthdayProblemDetail());
        employeeInfo.setBirthdayHaveProblem(birthdayInfoNew.getBirthdayHaveProblem());
        employeeInfo.setId(this.employeeInfoService.queryByEmployeeId(birthdayInfoNew.getEmployeeId()).getId());
        //更新大表对应模块
        this.employeeInfoService.update(employeeInfo);
        ChangeRecordUtil<EmployeeInfo> t= new ChangeRecordUtil<EmployeeInfo>();
        List<changePojo> list = t.contrastObj(target,employeeInfo);
        System.out.println("lenth is"+list.size());
        //更新操作记录
        OrdinaryOperateLog ordinaryOperateLog=new OrdinaryOperateLog();
        for(changePojo changePojolist:list){
            ordinaryOperateLog.setEmployeeId(target.getEmployeeId());
            ordinaryOperateLog.setEmployeeName(target.getEmployeeName());
            ordinaryOperateLog.setCheckTableName("生日模块");
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
        Result res=new GeneralResult(true);
        res.setCode(CommonController.SUCCESS);
        res.setMsg("更新成功！");
        res.setData(birthdayInfoNew);
        if(birthdayInfoNew==null){
            res.setSuccess(false);
            res.setCode(CommonController.ERROR);
            res.setMsg("更新失败！");
        }
        return  res;
    }

  /*  @PostMapping("deleteByEmployee")
    @ResponseBody
    public Boolean deleteByEmployee(int employeeId,String employeeName){
        return this.birthdayInfoService.deleteByEmployee(employeeId,employeeName);
    }*/

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
            ExcelImportResult<BirthdayInfo> result = ExcelImportUtil.importExcelMore(file.getInputStream(), BirthdayInfo.class, importParams);
            if(result.isVerfiyFail()){
                res.setSuccess(false);
                res.setCode(CommonController.ERROR);
                res.setMsg("导入失败");
            }else{
                int count=0;
                List<BirthdayInfo> birthdayInfos = result.getList();
                Iterator<BirthdayInfo> employeeInfoIterator=birthdayInfos.iterator();
                while(employeeInfoIterator.hasNext()){
                    BirthdayInfo employeeInfo=employeeInfoIterator.next();
                    if(employeeInfo.getEmployeeName()==null){
                        employeeInfoIterator.remove();
                    }
                }
                for (BirthdayInfo birthdayInfo: birthdayInfos) {
                    //TODO 将导入的数据做保存数据库操作,先将所有数据id设置为null
                    count=this.birthdayInfoService.insert(birthdayInfo);
                    if(count==1){
                        System.out.println("成功");
                    }
                }
                res.setCode(CommonController.SUCCESS);
                res.setMsg("导入成功");
                res.setTotalCount(birthdayInfos.size());
                if(birthdayInfos.size()==0){
                    res.setSuccess(false);
                    res.setCode(CommonController.ERROR);
                    res.setMsg("导入失败！没有对应的数据！");
                }
                System.out.println("从Excel导入数据一共 {} 行 "+birthdayInfos.size());
                System.out.println("从Excel导入数据一共 {} 行 "+birthdayInfos.size());
            } }catch (IOException e) {
            System.out.println("导入失败：{}"+e.getMessage());
            res.setMsg("导入失败！出现异常！");
            res.setSuccess(false);
        } catch (Exception e1) {
            System.out.println("导入失败：{}"+e1.getMessage());
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
    public void export(HttpServletResponse response, @RequestBody BirthdayInfo birthdayInfo) throws Exception {
        System.out.println("开始导出");
        // 模拟从数据库获取需要导出的数据 (偷懒，嘻嘻！)
        List<BirthdayInfo> personList = this.birthdayInfoService.queryAll(birthdayInfo);
        //设置序号（将id字段作为序号，导出后实现序号递增）
        Integer i =1;
        for (BirthdayInfo birthdayInfo1 : personList) {
            birthdayInfo1.setId(i++);
        }
        // 导出操作
        ExcelUtils.exportExcel(personList, "出生日期认定表", "导出sheet1", BirthdayInfo.class, "出生日期基本信息表.xls", response);
    }

    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/template/birthdayInfo.xlsx");
        try (OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            //显示下载进度
            response.setHeader("Content-Length", String.valueOf(this.getClass().getResourceAsStream("/template/birthdayInfo.xlsx")));
            response.setContentType("application/octet-stream");
            // 指定下载的文件名
            response.setHeader("Content-disposition", "attachment; filename=" + new String("birthdayInfo.xlsx".getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}