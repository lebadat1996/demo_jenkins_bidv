package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.constants.Constants;
import com.bidv.qlhdkh.entity.CaseInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CaseInfoRepository extends JpaRepository<CaseInfo, Integer> {
    @Query("select c from CaseInfo c WHERE (:status is null or c.Status = :status)")
    List<CaseInfo> getCaseInfos(String status);

    @Query("select c from CaseInfo c  WHERE (:status is null or c.Status = :status) and" +
            " (:projectName is null or lower(c.ProjectName) like lower(concat('%', :projectName,'%')) ) and " +
            "(:projectcode is null or  lower(c.ProjectCode) like lower(concat('%', :projectcode,'%')) ) and" +
            " (:startDate is null or c.CreatedDate >= :startDate)  and  (:endDate is null or c.CreatedDate <= :endDate) and" +
            " (:departmentCode is null or c.DeparmentCode like %:departmentCode%) and " +
            "(:branch is null or  c.Bds = :branch) and " +
            "(:caseType is null or  c.CaseType = :caseType)  order by c.caseId desc")
    List<CaseInfo> searchCase(String status, String projectName, String projectcode, Date startDate, Date endDate, String departmentCode, String branch, String caseType, Pageable pageable);


    @Query("SELECT c from  CaseInfo c where c.ProjectCode = :projectCode")
    List<CaseInfo> checkCaseInfo(String projectCode);


    List<CaseInfo> findAllByCaseId(Integer caseId);

    @Query(value = "select c from CaseInfo c WHERE  c.ProjectCode = :projectCode and (c.StatusRemuneration = :status or c.StatusRemuneration = :statusc)")
    List<CaseInfo> listCaseCtl(String projectCode, String status, String statusc);

    @Query("select c from CaseInfo c join ListMember l on l.caseId=c.id WHERE(:statusCTL is null or c.Status = :statusCTL) and (:status is null or c.Status = :status) and" +
            " (:projectName is null or c.ProjectName =:projectName ) and " +
            "(:projectcode is null or c.ProjectCode = :projectcode) and" +
            " ((:startDate is null or c.StartDate >= :startDate) and (:endDate is null or c.EndDate <= :endDate)) and" +
            " (:departmentCode is null or c.DeparmentCode = :departmentCode) and " +
            "(:branch is null or  c.Branch = :branch) and " +
            "(:caseType is null or  c.CaseType = :caseType) and " +
            "(:username is null or  l.userName = :username)")
    List<CaseInfo> searchCase(String statusCTL, String status, String projectName, String projectcode, Date startDate, Date endDate, String departmentCode, String branch, String caseType, String username);


    @Query(value = "select c from CaseInfo c  where c.caseId = :caseId")
    List<CaseInfo> caseInfo(int caseId);

}
