package com.bidv.qlhdkh.service.impl;

import com.bidv.qlhdkh.entity.ListAcceprtCouncil;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.ListAcceprtCouncilModel;

import com.bidv.qlhdkh.model.LstListAcceprtCouncil;
import com.bidv.qlhdkh.repository.ListAcceptCouncilRepository;
import com.bidv.qlhdkh.service.ListAcceptCouncilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAcceptCouncilServiceImpl implements ListAcceptCouncilService {
    private static final Logger log = LoggerFactory.getLogger(CaseInfoServiceImpl.class);

    @Autowired
    ListAcceptCouncilRepository acceptCouncilRepository;

    @Override
    public void saveListAcceptCouncilS(CaseInfoModel svCaseInfo, int caseId) {
        log.info("SAVE ListAcceptCouncil IN CASE_INFO");
        try {
            log.info("START ListAcceptCouncil Party IN CASE_INFO");
            List<ListAcceprtCouncil> listAcceprtCouncil = acceptCouncilRepository.findAllByCaseId(caseId);
            if (listAcceprtCouncil.size() > 0) {
                acceptCouncilRepository.deleteAll(listAcceprtCouncil);
                for (ListAcceprtCouncilModel listacceprtcouncil : svCaseInfo.getLstListAcceprtCouncil().getListAcceprtCouncilModel()) {
                    ListAcceprtCouncil listacceprtcouncils = new ListAcceprtCouncil();
                    listacceprtcouncils.setId(listacceprtcouncil.getId());
                    listacceprtcouncils.setCaseId(caseId);
                    listacceprtcouncils.setUserId(listacceprtcouncil.getUserId());
                    listacceprtcouncils.setFullName(listacceprtcouncil.getFullName());
                    listacceprtcouncils.setJobTitle(listacceprtcouncil.getJobTitle());
                    listacceprtcouncils.setEmail(listacceprtcouncil.getEmail());
                    listacceprtcouncils.setPhoneNumber(listacceprtcouncil.getPhoneNumber());
                    listacceprtcouncils.setUserName(listacceprtcouncil.getUserName());
                    listacceprtcouncils.setBds(listacceprtcouncil.getBds());
                    listacceprtcouncils.setCra(listacceprtcouncil.getCra());
                    listacceprtcouncils.setBrn(listacceprtcouncil.getBrn());
                    listacceprtcouncils.setBranch(listacceprtcouncil.getBranch());
                    listacceprtcouncils.setDepartmentCode(listacceprtcouncil.getDeparmentCode());
                    listacceprtcouncils.setDepartment(listacceprtcouncil.getDepartment());
                    listacceprtcouncils.setBrnLevel(listacceprtcouncil.getBrnLevel());
                    listacceprtcouncils.setGroupXl(listacceprtcouncil.getGroupXL());
                    listacceprtcouncils.setConfirm(listacceprtcouncil.getConfirm());
                    listacceprtcouncils.setQualification(listacceprtcouncil.getQualification());
                    listacceprtcouncils.setContributePercent(listacceprtcouncil.getContributePercent());
                    acceptCouncilRepository.save(listacceprtcouncils);
                }
            } else {
                for (ListAcceprtCouncilModel listacceprtcouncil : svCaseInfo.getLstListAcceprtCouncil().getListAcceprtCouncilModel()) {
                    ListAcceprtCouncil listacceprtcouncils = new ListAcceprtCouncil();
                    listacceprtcouncils.setId(listacceprtcouncil.getId());
                    listacceprtcouncils.setCaseId(caseId);
                    listacceprtcouncils.setUserId(listacceprtcouncil.getUserId());
                    listacceprtcouncils.setFullName(listacceprtcouncil.getFullName());
                    listacceprtcouncils.setJobTitle(listacceprtcouncil.getJobTitle());
                    listacceprtcouncils.setEmail(listacceprtcouncil.getEmail());
                    listacceprtcouncils.setPhoneNumber(listacceprtcouncil.getPhoneNumber());
                    listacceprtcouncils.setUserName(listacceprtcouncil.getUserName());
                    listacceprtcouncils.setBds(listacceprtcouncil.getBds());
                    listacceprtcouncils.setCra(listacceprtcouncil.getCra());
                    listacceprtcouncils.setBrn(listacceprtcouncil.getBrn());
                    listacceprtcouncils.setBranch(listacceprtcouncil.getBranch());
                    listacceprtcouncils.setDepartmentCode(listacceprtcouncil.getDeparmentCode());
                    listacceprtcouncils.setDepartment(listacceprtcouncil.getDepartment());
                    listacceprtcouncils.setBrnLevel(listacceprtcouncil.getBrnLevel());
                    listacceprtcouncils.setGroupXl(listacceprtcouncil.getGroupXL());
                    listacceprtcouncils.setConfirm(listacceprtcouncil.getConfirm());
                    listacceprtcouncils.setQualification(listacceprtcouncil.getQualification());
                    listacceprtcouncils.setContributePercent(listacceprtcouncil.getContributePercent());
                    acceptCouncilRepository.save(listacceprtcouncils);
                }
            }

            log.info("END SAVE ListAcceptCouncil IN CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("ERROR  SAVE ListAcceptCouncil IN CASE_INFO");
        }
    }

    @Override
    public LstListAcceprtCouncil getAcceptCouncil(int caseId) {
        LstListAcceprtCouncil lstListAcceprtCouncil = new LstListAcceprtCouncil();
        List<ListAcceprtCouncil> acceprtCouncils = acceptCouncilRepository.findAllByCaseId(caseId);
        for (ListAcceprtCouncil listacceprtcouncil: acceprtCouncils){
            ListAcceprtCouncilModel listacceprtcouncils= new ListAcceprtCouncilModel();
            listacceprtcouncils.setId(listacceprtcouncil.getId());
            listacceprtcouncils.setCaseId(caseId);
            listacceprtcouncils.setUserId(listacceprtcouncil.getUserId());
            listacceprtcouncils.setFullName(listacceprtcouncil.getFullName());
            listacceprtcouncils.setJobTitle(listacceprtcouncil.getJobTitle());
            listacceprtcouncils.setEmail(listacceprtcouncil.getEmail());
            listacceprtcouncils.setPhoneNumber(listacceprtcouncil.getPhoneNumber());
            listacceprtcouncils.setUserName(listacceprtcouncil.getUserName());
            listacceprtcouncils.setBds(listacceprtcouncil.getBds());
            listacceprtcouncils.setCra(listacceprtcouncil.getCra());
            listacceprtcouncils.setBrn(listacceprtcouncil.getBrn());
            listacceprtcouncils.setBranch(listacceprtcouncil.getBranch());
            listacceprtcouncils.setDeparmentCode(listacceprtcouncil.getDepartmentCode());
            listacceprtcouncils.setDepartment(listacceprtcouncil.getDepartment());
            listacceprtcouncils.setBrnLevel(listacceprtcouncil.getBrnLevel());
            listacceprtcouncils.setGroupXL(listacceprtcouncil.getGroupXl());
            listacceprtcouncils.setConfirm(listacceprtcouncil.getConfirm());
            listacceprtcouncils.setQualification(listacceprtcouncil.getQualification());
            listacceprtcouncils.setContributePercent(listacceprtcouncil.getContributePercent());
            lstListAcceprtCouncil.addListAcceprtCouncilModelItem(listacceprtcouncils);
        }
        return lstListAcceprtCouncil;
    }
}
