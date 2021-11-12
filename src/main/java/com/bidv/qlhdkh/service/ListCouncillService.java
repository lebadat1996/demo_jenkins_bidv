package com.bidv.qlhdkh.service;


import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.LstListCouncill;
import com.bidv.qlhdkh.model.LstListIniCouncil;

import java.text.ParseException;

public interface ListCouncillService {
    void saveListCouncill(CaseInfoModel svCaseInfo, int caseId) throws ParseException;

    LstListIniCouncil getIniCouncil(int caseId);

    LstListCouncill getListCouncill(int caseId);

    LstListCouncill findAllByCouncilId(int councilId);
}
