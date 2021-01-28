package com.archivesManagementSystem.springboot.service;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;

import java.util.List;

/**
 * 员工基本信息表(EmployeeInfo)表服务接口
 *
 * @author makejava
 * @since 2021-01-20 22:14:49
 */
public interface EmployeeInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeInfo queryById(Integer id);

    /**
     * 查询多条数据
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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EmployeeInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param employeeInfo 实例对象
     * @return 实例对象
     */
    int insert(EmployeeInfo employeeInfo);

    /**
     * 修改数据
     *
     * @param employeeInfo 实例对象
     * @return 实例对象
     */
    EmployeeInfo update(EmployeeInfo employeeInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}