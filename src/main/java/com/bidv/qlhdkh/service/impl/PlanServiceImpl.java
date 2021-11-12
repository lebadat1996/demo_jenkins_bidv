package com.bidv.qlhdkh.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidv.qlhdkh.entity.AcceptTranscript;
import com.bidv.qlhdkh.entity.CadresInfor;
import com.bidv.qlhdkh.entity.EstimateBudget;
import com.bidv.qlhdkh.entity.Party;
import com.bidv.qlhdkh.entity.Plan;
import com.bidv.qlhdkh.entity.ReTranScript;
import com.bidv.qlhdkh.model.AcceptTranscriptModel;
import com.bidv.qlhdkh.model.CadresInforModel;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.EstimateBudgetModel;
import com.bidv.qlhdkh.model.LstAcceptTranscript;
import com.bidv.qlhdkh.model.LstCadresInfor;
import com.bidv.qlhdkh.model.LstEstimateBudget;
import com.bidv.qlhdkh.model.LstParty;
import com.bidv.qlhdkh.model.LstPlan;
import com.bidv.qlhdkh.model.LstReTranscript;
import com.bidv.qlhdkh.model.PartyModel;
import com.bidv.qlhdkh.model.PlanModel;
import com.bidv.qlhdkh.model.ReTranscriptModel;
import com.bidv.qlhdkh.repository.AcceptTranscriptRepository;
import com.bidv.qlhdkh.repository.CadresInforRepository;
import com.bidv.qlhdkh.repository.EstimateBudgetRepository;
import com.bidv.qlhdkh.repository.PartyRepository;
import com.bidv.qlhdkh.repository.PlanRepository;
import com.bidv.qlhdkh.repository.ReTranscriptRepository;
import com.bidv.qlhdkh.service.PlanService;
import com.bidv.qlhdkh.util.Util;

@Service
public class PlanServiceImpl implements PlanService {
    private static final Logger log = LoggerFactory.getLogger(CoHostServiceImpl.class);

