package com.bidv.qlhdkh.service;

import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.LstEvaluateTranscript;


import java.text.ParseException;

public interface EvaluateTranscriptService {
    void saveListEvaluateTranscript(CaseInfoModel svCaseInfo,int caseId) throws ParseException;

    LstEvaluateTranscript getLstEvaluateTran(int caseId);
}
