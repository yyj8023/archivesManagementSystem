package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.EducationCareerInfo;
import com.archivesManagementSystem.springboot.service.EducationCareerInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

}