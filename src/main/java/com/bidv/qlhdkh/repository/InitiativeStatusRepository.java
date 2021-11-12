package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.model.LstInitiativeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bidv.qlhdkh.entity.InitiativeStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InitiativeStatusRepository extends JpaRepository<InitiativeStatus,Integer> {
    List<InitiativeStatus> findAllByCaseId(int caseId);

}
