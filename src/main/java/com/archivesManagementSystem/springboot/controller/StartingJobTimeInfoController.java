package com.archivesManagementSystem.springboot.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.archivesManagementSystem.springboot.entity.EducationInfo;
import com.archivesManagementSystem.springboot.entity.StartingJobTimeInfo;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import com.archivesManagementSystem.springboot.service.StartingJobTimeInfoService;
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
 * 参加工作时间基本信息认定表(StartingJobTimeInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:33:03
 */
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
    public int insert(StartingJobTimeInfo startingJobTimeInfo){
        return  this.startingJobTimeInfoService.insert(startingJobTimeInfo);
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Boolean delete(int id){
        return this.startingJobTimeInfoService.deleteById(id);
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
    public ModelAndView selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<StartingJobTimeInfo> cs=this.startingJobTimeInfoService.queryAllByPage();
        PageInfo<StartingJobTimeInfo> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;
    }

    /**
     * 根据实体类做更新
     * @param startingJobTimeInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  StartingJobTimeInfo update(StartingJobTimeInfo startingJobTimeInfo){
        return this.startingJobTimeInfoService.update(startingJobTimeInfo);
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
                for (StartingJobTimeInfo startingJobTimeInfo: startingJobTimeInfoList) {
                    //TODO 将导入的数据做保存数据库操作,先将所有数据id设置为null
                    count=this.startingJobTimeInfoService.insert(startingJobTimeInfo);
                    if(count==1){
                        System.out.println("成功");
                    }
                }
                res.setMsg("导入成功");
                res.setData(startingJobTimeInfoList.size());
                System.out.println("从Excel导入数据一共 {} 行 "+startingJobTimeInfoList.size());
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
}