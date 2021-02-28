package com.archivesManagementSystem.springboot.service;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.JoinPartyTimeInfo;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import java.util.List;

/**
 * 工作经历信息认定表(WorkExperienceInfo)表服务接口
 *
 * @author makejava
 * @since 2021-01-27 23:33:11
 */
public interface WorkExperienceInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WorkExperienceInfo queryById(Integer id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param workExperienceInfo 实例对象
     * @return 对象列表
     */
    List<WorkExperienceInfo> queryAll(WorkExperienceInfo workExperienceInfo);

    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    List<WorkExperienceInfo> queryAllByPage();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WorkExperienceInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param workExperienceInfo 实例对象
     * @return int
     */
    int insert(WorkExperienceInfo workExperienceInfo);

    /**
     * 修改数据
     *
     * @param workExperienceInfo 实例对象
     * @return 实例对象
     */
    WorkExperienceInfo update(WorkExperienceInfo workExperienceInfo);

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
    WorkExperienceInfo queryByEmployeeId(String employeeId);

    /**
     * 通过employeeId查询单条数据
     *
     * @param employeeName 主键
     * @return 实例对象
     */
    WorkExperienceInfo queryByEmployeeName(String employeeName);

    /**
     * 通过主键employeeIds删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    boolean deleteByEmployeeIds(String[] ids);
}