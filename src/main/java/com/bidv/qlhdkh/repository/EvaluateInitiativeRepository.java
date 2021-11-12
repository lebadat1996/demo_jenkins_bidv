package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.EvaluateInitiative;
import com.bidv.qlhdkh.entity.EvaluateTranscript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateInitiativeRepository extends JpaRepository<EvaluateInitiative, String> {
    @Query("select  e from EvaluateInitiative  e where  e.CaseId=:caseId")
    List<EvaluateInitiative> findAllByCaseId(int caseId);
}
