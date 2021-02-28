package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.BirthdayInfo;
import com.archivesManagementSystem.springboot.dao.BirthdayInfoDao;
import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.service.BirthdayInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 出生日期信息认定表(BirthdayInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-27 23:31:38
 */
@Service("birthdayInfoService")
public class BirthdayInfoServiceImpl implements BirthdayInfoService {
    @Resource
    private BirthdayInfoDao birthdayInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BirthdayInfo queryById(Integer id) {
        return this.birthdayInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BirthdayInfo> queryAllByLimit(int offset, int limit) {
        return this.birthdayInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param birthdayInfo 实例对象
     * @return 对象列表
     */
    @Override
    public List<BirthdayInfo> queryAll(BirthdayInfo birthdayInfo) {
        return this.birthdayInfoDao.queryAll(birthdayInfo);
    }

    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<BirthdayInfo> queryAllByPage() {
        return this.birthdayInfoDao.queryAllByPage();
    }

    /**
     * 新增数据
     *
     * @param birthdayInfo 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(BirthdayInfo birthdayInfo) {

        return this.birthdayInfoDao.insert(birthdayInfo);
    }

    /**
     * 修改数据
     *
     * @param birthdayInfo 实例对象
     * @return 实例对象
     */
    @Override
    public BirthdayInfo update(BirthdayInfo birthdayInfo) {
        this.birthdayInfoDao.update(birthdayInfo);
        return this.queryById(birthdayInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.birthdayInfoDao.deleteById(id) > 0;
    }

    @Override
    public boolean deleteByEmployee(String employeeId,String employeeName){
        return  this.birthdayInfoDao.deleteByEmployee(employeeId,employeeName)>0;
    }
    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public BirthdayInfo queryByEmployeeId(String employeeId) {
        return this.birthdayInfoDao.queryByEmployeeId(employeeId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param employeeName 主键
     * @return 实例对象
     */
    @Override
    public BirthdayInfo queryByEmployeeName(String employeeName) {
        return this.birthdayInfoDao.queryByEmployeeName(employeeName);
    }
}