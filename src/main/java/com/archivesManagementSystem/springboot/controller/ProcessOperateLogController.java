package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.ProcessOperateLog;
import com.archivesManagementSystem.springboot.service.ProcessOperateLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 业务流程操作记录表，用于记录该员工哪些认定步骤已走完。(ProcessOperateLog)表控制层
 *
 * @author makejava
 * @since 2021-01-20 22:14:02
 */
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

}