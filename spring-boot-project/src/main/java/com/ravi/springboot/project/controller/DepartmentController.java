package com.ravi.springboot.project.controller;

import com.ravi.springboot.project.entity.Department;
import com.ravi.springboot.project.error.DepartmentNotFoundException;
import com.ravi.springboot.project.service.DepartmentService;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vpi")
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService deptService;

    @PostMapping("/createdepts")
    public Department saveDepartment(@RequestBody Department department)
    {
        LOGGER.info("In Department Save");
        return deptService.saveDepartment(department);
    }

    @GetMapping("/fetchalldepts")
    public List<Department> fetchAllDepts()
    {
        LOGGER.info("Fetching all Departments");
        return deptService.fetchAllDepts();
    }

    @GetMapping("/fetchalldepts/{id}")
    public Department fetchDeptId(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Fetching a Department");
        return deptService.fetchDeptId(departmentId);
    }

    @GetMapping("/fetchalldepts/deptname/{name}")
    public Department fetchDeptByName(@PathVariable("name") String deptName)
    {
        LOGGER.info("Fetching Department By Name");
        return deptService.fetchDeptByName(deptName);
    }

    @DeleteMapping("/fetchalldepts/{id}")
    public String deleteDeptById(@PathVariable("id") Long departmentId)
    {
        LOGGER.info("Deleting Record "+departmentId);
         deptService.deleteDeptById(departmentId);
         return "Department ID "+departmentId+" is deleted successfully !!! ";
    }
    @PutMapping("/fetchalldepts/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,
                                           @RequestBody Department department)
    {
        return deptService.updateDepartmentById(departmentId,department);
    }
}
