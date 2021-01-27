package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.BirthdayInfo;
import com.archivesManagementSystem.springboot.service.BirthdayInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 出生日期信息认定表(BirthdayInfo)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:31:38
 */
@RestController
@RequestMapping("birthdayInfo")
public class BirthdayInfoController {
    /**
     * 服务对象
     */
    @Resource
    private BirthdayInfoService birthdayInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BirthdayInfo selectOne(Integer id) {
        return this.birthdayInfoService.queryById(id);
    }

}