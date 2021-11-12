package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.ListAcceprtCouncil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListAcceptCouncilRepository extends JpaRepository<ListAcceprtCouncil,Integer> {
    @Query("select ac from ListAcceprtCouncil ac where ac.caseId=:caseId")
    List<ListAcceprtCouncil> findAllByCaseId(int caseId);
}
