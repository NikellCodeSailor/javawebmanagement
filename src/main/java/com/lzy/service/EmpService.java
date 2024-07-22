package com.lzy.service;

import com.lzy.pojo.Emp;
import com.lzy.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    //查询员工列表
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    //批量删除员工
    void delete(List<Integer> ids);

    //新增员工
    void Insert(Emp emp);

    //根据id查询员工
    Emp getById(Integer id);

    //根据id修改员工
    void update(Emp emp);

    //登录验证
    Emp login(Emp emp);

}
