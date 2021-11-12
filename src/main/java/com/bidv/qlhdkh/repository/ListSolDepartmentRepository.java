package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.ListSolDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListSolDepartmentRepository extends JpaRepository<ListSolDepartment,Integer> {
    List<ListSolDepartment> findAllByCaseId(int caseId);
}
