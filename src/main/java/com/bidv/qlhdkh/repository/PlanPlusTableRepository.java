package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.Plan;
import com.bidv.qlhdkh.entity.PlanPlusTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanPlusTableRepository extends JpaRepository<PlanPlusTable, Integer> {
    List<PlanPlusTable> findAllByCaseId(int caseId);
}
