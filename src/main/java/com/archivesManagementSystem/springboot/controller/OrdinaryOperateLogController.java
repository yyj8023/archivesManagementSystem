package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.OrdinaryOperateLog;
import com.archivesManagementSystem.springboot.service.OrdinaryOperateLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 日常操作记录表，主要用于记录增加、修改、删除认定表的更新前和更新后每一个字段内容。不做太详细的记录（因为没给钱）(OrdinaryOperateLog)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:32:33
 */
@RestController
@RequestMapping("ordinaryOperateLog")
public class OrdinaryOperateLogController {
    /**
     * 服务对象
     */
    @Resource
    private OrdinaryOperateLogService ordinaryOperateLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OrdinaryOperateLog selectOne(Integer id) {
        return this.ordinaryOperateLogService.queryById(id);
    }

}