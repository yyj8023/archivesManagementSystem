package com.archivesManagementSystem.springboot.service;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.StartingJobTimeInfo;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;

import java.util.List;

/**
 * 参加工作时间基本信息认定表(StartingJobTimeInfo)表服务接口
 *
 * @author makejava
 * @since 2021-01-27 23:33:03
 */
public interface StartingJobTimeInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StartingJobTimeInfo queryById(Integer id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param startingJobTimeInfo 实例对象
     * @return 对象列表
     */
    List<StartingJobTimeInfo> queryAll(StartingJobTimeInfo startingJobTimeInfo);

    /**S
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    List<StartingJobTimeInfo> queryAllByPage();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<StartingJobTimeInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param startingJobTimeInfo 实例对象
     * @return int
     */
   int insert(StartingJobTimeInfo startingJobTimeInfo);

    /**
     * 修改数据
     *
     * @param startingJobTimeInfo 实例对象
     * @return 实例对象
     */
    StartingJobTimeInfo update(StartingJobTimeInfo startingJobTimeInfo);

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
    StartingJobTimeInfo queryByEmployeeId(String employeeId);

    /**
     * 通过employeeId查询单条数据
     *
     * @param employeeName 主键
     * @return 实例对象
     */
    StartingJobTimeInfo queryByEmployeeName(String employeeName);
}