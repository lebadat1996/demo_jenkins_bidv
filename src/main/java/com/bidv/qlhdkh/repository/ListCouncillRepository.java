package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.ListCouncill;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListCouncillRepository extends JpaRepository<ListCouncill, Integer> {
    List<ListCouncill> findAllByCaseId(Integer caseId);

    @Query(value = "select lc from ListCouncill  lc where lc.councilId = :councilId" )
    List<ListCouncill> findAllByCouncilId(Integer councilId);
}
