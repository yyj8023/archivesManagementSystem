package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.EducationInfo;
import com.archivesManagementSystem.springboot.service.EducationInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学位学历信息详细表(EducationInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:32:14
 */
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
     * @param employeeInfo
     * @return 实体对象，若为空，则插入不成功
     */
    @PostMapping("insert")
    @ResponseBody
    public int insert(EducationInfo employeeInfo){
        return  this.educationInfoService.insert(employeeInfo);
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Boolean delete(int id){
        return this.educationInfoService.deleteById(id);
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
    public ModelAndView selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<EducationInfo> cs=this.educationInfoService.queryAllByPage();
        PageInfo<EducationInfo> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;
    }

    /**
     * 根据实体类做更新
     * @param educationInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  EducationInfo update(EducationInfo educationInfo){
        return this.educationInfoService.update(educationInfo);
    }
}