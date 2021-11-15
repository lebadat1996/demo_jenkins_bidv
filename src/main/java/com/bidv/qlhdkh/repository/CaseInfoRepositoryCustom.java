package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.CaseInfo;
import com.bidv.qlhdkh.model.CaseInfoModel;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface CaseInfoRepositoryCustom {
    List<CaseInfoModel> getListCaseInfo(String status, String projectName, String projectCode, String startDate, String endDate, String departmentCode, String branch, String caseType, String topicCategory, String fieldType,String projectType) throws ParseException;
}
