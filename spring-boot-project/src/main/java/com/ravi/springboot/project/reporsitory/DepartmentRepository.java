package com.ravi.springboot.project.reporsitory;

import com.ravi.springboot.project.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentName(String deptName);

    public Department findByDepartmentNameIgnoreCase(String deptName);
}
