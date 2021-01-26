package com.archivesManagementSystem.springboot.service.impl;

import com.archivesManagementSystem.springboot.entity.SysUser;
import com.archivesManagementSystem.springboot.dao.SysUserDao;
import com.archivesManagementSystem.springboot.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 22:03:33
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer id) {
        return this.sysUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAll(SysUser sysUser){
        return this.sysUserDao.queryAll(sysUser);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByPage(){
        return this.sysUserDao.queryAllByPage();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SysUser sysUser) {
        return this.sysUserDao.insert(sysUser);
       /* return sysUser;*/
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysUserDao.deleteById(id) > 0;
    }

    @Override
    public int queryByNameAndPass(String userName,String userPassword){
        return this.sysUserDao.queryByNameAndPass(userName,userPassword);
    }
}