package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.dao.EmployeeInfoDao;
import com.archivesManagementSystem.springboot.service.EmployeeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工基本信息表(EmployeeInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 22:14:49
 */
@Service("employeeInfoService")
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
    @Resource
    private EmployeeInfoDao employeeInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EmployeeInfo queryById(Integer id) {
        return this.employeeInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<EmployeeInfo> queryAllByLimit(int offset, int limit) {
        return this.employeeInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param employeeInfo 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeInfo insert(EmployeeInfo employeeInfo) {
        this.employeeInfoDao.insert(employeeInfo);
        return employeeInfo;
    }

    /**
     * 修改数据
     *
     * @param employeeInfo 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeInfo update(EmployeeInfo employeeInfo) {
        this.employeeInfoDao.update(employeeInfo);
        return this.queryById(employeeInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employeeInfoDao.deleteById(id) > 0;
    }
}