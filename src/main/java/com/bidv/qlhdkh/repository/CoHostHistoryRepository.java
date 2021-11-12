package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.CoHost;
import com.bidv.qlhdkh.entity.CoHostHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoHostHistoryRepository extends JpaRepository<CoHostHistory,Integer> {
    @Query("select c from CoHostHistory c where  c.caseId =:caseId")
    List<CoHostHistory> findAllByCaseId(Integer caseId);

    @Query("select c from CoHostHistory c join CaseInfoHistory ca on c.caseId = ca.id where ca.ProjectCode like %:projectCode%")
    List<CoHostHistory> getCoHostHist(String  projectCode);
}
