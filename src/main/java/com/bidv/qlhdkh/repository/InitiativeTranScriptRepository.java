package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.InitiativeTranScript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InitiativeTranScriptRepository extends JpaRepository<InitiativeTranScript, String> {
    @Query("select i from InitiativeTranScript  i where i.caseId=:caseId")
    List<InitiativeTranScript> findAllByCaseId(int caseId);
}
