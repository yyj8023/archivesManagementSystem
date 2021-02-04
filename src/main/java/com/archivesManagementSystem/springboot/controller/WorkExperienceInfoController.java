package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.common.CommonController;
import com.archivesManagementSystem.springboot.entity.BirthdayInfo;
import com.archivesManagementSystem.springboot.entity.EducationInfo;
import com.archivesManagementSystem.springboot.entity.JoinPartyTimeInfo;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import com.archivesManagementSystem.springboot.service.WorkExperienceInfoService;
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
import java.util.Iterator;
import java.util.List;

/**
 * 工作经历信息认定表(WorkExperienceInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:33:11
 */
@CrossOrigin
@RestController
@RequestMapping("workExperienceInfo")
public class WorkExperienceInfoController {
    /**
     * 服务对象
     */
    @Resource
    private WorkExperienceInfoService workExperienceInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public WorkExperienceInfo selectOne(Integer id) {
        return this.workExperienceInfoService.queryById(id);
    }

    /**
     * 单条插入员工信息
     *
     * @param workExperienceInfo
     * @return 实体对象，若为空，则插入不成功
     */
    @PostMapping("insert")
    @ResponseBody
    public Result insert(@RequestBody WorkExperienceInfo workExperienceInfo){
        Result res=new GeneralResult(true);
        this.workExperienceInfoService.insert(workExperienceInfo);
        res.setCode(CommonController.SUCCESS);
        res.setMsg("新增出生认定信息成功！");
        return  res;
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return
     */
    @GetMapping("delete")
    @ResponseBody
    public Result delete(int id){
        Result res=new GeneralResult(true);
        WorkExperienceInfo workExperienceInfo=new WorkExperienceInfo();
        workExperienceInfo=this.workExperienceInfoService.queryById(id);
        if(workExperienceInfo!=null) {
            res.setData(workExperienceInfo);
            this.workExperienceInfoService.deleteById(id);
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
     * @param workExperienceInfo
     * @return List集合
     */

    @GetMapping("selectAll")
    public List<WorkExperienceInfo> selectAll(WorkExperienceInfo workExperienceInfo){
        return  this.workExperienceInfoService.queryAll(workExperienceInfo);
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
    public PageInfo<WorkExperienceInfo> selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<WorkExperienceInfo> cs=this.workExperienceInfoService.queryAllByPage();
        PageInfo<WorkExperienceInfo> page = new PageInfo<>(cs);
        return page;
        /*m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;*/
    }

    /**
     * 根据实体类做更新
     * @param workExperienceInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  Result update(@RequestBody WorkExperienceInfo workExperienceInfo){
        workExperienceInfo= this.workExperienceInfoService.update(workExperienceInfo);
        Result res=new GeneralResult(true);
        res.setCode(CommonController.SUCCESS);
        res.setMsg("更新成功！");
        res.setData(workExperienceInfo);
        if(workExperienceInfo==null){
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
            ExcelImportResult<WorkExperienceInfo> result = ExcelImportUtil.importExcelMore(file.getInputStream(), WorkExperienceInfo.class, importParams);
            if(result.isVerfiyFail()){
                res.setSuccess(false);
                res.setCode(CommonController.ERROR);
                res.setMsg("导入失败");
            }else{
                int count=0;
                List<WorkExperienceInfo> workExperienceInfoList = result.getList();
                Iterator<WorkExperienceInfo> employeeInfoIterator=workExperienceInfoList.iterator();
                while(employeeInfoIterator.hasNext()){
                    WorkExperienceInfo employeeInfo=employeeInfoIterator.next();
                    if(employeeInfo.getEmployeeName()==null){
                        employeeInfoIterator.remove();
                    }
                }
                for (WorkExperienceInfo workExperienceInfo: workExperienceInfoList) {
                    //TODO 将导入的数据做保存数据库操作,先将所有数据id设置为null
                    count=this.workExperienceInfoService.insert(workExperienceInfo);
                    if(count==1){
                        System.out.println("成功");
                    }
                }
                res.setCode(CommonController.SUCCESS);
                res.setMsg("导入成功");
                res.setTotalCount(workExperienceInfoList.size());
                if(workExperienceInfoList.size()==0){
                    res.setSuccess(false);
                    res.setSuccess(false);
                }
                System.out.println("从Excel导入数据一共 {} 行 "+workExperienceInfoList.size());
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
    public void export(HttpServletResponse response, HttpServletRequest request, WorkExperienceInfo workExperienceInfo) throws Exception {
        System.out.println("开始导出");
        // 模拟从数据库获取需要导出的数据 (偷懒，嘻嘻！)
        List<WorkExperienceInfo> personList = this.workExperienceInfoService.queryAll(workExperienceInfo);
        //设置序号（将id字段作为序号，导出后实现序号递增）
        Integer i =1;
        for (WorkExperienceInfo workExperienceInfo1 : personList) {
            workExperienceInfo1.setId(i++);
        }
        // 导出操作
        ExcelUtils.exportExcel(personList, "工作经历认定表", "导出sheet1",WorkExperienceInfo.class, "工作经历认定信息表.xls", response);
    }
    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/template/workExperienceInfo.xlsx");
        try (OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            //显示下载进度
            response.setHeader("Content-Length", String.valueOf(this.getClass().getResourceAsStream("/template/workExperienceInfo.xlsx")));
            response.setContentType("application/octet-stream");
            // 指定下载的文件名
            response.setHeader("Content-disposition", "attachment; filename=" + new String("workExperienceInfo.xlsx".getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}