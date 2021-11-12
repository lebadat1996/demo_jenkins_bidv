package com.bidv.qlhdkh.repository;


import com.bidv.qlhdkh.entity.ContentStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ContentStopRepository extends JpaRepository<ContentStop, Integer> {
    @Query("select c from ContentStop c where  c.CaseId =:caseId")
    List<ContentStop> getAll(int caseId);

}
