package com.archivesManagementSystem.springboot.service;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.JoinPartyTimeInfo;
import java.util.List;

/**
 * 入党时间信息认定表(JoinPartyTimeInfo)表服务接口
 *
 * @author makejava
 * @since 2021-01-27 23:32:23
 */
public interface JoinPartyTimeInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JoinPartyTimeInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<JoinPartyTimeInfo> queryAllByLimit(int offset, int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param joinPartyTimeInfo 实例对象
     * @return 对象列表
     */
    List<JoinPartyTimeInfo> queryAll(JoinPartyTimeInfo joinPartyTimeInfo);

    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    List<JoinPartyTimeInfo> queryAllByPage();

    /**
     * 新增数据
     *
     * @param joinPartyTimeInfo 实例对象
     * @return 实例对象
     */
    int insert(JoinPartyTimeInfo joinPartyTimeInfo);

    /**
     * 修改数据
     *
     * @param joinPartyTimeInfo 实例对象
     * @return 实例对象
     */
    JoinPartyTimeInfo update(JoinPartyTimeInfo joinPartyTimeInfo);

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
    JoinPartyTimeInfo queryByEmployeeId(String employeeId);

    /**
     * 通过employeeId查询单条数据
     *
     * @param employeeName 主键
     * @return 实例对象
     */
    JoinPartyTimeInfo queryByEmployeeName(String employeeName);

}