    @Autowired
    PlanRepository planRepository;
    @Autowired
    ReTranscriptRepository reTranscriptRepository;
    @Autowired
    AcceptTranscriptRepository acceptTranscriptRepository;
    @Autowired
    PartyRepository partyRepository;
    @Autowired
    EstimateBudgetRepository estimateBudgetRepository;
    @Autowired
    CadresInforRepository cadresInforRepository;
    @Override
    public void savePlan(CaseInfoModel svCaseInfo, int caseId) throws ParseException {
        log.info("SAVE PLAN IN CASE_INFO");
        try {
            log.info("START SAVE PLAN IN CASE_INFO");
            List<Plan> planss = planRepository.findAllByCaseId(caseId);
            if (planss.size() > 0) {
                planRepository.deleteAll(planss);
                for (PlanModel planModel : svCaseInfo.getLstPlan().getPlanModel()) {
                    Plan plans = new Plan();
                    plans.setCaseId(caseId);
                    plans.setContent(planModel.getContent());
                    plans.setResult(planModel.getResult());
                    plans.setStartDate(Util.getDate(planModel.getStartDate()));
                    plans.setEndDate(Util.getDate(planModel.getEndDate()));
                    plans.setAssigneeTo(planModel.getAssigneeTo());
                    planRepository.save(plans);
                }
            } else {
                for (PlanModel planModel : svCaseInfo.getLstPlan().getPlanModel()) {
                    Plan plans = new Plan();
                    plans.setCaseId(caseId);
                    plans.setContent(planModel.getContent());
                    plans.setResult(planModel.getResult());
                    plans.setStartDate(Util.getDate(planModel.getStartDate()));
                    plans.setEndDate(Util.getDate(planModel.getEndDate()));
                    plans.setAssigneeTo(planModel.getAssigneeTo());
                    planRepository.save(plans);
                }
            }
            log.info("END SAVE PLAN IN CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("ERROR  SAVE PLAN IN CASE_INFO");
        }
    }

    @Override
    public LstPlan getPlan(Integer caseId) {
        LstPlan lstPlan = new LstPlan();

        try{
            List<Plan> plans = planRepository.findAllByCaseId(caseId);
            for (Plan plan : plans){
                PlanModel planModel = new PlanModel();
                planModel.setCaseId(caseId);
                planModel.setContent(plan.getContent());
                planModel.setResult(plan.getResult());
                planModel.setStartDate(Util.convertDateToString(plan.getStartDate()));
                planModel.setEndDate(Util.convertDateToString(plan.getEndDate()));
                planModel.setAssigneeTo(plan.getAssigneeTo());
                lstPlan.addPlanModelItem(planModel);
            }
        }catch (Exception e) {
            e.printStackTrace();
            log.error("ERROR  Get PLAN IN CASE_INFO");
        }
        return lstPlan;
    }

    @Override
    public LstReTranscript getReTran(Integer caseId) {
        LstReTranscript lstReTranscript = new LstReTranscript();
        try{
            List<ReTranScript> list= reTranscriptRepository.findAllByCaseId(caseId);
            for (ReTranScript reTranScript:list){
                ReTranscriptModel reTranscriptModel = new ReTranscriptModel();
                reTranscriptModel.setAuthor(reTranScript.getAuthor());
                reTranscriptModel.setCaseId(reTranScript.getCaseId());
                reTranscriptModel.setContent(reTranScript.getContent());
                reTranscriptModel.setInterestAfterYear(reTranScript.getInterestAfterYear());
                reTranscriptModel.setNote(reTranScript.getNote());
                lstReTranscript.addReTranscriptModelItem(reTranscriptModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstReTranscript;
    }

    @Override
    public LstAcceptTranscript getAcceptTran(Integer caseId) {
        LstAcceptTranscript lstAcceptTranscript= new LstAcceptTranscript();

        try{
            List<AcceptTranscript> acceptTranscripts = acceptTranscriptRepository.findAllByCaseId(caseId);
            for (AcceptTranscript accepttranscript: acceptTranscripts){
                AcceptTranscriptModel transcriptModel = new AcceptTranscriptModel();
                transcriptModel.setCaseId(accepttranscript.getCaseId());
                transcriptModel.setNescesaryScore(accepttranscript.getNescesaryScore());
                transcriptModel.setSuiableScore(accepttranscript.getSuiableScore());
                transcriptModel.setProgressScore(accepttranscript.getProgressScore());
                transcriptModel.setQualityScore(accepttranscript.getQualityScore());
                transcriptModel.setRealityScore(accepttranscript.getRealityScore());
                transcriptModel.setContributeScore(accepttranscript.getContributeScore());
                transcriptModel.setEffecScore(accepttranscript.getEffecScore());
                transcriptModel.setRangeScore(accepttranscript.getRangeScore());
                transcriptModel.setAbilityDevelop(accepttranscript.getAbilityDevelop());
                transcriptModel.setSpecificReview(accepttranscript.getSpecificReview());
                transcriptModel.setContentConclusion(accepttranscript.getContentConclusion());
                transcriptModel.setAuthor(accepttranscript.getAuthor());
                lstAcceptTranscript.addAcceptTranscriptModelItem(transcriptModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstAcceptTranscript;
    }

    @Override
    public LstParty getParty(Integer caseId) {
        LstParty lstParty = new LstParty();

        try {
            List<Party> parties = partyRepository.findAllByCaseId(caseId);
                for (Party party : parties) {
                    PartyModel partyModel= new PartyModel();
                    partyModel.setDepartmentId(party.getDepartmentId());
                    partyModel.setCaseId(party.getCaseId());
                    partyModel.setDepartmentName(party.getDepartmentName());
                    lstParty.addPartyModelItem(partyModel);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
        return lstParty;
    }

    @Override
    public LstCadresInfor getCadresInfors(Integer caseId) {
        LstCadresInfor lstCadresInfor= new LstCadresInfor();

        try{
            List<CadresInfor> cadresInfors = cadresInforRepository.findAllByCaseId(caseId);
            for (CadresInfor cadresInfor:cadresInfors){
                CadresInforModel cadresInforModel= new CadresInforModel();
                cadresInforModel.setCaseId(cadresInfor.getCaseId());
                cadresInforModel.setUserId(cadresInfor.getUserId());
                cadresInforModel.setFullName(cadresInfor.getFullName());
                cadresInforModel.setJobTitle(cadresInfor.getJobTitle());
                cadresInforModel.setEmail(cadresInfor.getEmail());
                cadresInforModel.setPhoneNumber(cadresInfor.getPhoneNumber());
                cadresInforModel.setUserName(cadresInfor.getUserName());
                cadresInforModel.setBds(cadresInfor.getBds());
                cadresInforModel.setCra(cadresInfor.getCra());
                cadresInforModel.setBrn(cadresInfor.getBrn());
                cadresInforModel.setBranch(cadresInfor.getBranch());
                cadresInforModel.setDeparmentCode(cadresInfor.getDepartmentCode());
                cadresInforModel.setDepartment(cadresInfor.getDepartment());
                cadresInforModel.setBrnLevel(cadresInfor.getBrnLevel());
                cadresInforModel.setGroupXL(cadresInfor.getGroupXl());
                cadresInforModel.setConfirm(cadresInfor.getConfirm());
                cadresInforModel.setQualification(cadresInfor.getQualification());
                cadresInforModel.setContributePercent(cadresInfor.getContributePercent());
                cadresInforModel.setDateofBirth(Util.convertDateToString(cadresInfor.getDateOfBirth()));
                lstCadresInfor.addCadresInforModelItem(cadresInforModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstCadresInfor;
    }

    @Override
    public LstEstimateBudget getEstimateBudgets(Integer caseId) {
        LstEstimateBudget lstEstimateBudget = new LstEstimateBudget();
        try{
            List<EstimateBudget> estimateBudgetList= estimateBudgetRepository.findAllByCaseId(caseId);
            for (EstimateBudget estimateBudget:estimateBudgetList){
                EstimateBudgetModel estimateBudgetModel = new EstimateBudgetModel();
                estimateBudgetModel.setId(estimateBudget.getId());
                estimateBudgetModel.setCaseId(caseId);
                estimateBudgetModel.setContent(estimateBudget.getContent());
                estimateBudgetModel.setRate(estimateBudget.getRate());
                estimateBudgetModel.setQuanity(estimateBudget.getQuantity());
                estimateBudgetModel.setAmount(estimateBudget.getAmount());
                estimateBudgetModel.setNote(estimateBudget.getNote());
                lstEstimateBudget.addEstimateBudgetModelItem(estimateBudgetModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstEstimateBudget;
    }

    public static Date getSomeDate(final String str, final TimeZone tz)
            throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        sdf.setTimeZone(tz);
        return sdf.parse(str);
    }

}
