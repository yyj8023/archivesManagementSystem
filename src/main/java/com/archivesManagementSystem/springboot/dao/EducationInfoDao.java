package com.archivesManagementSystem.springboot.dao;

import com.archivesManagementSystem.springboot.entity.EducationInfo;
import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 学位学历信息详细表(EducationInfo)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-27 23:32:14
 */
@Mapper
public interface EducationInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EducationInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EducationInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param educationInfo 实例对象
     * @return 对象列表
     */
    List<EducationInfo> queryAll(EducationInfo educationInfo);

    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    List<EducationInfo> queryAllByPage();

    /**
     * 新增数据
     *
     * @param educationInfo 实例对象
     * @return 影响行数
     */
    int insert(EducationInfo educationInfo);

    /**
     * 修改数据
     *
     * @param educationInfo 实例对象
     * @return 影响行数
     */
    int update(EducationInfo educationInfo);

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
    EducationInfo queryByEmployeeId(String employeeId);

    /**
     * 通过employeeId查询单条数据
     *
     * @param employeeName 主键
     * @return 实例对象
     */
    EducationInfo queryByEmployeeName(String employeeName);
}