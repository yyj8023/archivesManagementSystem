package com.archivesManagementSystem.springboot.dao;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 员工基本信息表(EmployeeInfo)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-20 22:14:49
 */
@Mapper
public interface EmployeeInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EmployeeInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param employeeInfo 实例对象
     * @return 对象列表
     */
    List<EmployeeInfo> queryAll(EmployeeInfo employeeInfo);

    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    List<EmployeeInfo> queryAllByPage();

    /**
     * 新增数据
     *
     * @param employeeInfo 实例对象
     * @return 影响行数
     */
    int insert(EmployeeInfo employeeInfo);

    /**
     * 修改数据
     *
     * @param employeeInfo 实例对象
     * @return 影响行数
     */
    int update(EmployeeInfo employeeInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}