package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
    List<Party> findAllByCaseId(Integer caseId);


    @Query(value = "select c from Party c join CaseInfo l on c.caseId=l.id where l.caseId = :caseId")
    List<Party> getParty(Integer caseId);
}
