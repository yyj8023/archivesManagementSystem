package com.archivesManagementSystem.springboot.service;

import com.archivesManagementSystem.springboot.entity.EducationDetailInfo;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;

import java.util.List;

/**
 * (EducationDetailInfo)表服务接口
 *
 * @author makejava
 * @since 2021-03-07 17:12:28
 */
public interface EducationDetailInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EducationDetailInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EducationDetailInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param educationDetailInfo 实例对象
     * @return int
     */
     int  insert(EducationDetailInfo educationDetailInfo);

    /**
     * 修改数据
     *
     * @param educationDetailInfo 实例对象
     * @return 实例对象
     */
    EducationDetailInfo update(EducationDetailInfo educationDetailInfo);

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
    EducationDetailInfo queryByEmployeeId(String employeeId);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param educationDetailInfo 实例对象
     * @return 对象列表
     */
    List<EducationDetailInfo> queryAll(EducationDetailInfo educationDetailInfo);
    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    List<EducationDetailInfo> queryAllByPage();
}