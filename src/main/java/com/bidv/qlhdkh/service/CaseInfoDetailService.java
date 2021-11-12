package com.bidv.qlhdkh.service;

import com.bidv.qlhdkh.model.CaseInfoModel;

public interface CaseInfoDetailService {
    CaseInfoModel detailCaseInfo(Integer caseId);

    CaseInfoModel detailCaseInfoSystem(Integer caseId);
}
