package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.EducationInfo;
import com.archivesManagementSystem.springboot.dao.EducationInfoDao;
import com.archivesManagementSystem.springboot.service.EducationInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学位学历信息详细表(EducationInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-27 23:32:14
 */
@Service("educationInfoService")
public class EducationInfoServiceImpl implements EducationInfoService {
    @Resource
    private EducationInfoDao educationInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EducationInfo queryById(Integer id) {
        return this.educationInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param educationInfo 实例对象
     * @return 对象列表
     */
    @Override
    public List<EducationInfo> queryAll(EducationInfo educationInfo) {
        return this.educationInfoDao.queryAll(educationInfo);
    }

    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<EducationInfo> queryAllByPage() {
        return this.educationInfoDao.queryAllByPage();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<EducationInfo> queryAllByLimit(int offset, int limit) {
        return this.educationInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param educationInfo 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(EducationInfo educationInfo) {
        return this.educationInfoDao.insert(educationInfo);
    }

    /**
     * 修改数据
     *
     * @param educationInfo 实例对象
     * @return 实例对象
     */
    @Override
    public EducationInfo update(EducationInfo educationInfo) {
        this.educationInfoDao.update(educationInfo);
        return this.queryById(educationInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.educationInfoDao.deleteById(id) > 0;
    }
}