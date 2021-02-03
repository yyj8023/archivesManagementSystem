package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.OrdinaryOperateLog;
import com.archivesManagementSystem.springboot.service.OrdinaryOperateLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日常操作记录表，主要用于记录增加、修改、删除认定表的更新前和更新后每一个字段内容。不做太详细的记录（因为没给钱）(OrdinaryOperateLog)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:32:33
 */
@CrossOrigin
@RestController
@RequestMapping("ordinaryOperateLog")
public class OrdinaryOperateLogController {
    /**
     * 服务对象
     */
    @Resource
    private OrdinaryOperateLogService ordinaryOperateLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OrdinaryOperateLog selectOne(Integer id) {
        return this.ordinaryOperateLogService.queryById(id);
    }

    /**
     * 单条插入员工信息
     *
     * @param ordinaryOperateLog
     * @return 实体对象，若为空，则插入不成功
     */
    @PostMapping("insert")
    @ResponseBody
    public int insert(OrdinaryOperateLog ordinaryOperateLog){
        return  this.ordinaryOperateLogService.insert(ordinaryOperateLog);
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Boolean delete(int id){
        return this.ordinaryOperateLogService.deleteById(id);
    }

    /**
     * 根据某个字段查询所有的实体集合
     * @param ordinaryOperateLog
     * @return List集合
     */

    @GetMapping("selectAll")
    public List<OrdinaryOperateLog> selectAll(OrdinaryOperateLog ordinaryOperateLog){
        return  this.ordinaryOperateLogService.queryAll(ordinaryOperateLog);
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
        List<OrdinaryOperateLog> cs=this.ordinaryOperateLogService.queryAllByPage();
        PageInfo<OrdinaryOperateLog> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        //返回页面对象
        ModelAndView modelAndView= new ModelAndView("pageDemo");
        return modelAndView;
    }

    /**
     * 根据实体类做更新
     * @param ordinaryOperateLog
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  OrdinaryOperateLog update(OrdinaryOperateLog ordinaryOperateLog){
        return this.ordinaryOperateLogService.update(ordinaryOperateLog);
    }

}