package com.archivesManagementSystem.springboot.service;

import com.archivesManagementSystem.springboot.entity.OrdinaryOperateLog;
import java.util.List;

/**
 * 日常操作记录表，主要用于记录增加、修改、删除认定表的更新前和更新后每一个字段内容。不做太详细的记录（因为没给钱）(OrdinaryOperateLog)表服务接口
 *
 * @author makejava
 * @since 2021-01-20 22:14:24
 */
public interface OrdinaryOperateLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrdinaryOperateLog queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrdinaryOperateLog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param ordinaryOperateLog 实例对象
     * @return 实例对象
     */
    OrdinaryOperateLog insert(OrdinaryOperateLog ordinaryOperateLog);

    /**
     * 修改数据
     *
     * @param ordinaryOperateLog 实例对象
     * @return 实例对象
     */
    OrdinaryOperateLog update(OrdinaryOperateLog ordinaryOperateLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}