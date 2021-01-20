package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.EducationCareerInfo;
import com.archivesManagementSystem.springboot.dao.EducationCareerInfoDao;
import com.archivesManagementSystem.springboot.service.EducationCareerInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学历学位信息认定表(EducationCareerInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 22:15:23
 */
@Service("educationCareerInfoService")
public class EducationCareerInfoServiceImpl implements EducationCareerInfoService {
    @Resource
    private EducationCareerInfoDao educationCareerInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public EducationCareerInfo queryById(Integer employeeId) {
        return this.educationCareerInfoDao.queryById(employeeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<EducationCareerInfo> queryAllByLimit(int offset, int limit) {
        return this.educationCareerInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param educationCareerInfo 实例对象
     * @return 实例对象
     */
    @Override
    public EducationCareerInfo insert(EducationCareerInfo educationCareerInfo) {
        this.educationCareerInfoDao.insert(educationCareerInfo);
        return educationCareerInfo;
    }

    /**
     * 修改数据
     *
     * @param educationCareerInfo 实例对象
     * @return 实例对象
     */
    @Override
    public EducationCareerInfo update(EducationCareerInfo educationCareerInfo) {
        this.educationCareerInfoDao.update(educationCareerInfo);
        return this.queryById(educationCareerInfo.getEmployeeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer employeeId) {
        return this.educationCareerInfoDao.deleteById(employeeId) > 0;
    }
}