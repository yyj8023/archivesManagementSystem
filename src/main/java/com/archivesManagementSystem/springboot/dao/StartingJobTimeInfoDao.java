package com.archivesManagementSystem.springboot.dao;

import com.archivesManagementSystem.springboot.entity.StartingJobTimeInfo;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 参加工作时间基本信息认定表(StartingJobTimeInfo)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-27 23:33:03
 */
@Mapper
public interface StartingJobTimeInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StartingJobTimeInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<StartingJobTimeInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param startingJobTimeInfo 实例对象
     * @return 对象列表
     */
    List<StartingJobTimeInfo> queryAll(StartingJobTimeInfo startingJobTimeInfo);

    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    List<StartingJobTimeInfo> queryAllByPage();

    /**
     * 新增数据
     *
     * @param startingJobTimeInfo 实例对象
     * @return 影响行数
     */
    int insert(StartingJobTimeInfo startingJobTimeInfo);

    /**
     * 修改数据
     *
     * @param startingJobTimeInfo 实例对象
     * @return 影响行数
     */
    int update(StartingJobTimeInfo startingJobTimeInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int deleteByEmployee(@Param("employeeId") int employeeId,@Param("employeeName") String employeeName);
}