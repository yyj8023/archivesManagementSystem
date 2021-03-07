package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.common.CommonController;
import com.archivesManagementSystem.springboot.entity.*;
import com.archivesManagementSystem.springboot.service.EmployeeInfoService;
import com.archivesManagementSystem.springboot.service.JoinPartyTimeInfoService;
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
 * 入党时间信息认定表(JoinPartyTimeInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:32:23
 */
@CrossOrigin
@RestController
@RequestMapping("joinPartyTimeInfo")
public class JoinPartyTimeInfoController {
    /**
     * 服务对象
     */
    @Resource
    private JoinPartyTimeInfoService joinPartyTimeInfoService;
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

        if(this.joinPartyTimeInfoService.queryById(id)!=null){
            res.setData(this.joinPartyTimeInfoService.queryById(id));
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
     * @param joinPartyTimeInfo
     * @return 实体对象，若为空，则插入不成功
     */
    @PostMapping("insert")
    @ResponseBody
    public Result insert(@RequestBody JoinPartyTimeInfo joinPartyTimeInfo){
         Result res=new GeneralResult(true);
         this.joinPartyTimeInfoService.insert(joinPartyTimeInfo);
        res.setCode(CommonController.SUCCESS);
         res.setMsg("新增入党时间认定信息成功！");
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
        JoinPartyTimeInfo joinPartyTimeInfo=new JoinPartyTimeInfo();
        joinPartyTimeInfo=this.joinPartyTimeInfoService.queryById(id);
        if(joinPartyTimeInfo!=null) {
            res.setData(joinPartyTimeInfo);
            this.joinPartyTimeInfoService.deleteById(id);
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
     * @param joinPartyTimeInfo
     * @return List集合
     */

    @GetMapping("selectAll")
    public List<JoinPartyTimeInfo> selectAll(JoinPartyTimeInfo joinPartyTimeInfo){
        return  this.joinPartyTimeInfoService.queryAll(joinPartyTimeInfo);
    }

    /**
     * 查询全部数据分页展示
     * @return
     * @throws Exception
     */
/*    @GetMapping("selectAllForPage")
    public PageInfo<JoinPartyTimeInfo> selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<JoinPartyTimeInfo> cs=this.joinPartyTimeInfoService.queryAllByPage();
        PageInfo<JoinPartyTimeInfo> page = new PageInfo<>(cs);
        return page;
        *//*m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;*//*
    }*/
    @PostMapping("selectAllForPage")
    @ResponseBody
    public PageInfo<JoinPartyTimeInfo> selectAllForPage(@RequestBody JoinPartyTimeInfo joinPartyTimeInfo) throws Exception {
        PageHelper.startPage(joinPartyTimeInfo.getStart(), joinPartyTimeInfo.getSize());
        List<JoinPartyTimeInfo> joinPartyTimeInfoList = new Vector<JoinPartyTimeInfo>();
        List<JoinPartyTimeInfo> joinPartyTimeInfoList1 = new Vector<JoinPartyTimeInfo>();
        JoinPartyTimeInfo joinPartyTimeInfo1 = new JoinPartyTimeInfo();
        JoinPartyTimeInfo joinPartyTimeInfo2 = new JoinPartyTimeInfo();
        if(joinPartyTimeInfo.getEmployeeId()==""){
            joinPartyTimeInfo.setEmployeeId(null);
        }
        if(joinPartyTimeInfo.getEmployeeName()==""){
            joinPartyTimeInfo.setEmployeeName(null);
        }
        if (joinPartyTimeInfo.getEmployeeName() != null && joinPartyTimeInfo.getEmployeeId() == null) {
            String[] employeeNameArray = joinPartyTimeInfo.getEmployeeName().split(" ");
            for (int i = 0; i < employeeNameArray.length; i++) {
                System.out.println("员工NAME" + employeeNameArray[i]);
                joinPartyTimeInfo2.setEmployeeName(employeeNameArray[i]);
                joinPartyTimeInfoList1 = this.joinPartyTimeInfoService.queryAll(joinPartyTimeInfo2);
                if (joinPartyTimeInfoList1.size() != 0) {
                    joinPartyTimeInfoList.addAll(joinPartyTimeInfoList1);
                }
            }
            PageInfo<JoinPartyTimeInfo> page = new PageInfo<>(joinPartyTimeInfoList);
            return page;
        } else if (joinPartyTimeInfo.getEmployeeName() == null && joinPartyTimeInfo.getEmployeeId() != null) {
            String[] employeeIdArray = joinPartyTimeInfo.getEmployeeId().split(" ");
            for (int i = 0; i < employeeIdArray.length; i++) {
                System.out.println("员工Id" + employeeIdArray[i]);
                joinPartyTimeInfo1 = this.joinPartyTimeInfoService.queryByEmployeeId(employeeIdArray[i]);
                if (joinPartyTimeInfo1 != null) {
                   joinPartyTimeInfoList.add(joinPartyTimeInfo1);
                }
            }
            PageInfo<JoinPartyTimeInfo> page = new PageInfo<>(joinPartyTimeInfoList);
            return page;
        } else if (joinPartyTimeInfo.getEmployeeName() != null && joinPartyTimeInfo.getEmployeeId() != null) {
            String[] employeeNameArray = joinPartyTimeInfo.getEmployeeName().split(" ");
            String[] employeeIdArray = joinPartyTimeInfo.getEmployeeId().split(" ");
            if (employeeIdArray.length > 1 || employeeNameArray.length > 1) {
                //为空。两个都有且超过1，太多了，返回为空值
            } else if (employeeIdArray.length == 1 && employeeNameArray.length == 1) {
                //两个都为一个值时。精准查询
                joinPartyTimeInfo2.setEmployeeId(employeeIdArray[0]);
                joinPartyTimeInfo2.setEmployeeName(employeeNameArray[0]);
                joinPartyTimeInfoList = this.joinPartyTimeInfoService.queryAll(joinPartyTimeInfo2);
            }
            PageInfo<JoinPartyTimeInfo> page = new PageInfo<>(joinPartyTimeInfoList);
            return  page;
        } else {
            List<JoinPartyTimeInfo> cs = this.joinPartyTimeInfoService.queryAll(joinPartyTimeInfo);
            PageInfo<JoinPartyTimeInfo> page = new PageInfo<>(cs);
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
     * @param joinPartyTimeInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  Result update(@RequestBody JoinPartyTimeInfo joinPartyTimeInfo,HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = String.valueOf(session.getAttribute("userName"));
        System.out.println("username is "+userName);
        joinPartyTimeInfo.setUpdateTime(new Date());
        joinPartyTimeInfo.setUpdateBy(userName);
        joinPartyTimeInfo= this.joinPartyTimeInfoService.update(joinPartyTimeInfo);
        Result res=new GeneralResult(true);

        EmployeeInfo employeeInfo=new EmployeeInfo();
        EmployeeInfo target=this.employeeInfoService.queryByEmployeeId(joinPartyTimeInfo.getEmployeeId());
        //也对大表做更新
        employeeInfo.setUpdateBy(userName);
        employeeInfo.setUpdateTime(new Date());
        employeeInfo.setEmployeeId(joinPartyTimeInfo.getEmployeeId());
        employeeInfo.setEmployeeName(joinPartyTimeInfo.getEmployeeName());
        employeeInfo.setPoliticalStatus(joinPartyTimeInfo.getPoliticalStatus());
        employeeInfo.setJoinPartyTimeProblemDetail(joinPartyTimeInfo.getJoinPartyTimeProblemDetail());
        employeeInfo.setJoinPartyTimeCheckResult(joinPartyTimeInfo.getJoinPartyTimeCheckResult());
        employeeInfo.setJoinPartyTimeResearchSituation(joinPartyTimeInfo.getJoinPartyTimeResearchSituation());
        employeeInfo.setJoinPartyTime(joinPartyTimeInfo.getJoinPartyTime());
        employeeInfo.setJoinPartyIntroducer(joinPartyTimeInfo.getJoinPartyIntroducer());
        employeeInfo.setJoinGroupTime(joinPartyTimeInfo.getJoinGroupTime());
        employeeInfo.setJoinPartyTimeRemark(joinPartyTimeInfo.getJoinPartyTimeRemark());
        employeeInfo.setJoinPartyTimeHaveProblem(joinPartyTimeInfo.getJoinPartyTimeHaveProblem());
        employeeInfo.setId(this.employeeInfoService.queryByEmployeeId(joinPartyTimeInfo.getEmployeeId()).getId());
        //更新大表对应模块
        this.employeeInfoService.update(employeeInfo);
        ChangeRecordUtil<EmployeeInfo> t= new ChangeRecordUtil<EmployeeInfo>();
        List<changePojo> list = t.contrastObj(target,employeeInfo);
        System.out.println("lenth is"+list.size());
        OrdinaryOperateLog ordinaryOperateLog=new OrdinaryOperateLog();
        for(changePojo changePojolist:list){
            ordinaryOperateLog.setEmployeeId(target.getEmployeeId());
            ordinaryOperateLog.setEmployeeName(target.getEmployeeName());
            ordinaryOperateLog.setCheckTableName("入党时间模块");
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
        res.setData(joinPartyTimeInfo);
        if(joinPartyTimeInfo==null){
            res.setSuccess(false);
            res.setCode(CommonController.ERROR);
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
        importParams.setHeadRows(1);
        //表头行数,默认1
        importParams.setTitleRows(1);
        //是否需要校验上传的Excel,默认false
        importParams.setNeedVerfiy(false);

        try {
            ExcelImportResult<JoinPartyTimeInfo> result = ExcelImportUtil.importExcelMore(file.getInputStream(), JoinPartyTimeInfo.class, importParams);
            if(result.isVerfiyFail()){
                res.setSuccess(false);
                res.setCode(CommonController.ERROR);
                res.setMsg("导入失败");
            }else{
                int count=0;
                List<JoinPartyTimeInfo> joinPartyTimeInfoList = result.getList();
                Iterator<JoinPartyTimeInfo> employeeInfoIterator=joinPartyTimeInfoList.iterator();
                while(employeeInfoIterator.hasNext()){
                    JoinPartyTimeInfo employeeInfo=employeeInfoIterator.next();
                    if(employeeInfo.getEmployeeName()==null){
                        employeeInfoIterator.remove();
                    }
                }
                for (JoinPartyTimeInfo joinPartyTimeInfo: joinPartyTimeInfoList) {
                    //TODO 将导入的数据做保存数据库操作,先将所有数据id设置为null
                    count=this.joinPartyTimeInfoService.insert(joinPartyTimeInfo);
                    if(count==1){
                        System.out.println("成功");
                    }
                }
                res.setCode(CommonController.SUCCESS);
                res.setMsg("导入成功");
                res.setTotalCount(joinPartyTimeInfoList.size());
                if(joinPartyTimeInfoList.size()==0){
                    res.setSuccess(false);
                }
                System.out.println("从Excel导入数据一共 {} 行 "+joinPartyTimeInfoList.size());
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
    @GetMapping("exportExcel")
    public void export(HttpServletResponse response, HttpServletRequest request, JoinPartyTimeInfo joinPartyTimeInfo) throws Exception {
        System.out.println("开始导出");
        // 模拟从数据库获取需要导出的数据 (偷懒，嘻嘻！)
        List<JoinPartyTimeInfo> personList = this.joinPartyTimeInfoService.queryAll(joinPartyTimeInfo);
        //设置序号（将id字段作为序号，导出后实现序号递增）
        Integer i =1;
        for (JoinPartyTimeInfo joinPartyTimeInfo1 : personList) {
            joinPartyTimeInfo1.setId(i++);
        }
        // 导出操作
        ExcelUtils.exportExcel(personList, "入党时间认定表", "导出sheet1", JoinPartyTimeInfo.class, "入党时间认定基本信息表.xls", response);
    }
    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/template/joinPartyTimeInfo.xlsx");
        try (OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            //显示下载进度
            response.setHeader("Content-Length", String.valueOf(this.getClass().getResourceAsStream("/template/joinPartyTimeInfo.xlsx")));
            response.setContentType("application/octet-stream");
            // 指定下载的文件名
            response.setHeader("Content-disposition", "attachment; filename=" + new String("joinPartyTimeInfo.xlsx".getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}