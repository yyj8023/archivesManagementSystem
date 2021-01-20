package com.archivesManagementSystem.springboot.service;

import com.archivesManagementSystem.springboot.entity.EducationInfo;
import java.util.List;

/**
 * 学位学历信息详细表(EducationInfo)表服务接口
 *
 * @author makejava
 * @since 2021-01-20 22:15:04
 */
public interface EducationInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    EducationInfo queryById(Integer employeeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EducationInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param educationInfo 实例对象
     * @return 实例对象
     */
    EducationInfo insert(EducationInfo educationInfo);

    /**
     * 修改数据
     *
     * @param educationInfo 实例对象
     * @return 实例对象
     */
    EducationInfo update(EducationInfo educationInfo);

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer employeeId);

}