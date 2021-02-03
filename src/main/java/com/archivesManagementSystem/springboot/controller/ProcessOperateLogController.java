package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.OrdinaryOperateLog;
import com.archivesManagementSystem.springboot.entity.ProcessOperateLog;
import com.archivesManagementSystem.springboot.service.ProcessOperateLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务流程操作记录表，用于记录该员工哪些认定步骤已走完。(ProcessOperateLog)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:32:54
 */
@CrossOrigin
@RestController
@RequestMapping("processOperateLog")
public class ProcessOperateLogController {
    /**
     * 服务对象
     */
    @Resource
    private ProcessOperateLogService processOperateLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProcessOperateLog selectOne(Integer id) {
        return this.processOperateLogService.queryById(id);
    }

    /**
     * 单条插入员工信息
     *
     * @param processOperateLog
     * @return 实体对象，若为空，则插入不成功
     */
    @PostMapping("insert")
    @ResponseBody
    public int insert(ProcessOperateLog processOperateLog){
        return  this.processOperateLogService.insert(processOperateLog);
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Boolean delete(int id){
        return this.processOperateLogService.deleteById(id);
    }

    /**
     * 根据某个字段查询所有的实体集合
     * @param processOperateLog
     * @return List集合
     */

    @GetMapping("selectAll")
    public List<ProcessOperateLog> selectAll(ProcessOperateLog processOperateLog){
        return  this.processOperateLogService.queryAll(processOperateLog);
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
        List<ProcessOperateLog> cs=this.processOperateLogService.queryAllByPage();
        PageInfo<ProcessOperateLog> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        //返回页面对象
        ModelAndView modelAndView= new ModelAndView("pageDemo");
        return modelAndView;
    }

    /**
     * 根据实体类做更新
     * @param processOperateLog
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public ProcessOperateLog update(ProcessOperateLog processOperateLog){
        return this.processOperateLogService.update(processOperateLog);
    }
}