package com.bidv.qlhdkh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bidv.qlhdkh.entity.EvaluateDutys;

@Repository
public interface EvaluateDutyRepository extends JpaRepository<EvaluateDutys, Integer> {
    @Query(value = "select e from EvaluateDutys e where e.CaseId=:caseId")
    List<EvaluateDutys> findAllByCaseId(int caseId);
}
