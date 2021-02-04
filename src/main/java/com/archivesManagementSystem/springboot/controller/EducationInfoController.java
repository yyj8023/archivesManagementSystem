package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.common.CommonController;
import com.archivesManagementSystem.springboot.entity.BirthdayInfo;
import com.archivesManagementSystem.springboot.entity.EducationCareerInfo;
import com.archivesManagementSystem.springboot.entity.EducationInfo;
import com.archivesManagementSystem.springboot.service.EducationInfoService;
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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public EducationInfo selectOne(Integer id) {
        return this.educationInfoService.queryById(id);
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
     * @param m
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("selectAllForPage")
    public PageInfo<EducationInfo> selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<EducationInfo> cs=this.educationInfoService.queryAllByPage();
        PageInfo<EducationInfo> page = new PageInfo<>(cs);
        return page;
        /*m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;*/
    }

    /**
     * 根据实体类做更新
     * @param educationInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  Result update(@RequestBody EducationInfo educationInfo){
        Result res=new GeneralResult(true);
       educationInfo=this.educationInfoService.update(educationInfo);
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
    @GetMapping("exportExcel")
    public void export(HttpServletResponse response, HttpServletRequest request, EducationInfo educationInfo) throws Exception {
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