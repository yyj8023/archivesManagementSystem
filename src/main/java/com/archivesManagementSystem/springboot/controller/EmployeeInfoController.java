package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.service.EmployeeInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 员工基本信息表(EmployeeInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-20 22:14:49
 */
@RestController
@RequestMapping("employeeInfo")
public class EmployeeInfoController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeInfoService employeeInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public EmployeeInfo selectOne(Integer id) {
        return this.employeeInfoService.queryById(id);
    }

}