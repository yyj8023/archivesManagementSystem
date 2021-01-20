package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.StartingJobTimeInfo;
import com.archivesManagementSystem.springboot.dao.StartingJobTimeInfoDao;
import com.archivesManagementSystem.springboot.service.StartingJobTimeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 参加工作时间基本信息认定表(StartingJobTimeInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 22:13:43
 */
@Service("startingJobTimeInfoService")
public class StartingJobTimeInfoServiceImpl implements StartingJobTimeInfoService {
    @Resource
    private StartingJobTimeInfoDao startingJobTimeInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public StartingJobTimeInfo queryById(Integer employeeId) {
        return this.startingJobTimeInfoDao.queryById(employeeId);
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
    public StartingJobTimeInfo insert(StartingJobTimeInfo startingJobTimeInfo) {
        this.startingJobTimeInfoDao.insert(startingJobTimeInfo);
        return startingJobTimeInfo;
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
        return this.queryById(startingJobTimeInfo.getEmployeeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer employeeId) {
        return this.startingJobTimeInfoDao.deleteById(employeeId) > 0;
    }
}