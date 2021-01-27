package com.archivesManagementSystem.springboot.service;

import com.archivesManagementSystem.springboot.entity.BirthdayInfo;
import java.util.List;

/**
 * 出生日期信息认定表(BirthdayInfo)表服务接口
 *
 * @author makejava
 * @since 2021-01-27 23:31:38
 */
public interface BirthdayInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BirthdayInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BirthdayInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param birthdayInfo 实例对象
     * @return 实例对象
     */
    BirthdayInfo insert(BirthdayInfo birthdayInfo);

    /**
     * 修改数据
     *
     * @param birthdayInfo 实例对象
     * @return 实例对象
     */
    BirthdayInfo update(BirthdayInfo birthdayInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}