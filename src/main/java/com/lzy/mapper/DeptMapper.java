package com.lzy.mapper;

import com.lzy.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门
     * @return
     */
    @Select("select * from dept")
    List<Dept> SelectDept();

    /**
     * 根据id删除部门
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) value (#{name},#{createTime},#{updateTime})")
    void Insert(Dept dept);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from dept where id = #{id}")
    List<Dept> SelectById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    @Update("update dept set name = #{name},create_time = #{createTime},update_time = #{updateTime} where id = #{id}")
    void UpDate(Dept dept);
}
