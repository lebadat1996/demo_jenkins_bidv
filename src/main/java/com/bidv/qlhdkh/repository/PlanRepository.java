package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {
    List<Plan> findAllByCaseId(Integer caseId);

    @Query(value = "select c from Plan c join CaseInfo l on c.caseId=l.id where l.caseId = :caseId")
    List<Plan> getPlans(Integer caseId);
}
