package com.lzy.service.Impl;

import com.lzy.mapper.DeptMapper;
import com.lzy.mapper.EmpMapper;
import com.lzy.pojo.Dept;
import com.lzy.pojo.DeptLog;
import com.lzy.service.DeptLogService;
import com.lzy.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.SelectDept();
    }

    /**
     *@Transactional --->默认只对RuntimeException(运行时异常)才会回滚事务
     *rollbackFor属性用来指定什么异常才进行回滚
     */
    @Transactional(rollbackFor = Exception.class)//spring事务管理
    @Override
    public void delete(Integer id) {
        try {
            deptMapper.deleteById(id);

            empMapper.deleteByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此时解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void Insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.Insert(dept);
    }

    @Override
    public List<Dept> listById(Integer id) {
        return deptMapper.SelectById(id);
    }

    @Override
    public void UpDate(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.UpDate(dept);
    }
}
