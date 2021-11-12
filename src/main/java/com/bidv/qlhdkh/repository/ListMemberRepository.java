package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.ListMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListMemberRepository extends JpaRepository<ListMember, Integer> {
    @Query("select L from ListMember L join CaseInfo  C ON L.caseId = C.id WHERE C.ProjectCode like %:projectCode%")
    List<ListMember> findMemberCaseInfosss(String projectCode);

    List<ListMember> findAllByCaseId(Integer id);

    @Query("select m from ListMember m where m.userName like %:username%")
    List<ListMember> findAllByUserName(String username);

    @Query("select L from ListMember L join CaseInfo  C ON L.caseId = C.id WHERE C.caseId = :caseId")
    List<ListMember> findMember(Integer caseId);
}
