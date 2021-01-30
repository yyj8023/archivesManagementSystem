package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.entity.EducationInfo;
import com.archivesManagementSystem.springboot.entity.JoinPartyTimeInfo;
import com.archivesManagementSystem.springboot.service.JoinPartyTimeInfoService;
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
 * 入党时间信息认定表(JoinPartyTimeInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:32:23
 */
@RestController
@RequestMapping("joinPartyTimeInfo")
public class JoinPartyTimeInfoController {
    /**
     * 服务对象
     */
    @Resource
    private JoinPartyTimeInfoService joinPartyTimeInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public JoinPartyTimeInfo selectOne(Integer id) {
        return this.joinPartyTimeInfoService.queryById(id);
    }

    /**
     * 单条插入员工信息
     *
     * @param joinPartyTimeInfo
     * @return 实体对象，若为空，则插入不成功
     */
    @PostMapping("insert")
    @ResponseBody
    public int insert(@RequestBody JoinPartyTimeInfo joinPartyTimeInfo){
        return  this.joinPartyTimeInfoService.insert(joinPartyTimeInfo);
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Boolean delete(int id){
        return this.joinPartyTimeInfoService.deleteById(id);
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
     * @param m
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("selectAllForPage")
    public PageInfo<JoinPartyTimeInfo> selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<JoinPartyTimeInfo> cs=this.joinPartyTimeInfoService.queryAllByPage();
        PageInfo<JoinPartyTimeInfo> page = new PageInfo<>(cs);
        return page;
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
    public  JoinPartyTimeInfo update(@RequestBody JoinPartyTimeInfo joinPartyTimeInfo){
        return this.joinPartyTimeInfoService.update(joinPartyTimeInfo);
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
                res.setMsg("导入失败");
            }else{
                int count=0;
                List<JoinPartyTimeInfo> joinPartyTimeInfoList = result.getList();
                for (JoinPartyTimeInfo joinPartyTimeInfo: joinPartyTimeInfoList) {
                    //TODO 将导入的数据做保存数据库操作,先将所有数据id设置为null
                    count=this.joinPartyTimeInfoService.insert(joinPartyTimeInfo);
                    if(count==1){
                        System.out.println("成功");
                    }
                }
                res.setMsg("导入成功");
                res.setData(joinPartyTimeInfoList.size());
                System.out.println("从Excel导入数据一共 {} 行 "+joinPartyTimeInfoList.size());
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
}