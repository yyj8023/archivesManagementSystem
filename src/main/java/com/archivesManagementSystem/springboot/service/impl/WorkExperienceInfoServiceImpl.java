package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import com.archivesManagementSystem.springboot.dao.WorkExperienceInfoDao;
import com.archivesManagementSystem.springboot.service.WorkExperienceInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作经历信息认定表(WorkExperienceInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 22:20:41
 */
@Service("workExperienceInfoService")
public class WorkExperienceInfoServiceImpl implements WorkExperienceInfoService {
    @Resource
    private WorkExperienceInfoDao workExperienceInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public WorkExperienceInfo queryById(Integer employeeId) {
        return this.workExperienceInfoDao.queryById(employeeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<WorkExperienceInfo> queryAllByLimit(int offset, int limit) {
        return this.workExperienceInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param workExperienceInfo 实例对象
     * @return 实例对象
     */
    @Override
    public WorkExperienceInfo insert(WorkExperienceInfo workExperienceInfo) {
        this.workExperienceInfoDao.insert(workExperienceInfo);
        return workExperienceInfo;
    }

    /**
     * 修改数据
     *
     * @param workExperienceInfo 实例对象
     * @return 实例对象
     */
    @Override
    public WorkExperienceInfo update(WorkExperienceInfo workExperienceInfo) {
        this.workExperienceInfoDao.update(workExperienceInfo);
        return this.queryById(workExperienceInfo.getEmployeeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer employeeId) {
        return this.workExperienceInfoDao.deleteById(employeeId) > 0;
    }
}