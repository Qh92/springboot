package com.qinh.controller;

import com.qinh.dao.DepartmentDao;
import com.qinh.dao.EmployeeDao;
import com.qinh.entities.Department;
import com.qinh.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-09-06-22:44
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 查询所有员工返回列表页面
     *
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);

        // thymeleaf默认就会拼串
        // classpath:/templates/xxx.html
        return "emp/list";
    }

    /**
     * 来到员工添加页面
     *
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //添加页面，查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("depts",departments);

        return "emp/add";
    }
}
