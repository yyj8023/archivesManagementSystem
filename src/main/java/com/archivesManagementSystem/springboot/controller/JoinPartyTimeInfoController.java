package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.JoinPartyTimeInfo;
import com.archivesManagementSystem.springboot.service.JoinPartyTimeInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 入党时间信息认定表(JoinPartyTimeInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:32:23
 */
@RestController
@RequestMapping("joinPartyTimeInfo")
public class JoinPartyTimeInfoController {
    /**
     * 服务对象
     */
    @Resource
    private JoinPartyTimeInfoService joinPartyTimeInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public JoinPartyTimeInfo selectOne(Integer id) {
        return this.joinPartyTimeInfoService.queryById(id);
    }

}