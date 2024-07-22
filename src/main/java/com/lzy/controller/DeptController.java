package com.lzy.controller;

import com.lzy.anno.Log;
import com.lzy.pojo.Dept;
import com.lzy.pojo.Result;
import com.lzy.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    /**
     * 查询所有部门
     */
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        List<Dept> listDept = deptService.list();

        log.info("查询所有数据");
        return Result.success(listDept);
    }

    /**
     * 删除部门
     */
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        deptService.delete(id);

        log.info("根据id删除部门:{}",id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        deptService.Insert(dept);

        log.info("新增部门：{}",dept);
        return Result.success();
    }

    /**
     * 根据id查询
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        List<Dept> listById = deptService.listById(id);

        log.info("根据id查询：{}",id);
        return Result.success(listById);
    }

    /**
     * 修改部门
     */
    @Log
    @PutMapping
    public Result UpDate(@RequestBody Dept dept){
        deptService.UpDate(dept);

        log.info("修改部门：{},{}",dept);
        return Result.success();
    }

}
