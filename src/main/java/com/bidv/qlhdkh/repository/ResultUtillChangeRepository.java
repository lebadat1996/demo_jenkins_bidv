package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.ResultUtillChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultUtillChangeRepository extends JpaRepository<ResultUtillChange, Integer> {
    List<ResultUtillChange> findAllByCaseId(int caseId);
}
