package com.archivesManagementSystem.springboot.service;

import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import java.util.List;

/**
 * 工作经历信息认定表(WorkExperienceInfo)表服务接口
 *
 * @author makejava
 * @since 2021-01-20 22:20:41
 */
public interface WorkExperienceInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    WorkExperienceInfo queryById(Integer employeeId);

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
     * @return 实例对象
     */
    WorkExperienceInfo insert(WorkExperienceInfo workExperienceInfo);

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
     * @param employeeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer employeeId);

}