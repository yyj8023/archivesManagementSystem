package com.archivesManagementSystem.springboot.service;

import com.archivesManagementSystem.springboot.entity.ProcessOperateLog;
import java.util.List;

/**
 * 业务流程操作记录表，用于记录该员工哪些认定步骤已走完。(ProcessOperateLog)表服务接口
 *
 * @author makejava
 * @since 2021-01-27 23:32:54
 */
public interface ProcessOperateLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProcessOperateLog queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProcessOperateLog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param processOperateLog 实例对象
     * @return 实例对象
     */
    ProcessOperateLog insert(ProcessOperateLog processOperateLog);

    /**
     * 修改数据
     *
     * @param processOperateLog 实例对象
     * @return 实例对象
     */
    ProcessOperateLog update(ProcessOperateLog processOperateLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}