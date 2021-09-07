package com.qinh.controller;

import com.qinh.dao.DepartmentDao;
import com.qinh.dao.EmployeeDao;
import com.qinh.entities.Department;
import com.qinh.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Ids;

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

    /**
     * 员工添加
     * SpringMVC自动将请求参数和入参对象得属性进行一一绑定，要求请求参数得名字和javaBean入参得对象里面得属性名一一对应
     *
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println("保存得员工信息: " + employee);
        employeeDao.save(employee);
        /*
        来到员工列表页面
        redirect: 表示重定向到一个地址， /代表当前项目路径
        forward: 表示转发到一个地址
         */
        return "redirect:/emps";
    }

    /**
     * 来到修改页面，查出当前员工，在页面回显
     *
     * @return
     */
    @GetMapping("/emp/{id}")
    public String eoEditPage(@PathVariable Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一得页面)
        return "emp/add";
    }

    /**
     * 员工修改：需要提交员工id
     *
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改得员工数据: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @PostMapping("/emp/{id}")
    //@RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable Integer id){
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
