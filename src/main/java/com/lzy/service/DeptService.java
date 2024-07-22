package com.lzy.service;

import com.lzy.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查询所有部门
    List<Dept> list();

    //根据id删除部门
    void delete(Integer id);

    //新增部门
    void Insert(Dept dept);

    //根据id查询
    List<Dept> listById(Integer id);

    //修改部门
    void UpDate(Dept dept);
}
