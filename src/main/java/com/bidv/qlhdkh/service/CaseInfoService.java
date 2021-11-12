package com.bidv.qlhdkh.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bidv.qlhdkh.model.CaseInfoModel;

public interface CaseInfoService {
    void saveCase(CaseInfoModel caseInfo) throws ParseException;

    List<CaseInfoModel> getCaseInfoByStatus(String status);

    List<CaseInfoModel> searchCaseInfo(String userId, String status, String projectName, String projectcode, String startDate, String endDate, String departmentCode, String branch, String caseType) throws ParseException;

    CaseInfoModel detail(String projectCode);

    boolean checkCaseInfo(String projectCode, String caseType,int caseId);

    List<CaseInfoModel> getCaseInfo(String status, String projectName, String projectcode, String startDate,String endDate, String departmentCode, String branch, String caseType, Pageable pageable) throws ParseException;

    List<CaseInfoModel> searchCaseInfoCTL(String userId, String status, String projectName, String projectcode, String startDate, String endDate, String departmentCode, String branch, String caseType) throws ParseException;
    List<CaseInfoModel> searchCaseInfosReport(String projectName,String departmentCode,String projectCode, String status,String dateCurrent) throws ParseException;

    List<CaseInfoModel> searchCaseInfosReportSK(String projectName,String departmentCode,String projectCode, String status,String dateCurrent) throws ParseException;

    List<CaseInfoModel> searchCaseInfosReportNT(String projectName,String departmentCode,String projectCode, String status,String dateCurrent) throws ParseException;

    List<CaseInfoModel> searchCaseInfosReportNTSK(String projectName,String departmentCode,String projectCode, String status,String dateCurrent) throws ParseException;

}
