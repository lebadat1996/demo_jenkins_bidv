package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.CaseInfo;
import com.bidv.qlhdkh.entity.CaseInfoHistory;
import com.bidv.qlhdkh.entity.ListMemberHistory;
import com.bidv.qlhdkh.model.InfoEmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface CaseInfoHistoryRepository extends JpaRepository<CaseInfoHistory, Integer> {
    @Query("select c from CaseInfoHistory c where  c.ProjectCode LIKE %:projectCode%")
    List<CaseInfoHistory> getCaseInfo(String projectCode);


    @Query("select c from CaseInfoHistory c JOIN ListMemberHistory L ON L.caseId = c.id " +
            " WHERE (:status is null or c.Status LIKE %:status%) and" +
            " (:projectName is null or lower(c.ProjectName) like lower(concat('%', :projectName,'%')) ) and " +
            "(:projectcode is null or lower(c.ProjectCode) like lower(concat('%', :projectcode,'%')) ) and" +
            " ((:startDate is null or c.StartDate >= :startDate) and (:endDate is null or c.EndDate <= :endDate)) and" +
            " (:departmentCode is null or c.DeparmentCode = :departmentCode) and " +
            "(:branch is null or  c.Branch = :branch) and " +
            "(:caseType is null or  c.CaseType like %:caseType%) and (L.userId like %:userId%) ")
    List<CaseInfoHistory> searchCase(String status, String projectName, String projectcode, Date startDate, Date endDate, String departmentCode, String branch, String caseType, String userId);

    @Query("select c from CaseInfoHistory  c where c.caseId =:caseId")
    List<CaseInfoHistory> findAllByCaseId(int caseId);

    @Query(value = "select c.EndDate as EndDate ,c.Status as Status,l.email as email,l.userName as userName,l.userId as userId,l.departmentCode as departmentCode  from CaseInfoHistory c" +
            " inner join ListMemberHistory l on c.id =l.caseId" +
            " where l.email is not null and c.Status is not null" +
            " and c.EndDate is not null and l.userId is not null")
    List<InfoEmailModel.infoEmail> infoEmail();

    @Query(value = "select c  from CaseInfoHistory c  join ListMemberHistory l on l.caseId = c.id " +
            "where l.email is not null " +
            "and c.EndDate is not null and" +
            " (c.Status ='NVHT02' or c.Status ='NVCS02')")
    List<CaseInfoHistory> caseInfo();

    @Query(value = "select c  from CaseInfoHistory c  join ListMemberHistory l on l.caseId = c.id " +
            "where l.email is not null " +
            "and c.EndDate is not null and" +
            " (c.Status ='NVCS08' or c.Status ='NVHT08')")
    List<CaseInfoHistory> caseInfos();


    @Query(value = "select c  from CaseInfoHistory c  join ListMemberHistory l on l.caseId = c.id " +
            "where (c.Status ='SKCS02' or c.Status ='SKHT02') and c.RecognitionDate IS NOT NULL ")
    List<CaseInfoHistory> caseInfosSCN();

    @Query(value = "select c  from CaseInfoHistory c  join ListMemberHistory l on l.caseId = c.id " +
            "where c.InterestSub is not null and c.InterestSub like %:interestSub% and " +
            " (c.StatusRemuneration is null)")
    List<CaseInfoHistory> caseInfosCTL(String interestSub);

    @Query("select c from CaseInfoHistory c join ListMemberHistory l on l.caseId=c.id WHERE (:status is null or c.Status = :status) and" +
            " (:projectName is null or lower(c.ProjectName) like lower(concat('%', :projectName,'%')) ) and " +
            "(:projectcode is null or lower(c.ProjectCode) like lower(concat('%', :projectcode,'%')) ) and" +
            " ((:startDate is null or c.StartDate >= :startDate) and (:endDate is null or c.EndDate <= :endDate)) and" +
            " (:departmentCode is null or c.DeparmentCode = :departmentCode) and " +
            "(:branch is null or  c.Branch = :branch) and " +
            "(:caseType is null or  c.CaseType like %:caseType%) and " +
            "(:userId is null or l.userId like %:userId%) and c.StatusRemuneration is null")
    List<CaseInfoHistory> searchCases(String status, String projectName, String projectcode, Date startDate, Date endDate, String departmentCode, String branch, String caseType, String userId);


    @Query(value = "select c from CaseInfoHistory  c where (:departmentCode is null or c.DeparmentCode like %:departmentCode%) and " +
            "(:projectName is null or lower(c.ProjectName) like lower(concat('%', :projectName,'%')) ) and " +
            "(:projectcode is null or lower(c.ProjectCode) like lower(concat('%', :projectcode,'%')) )" +
            "and (:status is null or c.Status = :status)" +
            "and  (c.EndDate >= :fromDate and c.EndDate <= :toDate)")
    List<CaseInfoHistory> findCaseInfoHistory(String projectName,String departmentCode,String projectcode, String status, Timestamp fromDate, Timestamp toDate);


    @Query(value = "select c from CaseInfoHistory  c where (:departmentCode is null or c.DeparmentCode like %:departmentCode%) and " +
            "(:projectName is null or lower(c.ProjectName) like lower(concat('%', :projectName,'%')) ) and " +
            "(:projectcode is null or lower(c.ProjectCode) like lower(concat('%', :projectcode,'%')) )" +
            "and (:status is null or c.Status = :status)" +
            "and  (c.RecognitionDate >= :fromDate and c.RecognitionDate <= :toDate)")
    List<CaseInfoHistory> findCaseInfoHistorySK(String projectName,String departmentCode,String projectcode, String status, Timestamp fromDate, Timestamp toDate);

    @Query(value = "select c from CaseInfoHistory  c where (:departmentCode is null or c.DeparmentCode like %:departmentCode%) and " +
            "(:projectName is null or lower(c.ProjectName) like lower(concat('%', :projectName,'%')) ) and " +
            "(:projectcode is null or lower(c.ProjectCode) like lower(concat('%', :projectcode,'%')) )" +
            "and (:status is null or c.Status = :status)")
    List<CaseInfoHistory> findCaseInfoHistoryNT(String projectName,String departmentCode,String projectcode, String status);


}
