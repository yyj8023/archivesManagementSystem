package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.EducationInfo;
import com.archivesManagementSystem.springboot.service.EducationInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 学位学历信息详细表(EducationInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-20 22:15:04
 */
@RestController
@RequestMapping("educationInfo")
public class EducationInfoController {
    /**
     * 服务对象
     */
    @Resource
    private EducationInfoService educationInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public EducationInfo selectOne(Integer id) {
        return this.educationInfoService.queryById(id);
    }

}