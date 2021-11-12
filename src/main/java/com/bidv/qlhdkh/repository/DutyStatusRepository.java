package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.DutyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DutyStatusRepository extends JpaRepository<DutyStatus, Integer> {
    @Query("select d from DutyStatus  d where d.CaseId=:caseId")
    List<DutyStatus> findAllByCaseId(int caseId);
}
