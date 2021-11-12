package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.EstimateBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstimateBudgetRepository extends JpaRepository<EstimateBudget, Integer> {
    @Query("select e from EstimateBudget e where e.caseId=:caseId")
    List<EstimateBudget> findAllByCaseId(int caseId);

    @Query(value = "select c from EstimateBudget c join CaseInfo l on c.caseId=l.id where l.caseId = :caseId order by c.id asc")
    List<EstimateBudget> getEstimateBudgets(int caseId);
}
