package com.lzy.mapper;

import com.lzy.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 员工查询
     */
    /*//总数记录
    @Select("select count(*) from emp")
    Long count();

    //分页查询
    @Select("select * from emp limit #{start},#{pageSize}")
    List<Emp> Page(Integer start,Integer pageSize);*/
    List<Emp> Page(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除员工
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void Insert(Emp emp);

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @Select("select  * from  emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 根据id修改员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 登录验证
     * @param emp
     * @return
     */
    @Select("select  * from emp where username = #{username} and password = #{password}")
    Emp getUsernameAndPassword(Emp emp);

    /**
     * 根据部门id删除部门下的员工数据
     * @param deptId
     */
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
