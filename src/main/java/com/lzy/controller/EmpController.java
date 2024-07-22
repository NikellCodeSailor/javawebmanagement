package com.lzy.controller;

import com.lzy.anno.Log;
import com.lzy.pojo.Emp;
import com.lzy.pojo.PageBean;
import com.lzy.pojo.Result;
import com.lzy.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 查询列表信息
     */
    @GetMapping
    public Result Page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {

        log.info("查询,参数:{}，{}，{}，{}，{}", page, pageSize, name, gender, begin, end);

        PageBean pagebean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pagebean);
    }

    /**
     * 批量删除
     */
    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作, ids:{}",ids);

        empService.delete(ids);
        return Result.success();
    }

    /**
     * 新增员工
     */
    @Log
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增，参数：{}",emp);

        empService.Insert(emp);
        return Result.success();
    }

    /**
     * 根据id查询员工
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("查询，参数：{}",id);

        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /**
     * 根据id修改员工
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改，参数，{}",emp);

        empService.update(emp);
        return Result.success();
    }
}
