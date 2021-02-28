package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.StartingJobTimeInfo;
import com.archivesManagementSystem.springboot.dao.StartingJobTimeInfoDao;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import com.archivesManagementSystem.springboot.service.StartingJobTimeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 参加工作时间基本信息认定表(StartingJobTimeInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-27 23:33:03
 */
@Service("startingJobTimeInfoService")
public class StartingJobTimeInfoServiceImpl implements StartingJobTimeInfoService {
    @Resource
    private StartingJobTimeInfoDao startingJobTimeInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StartingJobTimeInfo queryById(Integer id) {
        return this.startingJobTimeInfoDao.queryById(id);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param startingJobTimeInfo 实例对象
     * @return 对象列表
     */
    @Override
    public List<StartingJobTimeInfo> queryAll(StartingJobTimeInfo startingJobTimeInfo) {
        return this.startingJobTimeInfoDao.queryAll(startingJobTimeInfo);
    }

    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<StartingJobTimeInfo> queryAllByPage() {
        return this.startingJobTimeInfoDao.queryAllByPage();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<StartingJobTimeInfo> queryAllByLimit(int offset, int limit) {
        return this.startingJobTimeInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param startingJobTimeInfo 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(StartingJobTimeInfo startingJobTimeInfo) {
        return this.startingJobTimeInfoDao.insert(startingJobTimeInfo);
    }

    /**
     * 修改数据
     *
     * @param startingJobTimeInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StartingJobTimeInfo update(StartingJobTimeInfo startingJobTimeInfo) {
        this.startingJobTimeInfoDao.update(startingJobTimeInfo);
        return this.queryById(startingJobTimeInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.startingJobTimeInfoDao.deleteById(id) > 0;
    }

    @Override
    public boolean deleteByEmployee(String employeeId,String employeeName){
        return  this.startingJobTimeInfoDao.deleteByEmployee(employeeId,employeeName)>0;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public StartingJobTimeInfo queryByEmployeeId(String employeeId) {
        return this.startingJobTimeInfoDao.queryByEmployeeId(employeeId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param employeeName 主键
     * @return 实例对象
     */
    @Override
    public StartingJobTimeInfo queryByEmployeeName(String employeeName) {
        return this.startingJobTimeInfoDao.queryByEmployeeName(employeeName);
    }

    /**
     * 通过主键employeeIds删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByEmployeeIds(String[] ids) {
        return this.startingJobTimeInfoDao.deleteByEmployeeIds(ids) > 0;
    }
}