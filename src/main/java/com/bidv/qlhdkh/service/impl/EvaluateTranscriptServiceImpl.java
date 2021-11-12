package com.bidv.qlhdkh.service.impl;

import com.bidv.qlhdkh.entity.EvaluateTranscript;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.EvaluateTranscriptModel;
import com.bidv.qlhdkh.model.LstEvaluateTranscript;
import com.bidv.qlhdkh.repository.EvaluateTranscriptRepository;
import com.bidv.qlhdkh.service.EvaluateTranscriptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class EvaluateTranscriptServiceImpl implements EvaluateTranscriptService {
    private static final Logger log = LoggerFactory.getLogger(ListCouncillServiceImpl.class);

    @Autowired
    EvaluateTranscriptRepository evaluateTranscriptRepository;

    @Override
    public void saveListEvaluateTranscript(CaseInfoModel svCaseInfo, int caseId) throws ParseException {
        log.info("SAVE ListEvaluateTranscript IN CASE_INFO");
        List<EvaluateTranscript> transcriptList = evaluateTranscriptRepository.getAllByCaseIdss(caseId);
        try {
            if (transcriptList.size() > 0) {
                evaluateTranscriptRepository.deleteAll(transcriptList);
                log.info("START ListEvaluateTranscript Party IN CASE_INFO");
                for (EvaluateTranscriptModel model : svCaseInfo.getLstEvaluateTranscript().getEvaluateTranscriptModel()) {
                    EvaluateTranscript evaluatetranscripts = new EvaluateTranscript();
                    evaluatetranscripts.setCaseId(caseId);
                    evaluatetranscripts.setClearScore(model.getClearScore());
                    evaluatetranscripts.setTargetScore(model.getTargetScore());
                    evaluatetranscripts.setContentScore(model.getContentScore());
                    evaluatetranscripts.setMethodScore(model.getMethodScore());
                    evaluatetranscripts.setSatifyScore(model.getSatifyScore());
                    evaluatetranscripts.setBenefitScore(model.getBenefitScore());
                    evaluatetranscripts.setRealityScore(model.getRealityScore());
                    evaluatetranscripts.setProgressScore(model.getProgressScore());
                    evaluatetranscripts.setAbilityOwner(model.getAbilityOwner());
                    evaluatetranscripts.setEvaluateBudget(model.getEvaluateBudget());
                    evaluatetranscripts.setBudgetComment(model.getBudgetComment());
                    evaluatetranscripts.setConclusion(model.getConclusion());
                    evaluatetranscripts.setContentConclusion(model.getContentConclusion());
                    evaluatetranscripts.setEstimateConclusion(model.getEstimateConclusion());
                    evaluatetranscripts.setSum(model.getSum());
                    evaluatetranscripts.setAuthor(model.getAuthor());
                    evaluateTranscriptRepository.save(evaluatetranscripts);
                }
            } else {
                log.info("START ListEvaluateTranscript Party IN CASE_INFO");
                for (EvaluateTranscriptModel model : svCaseInfo.getLstEvaluateTranscript().getEvaluateTranscriptModel()) {
                    EvaluateTranscript evaluatetranscripts = new EvaluateTranscript();
                    evaluatetranscripts.setCaseId(caseId);
                    evaluatetranscripts.setClearScore(model.getClearScore());
                    evaluatetranscripts.setTargetScore(model.getTargetScore());
                    evaluatetranscripts.setContentScore(model.getContentScore());
                    evaluatetranscripts.setMethodScore(model.getMethodScore());
                    evaluatetranscripts.setSatifyScore(model.getSatifyScore());
                    evaluatetranscripts.setBenefitScore(model.getBenefitScore());
                    evaluatetranscripts.setRealityScore(model.getRealityScore());
                    evaluatetranscripts.setProgressScore(model.getProgressScore());
                    evaluatetranscripts.setAbilityOwner(model.getAbilityOwner());
                    evaluatetranscripts.setEvaluateBudget(model.getEvaluateBudget());
                    evaluatetranscripts.setBudgetComment(model.getBudgetComment());
                    evaluatetranscripts.setConclusion(model.getConclusion());
                    evaluatetranscripts.setContentConclusion(model.getContentConclusion());
                    evaluatetranscripts.setEstimateConclusion(model.getEstimateConclusion());
                    evaluatetranscripts.setSum(model.getSum());
                    evaluatetranscripts.setAuthor(model.getAuthor());
                    evaluateTranscriptRepository.save(evaluatetranscripts);
                }
            }
            log.info("End ListEvaluateTranscript Party IN CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error ListEvaluateTranscript Party IN CASE_INFO");
        }
    }

    @Override
    public LstEvaluateTranscript getLstEvaluateTran(int caseId) {
        LstEvaluateTranscript lstEvaluateTranscript = new LstEvaluateTranscript();
        List<EvaluateTranscript> evaluateTranscripts = evaluateTranscriptRepository.getAllByCaseIdss(caseId);
        for (EvaluateTranscript model : evaluateTranscripts) {
            EvaluateTranscriptModel evaluatetranscripts = new EvaluateTranscriptModel();
            evaluatetranscripts.setCaseId(caseId);
            evaluatetranscripts.setClearScore(model.getClearScore());
            evaluatetranscripts.setTargetScore(model.getTargetScore());
            evaluatetranscripts.setContentScore(model.getContentScore());
            evaluatetranscripts.setMethodScore(model.getMethodScore());
            evaluatetranscripts.setSatifyScore(model.getSatifyScore());
            evaluatetranscripts.setBenefitScore(model.getBenefitScore());
            evaluatetranscripts.setRealityScore(model.getRealityScore());
            evaluatetranscripts.setProgressScore(model.getProgressScore());
            evaluatetranscripts.setAbilityOwner(model.getAbilityOwner());
            evaluatetranscripts.setEvaluateBudget(model.getEvaluateBudget());
            evaluatetranscripts.setBudgetComment(model.getBudgetComment());
            evaluatetranscripts.setConclusion(model.getConclusion());
            evaluatetranscripts.setContentConclusion(model.getContentConclusion());
            evaluatetranscripts.setEstimateConclusion(model.getEstimateConclusion());
            evaluatetranscripts.setSum(model.getSum());
            evaluatetranscripts.setAuthor(model.getAuthor());
            lstEvaluateTranscript.addEvaluateTranscriptModelItem(evaluatetranscripts);
        }
        return lstEvaluateTranscript;
    }
}
