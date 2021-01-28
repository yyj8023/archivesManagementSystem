package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.BirthdayInfo;
import com.archivesManagementSystem.springboot.service.BirthdayInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 出生日期信息认定表(BirthdayInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:31:38
 */
@RestController
@RequestMapping("birthdayInfo")
public class BirthdayInfoController {
    /**
     * 服务对象
     */
    @Resource
    private BirthdayInfoService birthdayInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BirthdayInfo selectOne(Integer id) {
        return this.birthdayInfoService.queryById(id);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param birthdayInfo 实例对象
     * @return 对象列表
     */
    @GetMapping("selectAll")
    @ResponseBody
    public List<BirthdayInfo> selectAll(BirthdayInfo birthdayInfo) {
        List<BirthdayInfo> result = this.birthdayInfoService.queryAll(birthdayInfo);
        return result;
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
        List<BirthdayInfo> cs = this.birthdayInfoService.queryAllByPage();
        PageInfo<BirthdayInfo> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;
    }

    /**
     * 单条插入员工信息
     *
     * @param birthdayInfo
     * @return 实体对象，若为空，则插入不成功
     */
    @PostMapping("insert")
    @ResponseBody
    public int insert(BirthdayInfo birthdayInfo){
        return this.birthdayInfoService.insert(birthdayInfo);
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Boolean delete(int id){
        return this.birthdayInfoService.deleteById(id);
    }

    /**
     * 根据实体类做更新
     * @param birthdayInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  BirthdayInfo update(BirthdayInfo birthdayInfo){
        return this.birthdayInfoService.update(birthdayInfo);
    }

}