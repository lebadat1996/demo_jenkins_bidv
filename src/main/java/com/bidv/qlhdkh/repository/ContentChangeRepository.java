package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.ContentChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentChangeRepository extends JpaRepository<ContentChange, Integer> {
    @Query("select c from ContentChange  c where  c.CaseId=:caseId")
    List<ContentChange> findAllByCaseId(int caseId);
}
