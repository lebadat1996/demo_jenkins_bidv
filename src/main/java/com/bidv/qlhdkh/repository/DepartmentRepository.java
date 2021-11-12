package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    @Query("select d from Department d where (:codeDepartment is null or d.codeDepartment like %:codeDepartment%) and (:nameDepartment is null or d.nameDepartment like %:nameDepartment%)")
    List<Department> listDepartment(String codeDepartment, String nameDepartment);

    @Query("select d from Department d where (d.brnLevel is not null and d.codeBdsParent is not null and d.codeDepartment is not null and d.nameDepartment is not null) ")
    List<Department> findDepartmentByBrnLevelNotNull();

    @Query("select d from Department d where d.brnLevel = 'CN' ")
    List<Department> findDepartment();
}
