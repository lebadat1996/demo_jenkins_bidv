package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.CoHost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoHostRepository extends JpaRepository<CoHost,Integer> {
    List<CoHost> findAllByCaseId(Integer caseId);
}
