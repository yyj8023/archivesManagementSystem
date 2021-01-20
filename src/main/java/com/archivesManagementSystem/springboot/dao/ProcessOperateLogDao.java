package com.archivesManagementSystem.springboot.dao;

import com.archivesManagementSystem.springboot.entity.ProcessOperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 业务流程操作记录表，用于记录该员工哪些认定步骤已走完。(ProcessOperateLog)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-20 22:14:02
 */
@Mapper
public interface ProcessOperateLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProcessOperateLog queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProcessOperateLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param processOperateLog 实例对象
     * @return 对象列表
     */
    List<ProcessOperateLog> queryAll(ProcessOperateLog processOperateLog);

    /**
     * 新增数据
     *
     * @param processOperateLog 实例对象
     * @return 影响行数
     */
    int insert(ProcessOperateLog processOperateLog);

    /**
     * 修改数据
     *
     * @param processOperateLog 实例对象
     * @return 影响行数
     */
    int update(ProcessOperateLog processOperateLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}