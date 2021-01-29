package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.StartingJobTimeInfo;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import com.archivesManagementSystem.springboot.service.StartingJobTimeInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
}