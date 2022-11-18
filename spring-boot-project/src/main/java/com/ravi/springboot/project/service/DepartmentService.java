package com.ravi.springboot.project.service;

import com.ravi.springboot.project.entity.Department;
import com.ravi.springboot.project.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchAllDepts();

    public Department fetchDeptId(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDeptById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    public Department fetchDeptByName(String deptName);
}
