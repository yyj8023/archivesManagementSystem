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
import com.archivesManagementSystem.springboot.entity.EducationCareerInfo;
import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.SysUser;
import com.archivesManagementSystem.springboot.service.EducationCareerInfoService;
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
import java.util.List;

/**
 * 学历学位信息详细表(EducationCareerInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-20 22:15:23
 */
@RestController
@RequestMapping("educationCareerInfo")
public class EducationCareerInfoController {
    /**
     * 服务对象
     */
    @Resource
    private EducationCareerInfoService educationCareerInfoService;

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
    public int insert(@RequestBody EducationCareerInfo educationCareerInfo){
        return  this.educationCareerInfoService.insert(educationCareerInfo);
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Boolean delete(int id){
        return this.educationCareerInfoService.deleteById(id);
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
    public  EducationCareerInfo update(@RequestBody EducationCareerInfo educationCareerInfo){
        return this.educationCareerInfoService.update(educationCareerInfo);
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
}
