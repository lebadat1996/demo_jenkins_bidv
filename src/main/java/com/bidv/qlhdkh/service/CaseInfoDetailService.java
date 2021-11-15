package com.bidv.qlhdkh.service;

import com.bidv.qlhdkh.model.CaseInfoModel;

import java.util.List;

public interface CaseInfoDetailService {
    CaseInfoModel detailCaseInfo(Integer caseId);

    CaseInfoModel detailCaseInfoSystem(Integer caseId);

    List<CaseInfoModel> ListCaseInfoSystem();
}
