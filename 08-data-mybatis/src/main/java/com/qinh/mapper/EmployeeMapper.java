package com.qinh.mapper;

import com.qinh.bean.Employee;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-09-14-0:39
 */
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);
}
