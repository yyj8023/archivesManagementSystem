package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.entity.BirthdayInfo;
import com.archivesManagementSystem.springboot.entity.EducationInfo;
import com.archivesManagementSystem.springboot.entity.StartingJobTimeInfo;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import com.archivesManagementSystem.springboot.service.StartingJobTimeInfoService;
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
 * 参加工作时间基本信息认定表(StartingJobTimeInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:33:03
 */
@CrossOrigin
@RestController
@RequestMapping("startingJobTimeInfo")
public class StartingJobTimeInfoController {
    /**
     * 服务对象
     */
    @Resource
    private StartingJobTimeInfoService startingJobTimeInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public StartingJobTimeInfo selectOne(Integer id) {
        return this.startingJobTimeInfoService.queryById(id);
    }

    /**
     * 单条插入开始工作时间信息
     *
     * @param startingJobTimeInfo
     * @return 实体对象，若为空，则插入不成功
     */
    @PostMapping("insert")
    @ResponseBody
    public Result insert(@RequestBody StartingJobTimeInfo startingJobTimeInfo){
        Result res=new GeneralResult(true);
        this.startingJobTimeInfoService.insert(startingJobTimeInfo);
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
        StartingJobTimeInfo startingJobTimeInfo=new StartingJobTimeInfo();
        startingJobTimeInfo=this.startingJobTimeInfoService.queryById(id);
        if(startingJobTimeInfo!=null) {
            res.setData(startingJobTimeInfo);
            this.startingJobTimeInfoService.deleteById(id);
            res.setMsg("删除成功！");
        }else{
            res.setMsg("删除失败！");
            res.setSuccess(false);
        }
        return res;
    }

    /**
     * 根据某个字段查询所有的实体集合
     * @param startingJobTimeInfo
     * @return List集合
     */

    @GetMapping("selectAll")
    public List<StartingJobTimeInfo> selectAll(StartingJobTimeInfo startingJobTimeInfo){
        return  this.startingJobTimeInfoService.queryAll(startingJobTimeInfo);
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
    public PageInfo<StartingJobTimeInfo> selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<StartingJobTimeInfo> cs=this.startingJobTimeInfoService.queryAllByPage();
        PageInfo<StartingJobTimeInfo> page = new PageInfo<>(cs);
        return page;
        /*m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;*/
    }

    /**
     * 根据实体类做更新
     * @param startingJobTimeInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  Result update(@RequestBody StartingJobTimeInfo startingJobTimeInfo){
        startingJobTimeInfo= this.startingJobTimeInfoService.update(startingJobTimeInfo);
        Result res=new GeneralResult(true);
        res.setMsg("更新成功！");
        res.setData(startingJobTimeInfo);
        if(startingJobTimeInfo==null){
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
        importParams.setHeadRows(1);
        //表头行数,默认1
        importParams.setTitleRows(1);
        //是否需要校验上传的Excel,默认false
        importParams.setNeedVerfiy(false);

        try {
            ExcelImportResult<StartingJobTimeInfo> result = ExcelImportUtil.importExcelMore(file.getInputStream(), StartingJobTimeInfo.class, importParams);
            if(result.isVerfiyFail()){
                res.setSuccess(false);
                res.setMsg("导入失败");
            }else{
                int count=0;
                List<StartingJobTimeInfo> startingJobTimeInfoList = result.getList();
                Iterator<StartingJobTimeInfo> employeeInfoIterator=startingJobTimeInfoList.iterator();
                while(employeeInfoIterator.hasNext()){
                    StartingJobTimeInfo employeeInfo=employeeInfoIterator.next();
                    if(employeeInfo.getEmployeeName()==null){
                        employeeInfoIterator.remove();
                    }
                }
                for (StartingJobTimeInfo startingJobTimeInfo: startingJobTimeInfoList) {
                    //TODO 将导入的数据做保存数据库操作,先将所有数据id设置为null
                    count=this.startingJobTimeInfoService.insert(startingJobTimeInfo);
                    if(count==1){
                        System.out.println("成功");
                    }
                }
                res.setMsg("导入成功");
                res.setTotalCount(startingJobTimeInfoList.size());
                if(startingJobTimeInfoList.size()==0){
                    res.setSuccess(false);
                }
                System.out.println("从Excel导入数据一共 {} 行 "+startingJobTimeInfoList.size());
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
    @GetMapping("exportExcel")
    public void export(HttpServletResponse response, HttpServletRequest request, StartingJobTimeInfo startingJobTimeInfo) throws Exception {
        System.out.println("开始导出");
        // 模拟从数据库获取需要导出的数据 (偷懒，嘻嘻！)
        List<StartingJobTimeInfo> personList = this.startingJobTimeInfoService.queryAll(startingJobTimeInfo);
        //设置序号（将id字段作为序号，导出后实现序号递增）
        Integer i =1;
        for (StartingJobTimeInfo startingJobTimeInfo1 : personList) {
            startingJobTimeInfo.setId(i++);
        }
        // 导出操作
        ExcelUtils.exportExcel(personList, "开始工作时间认定表", "导出sheet1", StartingJobTimeInfo.class, "开始工作时间认定信息表.xls", response);
    }
    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/template/startingJobTimeInfo.xlsx");
        try (OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            //显示下载进度
            response.setHeader("Content-Length", String.valueOf(this.getClass().getResourceAsStream("/template/startingJobTimeInfo.xlsx")));
            response.setContentType("application/octet-stream");
            // 指定下载的文件名
            response.setHeader("Content-disposition", "attachment; filename=" + new String("startingJobTimeInfo.xlsx".getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}