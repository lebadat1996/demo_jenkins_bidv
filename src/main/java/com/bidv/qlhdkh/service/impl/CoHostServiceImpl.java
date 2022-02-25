package com.bidv.qlhdkh.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bidv.qlhdkh.entity.CadresInfor;
import com.bidv.qlhdkh.entity.CoHost;
import com.bidv.qlhdkh.entity.CoHostHistory;
import com.bidv.qlhdkh.entity.ContentChange;
import com.bidv.qlhdkh.entity.ContentStop;
import com.bidv.qlhdkh.entity.DutyPayment;
import com.bidv.qlhdkh.entity.DutyStatus;
import com.bidv.qlhdkh.entity.EstimateBudget;
import com.bidv.qlhdkh.entity.EvaluateDutys;
import com.bidv.qlhdkh.entity.EvaluateInitiative;
import com.bidv.qlhdkh.entity.Histories;
import com.bidv.qlhdkh.entity.Host;
import com.bidv.qlhdkh.entity.InitiativeStatus;
import com.bidv.qlhdkh.entity.InitiativeTranScript;
import com.bidv.qlhdkh.entity.ListIniCouncil;
import com.bidv.qlhdkh.entity.ListSolDepartment;
import com.bidv.qlhdkh.entity.PlanPlusTable;
import com.bidv.qlhdkh.entity.ReTranScript;
import com.bidv.qlhdkh.entity.ResultUtillChange;
import com.bidv.qlhdkh.model.CadresInforModel;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.CoHostModel;
import com.bidv.qlhdkh.model.ContentChangeModel;
import com.bidv.qlhdkh.model.ContentStopModel;
import com.bidv.qlhdkh.model.DutyPaymentModel;
import com.bidv.qlhdkh.model.DutyStatusModel;
import com.bidv.qlhdkh.model.EstimateBudgetModel;
import com.bidv.qlhdkh.model.EvaluateDutyModel;
import com.bidv.qlhdkh.model.EvaluateInitiativeModel;
import com.bidv.qlhdkh.model.HistoriesModel;
import com.bidv.qlhdkh.model.HostModel;
import com.bidv.qlhdkh.model.InitiativeStatusModel;
import com.bidv.qlhdkh.model.InitiativeTranScriptModel;
import com.bidv.qlhdkh.model.ListIniCouncilModel;
import com.bidv.qlhdkh.model.ListSolDepartmentModel;
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
import com.bidv.qlhdkh.model.PlanPlusTableModel;
import com.bidv.qlhdkh.model.ReTranscriptModel;
import com.bidv.qlhdkh.model.ResultUntillChangeModel;
import com.bidv.qlhdkh.repository.CadresInforRepository;
import com.bidv.qlhdkh.repository.CoHostHistoryRepository;
import com.bidv.qlhdkh.repository.CoHostRepository;
import com.bidv.qlhdkh.repository.ContentChangeRepository;
import com.bidv.qlhdkh.repository.ContentStopRepository;
import com.bidv.qlhdkh.repository.DutyPaymentRepository;
import com.bidv.qlhdkh.repository.DutyStatusRepository;
import com.bidv.qlhdkh.repository.EstimateBudgetRepository;
import com.bidv.qlhdkh.repository.EvaluateDutyRepository;
import com.bidv.qlhdkh.repository.EvaluateInitiativeRepository;
import com.bidv.qlhdkh.repository.HistoriesRepository;
import com.bidv.qlhdkh.repository.HostRepository;
import com.bidv.qlhdkh.repository.InitiativeStatusRepository;
import com.bidv.qlhdkh.repository.InitiativeTranScriptRepository;
import com.bidv.qlhdkh.repository.ListCouncillRepository;
import com.bidv.qlhdkh.repository.ListIniCouncilRepository;
import com.bidv.qlhdkh.repository.ListSolDepartmentRepository;
import com.bidv.qlhdkh.repository.PlanPlusTableRepository;
import com.bidv.qlhdkh.repository.ReTranscriptRepository;
import com.bidv.qlhdkh.repository.ResultUtillChangeRepository;
import com.bidv.qlhdkh.service.CoHostService;
import com.bidv.qlhdkh.util.Util;

@Service
public class CoHostServiceImpl implements CoHostService {
    private static final Logger log = LoggerFactory.getLogger(CoHostServiceImpl.class);

    @Autowired
    CoHostRepository coHostRepository;

    @Autowired
    CoHostHistoryRepository coHostHistoryRepository;

    @Autowired
    ReTranscriptRepository reTranscriptRepository;

    @Autowired
    PlanPlusTableRepository planPlusTableRepository;

    @Autowired
    ListSolDepartmentRepository solDepartmentRepository;

    @Autowired
    ListIniCouncilRepository listIniCouncilRepository;

    @Autowired
    InitiativeTranScriptRepository initiativeTranScriptRepository;

    @Autowired
    InitiativeStatusRepository initiativeStatusRepository;

    @Autowired
    HistoriesRepository historiesRepository;

    @Autowired
    EvaluateInitiativeRepository evaluateInitiativeRepository;

    @Autowired
    EvaluateDutyRepository evaluateDutyRepository;

    @Autowired
    EstimateBudgetRepository estimateBudgetRepository;

    @Autowired
    DutyStatusRepository dutyStatusRepository;

    @Autowired
    DutyPaymentRepository dutyPaymentRepository;

    @Autowired
    ContentStopRepository contentStopRepository;

    @Autowired
    ContentChangeRepository contentChangeRepository;


    @Autowired
    ListSolDepartmentRepository listSolDepartmentRepository;

    @Autowired
    ListCouncillRepository listCouncillRepository;

    @Autowired
    HostRepository hostRepository;

    @Autowired
    CadresInforRepository cadresInforRepository;

    @Autowired
    ResultUtillChangeRepository resultUtillChangeRepository;

