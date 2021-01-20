package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import com.archivesManagementSystem.springboot.service.WorkExperienceInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 工作经历信息认定表(WorkExperienceInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-20 22:20:44
 */
@RestController
@RequestMapping("workExperienceInfo")
public class WorkExperienceInfoController {
    /**
     * 服务对象
     */
    @Resource
    private WorkExperienceInfoService workExperienceInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public WorkExperienceInfo selectOne(Integer id) {
        return this.workExperienceInfoService.queryById(id);
    }

}