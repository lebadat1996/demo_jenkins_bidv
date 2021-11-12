package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InfoFileUploadRepository extends JpaRepository<Document, Integer> {
    @Query("select d from Document d where d.objectId like %:objectId%")
    List<Document> getDoc(String objectId);

    @Query("select d from Document d where d.caseId = :caseId")
    List<Document> checkDocs(int caseId);
}
