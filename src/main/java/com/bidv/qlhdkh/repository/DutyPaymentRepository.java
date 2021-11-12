package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.DutyPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DutyPaymentRepository extends JpaRepository<DutyPayment,Integer> {
    @Query("select c from DutyPayment  c where  c.CaseId= :caseId")
    List<DutyPayment> findAllByCaseId(int caseId);
}
