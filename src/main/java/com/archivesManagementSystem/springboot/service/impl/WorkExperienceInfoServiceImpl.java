package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.JoinPartyTimeInfo;
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
 * @since 2021-01-27 23:33:11
 */
@Service("workExperienceInfoService")
public class WorkExperienceInfoServiceImpl implements WorkExperienceInfoService {
    @Resource
    private WorkExperienceInfoDao workExperienceInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public WorkExperienceInfo queryById(Integer id) {
        return this.workExperienceInfoDao.queryById(id);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param workExperienceInfo 实例对象
     * @return 对象列表
     */
    @Override
    public List<WorkExperienceInfo> queryAll(WorkExperienceInfo workExperienceInfo) {
        return this.workExperienceInfoDao.queryAll(workExperienceInfo);
    }

    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<WorkExperienceInfo> queryAllByPage() {
        return this.workExperienceInfoDao.queryAllByPage();
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
    public int insert(WorkExperienceInfo workExperienceInfo) {
        return this.workExperienceInfoDao.insert(workExperienceInfo);
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
        return this.queryById(workExperienceInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.workExperienceInfoDao.deleteById(id) > 0;
    }

    @Override
    public boolean deleteByEmployee(String employeeId,String employeeName){
        return  this.workExperienceInfoDao.deleteByEmployee(employeeId,employeeName)>0;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public WorkExperienceInfo queryByEmployeeId(String employeeId) {
        return this.workExperienceInfoDao.queryByEmployeeId(employeeId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param employeeName 主键
     * @return 实例对象
     */
    @Override
    public WorkExperienceInfo queryByEmployeeName(String employeeName) {
        return this.workExperienceInfoDao.queryByEmployeeName(employeeName);
    }

    /**
     * 通过主键employeeIds删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByEmployeeIds(String[] ids) {
        return this.workExperienceInfoDao.deleteByEmployeeIds(ids) > 0;
    }
}