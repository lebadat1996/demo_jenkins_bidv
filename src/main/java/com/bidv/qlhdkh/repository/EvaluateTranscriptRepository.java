package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.EvaluateTranscript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateTranscriptRepository extends JpaRepository<EvaluateTranscript, String> {
    @Query("select e from EvaluateTranscript e where e.CaseId = :caseId")
    List<EvaluateTranscript> getAllByCaseIdss(Integer caseId);
}
