package com.ravi.department.service;

import com.ravi.department.entity.Department;
import com.ravi.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        log.info("Inside save department service");
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {

        log.info("Inside get department service");
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long departmentId) {

        log.info("Inside get department by ID service");
        return departmentRepository.findById(departmentId).get();
    }
}
