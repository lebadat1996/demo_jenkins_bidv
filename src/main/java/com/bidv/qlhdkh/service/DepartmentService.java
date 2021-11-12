package com.bidv.qlhdkh.service;

import com.bidv.qlhdkh.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartment();

    List<Department> getDepartmentByNameOrCode(String codeDepartment, String nameDepartment);

    List<Department> getAllDepartmentByBranch(String branch);

    List<Department> getAllDepartmentByBrnLevel();
}
