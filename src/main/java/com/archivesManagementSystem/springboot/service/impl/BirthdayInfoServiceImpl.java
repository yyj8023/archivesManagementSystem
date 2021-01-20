package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.BirthdayInfo;
import com.archivesManagementSystem.springboot.dao.BirthdayInfoDao;
import com.archivesManagementSystem.springboot.service.BirthdayInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 出生日期信息认定表(BirthdayInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 22:11:48
 */
@Service("birthdayInfoService")
public class BirthdayInfoServiceImpl implements BirthdayInfoService {
    @Resource
    private BirthdayInfoDao birthdayInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public BirthdayInfo queryById(Integer employeeId) {
        return this.birthdayInfoDao.queryById(employeeId);
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
     * 新增数据
     *
     * @param birthdayInfo 实例对象
     * @return 实例对象
     */
    @Override
    public BirthdayInfo insert(BirthdayInfo birthdayInfo) {
        this.birthdayInfoDao.insert(birthdayInfo);
        return birthdayInfo;
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
        return this.queryById(birthdayInfo.getEmployeeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer employeeId) {
        return this.birthdayInfoDao.deleteById(employeeId) > 0;
    }
}