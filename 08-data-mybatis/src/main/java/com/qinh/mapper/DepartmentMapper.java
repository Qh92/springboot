package com.qinh.mapper;

import com.qinh.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * 指定这是一个操作数据库的mapper
 *
 * @author Qh
 * @version 1.0
 * @date 2021-09-14-0:05
 */
@Repository
//@Mapper
public interface DepartmentMapper {


    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    int deleteDeptById(Integer id);

    /**
     * 可以返回主键值
     *
     * @param department
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set department_name = #{departmentName} where id = #{id}")
    int updateDept(Department department);

}