    @Override
    public LstCoHost getCoHost(Integer caseId) {
        LstCoHost lstCoHost = new LstCoHost();

        try {
            List<CoHost> coHosts = coHostRepository.findAllByCaseId(caseId);
            for (CoHost coHost : coHosts) {
                CoHostModel coHostModel = new CoHostModel();
                coHostModel.setCaseId(coHost.getCaseId());
                coHostModel.setDepartmentId(coHost.getDepartmentId());
                coHostModel.setDepartmentName(coHost.getDepartmentName());
                lstCoHost.addCoHostModelItem(coHostModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstCoHost;
    }

    @Override
    public LstResultUntillChange getResultUtil(Integer caseId) {
        LstResultUntillChange resultUntillChange = new LstResultUntillChange();
        try {
            List<ResultUtillChange> resultUtillChanges = resultUtillChangeRepository.findAllByCaseId(caseId);
            for (ResultUtillChange resultUtillChange : resultUtillChanges) {
                ResultUntillChangeModel resultUntillChangeModel = new ResultUntillChangeModel();
                resultUntillChangeModel.setCaseId(resultUtillChange.getCaseId());
                resultUntillChangeModel.setActualProduct(resultUtillChange.getActualProduct());
                resultUntillChangeModel.setExpectProduct(resultUtillChange.getExpectProduct());
                resultUntillChange.addResultUntillChangeModelItem(resultUntillChangeModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultUntillChange;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveCoHostService(CaseInfoModel svCaseInfo, int caseId) {
        log.info("Save CoHost in CASE_INFO");
        try {
            log.info("START Save CoHost in CASE_INFO");
            List<CoHost> coHosts = coHostRepository.findAllByCaseId(caseId);
            if (coHosts.size() > 0) {
                coHostRepository.deleteAll(coHosts);
                for (CoHostModel coHost : svCaseInfo.getLstCoHost().getCoHostModel()) {
                    CoHost cohosts = new CoHost();
                    cohosts.setCaseId(caseId);
                    cohosts.setDepartmentId(coHost.getDepartmentId());
                    cohosts.setDepartmentName(coHost.getDepartmentName());
                    coHostRepository.save(cohosts);
                }
            } else {
                for (CoHostModel coHost : svCaseInfo.getLstCoHost().getCoHostModel()) {
                    CoHost cohosts = new CoHost();
                    cohosts.setCaseId(caseId);
                    cohosts.setDepartmentId(coHost.getDepartmentId());
                    cohosts.setDepartmentName(coHost.getDepartmentName());
                    coHostRepository.save(cohosts);
                }
            }

            log.info("END Save CoHost in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save CoHost in CASE_INFO");
            log.error("ERROR Save CoHost in CASE_INFO");
        }
    }

    @Override
    public void saveReTranscript(CaseInfoModel caseInfo, int caseId) {
        log.info("Save ReTranscript in CASE_INFO");
        try {
            log.info("START Save ReTranscript in CASE_INFO");
            List<ReTranScript> reTranScripts = reTranscriptRepository.findAllByCaseId(caseId);
            if (reTranScripts.size() > 0) {
                reTranscriptRepository.deleteAll(reTranScripts);
                for (ReTranscriptModel transcriptModel : caseInfo.getLstReTranscript().getReTranscriptModel()) {
                    ReTranScript reTranScript = new ReTranScript();
                    reTranScript.setAuthor(transcriptModel.getAuthor());
                    reTranScript.setCaseId(caseId);
                    reTranScript.setContent(transcriptModel.getContent());
                    reTranScript.setInterestAfterYear(transcriptModel.getInterestAfterYear());
                    reTranScript.setNote(transcriptModel.getNote());
                    reTranscriptRepository.save(reTranScript);
                }
            } else {
                for (ReTranscriptModel transcriptModel : caseInfo.getLstReTranscript().getReTranscriptModel()) {
                    ReTranScript reTranScript = new ReTranScript();
                    reTranScript.setAuthor(transcriptModel.getAuthor());
                    reTranScript.setCaseId(caseId);
                    reTranScript.setContent(reTranScript.getContent());
                    reTranScript.setInterestAfterYear(reTranScript.getInterestAfterYear());
                    reTranScript.setNote(reTranScript.getNote());
                    reTranscriptRepository.save(reTranScript);
                }
            }
            log.info("END Save ReTranscript in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save ReTranscript in CASE_INFO");
            log.error("ERROR Save ReTranscript in CASE_INFO");
        }
    }

    @Override
    public void savePlanPlusTable(CaseInfoModel caseInfo, int caseId) {
        log.info("Save planPlusTable in CASE_INFO");
        try {
            log.info("START Save planPlusTable in CASE_INFO");
            List<PlanPlusTable> planPlusTables = planPlusTableRepository.findAllByCaseId(caseId);
            if (planPlusTables.size() > 0) {
                planPlusTableRepository.deleteAll(planPlusTables);
                for (PlanPlusTableModel planplustable : caseInfo.getLstPlanPlusTable().getPlanPlusTableModel()) {
                    PlanPlusTable planplustables = new PlanPlusTable();
                    planplustables.setCaseId(caseId);
                    planplustables.setContent(planplustable.getContent());
                    planplustables.setCost(planplustable.getCost());
                    planplustables.setEvaluateEffect(planplustable.getEvaluateEffect());
                    planplustables.setNote(planplustable.getNote());
                    planPlusTableRepository.save(planplustables);
                }
            } else {
                for (PlanPlusTableModel planplustable : caseInfo.getLstPlanPlusTable().getPlanPlusTableModel()) {
                    PlanPlusTable planplustables = new PlanPlusTable();
                    planplustables.setCaseId(caseId);
                    planplustables.setContent(planplustable.getContent());
                    planplustables.setCost(planplustable.getCost());
                    planplustables.setEvaluateEffect(planplustable.getEvaluateEffect());
                    planplustables.setNote(planplustable.getNote());
                    planPlusTableRepository.save(planplustables);
                }
            }
            log.info("END Save planPlusTable in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save planPlusTable in CASE_INFO");
            log.error("ERROR Save planPlusTable in CASE_INFO");
        }
    }

    @Override
    public LstPlanPlusTable getPlanPlus(int caseId) {
        LstPlanPlusTable lstPlanPlusTable = new LstPlanPlusTable();
        List<PlanPlusTable> planPlusTables = planPlusTableRepository.findAllByCaseId(caseId);
        for (PlanPlusTable planPlusTable : planPlusTables) {
            PlanPlusTableModel planplustables = new PlanPlusTableModel();
            planplustables.setCaseId(caseId);
            planplustables.setContent(planPlusTable.getContent());
            planplustables.setCost(planPlusTable.getCost());
            planplustables.setEvaluateEffect(planPlusTable.getEvaluateEffect());
            planplustables.setNote(planPlusTable.getNote());
            lstPlanPlusTable.addPlanPlusTableModelItem(planplustables);
        }

        return lstPlanPlusTable;
    }

    @Override
    public void saveListSolDepartment(CaseInfoModel caseInfo, int caseId) {
        log.info("Save listSolDepartment in CASE_INFO");
        try {
            log.info("START Save listSolDepartment in CASE_INFO");
            List<ListSolDepartment> listSolDepartments = listSolDepartmentRepository.findAllByCaseId(caseId);
            if (listSolDepartments.size() > 0) {
                listSolDepartmentRepository.deleteAll(listSolDepartments);
                for (ListSolDepartmentModel listsoldepartment : caseInfo.getLstListSolDepartment().getListSolDepartmentModel()) {
                    ListSolDepartment listsoldepartments = new ListSolDepartment();
                    listsoldepartments.setRepresent(listsoldepartment.getRepresent());
                    listsoldepartments.setCaseId(caseId);
                    listsoldepartments.setDepartmentId(listsoldepartment.getDepartmentId());
                    listsoldepartments.setDepartmentName(listsoldepartment.getDepartmentName());
                    listSolDepartmentRepository.save(listsoldepartments);
                }
            } else {
                for (ListSolDepartmentModel listsoldepartment : caseInfo.getLstListSolDepartment().getListSolDepartmentModel()) {
                    ListSolDepartment listsoldepartments = new ListSolDepartment();
                    listsoldepartments.setRepresent(listsoldepartment.getRepresent());
                    listsoldepartments.setCaseId(caseId);
                    listsoldepartments.setDepartmentId(listsoldepartment.getDepartmentId());
                    listsoldepartments.setDepartmentName(listsoldepartment.getDepartmentName());
                    listSolDepartmentRepository.save(listsoldepartments);
                }
            }
            log.info("END Save listSolDepartment in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save listSolDepartment in CASE_INFO");
            log.error("ERROR Save listSolDepartment in CASE_INFO");
        }
    }

    @Override
    public LstListSolDepartment getListSolDepartment(int caseId) {
        LstListSolDepartment lstListSolDepartment = new LstListSolDepartment();

        List<ListSolDepartment> listSolDepartments = listSolDepartmentRepository.findAllByCaseId(caseId);
        for (ListSolDepartment listSolDepartment : listSolDepartments) {
            ListSolDepartmentModel listSolDepartmentModel = new ListSolDepartmentModel();
            listSolDepartmentModel.setRepresent(listSolDepartment.getRepresent());
            listSolDepartmentModel.setCaseId(listSolDepartment.getCaseId());
            listSolDepartmentModel.setDepartmentId(listSolDepartment.getDepartmentId());
            listSolDepartmentModel.setDepartmentName(listSolDepartment.getDepartmentName());
            lstListSolDepartment.addListSolDepartmentModelItem(listSolDepartmentModel);
        }
        return lstListSolDepartment;
    }


    @Override
    public void saveInitiativeTranScript(CaseInfoModel caseInfo, int caseId) {
        log.info("Save InitiativeTranScript in CASE_INFO");
        try {
            log.info("START Save InitiativeTranScript in CASE_INFO");
            List<InitiativeTranScript> initiativeTranScripts = initiativeTranScriptRepository.findAllByCaseId(caseId);
            if (initiativeTranScripts.size() > 0) {
                initiativeTranScriptRepository.deleteAll(initiativeTranScripts);
                for (InitiativeTranScriptModel initiativetranscript : caseInfo.getLstInitiativeTranScript().getInitiativeTranScriptModel()) {
                    InitiativeTranScript initiativetranscripts = new InitiativeTranScript();
                    initiativetranscripts.setId(initiativetranscript.getId());
                    initiativetranscripts.setCaseId(caseId);
                    initiativetranscripts.setCreativityScore(initiativetranscript.getCreativityScore());
                    initiativetranscripts.setSciencesScore(initiativetranscript.getScienceScore());
                    initiativetranscripts.setRealityScore(initiativetranscript.getRealityScore());
                    initiativetranscripts.setEffecScore(initiativetranscript.getEffecScore());
                    initiativetranscripts.setAverage(initiativetranscript.getAverage());
                    initiativetranscripts.setConclusion(initiativetranscript.getConclusion());
                    initiativetranscripts.setSugguest(initiativetranscript.getSugguest());
                    initiativetranscripts.setAddRequest(initiativetranscript.getAddRequest());
                    initiativetranscripts.setDepartment(initiativetranscript.getDepartment());
                    initiativetranscripts.setProjectName(initiativetranscript.getProjectName());
                    initiativetranscripts.setInterest(initiativetranscript.getInterest());
                    initiativetranscripts.setAddRequest(initiativetranscript.getAddRequest());
                    initiativetranscripts.setAuthor(initiativetranscript.getAuthor());
                    initiativeTranScriptRepository.save(initiativetranscripts);
                }
            } else {
                for (InitiativeTranScriptModel initiativetranscript : caseInfo.getLstInitiativeTranScript().getInitiativeTranScriptModel()) {
                    InitiativeTranScript initiativetranscripts = new InitiativeTranScript();
                    initiativetranscripts.setId(initiativetranscript.getId());
                    initiativetranscripts.setCaseId(caseId);
                    initiativetranscripts.setCreativityScore(initiativetranscript.getCreativityScore());
                    initiativetranscripts.setSciencesScore(initiativetranscript.getScienceScore());
                    initiativetranscripts.setRealityScore(initiativetranscript.getRealityScore());
                    initiativetranscripts.setEffecScore(initiativetranscript.getEffecScore());
                    initiativetranscripts.setAverage(initiativetranscript.getAverage());
                    initiativetranscripts.setConclusion(initiativetranscript.getConclusion());
                    initiativetranscripts.setSugguest(initiativetranscript.getSugguest());
                    initiativetranscripts.setAddRequest(initiativetranscript.getAddRequest());
                    initiativetranscripts.setDepartment(initiativetranscript.getDepartment());
                    initiativetranscripts.setProjectName(initiativetranscript.getProjectName());
                    initiativetranscripts.setInterest(initiativetranscript.getInterest());
                    initiativetranscripts.setAddRequest(initiativetranscript.getAddRequest());
                    initiativetranscripts.setAuthor(initiativetranscript.getAuthor());
                    initiativeTranScriptRepository.save(initiativetranscripts);
                }
            }

            log.info("END Save InitiativeTranScript in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save InitiativeTranScript in CASE_INFO");
            log.error("ERROR Save InitiativeTranScript in CASE_INFO");
        }
    }

    @Override
    public LstInitiativeTranScript getLstInitiativeTranScript(int caseId) {
        LstInitiativeTranScript initiativeTranScript = new LstInitiativeTranScript();
        List<InitiativeTranScript> tranScriptList = initiativeTranScriptRepository.findAllByCaseId(caseId);
        for (InitiativeTranScript initiativetranscript : tranScriptList) {
            InitiativeTranScriptModel initiativetranscripts = new InitiativeTranScriptModel();
            initiativetranscripts.setId(initiativetranscript.getId());
            initiativetranscripts.setCaseId(caseId);
            initiativetranscripts.setCreativityScore(initiativetranscript.getCreativityScore());
            initiativetranscripts.setScienceScore(initiativetranscript.getSciencesScore());
            initiativetranscripts.setRealityScore(initiativetranscript.getRealityScore());
            initiativetranscripts.setEffecScore(initiativetranscript.getEffecScore());
            initiativetranscripts.setAverage(initiativetranscript.getAverage());
            initiativetranscripts.setConclusion(initiativetranscript.getConclusion());
            initiativetranscripts.setSugguest(initiativetranscript.getSugguest());
            initiativetranscripts.setAddRequest(initiativetranscript.getAddRequest());
            initiativetranscripts.setDepartment(initiativetranscript.getDepartment());
            initiativetranscripts.setProjectName(initiativetranscript.getProjectName());
            initiativetranscripts.setInterest(initiativetranscript.getInterest());
            initiativetranscripts.setAddRequest(initiativetranscript.getAddRequest());
            initiativetranscripts.setAuthor(initiativetranscript.getAuthor());
            initiativeTranScript.addInitiativeTranScriptModelItem(initiativetranscripts);
        }
        return initiativeTranScript;
    }


    @Override
    public void saveInitiativeStatus(CaseInfoModel caseInfo, int caseId) {
        log.info("Save InitiativeStatus in CASE_INFO");
        try {
            log.info("START Save InitiativeStatus in CASE_INFO");
            List<InitiativeStatus> initiativeStatuses = initiativeStatusRepository.findAllByCaseId(caseId);
            if (initiativeStatuses.size() > 0) {
                initiativeStatusRepository.deleteAll(initiativeStatuses);
                for (InitiativeStatusModel initiativestatus : caseInfo.getLstInitiativeStatus().getInitiativeStatusModel()) {
                    InitiativeStatus initiativestatuss = new InitiativeStatus();
                    initiativestatuss.setCaseId(caseId);
                    initiativestatuss.setContent(initiativestatus.getContent());
                    initiativestatuss.setCost(initiativestatus.getCost());
                    initiativestatuss.setEvaluateEffect(initiativestatus.getEvaluateEffect());
                    initiativestatuss.setNote(initiativestatus.getNote());
                    initiativeStatusRepository.save(initiativestatuss);
                }
            } else {
                for (InitiativeStatusModel initiativestatus : caseInfo.getLstInitiativeStatus().getInitiativeStatusModel()) {
                    InitiativeStatus initiativestatuss = new InitiativeStatus();
                    initiativestatuss.setCaseId(caseId);
                    initiativestatuss.setContent(initiativestatus.getContent());
                    initiativestatuss.setCost(initiativestatus.getCost());
                    initiativestatuss.setEvaluateEffect(initiativestatus.getEvaluateEffect());
                    initiativestatuss.setNote(initiativestatus.getNote());
                    initiativeStatusRepository.save(initiativestatuss);
                }
            }
            log.info("END Save InitiativeStatus in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save InitiativeStatus in CASE_INFO");
            log.error("ERROR Save InitiativeStatus in CASE_INFO");
        }
    }

    @Override
    public LstInitiativeStatus getLstInitiativeStatus(int caseId) {
        LstInitiativeStatus lstInitiativeStatus = new LstInitiativeStatus();
        List<InitiativeStatus> initiativeStatusList = initiativeStatusRepository.findAllByCaseId(caseId);
        for (InitiativeStatus initiativestatus : initiativeStatusList) {
            InitiativeStatusModel initiativestatuss = new InitiativeStatusModel();
            initiativestatuss.setCaseId(caseId);
            initiativestatuss.setContent(initiativestatus.getContent());
            initiativestatuss.setCost(initiativestatus.getCost());
            initiativestatuss.setEvaluateEffect(initiativestatus.getEvaluateEffect());
            initiativestatuss.setNote(initiativestatus.getNote());
            lstInitiativeStatus.addInitiativeStatusModelItem(initiativestatuss);
        }
        return lstInitiativeStatus;
    }

    @Override
    public void saveHistories(CaseInfoModel caseInfo, int caseId) {
        log.info("Save Histories in CASE_INFO");
        try {
            log.info("START Save Histories in CASE_INFO");
            List<Histories> historiesList = historiesRepository.findAllByCaseId(caseId);
            if (historiesList.size() > 0) {
                historiesRepository.deleteAll(historiesList);
                for (HistoriesModel histories : caseInfo.getLstHistories().getHistoriesModel()) {
                    Histories historiess = new Histories();
                    historiess.setId(histories.getId());
                    historiess.setCaseId(caseId);
                    historiess.setCreate(histories.getCreator());
                    historiess.setDateCreate(Util.getDates(histories.getCreatedDate()));
                    historiess.setAction(histories.getAction());
                    historiess.setNote(histories.getNote());
                    historiess.setRole(histories.getRole());
                    historiesRepository.save(historiess);
                }
            } else {
                for (HistoriesModel histories : caseInfo.getLstHistories().getHistoriesModel()) {
                    Histories historiess = new Histories();
                    historiess.setId(histories.getId());
                    historiess.setCaseId(caseId);
                    historiess.setCreate(histories.getCreator());
                    historiess.setDateCreate(Util.getDates(histories.getCreatedDate()));
                    historiess.setAction(histories.getAction());
                    historiess.setNote(histories.getNote());
                    historiess.setRole(histories.getRole());
                    historiesRepository.save(historiess);
                }
            }

            log.info("END Save Histories in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save Histories in CASE_INFO");
            log.error("ERROR Save Histories in CASE_INFO");
        }
    }

    @Override
    public LstHistories getHistory(int caseId) {
        LstHistories historiesLs = new LstHistories();
        List<Histories> histories1 = historiesRepository.findAllByCaseId(caseId);
        for (Histories histories : histories1) {
            HistoriesModel historiess = new HistoriesModel();
            historiess.setCaseId(caseId);
            historiess.setCreator(histories.getCreate());
            historiess.setCreatedDate(Util.convertDateToString(histories.getDateCreate()));
            historiess.setAction(histories.getAction());
            historiess.setNote(histories.getNote());
            historiess.setRole(histories.getRole());
            historiesLs.addHistoriesModelItem(historiess);
        }
        return historiesLs;
    }

    @Override
    public void saveEvaluateInitiative(CaseInfoModel caseInfo, int caseId) {
        log.info("Save EvaluateInitiative in CASE_INFO");
        try {
            log.info("START Save EvaluateInitiative in CASE_INFO");
            List<EvaluateInitiative> initiativeList = evaluateInitiativeRepository.findAllByCaseId(caseId);
            if (initiativeList.size() > 0) {
                evaluateInitiativeRepository.deleteAll(initiativeList);
                for (EvaluateInitiativeModel evaluateinitiative : caseInfo.getLstEvaluateInitiative().getEvaluateInitiativeModel()) {
                    EvaluateInitiative evaluateinitiatives = new EvaluateInitiative();
                    evaluateinitiatives.setCaseId(caseId);
                    evaluateinitiatives.setContent(evaluateinitiative.getContent());
                    evaluateinitiatives.setCost(evaluateinitiative.getCost());
                    evaluateinitiatives.setEvaluateEffect(evaluateinitiative.getEvaluateEffect());
                    evaluateinitiatives.setNote(evaluateinitiative.getNote());
                    evaluateInitiativeRepository.save(evaluateinitiatives);
                }
            } else {
                for (EvaluateInitiativeModel evaluateinitiative : caseInfo.getLstEvaluateInitiative().getEvaluateInitiativeModel()) {
                    EvaluateInitiative evaluateinitiatives = new EvaluateInitiative();
                    evaluateinitiatives.setCaseId(caseId);
                    evaluateinitiatives.setContent(evaluateinitiative.getContent());
                    evaluateinitiatives.setCost(evaluateinitiative.getCost());
                    evaluateinitiatives.setEvaluateEffect(evaluateinitiative.getEvaluateEffect());
                    evaluateinitiatives.setNote(evaluateinitiative.getNote());
                    evaluateInitiativeRepository.save(evaluateinitiatives);
                }
            }
            log.info("END Save EvaluateInitiative in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save EvaluateInitiative in CASE_INFO");
            log.error("ERROR Save EvaluateInitiative in CASE_INFO");
        }
    }

    @Override
    public LstEvaluateInitiative getLstEvaluateInitiative(int caseId) {
        LstEvaluateInitiative lstEvaluateInitiative = new LstEvaluateInitiative();

        List<EvaluateInitiative> evaluateInitiative = evaluateInitiativeRepository.findAllByCaseId(caseId);
        for (EvaluateInitiative evaluateinitiative : evaluateInitiative) {
            EvaluateInitiativeModel evaluateinitiatives = new EvaluateInitiativeModel();
            evaluateinitiatives.setCaseId(caseId);
            evaluateinitiatives.setContent(evaluateinitiative.getContent());
            evaluateinitiatives.setCost(evaluateinitiative.getCost());
            evaluateinitiatives.setEvaluateEffect(evaluateinitiative.getEvaluateEffect());
            evaluateinitiatives.setNote(evaluateinitiative.getNote());
            lstEvaluateInitiative.addEvaluateInitiativeModelItem(evaluateinitiatives);
        }
        return lstEvaluateInitiative;
    }

    @Override
    public void saveEvaluateDuty(CaseInfoModel caseInfo, int caseId) {
        log.info("Save evaluateDuty in CASE_INFO");
        try {
            log.info("START Save evaluateDuty in CASE_INFO");
            List<EvaluateDutys> evaluateDuties = evaluateDutyRepository.findAllByCaseId(caseId);
            if (evaluateDuties.size() > 0) {
                evaluateDutyRepository.deleteAll(evaluateDuties);
                for (EvaluateDutyModel evaluateduty : caseInfo.getLstEvaluateDuty().getEvaluateDutyModel()) {
                    EvaluateDutys evaluatedutys = new EvaluateDutys();
                    evaluatedutys.setCaseId(caseId);
                    evaluatedutys.setContent(evaluateduty.getContent());
                    evaluatedutys.setCost(evaluateduty.getCost());
                    evaluatedutys.setEvaluateEffect(evaluateduty.getEvaluateEffect());
                    evaluatedutys.setNote(evaluateduty.getNote());
                    evaluateDutyRepository.save(evaluatedutys);
                }
            } else {
                for (EvaluateDutyModel evaluateduty : caseInfo.getLstEvaluateDuty().getEvaluateDutyModel()) {
                    EvaluateDutys evaluatedutys = new EvaluateDutys();
                    evaluatedutys.setCaseId(caseId);
                    evaluatedutys.setContent(evaluateduty.getContent());
                    evaluatedutys.setCost(evaluateduty.getCost());
                    evaluatedutys.setEvaluateEffect(evaluateduty.getEvaluateEffect());
                    evaluatedutys.setNote(evaluateduty.getNote());
                    evaluateDutyRepository.save(evaluatedutys);
                }
            }

            log.info("END Save evaluateDuty in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save evaluateDuty in CASE_INFO");
            log.error("ERROR Save evaluateDuty in CASE_INFO");
        }
    }

    @Override
    public LstEvaluateDuty getLstEvaluateDuty(int caseId) {
        LstEvaluateDuty lstEvaluateDuty = new LstEvaluateDuty();
        List<EvaluateDutys> evaluateDutys = evaluateDutyRepository.findAllByCaseId(caseId);
        for (EvaluateDutys evaluateduty : evaluateDutys) {
            EvaluateDutyModel evaluatedutys = new EvaluateDutyModel();
            evaluatedutys.setCaseId(caseId);
            evaluatedutys.setContent(evaluateduty.getContent());
            evaluatedutys.setCost(evaluateduty.getCost());
            evaluatedutys.setEvaluateEffect(evaluateduty.getEvaluateEffect());
            evaluatedutys.setNote(evaluateduty.getNote());
            lstEvaluateDuty.addEvaluateDutyModelItem(evaluatedutys);
        }
        return lstEvaluateDuty;
    }

    @Override
    public void saveEstimateBudget(CaseInfoModel caseInfo, int caseId) {
        log.info("Save EstimateBudget in CASE_INFO");
        try {
            log.info("START Save EstimateBudget in CASE_INFO");
            List<EstimateBudget> estimateBudgetList = estimateBudgetRepository.findAllByCaseId(caseId);
            if (estimateBudgetList.size() > 0) {
                estimateBudgetRepository.deleteAll(estimateBudgetList);
                for (EstimateBudgetModel estimatebudget : caseInfo.getLstEstimateBudget().getEstimateBudgetModel()) {
                    EstimateBudget estimatebudgets = new EstimateBudget();
                    estimatebudgets.setCaseId(caseId);
                    estimatebudgets.setContent(estimatebudget.getContent());
                    estimatebudgets.setRate(estimatebudget.getRate());
                    estimatebudgets.setQuantity(estimatebudget.getQuanity());
                    estimatebudgets.setAmount(estimatebudget.getAmount());
                    estimatebudgets.setNote(estimatebudget.getNote());
                    estimateBudgetRepository.save(estimatebudgets);
                }
            } else {
                for (EstimateBudgetModel estimatebudget : caseInfo.getLstEstimateBudget().getEstimateBudgetModel()) {
                    EstimateBudget estimatebudgets = new EstimateBudget();
                    estimatebudgets.setCaseId(caseId);
                    estimatebudgets.setContent(estimatebudget.getContent());
                    estimatebudgets.setRate(estimatebudget.getRate());
                    estimatebudgets.setQuantity(estimatebudget.getQuanity());
                    estimatebudgets.setAmount(estimatebudget.getAmount());
                    estimatebudgets.setNote(estimatebudget.getNote());
                    estimateBudgetRepository.save(estimatebudgets);
                }
            }

            log.info("END Save EstimateBudget in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save EstimateBudget in CASE_INFO");
            log.error("ERROR Save EstimateBudget in CASE_INFO");
        }
    }

    @Override
    public void saveDutyStatus(CaseInfoModel caseInfo, int caseId) {
        log.info("Save DutyStatus in CASE_INFO");
        try {
            log.info("START Save DutyStatus in CASE_INFO");
            List<DutyStatus> dutyStatuses = dutyStatusRepository.findAllByCaseId(caseId);
            if (dutyStatuses.size() > 0) {
                dutyPaymentRepository.deleteAll();
                for (DutyStatusModel dutyStatusModel : caseInfo.getLstDutyStatus().getDutyStatusModel()) {
                    DutyStatus dutystatuss = new DutyStatus();
                    dutystatuss.setCaseId(caseId);
                    dutystatuss.setContent(dutyStatusModel.getContent());
                    dutystatuss.setCost(dutyStatusModel.getCost());
                    dutystatuss.setEvaluateEffect(dutyStatusModel.getEvaluateEffect());
                    dutystatuss.setNote(dutyStatusModel.getNote());
                    dutyStatusRepository.save(dutystatuss);
                }
            } else {
                for (DutyStatusModel dutyStatusModel : caseInfo.getLstDutyStatus().getDutyStatusModel()) {
                    DutyStatus dutystatuss = new DutyStatus();
                    dutystatuss.setCaseId(caseId);
                    dutystatuss.setContent(dutyStatusModel.getContent());
                    dutystatuss.setCost(dutyStatusModel.getCost());
                    dutystatuss.setEvaluateEffect(dutyStatusModel.getEvaluateEffect());
                    dutystatuss.setNote(dutyStatusModel.getNote());
                    dutyStatusRepository.save(dutystatuss);
                }
            }
            log.info("END Save DutyStatus in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save DutyStatus in CASE_INFO");
            log.error("ERROR Save DutyStatus in CASE_INFO");
        }
    }

    @Override
    public LstDutyStatus getDutyStatus(int caseId) {
        LstDutyStatus lstDutyStatus = new LstDutyStatus();
        List<DutyStatus> dutyStatuses = dutyStatusRepository.findAllByCaseId(caseId);
        for (DutyStatus dutyStatusModel : dutyStatuses) {
            DutyStatusModel dutystatuss = new DutyStatusModel();
            dutystatuss.setCaseId(caseId);
            dutystatuss.setContent(dutyStatusModel.getContent());
            dutystatuss.setCost(dutyStatusModel.getCost());
            dutystatuss.setEvaluateEffect(dutyStatusModel.getEvaluateEffect());
            dutystatuss.setNote(dutyStatusModel.getNote());
            lstDutyStatus.addDutyStatusModelItem(dutystatuss);
        }
        return lstDutyStatus;
    }

    @Override
    public void saveDutyPayment(CaseInfoModel caseInfo, int caseId) {
        log.info("Save DutyPayment in CASE_INFO");
        try {
            log.info("START Save DutyPayment in CASE_INFO");
            List<DutyPayment> dutyPayments = dutyPaymentRepository.findAllByCaseId(caseId);
            if (dutyPayments.size() > 0) {
                dutyPaymentRepository.deleteAll(dutyPayments);
                for (DutyPaymentModel dutyPaymentModel : caseInfo.getLstDutyPayment().getDutyPaymentModel()) {
                    DutyPayment dutypayments = new DutyPayment();
                    dutypayments.setCaseId(caseId);
                    dutypayments.setContent(dutyPaymentModel.getContent());
                    dutypayments.setCost(dutyPaymentModel.getCost());
                    dutypayments.setEvaluateEffect(dutyPaymentModel.getEvaluateEffect());
                    dutypayments.setNote(dutyPaymentModel.getNote());
                    dutyPaymentRepository.save(dutypayments);
                }
            } else {
                for (DutyPaymentModel dutyPaymentModel : caseInfo.getLstDutyPayment().getDutyPaymentModel()) {
                    DutyPayment dutypayments = new DutyPayment();
                    dutypayments.setCaseId(caseId);
                    dutypayments.setContent(dutyPaymentModel.getContent());
                    dutypayments.setCost(dutyPaymentModel.getCost());
                    dutypayments.setEvaluateEffect(dutyPaymentModel.getEvaluateEffect());
                    dutypayments.setNote(dutyPaymentModel.getNote());
                    dutyPaymentRepository.save(dutypayments);
                }
            }
            log.info("END Save DutyPayment in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save DutyPayment in CASE_INFO");
            log.error("ERROR Save DutyPayment in CASE_INFO");
        }
    }

    @Override
    public LstDutyPayment getLstDutyPayment(int caseId) {
        LstDutyPayment lstDutyPayment = new LstDutyPayment();

        List<DutyPayment> dutyPayments = dutyPaymentRepository.findAllByCaseId(caseId);
        for (DutyPayment dutyPayment : dutyPayments) {
            DutyPaymentModel dutyPaymentModel = new DutyPaymentModel();
            dutyPaymentModel.setCaseId(dutyPayment.getCaseId());
            dutyPaymentModel.setContent(dutyPayment.getContent());
            dutyPaymentModel.setCost(dutyPayment.getCost());
            dutyPaymentModel.setEvaluateEffect(dutyPayment.getEvaluateEffect());
            dutyPaymentModel.setNote(dutyPayment.getNote());
            lstDutyPayment.addDutyPaymentModelItem(dutyPaymentModel);
        }
        return lstDutyPayment;
    }

    @Override
    public void saveContentStop(CaseInfoModel caseInfo, int caseId) {
        log.info("Save ContentStop in CASE_INFO");
        try {
            log.info("START Save ContentStop in CASE_INFO");
            List<ContentStop> contentStops = contentStopRepository.getAll(caseId);
            if (contentStops.size() > 0) {
                contentStopRepository.deleteAll(contentStops);
                for (ContentStopModel contentStopModel : caseInfo.getLstContentStop().getContentStopModel()) {
                    ContentStop contentstops = new ContentStop();
                    contentstops.setCaseId(caseId);
                    contentstops.setStopReason(contentStopModel.getStopReason());
                    contentstops.setDutyCost(contentStopModel.getDutyCost());
                    contentstops.setOtherCost(contentStopModel.getOtherCost());
                    contentstops.setTotalCost(contentStopModel.getTotalCost());
                    contentStopRepository.save(contentstops);
                }
            } else {
                for (ContentStopModel contentStopModel : caseInfo.getLstContentStop().getContentStopModel()) {
                    ContentStop contentstops = new ContentStop();
                    contentstops.setCaseId(caseId);
                    contentstops.setStopReason(contentStopModel.getStopReason());
                    contentstops.setDutyCost(contentStopModel.getDutyCost());
                    contentstops.setOtherCost(contentStopModel.getOtherCost());
                    contentstops.setTotalCost(contentStopModel.getTotalCost());
                    contentStopRepository.save(contentstops);
                }
            }
            log.info("END Save ContentStop in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save ContentStop in CASE_INFO");
            log.error("ERROR Save ContentStop in CASE_INFO");
        }
    }

    @Override
    public LstContentStop getLstContentStop(int caseId) {
        LstContentStop contentStop = new LstContentStop();
        List<ContentStop> contentStops = contentStopRepository.getAll(caseId);
        for (ContentStop content : contentStops) {
            ContentStopModel contentStopModel = new ContentStopModel();
            contentStopModel.setCaseId(caseId);
            contentStopModel.setStopReason(content.getStopReason());
            contentStopModel.setDutyCost(content.getDutyCost());
            contentStopModel.setOtherCost(content.getOtherCost());
            contentStopModel.setTotalCost(content.getTotalCost());
            contentStop.addContentStopModelItem(contentStopModel);
        }
        return contentStop;
    }

    @Override
    public int saveHost(CaseInfoModel caseInfo, int caseId) {
        log.info("Save Host in CASE_INFO");
        try {
            log.info("START Save Host in CASE_INFO");
            List<Host> hostList = hostRepository.findAllByCaseId(caseId);
            if (hostList.size() > 0) {
                hostRepository.deleteAll();
                for (HostModel host : caseInfo.getLstHost().getHostModel()) {
                    Host hosts = new Host();
                    hosts.setCaseId(caseId);
                    hosts.setDepartmentId(host.getDepartmentId());
                    hosts.setDepartmentName(host.getDepartmentName());
                    hostRepository.save(hosts);
                    return hosts.getId();
                }
            } else {
                for (HostModel host : caseInfo.getLstHost().getHostModel()) {
                    Host hosts = new Host();
                    hosts.setCaseId(caseId);
                    hosts.setDepartmentId(host.getDepartmentId());
                    hosts.setDepartmentName(host.getDepartmentName());
                    hostRepository.save(hosts);
                    return hosts.getId();
                }
            }
            log.info("END Save Host in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save Host in CASE_INFO");
            log.error("ERROR Save Host in CASE_INFO");
        }
        return 0;
    }

    @Override
    public LstHost getHost(int caseId) {
        LstHost lstHost = new LstHost();
        List<Host> lstHosts = hostRepository.findAllByCaseId(caseId);
        for (Host host : lstHosts) {
            HostModel hostModel = new HostModel();
            hostModel.setCaseId(caseId);
            hostModel.setDepartmentId(host.getDepartmentId());
            hostModel.setDepartmentName(host.getDepartmentName());
            lstHost.addHostModelItem(hostModel);
        }
        return lstHost;
    }

    @Override
    public int saveCadresInfo(CaseInfoModel caseInfo, int caseId) {
        log.info("Save CadresInfo in CASE_INFO");

        try {
            log.info("START Save CadresInfoost in CASE_INFO");
            List<CadresInfor> cadresInfors = cadresInforRepository.findAllByCaseId(caseId);
            if (cadresInfors.size() > 0) {
                cadresInforRepository.deleteAll(cadresInfors);
                for (CadresInforModel cadresinfor : caseInfo.getLstCadresInfor().getCadresInforModel()) {
                    CadresInfor cadresinfors = new CadresInfor();
                    cadresinfors.setCaseId(caseId);
                    cadresinfors.setUserId(cadresinfor.getUserId());
                    cadresinfors.setFullName(cadresinfor.getFullName());
                    cadresinfors.setJobTitle(cadresinfor.getJobTitle());
                    cadresinfors.setEmail(cadresinfor.getEmail());
                    cadresinfors.setPhoneNumber(cadresinfor.getPhoneNumber());
                    cadresinfors.setUserName(cadresinfor.getUserName());
                    cadresinfors.setBds(cadresinfor.getBds());
                    cadresinfors.setCra(cadresinfor.getCra());
                    cadresinfors.setBrn(cadresinfor.getBrn());
                    cadresinfors.setBranch(cadresinfor.getBranch());
                    cadresinfors.setDepartmentCode(cadresinfor.getDeparmentCode());
                    cadresinfors.setDepartment(cadresinfor.getDepartment());
                    cadresinfors.setBrnLevel(cadresinfor.getBrnLevel());
                    cadresinfors.setGroupXl(cadresinfor.getGroupXL());
                    cadresinfors.setConfirm(cadresinfor.getConfirm());
                    cadresinfors.setQualification(cadresinfor.getQualification());
                    cadresinfors.setContributePercent(cadresinfor.getContributePercent());
                    cadresinfors.setDateOfBirth(Util.getDates(cadresinfor.getDateofBirth()));
                    cadresInforRepository.save(cadresinfors);
                    return cadresinfors.getId();
                }
            } else {
                for (CadresInforModel cadresinfor : caseInfo.getLstCadresInfor().getCadresInforModel()) {
                    CadresInfor cadresinfors = new CadresInfor();
                    cadresinfors.setCaseId(caseId);
                    cadresinfors.setUserId(cadresinfor.getUserId());
                    cadresinfors.setFullName(cadresinfor.getFullName());
                    cadresinfors.setJobTitle(cadresinfor.getJobTitle());
                    cadresinfors.setEmail(cadresinfor.getEmail());
                    cadresinfors.setPhoneNumber(cadresinfor.getPhoneNumber());
                    cadresinfors.setUserName(cadresinfor.getUserName());
                    cadresinfors.setBds(cadresinfor.getBds());
                    cadresinfors.setCra(cadresinfor.getCra());
                    cadresinfors.setBrn(cadresinfor.getBrn());
                    cadresinfors.setBranch(cadresinfor.getBranch());
                    cadresinfors.setDepartmentCode(cadresinfor.getDeparmentCode());
                    cadresinfors.setDepartment(cadresinfor.getDepartment());
                    cadresinfors.setBrnLevel(cadresinfor.getBrnLevel());
                    cadresinfors.setGroupXl(cadresinfor.getGroupXL());
                    cadresinfors.setConfirm(cadresinfor.getConfirm());
                    cadresinfors.setQualification(cadresinfor.getQualification());
                    cadresinfors.setContributePercent(cadresinfor.getContributePercent());
                    cadresinfors.setDateOfBirth(Util.getDates(cadresinfor.getDateofBirth()));
                    cadresInforRepository.save(cadresinfors);
                    return cadresinfors.getId();

                }
            }

            log.info("END Save CadresInfo in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save CadresInfo in CASE_INFO");
            log.error("ERROR Save CadresInfo in CASE_INFO");
        }
        return 0;
    }


    @Override
    public void saveContentChange(CaseInfoModel caseInfo, int caseId, int hostId, int cadresInfo) {
        ContentChange contentchanges = null;
        try {
            log.info("START Save ContentChange in CASE_INFO");
            if (hostId == 0 || cadresInfo == 0) {
                return;
            }
            List<ContentChange> contentChanges = contentChangeRepository.findAllByCaseId(caseId);
            if (contentChanges.size() > 0) {
                contentChangeRepository.deleteAll(contentChanges);
                for (ContentChangeModel contentchange : caseInfo.getLstContentChange().getContentChangeModel()) {
                    contentchanges = new ContentChange();
                    contentchanges.setCaseId(caseId);
                    contentchanges.setStartDate(Util.getDates(contentchange.getStartDate()));
                    contentchanges.setEndDate(Util.getDates(contentchange.getEndDate()));
                    contentchanges.setChangeTimeReason(contentchange.getChangeTimeReason());
                    contentchanges.setHost(hostId);
                    contentchanges.setOwner(cadresInfo);
                    contentchanges.setChangeHostReason(contentchange.getChangeHostReason());
                    contentChangeRepository.save(contentchanges);
                }
            } else {
                for (ContentChangeModel contentchange : caseInfo.getLstContentChange().getContentChangeModel()) {
                    contentchanges = new ContentChange();
                    contentchanges.setCaseId(caseId);
                    contentchanges.setStartDate(Util.getDates(contentchange.getStartDate()));
                    contentchanges.setEndDate(Util.getDates(contentchange.getEndDate()));
                    contentchanges.setChangeTimeReason(contentchange.getChangeTimeReason());
                    contentchanges.setHost(hostId);
                    contentchanges.setOwner(cadresInfo);
                    contentchanges.setChangeHostReason(contentchange.getChangeHostReason());
                    contentChangeRepository.save(contentchanges);
                }
            }
            log.info("END Save ContentChange in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save ContentChange in CASE_INFO");
            log.error("ERROR Save ContentChange in CASE_INFO");
        }
    }

    @Override
    public LstContentChange getLstConChange(int caseId) {
        LstContentChange lstContentChange = new LstContentChange();
        List<ContentChange> contentChanges = contentChangeRepository.findAllByCaseId(caseId);
        for (ContentChange c : contentChanges) {
            ContentChangeModel changeModel = new ContentChangeModel();
            changeModel.setCaseId(caseId);
            changeModel.setStartDate(Util.convertDateToString(c.getStartDate()));
            changeModel.setEndDate(Util.convertDateToString(c.getEndDate()));
            changeModel.setChangeTimeReason(c.getChangeTimeReason());
            changeModel.setChangeHostReason(c.getChangeHostReason());
            lstContentChange.addContentChangeModelItem(changeModel);
        }
        return lstContentChange;
    }

    @Override
    public void saveResultUtillChange(CaseInfoModel caseInfo, int caseId) {
        try {
            log.info("START Save ResultUtillChange in CASE_INFO");
            List<ResultUtillChange> resultUtillChanges = resultUtillChangeRepository.findAllByCaseId(caseId);
            if (resultUtillChanges.size() > 0) {
                resultUtillChangeRepository.deleteAll(resultUtillChanges);
                for (ResultUntillChangeModel untillChangeModel : caseInfo.getLstResultUntillChange().getResultUntillChangeModel()) {
                    ResultUtillChange resultUtillChange = new ResultUtillChange();
                    resultUtillChange.setCaseId(caseId);
                    resultUtillChange.setActualProduct(untillChangeModel.getActualProduct());
                    resultUtillChange.setExpectProduct(untillChangeModel.getExpectProduct());
                    resultUtillChangeRepository.save(resultUtillChange);
                }
            } else {
                for (ResultUntillChangeModel untillChangeModel : caseInfo.getLstResultUntillChange().getResultUntillChangeModel()) {
                    ResultUtillChange resultUtillChange = new ResultUtillChange();
                    resultUtillChange.setCaseId(caseId);
                    resultUtillChange.setActualProduct(untillChangeModel.getActualProduct());
                    resultUtillChange.setExpectProduct(untillChangeModel.getExpectProduct());
                    resultUtillChangeRepository.save(resultUtillChange);
                }
            }
            log.info("END Save ResultUtillChange in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save ResultUtillChange in CASE_INFO");
            log.error("ERROR Save ResultUtillChange in CASE_INFO");
        }
    }

    @Override
    public void saveCoHostHistory(CaseInfoModel svCaseInfo, int caseId) {
        log.info("Save CoHostHistory in CASE_INFO");
        try {
            log.info("START Save CoHostHistory in CASE_INFO");
            if (caseId == 0) {
                return;
            }
            List<CoHostHistory> coHosts = coHostHistoryRepository.getCoHostHist(svCaseInfo.getProjectCode());
            if (coHosts.size() > 0 && Util.listUpdate().contains(svCaseInfo.getStatus())) {
                coHostHistoryRepository.deleteAll(coHosts);
                for (CoHostModel coHost : svCaseInfo.getLstCoHost().getCoHostModel()) {
                    CoHostHistory cohosts = new CoHostHistory();
                    cohosts.setCaseId(caseId);
                    cohosts.setDepartmentId(coHost.getDepartmentId());
                    cohosts.setDepartmentName(coHost.getDepartmentName());
                    coHostHistoryRepository.save(cohosts);
                }
            } else {
                if (Util.listStatusNewCase().contains(svCaseInfo.getStatus())) {
                    for (CoHostModel coHost : svCaseInfo.getLstCoHost().getCoHostModel()) {
                        CoHostHistory cohosts = new CoHostHistory();
                        cohosts.setId(coHost.getId());
                        cohosts.setCaseId(caseId);
                        cohosts.setDepartmentId(coHost.getDepartmentId());
                        cohosts.setDepartmentName(coHost.getDepartmentName());
                        coHostHistoryRepository.save(cohosts);
                    }
                }
            }

            log.info("END Save CoHostHistory in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("WARN Save CoHostHistory in CASE_INFO");
            log.error("ERROR Save CoHostHistory in CASE_INFO");
        }
    }

    @Override
    public void saveListIniCouncil(CaseInfoModel caseinfo, int caseId) {
        log.info("SAVE ListIniCouncil IN CASE_INFO");
        try {
            log.info("START ListIniCouncil  IN CASE_INFO");
            List<ListIniCouncil> listIniCouncils = listIniCouncilRepository.findAllByCaseId(caseId);
            if (listIniCouncils.size() > 0) {
                listIniCouncilRepository.deleteAll(listIniCouncils);
                for (ListIniCouncilModel lstListMember : caseinfo.getLstListIniCouncil().getListIniCouncilModel()) {
                    ListIniCouncil listIniCouncil = new ListIniCouncil();
                    listIniCouncil.setCaseId(caseId);
                    listIniCouncil.setUserId(lstListMember.getUserId());
                    listIniCouncil.setFullName(lstListMember.getFullName());
                    listIniCouncil.setJobTitle(lstListMember.getJobTitle());
                    listIniCouncil.setEmail(lstListMember.getEmail());
                    listIniCouncil.setPhoneNumber(lstListMember.getPhoneNumber());
                    listIniCouncil.setUserName(lstListMember.getUserName());
                    listIniCouncil.setBds(lstListMember.getBds());
                    listIniCouncil.setCra(lstListMember.getCra());
                    listIniCouncil.setBrn(lstListMember.getBrn());
                    listIniCouncil.setBranch(lstListMember.getBranch());
                    listIniCouncil.setDepartmentCode(lstListMember.getDeparmentCode());
                    listIniCouncil.setDepartment(lstListMember.getDepartment());
                    listIniCouncil.setBrnLevel(lstListMember.getBrnLevel());
                    listIniCouncil.setGroupXl(lstListMember.getGroupXL());
                    listIniCouncil.setConfirm(lstListMember.getConfirm());
                    listIniCouncil.setAverage(lstListMember.getAverage());
                    listIniCouncil.setConclusion(lstListMember.getConclusion());
                    listIniCouncil.setDateOfBirth(Util.getDates(lstListMember.getDateofBirth()));
                    listIniCouncilRepository.save(listIniCouncil);
                }
            } else {
                for (ListIniCouncilModel lstListMember : caseinfo.getLstListIniCouncil().getListIniCouncilModel()) {
                    ListIniCouncil listIniCouncil = new ListIniCouncil();
                    listIniCouncil.setCaseId(caseId);
                    listIniCouncil.setUserId(lstListMember.getUserId());
                    listIniCouncil.setFullName(lstListMember.getFullName());
                    listIniCouncil.setJobTitle(lstListMember.getJobTitle());
                    listIniCouncil.setEmail(lstListMember.getEmail());
                    listIniCouncil.setPhoneNumber(lstListMember.getPhoneNumber());
                    listIniCouncil.setUserName(lstListMember.getUserName());
                    listIniCouncil.setBds(lstListMember.getBds());
                    listIniCouncil.setCra(lstListMember.getCra());
                    listIniCouncil.setBrn(lstListMember.getBrn());
                    listIniCouncil.setBranch(lstListMember.getBranch());
                    listIniCouncil.setDepartmentCode(lstListMember.getDeparmentCode());
                    listIniCouncil.setDepartment(lstListMember.getDepartment());
                    listIniCouncil.setBrnLevel(lstListMember.getBrnLevel());
                    listIniCouncil.setGroupXl(lstListMember.getGroupXL());
                    listIniCouncil.setConfirm(lstListMember.getConfirm());
                    listIniCouncil.setAverage(lstListMember.getAverage());
                    listIniCouncil.setConclusion(lstListMember.getConclusion());
                    listIniCouncil.setDateOfBirth(Util.getDates(lstListMember.getDateofBirth()));
                    listIniCouncilRepository.save(listIniCouncil);
                }
            }
            log.info("END SAVE ListIniCouncil IN CASE_INFO");
        } catch (
                Exception e) {
            e.printStackTrace();
            log.error("ERROR  SAVE ListIniCouncil IN CASE_INFO");
        }

    }


}
