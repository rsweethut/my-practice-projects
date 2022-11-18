package com.ravi.department.controller;

import com.ravi.department.entity.Department;
import com.ravi.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department)
    {
        log.info("Inside controller - Post method to save department");
        return  departmentService.saveDepartment(department);
    }

    @GetMapping("/alldepartments")
    public List<Department> getAllDepartments()
    {
        log.info("Inside Controller - Get All Departments");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/alldepartments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId)
    {
        log.info("Inside Controller - Get  Department by ID");
        return departmentService.getDepartmentById(departmentId);
    }
}
