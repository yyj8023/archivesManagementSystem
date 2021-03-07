package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.EducationDetailInfo;
import com.archivesManagementSystem.springboot.dao.EducationDetailInfoDao;
import com.archivesManagementSystem.springboot.entity.WorkExperienceInfo;
import com.archivesManagementSystem.springboot.service.EducationDetailInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EducationDetailInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-03-07 17:12:28
 */
@Service("educationDetailInfoService")
public class EducationDetailInfoServiceImpl implements EducationDetailInfoService {
    @Resource
    private EducationDetailInfoDao educationDetailInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EducationDetailInfo queryById(Integer id) {
        return this.educationDetailInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<EducationDetailInfo> queryAllByLimit(int offset, int limit) {
        return this.educationDetailInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param educationDetailInfo 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(EducationDetailInfo educationDetailInfo) {
        return this.educationDetailInfoDao.insert(educationDetailInfo);
    }

    /**
     * 修改数据
     *
     * @param educationDetailInfo 实例对象
     * @return 实例对象
     */
    @Override
    public EducationDetailInfo update(EducationDetailInfo educationDetailInfo) {
        this.educationDetailInfoDao.update(educationDetailInfo);
        return this.queryById(educationDetailInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.educationDetailInfoDao.deleteById(id) > 0;
    }

    @Override
    public boolean deleteByEmployee(String employeeId,String employeeName){
        return  this.educationDetailInfoDao.deleteByEmployee(employeeId,employeeName)>0;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public EducationDetailInfo queryByEmployeeId(String employeeId) {
        return this.educationDetailInfoDao.queryByEmployeeId(employeeId);
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param educationDetailInfo
     * @return 对象列表
     */
    @Override
    public List<EducationDetailInfo> queryAll(EducationDetailInfo educationDetailInfo) {
        return this.educationDetailInfoDao.queryAll(educationDetailInfo);
    }

    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<EducationDetailInfo> queryAllByPage() {
        return this.educationDetailInfoDao.queryAllByPage();
    }
}