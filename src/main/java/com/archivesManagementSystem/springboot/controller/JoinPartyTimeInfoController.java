package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.JoinPartyTimeInfo;
import com.archivesManagementSystem.springboot.service.JoinPartyTimeInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
    public int insert(JoinPartyTimeInfo joinPartyTimeInfo){
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
    public ModelAndView selectAllForPage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size);
        List<JoinPartyTimeInfo> cs=this.joinPartyTimeInfoService.queryAllByPage();
        PageInfo<JoinPartyTimeInfo> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;
    }

    /**
     * 根据实体类做更新
     * @param joinPartyTimeInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  JoinPartyTimeInfo update(JoinPartyTimeInfo joinPartyTimeInfo){
        return this.joinPartyTimeInfoService.update(joinPartyTimeInfo);
    }
}