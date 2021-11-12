package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.AcceptTranscript;
import com.bidv.qlhdkh.entity.CaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcceptTranscriptRepository extends JpaRepository<AcceptTranscript, Integer> {
    @Query(value = "select c from AcceptTranscript c where c.CaseId=:caseId")
    List<AcceptTranscript> findAllByCaseId(Integer caseId);
}
