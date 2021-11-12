package com.bidv.qlhdkh.service;


import java.text.ParseException;

import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.LstCoHost;
import com.bidv.qlhdkh.model.LstListMember;

public interface ListMemberService {
    void saveListMember(CaseInfoModel svCaseInfo, int caseId) throws ParseException;

    LstListMember searchListMember(String projectCode);



    void saveListMemberHistory(CaseInfoModel caseInfoModel,int caseId);

    LstCoHost searchListCoHost(String projectCode);


    LstListMember getMember(Integer caseId);

}
