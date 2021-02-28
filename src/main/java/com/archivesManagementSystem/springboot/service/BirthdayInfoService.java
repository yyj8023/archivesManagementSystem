package com.archivesManagementSystem.springboot.service;

import com.archivesManagementSystem.springboot.entity.BirthdayInfo;
import com.archivesManagementSystem.springboot.entity.EmployeeInfo;

import java.util.List;

/**
 * 出生日期信息认定表(BirthdayInfo)表服务接口
 *
 * @author makejava
 * @since 2021-01-27 23:31:38
 */
public interface BirthdayInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BirthdayInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BirthdayInfo> queryAllByLimit(int offset, int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param birthdayInfo 实例对象
     * @return 对象列表
     */
    List<BirthdayInfo> queryAll(BirthdayInfo birthdayInfo);

    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    List<BirthdayInfo> queryAllByPage();

    /**
     * 新增数据
     *
     * @param birthdayInfo 实例对象
     * @return 实例对象
     */
    int insert(BirthdayInfo birthdayInfo);

    /**
     * 修改数据
     *
     * @param birthdayInfo 实例对象
     * @return 实例对象
     */
    BirthdayInfo update(BirthdayInfo birthdayInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    boolean deleteByEmployee(String employeeId,String employeeName);

    /**
     * 通过employeeId查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    BirthdayInfo queryByEmployeeId(String employeeId);

    /**
     * 通过employeeId查询单条数据
     *
     * @param employeeName 主键
     * @return 实例对象
     */
    BirthdayInfo queryByEmployeeName(String employeeName);

    /**
     * 通过主键employeeIds删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    boolean deleteByEmployeeIds(String[] ids);
}