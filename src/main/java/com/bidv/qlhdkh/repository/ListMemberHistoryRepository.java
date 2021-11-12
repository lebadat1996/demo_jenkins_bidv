package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.CaseInfoHistory;
import com.bidv.qlhdkh.entity.ListMemberHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListMemberHistoryRepository extends JpaRepository<ListMemberHistory, Integer> {
    @Query("select l from ListMemberHistory l join CaseInfoHistory c on c.id = l.caseId")
    List<ListMemberHistory> listMemBerHis();

    @Query(value = "select l from ListMemberHistory l where l.caseId=:caseId")
    List<ListMemberHistory> findAllByCaseId(int caseId);

    @Query(value = "select l from ListMemberHistory l join CaseInfoHistory c on l.caseId = c.id where c.ProjectCode like %:projectCode%")
    List<ListMemberHistory> getListMember(String projectCode);

    @Query(value = "select l from ListMemberHistory l join CaseInfoHistory c on l.caseId = c.id where c.ProjectCode like %:projectCode% and l.userName like %:userName%")
    List<ListMemberHistory> getListMembers(String projectCode, String userName);
}
