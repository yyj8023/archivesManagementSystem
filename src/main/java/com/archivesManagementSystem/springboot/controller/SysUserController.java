package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.entity.SysUser;
import com.archivesManagementSystem.springboot.service.SysUserService;
import com.archivesManagementSystem.springboot.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoleilu.hutool.date.DateUtil;
import net.minidev.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import com.archivesManagementSystem.springboot.util.GeneralResult;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 系统用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2021-01-20 22:03:33
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 简单登录用
     * @param sysUser
     * @return
     */
    @PostMapping("login")
    @ResponseBody
    public String loginCheck(@RequestBody SysUser sysUser) {
        //后期用于MD5加密
        //String encodePassword = MD5Utils.MD5(sysUser.getUserPassword());
        return this.sysUserService.queryByNameAndPass(sysUser.getUserName(),sysUser.getUserPassword());
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysUser selectOne(Integer id) {
        return this.sysUserService.queryById(id);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    @GetMapping("selectAll")
    public List<SysUser> selectAll(SysUser sysUser)
    {
        return this.sysUserService.queryAll(sysUser);
    }

    /**
     *查询结果分页返回
     * @return 页面对象
     */
    @GetMapping("selectAllForPage")
    public ModelAndView selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<SysUser> cs=this.sysUserService.queryAllByPage();
        PageInfo<SysUser> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;
    }

    /**
     * 插入数据
     * @param sysUser
     * @return int类型>1就是成功
     */
    @PostMapping("insert")
    @ResponseBody
    public int insert(SysUser sysUser){
        return this.sysUserService.insert(sysUser);
    }

    /**
     * 通过主键删除单条数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Boolean delete(int id){
        return this.sysUserService.deleteById(id);
    }

    /**
     * 通过主键更新单条数据
     * @param sysUser
     * @return
     */
    @PostMapping("update")
    @ResponseBody
    public SysUser update(SysUser sysUser){
        return this.sysUserService.update(sysUser);
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
            ExcelImportResult<SysUser> result = ExcelImportUtil.importExcelMore(file.getInputStream(), SysUser.class, importParams);
            if(result.isVerfiyFail()){
                res.setSuccess(false);
                res.setMsg("导入失败");
            }else{
            List<SysUser> sysUserList = result.getList();
            int count=0;
            for (SysUser sysUser : sysUserList) {
               /* log.info("从Excel导入数据到数据库的详细为 ：{}", JSONObject.toJSONString(sysUser));*/
                //TODO 将导入的数据做保存数据库操作,先将所有数据id设置为null
                //对可用标志进行判断,若上传表格可用标志为空，则设为不可用
                if(sysUser.getUserFlag()==null){
                    sysUser.setUserFlag(false);
                }
                count=this.sysUserService.insert(sysUser);
                if(count==1){
                    System.out.println("成功");
                }
            }
            res.setMsg("导入成功");
            res.setData(sysUserList.size());
            System.out.println("从Excel导入数据一共 {} 行 "+sysUserList.size());
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
    public void export(HttpServletResponse response, HttpServletRequest request, SysUser sysUser) throws Exception {
       System.out.println("开始导出");
        // 模拟从数据库获取需要导出的数据 (偷懒，嘻嘻！)
        List<SysUser> personList = this.sysUserService.queryAll(sysUser);
        //设置序号（将id字段作为序号，导出后实现序号递增）
        Integer i =1;
        for (SysUser users : personList) {
            users.setId(i++);
        }
        // 导出操作
        ExcelUtils.exportExcel(personList, "系统用户导出功能(用户表)", "导出sheet1", SysUser.class, "系统用户表.xls", response);
    }

    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/template/sysuser.xlsx");
        try (OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            //显示下载进度
            response.setHeader("Content-Length", String.valueOf(this.getClass().getResourceAsStream("/template/sysuser.xlsx")));
            response.setContentType("application/octet-stream");
            // 指定下载的文件名
            response.setHeader("Content-disposition", "attachment; filename=" + new String("sysuser.xlsx".getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}