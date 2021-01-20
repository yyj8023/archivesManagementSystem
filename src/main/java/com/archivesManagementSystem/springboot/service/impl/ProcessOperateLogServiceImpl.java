package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.ProcessOperateLog;
import com.archivesManagementSystem.springboot.dao.ProcessOperateLogDao;
import com.archivesManagementSystem.springboot.service.ProcessOperateLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务流程操作记录表，用于记录该员工哪些认定步骤已走完。(ProcessOperateLog)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 22:14:02
 */
@Service("processOperateLogService")
public class ProcessOperateLogServiceImpl implements ProcessOperateLogService {
    @Resource
    private ProcessOperateLogDao processOperateLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProcessOperateLog queryById(Integer id) {
        return this.processOperateLogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProcessOperateLog> queryAllByLimit(int offset, int limit) {
        return this.processOperateLogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param processOperateLog 实例对象
     * @return 实例对象
     */
    @Override
    public ProcessOperateLog insert(ProcessOperateLog processOperateLog) {
        this.processOperateLogDao.insert(processOperateLog);
        return processOperateLog;
    }

    /**
     * 修改数据
     *
     * @param processOperateLog 实例对象
     * @return 实例对象
     */
    @Override
    public ProcessOperateLog update(ProcessOperateLog processOperateLog) {
        this.processOperateLogDao.update(processOperateLog);
        return this.queryById(processOperateLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.processOperateLogDao.deleteById(id) > 0;
    }
}