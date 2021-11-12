package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.Plan;
import com.bidv.qlhdkh.entity.ReTranScript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReTranscriptRepository extends JpaRepository<ReTranScript,Integer> {
    List<ReTranScript> findAllByCaseId(Integer caseId);

    @Query(value = "select c from ReTranScript c join CaseInfo l on c.caseId=l.id where l.caseId = :caseId")
    List<ReTranScript> findReTran(Integer caseId);
}
