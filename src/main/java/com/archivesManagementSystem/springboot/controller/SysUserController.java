package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.SysUser;
import com.archivesManagementSystem.springboot.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
     * @param userName
     * @param userPassword
     * @return int
     */
    @GetMapping("login")
    public int loginCheck(String userName, String userPassword)
    {
        return this.sysUserService.queryByNameAndPass(userName,userPassword);
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
     *
     * @return 对象列表
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

}