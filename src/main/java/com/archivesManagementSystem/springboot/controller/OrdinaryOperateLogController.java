package com.archivesManagementSystem.springboot.controller;

import com.archivesManagementSystem.springboot.entity.EmployeeInfo;
import com.archivesManagementSystem.springboot.entity.OrdinaryOperateLog;
import com.archivesManagementSystem.springboot.service.OrdinaryOperateLogService;
import com.archivesManagementSystem.springboot.util.GeneralResult;
import com.archivesManagementSystem.springboot.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.assertj.core.internal.cglib.asm.$Opcodes;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Vector;

/**
 * 日常操作记录表，主要用于记录增加、修改、删除认定表的更新前和更新后每一个字段内容。不做太详细的记录（因为没给钱）(OrdinaryOperateLog)表控制层
 *
 * @author makejava
 * @since 2021-01-27 23:32:33
 */
@CrossOrigin
@RestController
@RequestMapping("ordinaryOperateLog")
public class OrdinaryOperateLogController {
    /**
     * 服务对象
     */
    @Resource
    private OrdinaryOperateLogService ordinaryOperateLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Result selectOne(Integer id) {
        Result res = new GeneralResult(true);
        if(this.ordinaryOperateLogService.queryById(id)!=null){
            res.setData(this.ordinaryOperateLogService.queryById(id));
            res.setMsg("查询成功");
        }else{
            res.setMsg("没有找到对应的值");
            res.setSuccess(false);
        }
        return  res;
    }

    /**
     * 单条插入员工信息
     *
     * @param ordinaryOperateLog
     * @return 实体对象，若为空，则插入不成功
     */
    @PostMapping("insert")
    @ResponseBody
    public int insert(OrdinaryOperateLog ordinaryOperateLog){
        return  this.ordinaryOperateLogService.insert(ordinaryOperateLog);
    }

    /**
     * 根据主键删除数据
     * @param id
     * @return boolean
     */
    @PostMapping("delete")
    @ResponseBody
    public Boolean delete(int id){
        return this.ordinaryOperateLogService.deleteById(id);
    }

    /**
     * 根据某个字段查询所有的实体集合
     * @param ordinaryOperateLog
     * @return List集合
     */

    @GetMapping("selectAll")
    public List<OrdinaryOperateLog> selectAll(OrdinaryOperateLog ordinaryOperateLog){
        return  this.ordinaryOperateLogService.queryAll(ordinaryOperateLog);
    }

    /**
     * 查询全部数据分页展示
     * @return
     * @throws Exception
     */
    @PostMapping("selectAllForPage")
    @ResponseBody
    public PageInfo selectAllForPage(@RequestBody  OrdinaryOperateLog ordinaryOperateLog) throws Exception {
        PageHelper.startPage(ordinaryOperateLog.getStart(),ordinaryOperateLog.getSize());
        List<OrdinaryOperateLog> ordinaryOperateLogList = new Vector<OrdinaryOperateLog>();
        List<OrdinaryOperateLog> ordinaryOperateLogList1=new Vector<OrdinaryOperateLog>();
        OrdinaryOperateLog ordinaryOperateLog1 = new OrdinaryOperateLog();
        OrdinaryOperateLog ordinaryOperateLog2 = new OrdinaryOperateLog();
        if(ordinaryOperateLog.getEmployeeId()==""){
            ordinaryOperateLog.setEmployeeId(null);
        }
        if(ordinaryOperateLog.getEmployeeName()==""){
            ordinaryOperateLog.setEmployeeName(null);
        }
        if ((ordinaryOperateLog.getEmployeeName() != null) && (ordinaryOperateLog.getEmployeeId() == null)) {
            String[] employeeNameArray = ordinaryOperateLog.getEmployeeName().split(" ");
            for (int i = 0; i < employeeNameArray.length; i++) {
                ordinaryOperateLog2.setEmployeeName(employeeNameArray[i]);
                ordinaryOperateLogList1 = this.ordinaryOperateLogService.queryAll(ordinaryOperateLog2);
                if (ordinaryOperateLogList1.size() != 0) {
                    ordinaryOperateLogList.addAll(ordinaryOperateLogList1);
                }
            }
            PageInfo<OrdinaryOperateLog> page = new PageInfo<>(ordinaryOperateLogList);
            return page;
        } else if ((ordinaryOperateLog.getEmployeeName() == null) && ordinaryOperateLog.getEmployeeId() != null) {
            String[] employeeIdArray = ordinaryOperateLog.getEmployeeId().split(" ");
            for (int i = 0; i < employeeIdArray.length; i++) {
                System.out.println("员工Id" + employeeIdArray[i]);
                ordinaryOperateLog2.setEmployeeId(employeeIdArray[i]);
                ordinaryOperateLogList1 = this.ordinaryOperateLogService.queryAll(ordinaryOperateLog2);
                if (ordinaryOperateLogList1.size() != 0) {
                    ordinaryOperateLogList.addAll(ordinaryOperateLogList1);
                }
            }
            PageInfo<OrdinaryOperateLog> page = new PageInfo<>(ordinaryOperateLogList);
            return page;
        } else if ((ordinaryOperateLog.getEmployeeName() != null) && (ordinaryOperateLog.getEmployeeId() != null)) {
            String[] employeeNameArray = ordinaryOperateLog.getEmployeeName().split(" ");
            String[] employeeIdArray = ordinaryOperateLog.getEmployeeId().split(" ");
            if (employeeIdArray.length > 1 || employeeNameArray.length > 1) {
                //为空。两个都有且超过1，太多了，返回为空值
            } else if (employeeIdArray.length == 1 && employeeNameArray.length == 1) {
                //两个都为一个值时。精准查询
                ordinaryOperateLog2.setEmployeeId(employeeIdArray[0]);
                ordinaryOperateLog2.setEmployeeName(employeeNameArray[0]);
                ordinaryOperateLogList = this.ordinaryOperateLogService.queryAll(ordinaryOperateLog2);
            }
            PageInfo<OrdinaryOperateLog> page = new PageInfo<>(ordinaryOperateLogList);
            return  page;
        } else {
            List<OrdinaryOperateLog> cs = this.ordinaryOperateLogService.queryAll(ordinaryOperateLog);
            PageInfo<OrdinaryOperateLog> page = new PageInfo<>(cs);
            return page;
        }
    }

    /**
     * 根据实体类做更新
     * @param ordinaryOperateLog
     * @return 实体对象
     */
    @PostMapping("update")
    @ResponseBody
    public  OrdinaryOperateLog update(OrdinaryOperateLog ordinaryOperateLog){
        return this.ordinaryOperateLogService.update(ordinaryOperateLog);
    }

}