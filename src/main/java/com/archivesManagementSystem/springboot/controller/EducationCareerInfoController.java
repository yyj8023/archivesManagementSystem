/*
package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.EducationCareerInfo;
import com.archivesManagementSystem.springboot.service.EducationCareerInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

*/
/**
 * 学历学位信息认定表(EducationCareerInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:32:05
 *//*

@RestController
@RequestMapping("educationCareerInfo")
public class EducationCareerInfoController {
    */
/**
     * 服务对象
     *//*

    @Resource
    private EducationCareerInfoService educationCareerInfoService;

    */
/**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     *//*

    @GetMapping("selectOne")
    public EducationCareerInfo selectOne(Integer id) {
        return this.educationCareerInfoService.queryById(id);
    }

}*/
package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.EducationCareerInfo;
import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.service.EducationCareerInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学历学位信息认定表(EducationCareerInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-20 22:15:23
 */
@RestController
@RequestMapping("educationCareerInfo")
public class EducationCareerInfoController {
    /**
     * 服务对象
     */
    @Resource
    private EducationCareerInfoService educationCareerInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public EducationCareerInfo selectOne(Integer id) {
        return this.educationCareerInfoService.queryById(id);
    }

    /**
     * 单条插入学历信息
     *
     * @param educationCareerInfo
     * @return int=1即为成功
     */
    @PostMapping("insert")
    @ResponseBody
    public int insert(EducationCareerInfo educationCareerInfo){
        return  this.educationCareerInfoService.insert(educationCareerInfo);
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Boolean delete(int id){
        return this.educationCareerInfoService.deleteById(id);
    }

    /**
     * 根据某个字段查询所有的实体集合
     * @param educationCareerInfo
     * @return List集合
     */

    @GetMapping("selectAll")
    public List<EducationCareerInfo> selectAll(EducationCareerInfo educationCareerInfo){
        return  this.educationCareerInfoService.queryAll(educationCareerInfo);
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
        List<EducationCareerInfo> cs=this.educationCareerInfoService.queryAllByPage();
        PageInfo<EducationCareerInfo> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        //返回页面对象
        ModelAndView  modelAndView= new ModelAndView("pageDemo");
        return modelAndView;
    }

    /**
     * 根据实体类做更新
     * @param educationCareerInfo
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  EducationCareerInfo update(EducationCareerInfo educationCareerInfo){
        return this.educationCareerInfoService.update(educationCareerInfo);
    }
}
