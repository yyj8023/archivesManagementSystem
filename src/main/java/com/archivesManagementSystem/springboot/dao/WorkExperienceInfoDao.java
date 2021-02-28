package com.archivesManagementSystem.springboot.dao;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.JoinPartyTimeInfo;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.assertj.core.internal.cglib.asm.$ClassWriter;

import java.util.List;

/**
 * 工作经历信息认定表(WorkExperienceInfo)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-27 23:33:11
 */
@Mapper
public interface WorkExperienceInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WorkExperienceInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WorkExperienceInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


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
     * 新增数据
     *
     * @param workExperienceInfo 实例对象
     * @return 影响行数
     */
    int insert(WorkExperienceInfo workExperienceInfo);

    /**
     * 修改数据
     *
     * @param workExperienceInfo 实例对象
     * @return 影响行数
     */
    int update(WorkExperienceInfo workExperienceInfo);

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
    WorkExperienceInfo queryByEmployeeId(String employeeId);

    /**
     * 通过employeeId查询单条数据
     *
     * @param employeeName 主键
     * @return 实例对象
     */
    WorkExperienceInfo queryByEmployeeName(String employeeName);
}