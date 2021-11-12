package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.CadresInfor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadresInforRepository extends JpaRepository<CadresInfor, Integer> {
    List<CadresInfor> findAllByCaseId(int caseId);

}
