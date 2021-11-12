package com.bidv.qlhdkh.service;


import java.text.ParseException;

import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.LstCoHost;
import com.bidv.qlhdkh.model.LstContentChange;
import com.bidv.qlhdkh.model.LstContentStop;
import com.bidv.qlhdkh.model.LstDutyPayment;
import com.bidv.qlhdkh.model.LstDutyStatus;
import com.bidv.qlhdkh.model.LstEvaluateDuty;
import com.bidv.qlhdkh.model.LstEvaluateInitiative;
import com.bidv.qlhdkh.model.LstHistories;
import com.bidv.qlhdkh.model.LstHost;
import com.bidv.qlhdkh.model.LstInitiativeStatus;
import com.bidv.qlhdkh.model.LstInitiativeTranScript;
import com.bidv.qlhdkh.model.LstListSolDepartment;
import com.bidv.qlhdkh.model.LstPlanPlusTable;
import com.bidv.qlhdkh.model.LstResultUntillChange;

public interface CoHostService {
    LstCoHost getCoHost(Integer caseId);

    LstResultUntillChange getResultUtil(Integer caseId);

    void saveCoHostService(CaseInfoModel svCaseInfo, int caseId) throws ParseException;

    void saveReTranscript(CaseInfoModel caseInfo, int caseId);

    void savePlanPlusTable(CaseInfoModel caseInfo, int caseId);

    LstPlanPlusTable getPlanPlus(int caseId);

    void saveListSolDepartment(CaseInfoModel caseInfo, int caseId);

    LstListSolDepartment getListSolDepartment(int caseId);

    void saveInitiativeTranScript(CaseInfoModel caseInfo, int caseId);

    LstInitiativeTranScript getLstInitiativeTranScript(int caseId);

    void saveInitiativeStatus(CaseInfoModel caseInfo, int caseId);

    LstInitiativeStatus getLstInitiativeStatus(int caseId);

    void saveHistories(CaseInfoModel caseInfo, int caseId);

    LstHistories getHistory(int caseId);

    void saveEvaluateInitiative(CaseInfoModel caseInfo, int caseId);

    LstEvaluateInitiative getLstEvaluateInitiative(int caseId);

    void saveEvaluateDuty(CaseInfoModel caseInfo, int caseId);

    LstEvaluateDuty getLstEvaluateDuty(int caseId);

    void saveEstimateBudget(CaseInfoModel caseInfo, int caseId);

    void saveDutyStatus(CaseInfoModel caseInfo, int caseId);

    LstDutyStatus getDutyStatus(int caseId);

    void saveDutyPayment(CaseInfoModel caseInfo, int caseId);

    LstDutyPayment getLstDutyPayment(int caseId);

    void saveContentStop(CaseInfoModel caseInfo, int caseId);

    LstContentStop getLstContentStop(int caseId);

    int saveHost(CaseInfoModel caseInfo, int caseId);

    LstHost getHost(int caseId);

    int saveCadresInfo(CaseInfoModel caseInfo, int caseId);

    void saveContentChange(CaseInfoModel caseInfo, int caseId, int hostId, int cadresInfo);

    LstContentChange getLstConChange(int caseId);

    void saveResultUtillChange(CaseInfoModel caseInfo, int caseId);

    void saveCoHostHistory(CaseInfoModel caseInfo, int caseId);

    void saveListIniCouncil(CaseInfoModel caseinfo, int caseId);

}
