package com.bidv.qlhdkh.service;


import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.LstListAcceprtCouncil;

public interface ListAcceptCouncilService {
    void saveListAcceptCouncilS(CaseInfoModel svCaseInfo,int caseId);

    LstListAcceprtCouncil getAcceptCouncil(int caseId);
}
