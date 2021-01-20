package com.archivesManagementSystem.springboot.service;

import com.archivesManagementSystem.springboot.entity.EducationCareerInfo;
import java.util.List;

/**
 * 学历学位信息认定表(EducationCareerInfo)表服务接口
 *
 * @author makejava
 * @since 2021-01-20 22:15:23
 */
public interface EducationCareerInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    EducationCareerInfo queryById(Integer employeeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EducationCareerInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param educationCareerInfo 实例对象
     * @return 实例对象
     */
    EducationCareerInfo insert(EducationCareerInfo educationCareerInfo);

    /**
     * 修改数据
     *
     * @param educationCareerInfo 实例对象
     * @return 实例对象
     */
    EducationCareerInfo update(EducationCareerInfo educationCareerInfo);

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer employeeId);

}