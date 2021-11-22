package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.ListIniCouncil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListIniCouncilRepository extends JpaRepository<ListIniCouncil, Integer> {
    @Query("select l from ListIniCouncil  l where l.caseId=:caseId")
    List<ListIniCouncil> findAllByCaseId(int caseId);

    @Query("select l from ListIniCouncil  l where l.councilId like %:councilId% ")
    List<ListIniCouncil> findAllByCouncilId(String councilId);

    @Query("select l from ListIniCouncil  l where l.jobTitle like %:jobTitle% ")
    List<ListIniCouncil> findAllByJobTitles(String jobTitle);
}
