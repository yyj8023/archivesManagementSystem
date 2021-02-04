/*
package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.EducationCareerInfo;
import com.archivesManagementSystem.springboot.service.EducationCareerInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

*/
/**
 * 学历学位信息认定表(EducationCareerInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:32:05
 *//*

@RestController
@RequestMapping("educationCareerInfo")
public class EducationCareerInfoController {
    */
/**
     * 服务对象
     *//*

    @Resource
    private EducationCareerInfoService educationCareerInfoService;

    */
/**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     *//*

    @GetMapping("selectOne")
    public EducationCareerInfo selectOne(Integer id) {
        return this.educationCareerInfoService.queryById(id);
    }

}*/
package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.common.CommonController;
import com.archivesManagementSystem.springboot.entity.EducationCareerInfo;
import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.SysUser;
import com.archivesManagementSystem.springboot.service.EducationCareerInfoService;
import com.archivesManagementSystem.springboot.service.EmployeeInfoService;
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
import java.util.List;

/**
 * 学历学位信息详细表(EducationCareerInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-20 22:15:23
 */
@CrossOrigin
@RestController
@RequestMapping("educationCareerInfo")
public class EducationCareerInfoController {
    /**
     * 服务对象
     */
    @Resource
    private EducationCareerInfoService educationCareerInfoService;
    @Resource
    private EmployeeInfoService employeeInfoService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public EducationCareerInfo selectOne(Integer id) {
        return this.educationCareerInfoService.queryById(id);
    }

    /**
     * 单条插入学历信息
     *
     * @param educationCareerInfo
     * @return int=1即为成功
     */
    @PostMapping("insert")
    @ResponseBody
    public Result insert(@RequestBody EducationCareerInfo educationCareerInfo){
        Result res=new GeneralResult(true);
        this.educationCareerInfoService.insert(educationCareerInfo);
        res.setCode(CommonController.SUCCESS);
        res.setMsg("新增学历学历详情信息成功");
        return res;
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
        EducationCareerInfo educationCareerInfo=this.educationCareerInfoService.queryById(id);
        if(educationCareerInfo!=null){
            res.setData(educationCareerInfo);
            this.educationCareerInfoService.deleteById(id);
            res.setCode(CommonController.SUCCESS);
            res.setMsg("删除成功");
        }else{
            res.setSuccess(false);
            res.setCode(CommonController.ERROR);
            res.setMsg("删除失败!不存在"+id+"为主键的学历详情信息");
        }
        return res;
    }

    /**
     * 根据某个字段查询所有的实体集合
     * @param educationCareerInfo
     * @return List集合
     */

    @GetMapping("selectAll")
    public List<EducationCareerInfo> selectAll(EducationCareerInfo educationCareerInfo){
        return  this.educationCareerInfoService.queryAll(educationCareerInfo);
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
    public PageInfo<EducationCareerInfo> selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<EducationCareerInfo> cs=this.educationCareerInfoService.queryAllByPage();
        PageInfo<EducationCareerInfo> page = new PageInfo<>(cs);
        return page;
        /*m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;*/
    }

    /**
     * 根据实体类做更新
     * @param educationCareerInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  Result update(@RequestBody EducationCareerInfo educationCareerInfo){
        Result res=new GeneralResult(true);
        educationCareerInfo=this.educationCareerInfoService.update(educationCareerInfo);
        res.setCode(CommonController.SUCCESS);
        res.setMsg("更新成功！");
        res.setData(educationCareerInfo);
        if(educationCareerInfo==null){
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
            ExcelImportResult<EducationCareerInfo> result = ExcelImportUtil.importExcelMore(file.getInputStream(), EducationCareerInfo.class, importParams);
            if(result.isVerfiyFail()){
                res.setSuccess(false);
                res.setCode(CommonController.ERROR);
                res.setMsg("导入失败");
            }else{
                List<EducationCareerInfo> educationCareerInfos = result.getList();
                int count=0;
                for (EducationCareerInfo educationCareerInfo : educationCareerInfos) {
                    /* log.info("从Excel导入数据到数据库的详细为 ：{}", JSONObject.toJSONString(sysUser));*/
                    //TODO 将导入的数据做保存数据库操作,先将所有数据id设置为null
                    count=this.educationCareerInfoService.insert(educationCareerInfo);
                    if(count==1){
                        System.out.println("成功");
                    }
                }
                res.setCode(CommonController.SUCCESS);
                res.setMsg("导入成功");
                res.setData(educationCareerInfos.size());
                System.out.println("从Excel导入数据一共 {} 行 "+educationCareerInfos.size());
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
    public void export(HttpServletResponse response, HttpServletRequest request, EducationCareerInfo educationCareerInfo) throws Exception {
        System.out.println("开始导出");
        // 模拟从数据库获取需要导出的数据 (偷懒，嘻嘻！)
        List<EducationCareerInfo> personList = this.educationCareerInfoService.queryAll(educationCareerInfo);
        //设置序号（将id字段作为序号，导出后实现序号递增）
        Integer i =1;
        for (EducationCareerInfo educationCareerInfo1 : personList) {
            educationCareerInfo1.setId(i++);
        }
        // 导出操作
        ExcelUtils.exportExcel(personList, "学历详情信息导出功能(学历详情表)", "导出sheet1", EducationCareerInfo.class, "学历详情表.xls", response);
    }
    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/template/educationCareerInfo.xlsx");
        try (OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            //显示下载进度
            response.setHeader("Content-Length", String.valueOf(this.getClass().getResourceAsStream("/template/educationCareerInfo.xlsx")));
            response.setContentType("application/octet-stream");
            // 指定下载的文件名
            response.setHeader("Content-disposition", "attachment; filename=" + new String("educationCareerInfo.xlsx".getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
