package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.EducationCareerInfo;
import com.archivesManagementSystem.springboot.dao.EducationCareerInfoDao;
import com.archivesManagementSystem.springboot.entity.SysUser;
import com.archivesManagementSystem.springboot.service.EducationCareerInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学历学位信息认定表(EducationCareerInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-27 23:32:05
 */
@Service("educationCareerInfoService")
public class EducationCareerInfoServiceImpl implements EducationCareerInfoService {
    @Resource
    private EducationCareerInfoDao educationCareerInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EducationCareerInfo queryById(Integer id) {
        return this.educationCareerInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param educationCareerInfo 实例对象
     * @return 对象列表
     */
    @Override
    public List<EducationCareerInfo> queryAll(EducationCareerInfo educationCareerInfo){
        return this.educationCareerInfoDao.queryAll(educationCareerInfo);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<EducationCareerInfo> queryAllByPage(){
        return this.educationCareerInfoDao.queryAllByPage();
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
    public int insert(EducationCareerInfo educationCareerInfo) {
        return this.educationCareerInfoDao.insert(educationCareerInfo);
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
        return this.queryById(educationCareerInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.educationCareerInfoDao.deleteById(id) > 0;
    }
}