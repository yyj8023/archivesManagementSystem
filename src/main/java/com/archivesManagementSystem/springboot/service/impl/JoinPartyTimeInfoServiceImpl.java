package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.JoinPartyTimeInfo;
import com.archivesManagementSystem.springboot.dao.JoinPartyTimeInfoDao;
import com.archivesManagementSystem.springboot.service.JoinPartyTimeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 入党时间信息认定表(JoinPartyTimeInfo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-27 23:32:23
 */
@Service("joinPartyTimeInfoService")
public class JoinPartyTimeInfoServiceImpl implements JoinPartyTimeInfoService {
    @Resource
    private JoinPartyTimeInfoDao joinPartyTimeInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public JoinPartyTimeInfo queryById(Integer id) {
        return this.joinPartyTimeInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<JoinPartyTimeInfo> queryAllByLimit(int offset, int limit) {
        return this.joinPartyTimeInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param joinPartyTimeInfo 实例对象
     * @return 对象列表
     */
    @Override
    public List<JoinPartyTimeInfo> queryAll(JoinPartyTimeInfo joinPartyTimeInfo) {
        return this.joinPartyTimeInfoDao.queryAll(joinPartyTimeInfo);
    }

    /**
     * 分页查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<JoinPartyTimeInfo> queryAllByPage() {
        return this.joinPartyTimeInfoDao.queryAllByPage();
    }

    /**
     * 新增数据
     *
     * @param joinPartyTimeInfo 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(JoinPartyTimeInfo joinPartyTimeInfo) {
        return this.joinPartyTimeInfoDao.insert(joinPartyTimeInfo);
    }

    /**
     * 修改数据
     *
     * @param joinPartyTimeInfo 实例对象
     * @return 实例对象
     */
    @Override
    public JoinPartyTimeInfo update(JoinPartyTimeInfo joinPartyTimeInfo) {
        this.joinPartyTimeInfoDao.update(joinPartyTimeInfo);
        return this.queryById(joinPartyTimeInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.joinPartyTimeInfoDao.deleteById(id) > 0;
    }

    @Override
    public boolean deleteByEmployee(String employeeId,String employeeName){
        return  this.joinPartyTimeInfoDao.deleteByEmployee(employeeId,employeeName)>0;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public JoinPartyTimeInfo queryByEmployeeId(String employeeId) {
        return this.joinPartyTimeInfoDao.queryByEmployeeId(employeeId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param employeeName 主键
     * @return 实例对象
     */
    @Override
    public JoinPartyTimeInfo queryByEmployeeName(String employeeName) {
        return this.joinPartyTimeInfoDao.queryByEmployeeName(employeeName);
    }

    /**
     * 通过主键employeeIds删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByEmployeeIds(String[] ids) {
        return this.joinPartyTimeInfoDao.deleteByEmployeeIds(ids) > 0;
    }

}