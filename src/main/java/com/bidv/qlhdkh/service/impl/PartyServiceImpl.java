package com.bidv.qlhdkh.service.impl;

import com.bidv.qlhdkh.entity.Party;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.PartyModel;
import com.bidv.qlhdkh.repository.PartyRepository;
import com.bidv.qlhdkh.service.PartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class PartyServiceImpl implements PartyService {
    private static final Logger log = LoggerFactory.getLogger(CoHostServiceImpl.class);

    @Autowired
    PartyRepository partyRepository;

    @Override
    public void saveParty(CaseInfoModel svCaseInfo, int caseId) throws ParseException {
        log.info("SAVE Party IN CASE_INFO");
        try {
            log.info("START SAVE Party IN CASE_INFO");
            List<Party> parties = partyRepository.findAllByCaseId(caseId);
            if (parties.size() > 0) {
                partyRepository.deleteAll(parties);
                for (PartyModel model : svCaseInfo.getLstParty().getPartyModel()) {
                    Party partys = new Party();
                    partys.setDepartmentId(model.getDepartmentId());
                    partys.setCaseId(caseId);
                    partys.setDepartmentName(model.getDepartmentName());
                    partyRepository.save(partys);
                }
            } else {
                for (PartyModel model : svCaseInfo.getLstParty().getPartyModel()) {
                    Party partys = new Party();
                    partys.setDepartmentId(model.getDepartmentId());
                    partys.setCaseId(caseId);
                    partys.setDepartmentName(model.getDepartmentName());
                    partyRepository.save(partys);
                }
            }
            log.info("END SAVE Party IN CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("ERROR  SAVE Party IN CASE_INFO");
        }
    }
}
