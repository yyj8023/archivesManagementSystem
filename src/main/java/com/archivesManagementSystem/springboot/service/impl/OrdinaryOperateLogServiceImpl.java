package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.OrdinaryOperateLog;
import com.archivesManagementSystem.springboot.dao.OrdinaryOperateLogDao;
import com.archivesManagementSystem.springboot.service.OrdinaryOperateLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日常操作记录表，主要用于记录增加、修改、删除认定表的更新前和更新后每一个字段内容。不做太详细的记录（因为没给钱）(OrdinaryOperateLog)表服务实现类
 *
 * @author makejava
 * @since 2021-01-27 23:32:33
 */
@Service("ordinaryOperateLogService")
public class OrdinaryOperateLogServiceImpl implements OrdinaryOperateLogService {
    @Resource
    private OrdinaryOperateLogDao ordinaryOperateLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrdinaryOperateLog queryById(Integer id) {
        return this.ordinaryOperateLogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OrdinaryOperateLog> queryAllByLimit(int offset, int limit) {
        return this.ordinaryOperateLogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ordinaryOperateLog 实例对象
     * @return 实例对象
     */
    @Override
    public OrdinaryOperateLog insert(OrdinaryOperateLog ordinaryOperateLog) {
        this.ordinaryOperateLogDao.insert(ordinaryOperateLog);
        return ordinaryOperateLog;
    }

    /**
     * 修改数据
     *
     * @param ordinaryOperateLog 实例对象
     * @return 实例对象
     */
    @Override
    public OrdinaryOperateLog update(OrdinaryOperateLog ordinaryOperateLog) {
        this.ordinaryOperateLogDao.update(ordinaryOperateLog);
        return this.queryById(ordinaryOperateLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.ordinaryOperateLogDao.deleteById(id) > 0;
    }
}