package com.archivesManagementSystem.springboot.dao;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.OrdinaryOperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 日常操作记录表，主要用于记录增加、修改、删除认定表的更新前和更新后每一个字段内容。不做太详细的记录（因为没给钱）(OrdinaryOperateLog)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-27 23:32:33
 */
@Mapper
public interface OrdinaryOperateLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrdinaryOperateLog queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrdinaryOperateLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param ordinaryOperateLog 实例对象
     * @return 对象列表
     */
    List<OrdinaryOperateLog> queryAll(OrdinaryOperateLog ordinaryOperateLog);

    /**
     *
     * @return 对象列表
     */
    List<OrdinaryOperateLog> queryAllByPage();

    /**
     * 新增数据
     *
     * @param ordinaryOperateLog 实例对象
     * @return 影响行数
     */
    int insert(OrdinaryOperateLog ordinaryOperateLog);

    /**
     * 修改数据
     *
     * @param ordinaryOperateLog 实例对象
     * @return 影响行数
     */
    int update(OrdinaryOperateLog ordinaryOperateLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}