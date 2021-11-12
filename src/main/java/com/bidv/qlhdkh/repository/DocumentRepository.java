package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
    @Query(value = "select d from Document  d where d.caseId=:caseId")
    List<Document> getLstDoc(int caseId);
}
