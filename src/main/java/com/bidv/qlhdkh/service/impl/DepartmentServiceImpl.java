package com.bidv.qlhdkh.service.impl;

import com.bidv.qlhdkh.entity.Department;
import com.bidv.qlhdkh.repository.DepartmentRepository;
import com.bidv.qlhdkh.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> getDepartmentByNameOrCode(String codeDepartment, String nameDepartment) {
        List<Department> departments = new ArrayList<>();
        log.info("Find Department By Code and Name");
        try {
            log.info("Start Find Department By Code and Name");
            departments = departmentRepository.listDepartment(codeDepartment, nameDepartment);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Find Department By Code and Name");
        }
        log.info("End Find Department By Code and Name");
        return departments;
    }

    @Override
    public List<Department> getAllDepartmentByBranch(String branch) {
        List<Department> departments = new ArrayList<>();
        log.info("Find Department By Branch");
        try {
            log.info("Start Find Department By Branch");
            departments = departmentRepository.findDepartmentByBrnLevelNotNull();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Find Department By Branch");
        }
        log.info("End Find Department By Branch");
        return departments;
    }

    @Override
    public List<Department> getAllDepartmentByBrnLevel() {
        List<Department> departments = new ArrayList<>();
        log.info("Find Department By BrnLevel");
        try {
            log.info("Start Find Department By BrnLevel");
            departments = departmentRepository.findDepartment();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Find Department By BrnLevel");

        }
        return departments;
    }
}