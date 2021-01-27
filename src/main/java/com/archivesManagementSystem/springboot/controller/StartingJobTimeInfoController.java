package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.StartingJobTimeInfo;
import com.archivesManagementSystem.springboot.service.StartingJobTimeInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 参加工作时间基本信息认定表(StartingJobTimeInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:33:03
 */
@RestController
@RequestMapping("startingJobTimeInfo")
public class StartingJobTimeInfoController {
    /**
     * 服务对象
     */
    @Resource
    private StartingJobTimeInfoService startingJobTimeInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public StartingJobTimeInfo selectOne(Integer id) {
        return this.startingJobTimeInfoService.queryById(id);
    }

}