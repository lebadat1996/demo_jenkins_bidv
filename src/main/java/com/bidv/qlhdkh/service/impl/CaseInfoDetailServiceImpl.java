package com.bidv.qlhdkh.service.impl;

import static com.bidv.qlhdkh.util.Util.convertDateToString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidv.qlhdkh.entity.CaseInfo;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.repository.CaseInfoRepository;
import com.bidv.qlhdkh.service.CaseInfoDetailService;
import com.bidv.qlhdkh.service.ListCouncillService;
import com.bidv.qlhdkh.service.ListMemberService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CaseInfoDetailServiceImpl implements CaseInfoDetailService {
    @Autowired
    CaseInfoRepository caseInfoRepository;
    @Autowired
    ListMemberService memberService;
    @Autowired
    CoHostServiceImpl coHostService;
    @Autowired
    PlanServiceImpl planService;
    @Autowired
    ListCouncillService councillService;
    @Autowired
    EvaluateTranscriptServiceImpl evaluateTranscriptService;
    @Autowired
    ListAcceptCouncilServiceImpl acceptCouncilService;
    @Autowired
    UploadFileServiceImpl uploadFileService;

    @Override
    public CaseInfoModel detailCaseInfo(Integer caseId) {
        CaseInfoModel caseInfoModelList = new CaseInfoModel();
        try {
                List<CaseInfo> caseInfos = caseInfoRepository.caseInfo(caseId);
                for (CaseInfo cases : caseInfos) {
                    caseInfoModelList.setLstListCouncill(councillService.getListCouncill(cases.getId()));
                    getDetailCaseInfoByCaseId(caseInfoModelList, cases);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return caseInfoModelList;
    }

    @Override
    @Transactional
    public CaseInfoModel detailCaseInfoSystem(Integer caseId) {
        CaseInfoModel caseInfoModelList = new CaseInfoModel();
        try {
            List<CaseInfo> caseInfo = caseInfoRepository.caseInfo(caseId);
            for (CaseInfo c : caseInfo) {
                caseInfoModelList.setLstListCouncill(councillService.getListCouncill(c.getId()));
                getDetailCaseInfoByCaseId(caseInfoModelList, c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return caseInfoModelList;
    }

    @Override
    public List<CaseInfoModel> ListCaseInfoSystem() {
        List<CaseInfoModel> caseInfoList = new ArrayList<>();
        try {
            List<CaseInfo> infoList = caseInfoRepository.findAll();
            for (CaseInfo info : infoList) {
                if (info.getCaseId() != null) {
                    CaseInfoModel caseInfoModel = detailCaseInfo(info.getCaseId());
                    caseInfoList.add(caseInfoModel);
                }
            }
            return caseInfoList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return caseInfoList;
    }

    private void getDetailCaseInfoByCaseId(CaseInfoModel caseInfoModelList, CaseInfo caseInfo) {
        if (caseInfo.getProjectCode() != null) {
            caseInfoModelList.setProjectCode(caseInfo.getProjectCode());
        }
        if (caseInfo.getProjectName() != null) {
            caseInfoModelList.setProjectName(caseInfo.getProjectName());
        }
        caseInfoModelList.setId(caseInfo.getId());
        caseInfoModelList.setCaseType(caseInfo.getCaseType());
        caseInfoModelList.setCadresName(caseInfo.getCadresName());
        caseInfoModelList.setCadresEmail(caseInfo.getCadresEmail());
        caseInfoModelList.setQuantity(caseInfo.getQuantity());
        caseInfoModelList.setCadresPhone(caseInfo.getCadresPhone());
        caseInfoModelList.setRegisterCondition(caseInfo.getRegisterCondition());
        caseInfoModelList.setCost(caseInfo.getCost());
        caseInfoModelList.setStartDate(convertDateToString(caseInfo.getStartDate()));
        caseInfoModelList.setEndDate(convertDateToString(caseInfo.getEndDate()));
        caseInfoModelList.setNecessity(caseInfo.getNecessity());
        caseInfoModelList.setTarget(caseInfo.getTarget());
        caseInfoModelList.setRange(caseInfo.getRange());
        caseInfoModelList.setObject(caseInfo.getObject());
        caseInfoModelList.setMethod(caseInfo.getMethod());
        caseInfoModelList.setData(caseInfo.getData());
        caseInfoModelList.setContent(caseInfo.getContent());
        caseInfoModelList.setConsequence(caseInfo.getConsequence());
        caseInfoModelList.setContribute(caseInfo.getContribute());
        caseInfoModelList.setWeakness(caseInfo.getWeakness());
        caseInfoModelList.setTranferMethod(caseInfo.getTranferMethod());
        caseInfoModelList.setAction(caseInfo.getAction());
        caseInfoModelList.setProjectType(caseInfo.getProjectType());
        caseInfoModelList.setTopicType(caseInfo.getTopicType());
        caseInfoModelList.setDutyOwner(caseInfo.getDutyOwner());
        caseInfoModelList.setDutySecretary(caseInfo.getDutySecretary());
        caseInfoModelList.setCreatedDate(convertDateToString(caseInfo.getCreatedDate()));
        caseInfoModelList.setProjectLevel(caseInfo.getProjectLevel());
        caseInfoModelList.setTopicCategory(caseInfo.getTopicCategory());
        caseInfoModelList.setEvaluateBudget(caseInfo.getEvaluateBudget());
        caseInfoModelList.setPresidentConclusion(caseInfo.getPresidentConclusion());
        caseInfoModelList.setRecommentBudget(caseInfo.getRecommentBudget());
        caseInfoModelList.setRequestPerfect(caseInfo.getRequestPerfect());
        caseInfoModelList.setResearchOverView(caseInfo.getResearchOverView());
        caseInfoModelList.setResearchMethod(caseInfo.getResearchMethod());
        caseInfoModelList.setResearchResult(caseInfo.getResearchResult());
        caseInfoModelList.setOrientation(caseInfo.getOrientation());
        caseInfoModelList.setReference(caseInfo.getReference());
        caseInfoModelList.setExtensionDate(convertDateToString(caseInfo.getExtensionDate()));
        caseInfoModelList.setContractNo(caseInfo.getContractNo());
        caseInfoModelList.setAccomanyDoc(caseInfo.getAccomanyDoc());
        caseInfoModelList.setNote(caseInfo.getNote());
        caseInfoModelList.setBudgetPercent(caseInfo.getBudgetPercent());
        caseInfoModelList.setReportRange(caseInfo.getReportRange());
        caseInfoModelList.setReportEffective(caseInfo.getReportEffective());
        caseInfoModelList.setReportDifficult(caseInfo.getReportDifficult());
        caseInfoModelList.setPreStatusSol(caseInfo.getPreStatusSol());
        caseInfoModelList.setProcessApp(caseInfo.getProcessApp());
        caseInfoModelList.setEffecSol(caseInfo.getEffecSol());
        caseInfoModelList.setInterestSub(caseInfo.getInterestSub());
        caseInfoModelList.setConclusion(caseInfo.getConclusion());
        caseInfoModelList.setInterest(caseInfo.getInterest());
        caseInfoModelList.setRemuneration(caseInfo.getRemuneration());
        caseInfoModelList.setCalInterestMethod(caseInfo.getCalInterestMethod());
        caseInfoModelList.setBackground(caseInfo.getBackground());
        caseInfoModelList.setShare(caseInfo.getShares());
        caseInfoModelList.setPlanPlus(caseInfo.getPlanPlus());
        caseInfoModelList.setSuggest(caseInfo.getSuggest());
        caseInfoModelList.setStatus(caseInfo.getStatus());
        caseInfoModelList.setBds(caseInfo.getBds());
        caseInfoModelList.setDeparmentCode(caseInfo.getDeparmentCode());
        caseInfoModelList.setDepartment(caseInfo.getDepartment());
        caseInfoModelList.setBrn(caseInfo.getBrn());
        caseInfoModelList.setBranch(caseInfo.getBranch());
        caseInfoModelList.setCaseId(caseInfo.getCaseId());
        caseInfoModelList.setCra(caseInfo.getCra());
        caseInfoModelList.setStepId(caseInfo.getStepId());
        caseInfoModelList.setAcceptDate(convertDateToString(caseInfo.getAcceptDate()));
        caseInfoModelList.setStatusRemuneration(caseInfo.getStatusRemuneration());
        caseInfoModelList.setRecognitionDate(convertDateToString(caseInfo.getRecognitionDate()));
        caseInfoModelList.setLstListMember(memberService.getMember(caseInfo.getId()));
        caseInfoModelList.setLstCoHost(coHostService.getCoHost(caseInfo.getId()));
        caseInfoModelList.setLstPlan(planService.getPlan(caseInfo.getId()));
        caseInfoModelList.setLstReTranscript(planService.getReTran(caseInfo.getId()));
        caseInfoModelList.setLstAcceptTranscript(planService.getAcceptTran(caseInfo.getId()));
        caseInfoModelList.setLstCadresInfor(planService.getCadresInfors(caseInfo.getId()));
        caseInfoModelList.setLstParty(planService.getParty(caseInfo.getId()));
        caseInfoModelList.setLstEstimateBudget(planService.getEstimateBudgets(caseInfo.getId()));
        caseInfoModelList.setLstResultUntillChange(coHostService.getResultUtil(caseInfo.getId()));
        caseInfoModelList.setLstPlanPlusTable(coHostService.getPlanPlus(caseInfo.getId()));
        caseInfoModelList.setLstListSolDepartment(coHostService.getListSolDepartment(caseInfo.getId()));
        caseInfoModelList.setLstListIniCouncil(councillService.getIniCouncil(caseInfo.getId()));
        caseInfoModelList.setLstContentChange(coHostService.getLstConChange(caseInfo.getId()));
        caseInfoModelList.setLstContentStop(coHostService.getLstContentStop(caseInfo.getId()));
        caseInfoModelList.setLstDutyPayment(coHostService.getLstDutyPayment(caseInfo.getId()));
        caseInfoModelList.setLstDutyStatus(coHostService.getDutyStatus(caseInfo.getId()));
        caseInfoModelList.setLstEvaluateDuty(coHostService.getLstEvaluateDuty(caseInfo.getId()));
        caseInfoModelList.setLstEvaluateInitiative(coHostService.getLstEvaluateInitiative(caseInfo.getId()));
        caseInfoModelList.setLstEvaluateTranscript(evaluateTranscriptService.getLstEvaluateTran(caseInfo.getId()));
        caseInfoModelList.setLstInitiativeStatus(coHostService.getLstInitiativeStatus(caseInfo.getId()));
        caseInfoModelList.setLstListAcceprtCouncil(acceptCouncilService.getAcceptCouncil(caseInfo.getId()));
        caseInfoModelList.setLstHost(coHostService.getHost(caseInfo.getId()));
        caseInfoModelList.setLstInitiativeTranScript(coHostService.getLstInitiativeTranScript(caseInfo.getId()));
        caseInfoModelList.setLstHistories(coHostService.getHistory(caseInfo.getId()));
        caseInfoModelList.setLstDocument(uploadFileService.getListDoc(caseInfo.getId()));
    }
}
