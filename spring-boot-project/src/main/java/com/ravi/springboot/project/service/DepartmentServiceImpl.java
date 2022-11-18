package com.ravi.springboot.project.service;

import com.ravi.springboot.project.entity.Department;
import com.ravi.springboot.project.error.DepartmentNotFoundException;
import com.ravi.springboot.project.reporsitory.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAllDepts() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDeptId(Long departmentId) throws DepartmentNotFoundException {

        Optional <Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent())
        {
            throw new DepartmentNotFoundException("Department NOt Found - Please    check and provide correct one");
        }
        return department.get();
    }

    @Override
    public void deleteDeptById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {

        Department deptDb = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            deptDb.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            deptDb.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            deptDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(deptDb);
    }

    @Override
    public Department fetchDeptByName(String deptName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(deptName);//findByDepartmentNameIgnoreCase
    }


}
