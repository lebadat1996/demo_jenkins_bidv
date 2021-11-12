package com.bidv.qlhdkh.service;


import java.text.ParseException;

import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.LstAcceptTranscript;
import com.bidv.qlhdkh.model.LstCadresInfor;
import com.bidv.qlhdkh.model.LstEstimateBudget;
import com.bidv.qlhdkh.model.LstParty;
import com.bidv.qlhdkh.model.LstPlan;
import com.bidv.qlhdkh.model.LstReTranscript;

public interface PlanService {
    void savePlan(CaseInfoModel svCaseInfo,int caseId) throws ParseException;

    LstPlan getPlan(Integer caseId);

    LstReTranscript getReTran(Integer caseId);

    LstAcceptTranscript getAcceptTran(Integer caseId);

    LstParty getParty(Integer caseId);

    LstCadresInfor getCadresInfors(Integer caseId);

    LstEstimateBudget getEstimateBudgets(Integer caseId);
}
