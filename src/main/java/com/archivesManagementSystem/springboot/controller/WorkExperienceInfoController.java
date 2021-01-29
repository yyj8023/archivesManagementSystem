package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.JoinPartyTimeInfo;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import com.archivesManagementSystem.springboot.service.WorkExperienceInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作经历信息认定表(WorkExperienceInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:33:11
 */
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
    public int insert(WorkExperienceInfo workExperienceInfo){
        return  this.workExperienceInfoService.insert(workExperienceInfo);
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Boolean delete(int id){
        return this.workExperienceInfoService.deleteById(id);
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
    public ModelAndView selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<WorkExperienceInfo> cs=this.workExperienceInfoService.queryAllByPage();
        PageInfo<WorkExperienceInfo> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;
    }

    /**
     * 根据实体类做更新
     * @param workExperienceInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  WorkExperienceInfo update(WorkExperienceInfo workExperienceInfo){
        return this.workExperienceInfoService.update(workExperienceInfo);
    }
}