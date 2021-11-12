package com.bidv.qlhdkh.service;


import com.bidv.qlhdkh.model.CaseInfoModel;

import java.text.ParseException;

public interface PartyService {
    void saveParty(CaseInfoModel svCaseInfo,int caseId) throws ParseException;
}
