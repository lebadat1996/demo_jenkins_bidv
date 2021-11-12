package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostRepository extends JpaRepository<Host, Integer> {
    List<Host> findAllByCaseId(int caseId);
}
