package com.archivesManagementSystem.springboot.dao;

import com.archivesManagementSystem.springboot.entity.EducationDetailInfo;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (EducationDetailInfo)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-07 17:12:28
 */
@Mapper
public interface EducationDetailInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EducationDetailInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EducationDetailInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);



    /**
     * 新增数据
     *
     * @param educationDetailInfo 实例对象
     * @return 影响行数
     */
    int insert(EducationDetailInfo educationDetailInfo);

    /**
     * 修改数据
     *
     * @param educationDetailInfo 实例对象
     * @return 影响行数
     */
    int update(EducationDetailInfo educationDetailInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int deleteByEmployee(@Param("employeeId") String employeeId,@Param("employeeName") String employeeName);

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