package com.archivesManagementSystem.springboot.dao;

import com.archivesManagementSystem.springboot.entity.EducationCareerInfo;
import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 学历学位信息认定表(EducationCareerInfo)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-27 23:32:05
 */
@Mapper
public interface EducationCareerInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EducationCareerInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EducationCareerInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param educationCareerInfo 实例对象
     * @return 对象列表
     */
    List<EducationCareerInfo> queryAll(EducationCareerInfo educationCareerInfo);

    /**
     *
     * @return 对象列表
     */
    List<EducationCareerInfo> queryAllByPage();

    /**
     * 新增数据
     *
     * @param educationCareerInfo 实例对象
     * @return 影响行数
     */
    int insert(EducationCareerInfo educationCareerInfo);

    /**
     * 修改数据
     *
     * @param educationCareerInfo 实例对象
     * @return 影响行数
     */
    int update(EducationCareerInfo educationCareerInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}