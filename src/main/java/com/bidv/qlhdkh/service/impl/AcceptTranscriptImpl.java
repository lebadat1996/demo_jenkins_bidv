package com.bidv.qlhdkh.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidv.qlhdkh.entity.AcceptTranscript;
import com.bidv.qlhdkh.model.AcceptTranscriptModel;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.repository.AcceptTranscriptRepository;
import com.bidv.qlhdkh.service.AcceptTranscriptService;

@Service
public class AcceptTranscriptImpl implements AcceptTranscriptService {
    private static final Logger log = LoggerFactory.getLogger(CaseInfoServiceImpl.class);

    @Autowired
    AcceptTranscriptRepository transcriptRepository;

    @Override
    public void saveAcceptTranscript(CaseInfoModel svCaseInfo, int caseId) {
        log.info("Save AcceptTranscript in CASE_INFO");
        try {
            List<AcceptTranscript> acceptTranscripts = transcriptRepository.findAllByCaseId(caseId);
            log.info("START Save AcceptTranscript in CASE_INFO");
            if (acceptTranscripts.size() > 0) {
                transcriptRepository.deleteAll(acceptTranscripts);
                for (AcceptTranscriptModel accepttranscript : svCaseInfo.getLstAcceptTranscript().getAcceptTranscriptModel()) {
                    AcceptTranscript accepttranscripts = new AcceptTranscript();
                    accepttranscripts.setCaseId(caseId);
                    accepttranscripts.setNescesaryScore(accepttranscript.getNescesaryScore());
                    accepttranscripts.setSuiableScore(accepttranscript.getSuiableScore());
                    accepttranscripts.setProgressScore(accepttranscript.getProgressScore());
                    accepttranscripts.setQualityScore(accepttranscript.getQualityScore());
                    accepttranscripts.setRealityScore(accepttranscript.getRealityScore());
                    accepttranscripts.setContributeScore(accepttranscript.getContributeScore());
                    accepttranscripts.setEffecScore(accepttranscript.getEffecScore());
                    accepttranscripts.setRangeScore(accepttranscript.getRangeScore());
                    accepttranscripts.setAbilityDevelop(accepttranscript.getAbilityDevelop());
                    accepttranscripts.setSpecificReview(accepttranscript.getSpecificReview());
                    accepttranscripts.setContentConclusion(accepttranscript.getContentConclusion());
                    accepttranscripts.setAuthor(accepttranscript.getAuthor());
                    transcriptRepository.save(accepttranscripts);
                }
            }else {
                for (AcceptTranscriptModel accepttranscript : svCaseInfo.getLstAcceptTranscript().getAcceptTranscriptModel()) {
                    AcceptTranscript accepttranscripts = new AcceptTranscript();
                    accepttranscripts.setCaseId(caseId);
                    accepttranscripts.setNescesaryScore(accepttranscript.getNescesaryScore());
                    accepttranscripts.setSuiableScore(accepttranscript.getSuiableScore());
                    accepttranscripts.setProgressScore(accepttranscript.getProgressScore());
                    accepttranscripts.setQualityScore(accepttranscript.getQualityScore());
                    accepttranscripts.setRealityScore(accepttranscript.getRealityScore());
                    accepttranscripts.setContributeScore(accepttranscript.getContributeScore());
                    accepttranscripts.setEffecScore(accepttranscript.getEffecScore());
                    accepttranscripts.setRangeScore(accepttranscript.getRangeScore());
                    accepttranscripts.setAbilityDevelop(accepttranscript.getAbilityDevelop());
                    accepttranscripts.setSpecificReview(accepttranscript.getSpecificReview());
                    accepttranscripts.setContentConclusion(accepttranscript.getContentConclusion());
                    accepttranscripts.setAuthor(accepttranscript.getAuthor());
                    transcriptRepository.save(accepttranscripts);
                }
            }

            log.info("END Save CoHost in CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("ERROR Save CoHost in CASE_INFO");
        }
    }
}
