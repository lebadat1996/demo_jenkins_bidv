package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.EvaluateTranscript;
import com.bidv.qlhdkh.entity.Histories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriesRepository extends JpaRepository<Histories, String> {
    @Query("select h from Histories  h where  h.caseId=:caseId")
    List<Histories> findAllByCaseId(int caseId);
}
