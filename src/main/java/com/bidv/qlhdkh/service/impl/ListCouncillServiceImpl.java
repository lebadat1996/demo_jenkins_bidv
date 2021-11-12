package com.bidv.qlhdkh.service.impl;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidv.qlhdkh.entity.ListCouncill;
import com.bidv.qlhdkh.entity.ListIniCouncil;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.ListCouncillModel;
import com.bidv.qlhdkh.model.ListIniCouncilModel;
import com.bidv.qlhdkh.model.LstListCouncill;
import com.bidv.qlhdkh.model.LstListIniCouncil;
import com.bidv.qlhdkh.repository.ListCouncillRepository;
import com.bidv.qlhdkh.repository.ListIniCouncilRepository;
import com.bidv.qlhdkh.service.ListCouncillService;
import com.bidv.qlhdkh.util.Util;

@Service
public class ListCouncillServiceImpl implements ListCouncillService {
    private static final Logger log = LoggerFactory.getLogger(ListCouncillServiceImpl.class);
    @Autowired
    ListCouncillRepository councillRepository;

    @Autowired
    ListIniCouncilRepository iniCouncilRepository;

    @Override
    public void saveListCouncill(CaseInfoModel svCaseInfo, int caseId) throws ParseException {
        log.info("SAVE ListCouncill IN CASE_INFO");
        try {
            log.info("START ListCouncill  IN CASE_INFO");
            List<ListCouncill> listCouncills = councillRepository.findAllByCaseId(caseId);
            if (listCouncills.size() > 0) {
                councillRepository.deleteAll(listCouncills);
                for (ListCouncillModel model : svCaseInfo.getLstListCouncill().getListCouncillModel()) {
                    ListCouncill listinicouncils = new ListCouncill();
                    listinicouncils.setCaseId(caseId);
                    listinicouncils.setUserId(model.getUserId());
                    listinicouncils.setFullName(model.getFullName());
                    listinicouncils.setJobTitle(model.getJobTitle());
                    listinicouncils.setEmail(model.getEmail());
                    listinicouncils.setPhoneNumber(model.getPhoneNumber());
                    listinicouncils.setUserName(model.getUserName());
                    listinicouncils.setBds(model.getBds());
                    listinicouncils.setCra(model.getCra());
                    listinicouncils.setBrn(model.getBrn());
                    listinicouncils.setBranch(model.getBranch());
                    listinicouncils.setDepartmentCode(model.getDeparmentCode());
                    listinicouncils.setDepartment(model.getDepartment());
                    listinicouncils.setBrnLevel(model.getBrnLevel());
                    listinicouncils.setGroupXl(model.getGroupXL());
                    listinicouncils.setConfirm(model.getConfirm());
                    listinicouncils.setQualification(model.getQualification());
                    listinicouncils.setContributePercent(model.getContributePercent());
                    listinicouncils.setDateOfBirth(Util.getDates(model.getDateofBirth()));
                    log.info("DateOfBirth" + model.getDateofBirth());
                    councillRepository.save(listinicouncils);
                }
            } else {
                for (ListCouncillModel model : svCaseInfo.getLstListCouncill().getListCouncillModel()) {
                    ListCouncill listinicouncils = new ListCouncill();
                    listinicouncils.setCaseId(caseId);
                    listinicouncils.setUserId(model.getUserId());
                    listinicouncils.setFullName(model.getFullName());
                    listinicouncils.setJobTitle(model.getJobTitle());
                    listinicouncils.setEmail(model.getEmail());
                    listinicouncils.setPhoneNumber(model.getPhoneNumber());
                    listinicouncils.setUserName(model.getUserName());
                    listinicouncils.setBds(model.getBds());
                    listinicouncils.setCra(model.getCra());
                    listinicouncils.setBrn(model.getBrn());
                    listinicouncils.setBranch(model.getBranch());
                    listinicouncils.setDepartmentCode(model.getDeparmentCode());
                    listinicouncils.setDepartment(model.getDepartment());
                    listinicouncils.setBrnLevel(model.getBrnLevel());
                    listinicouncils.setGroupXl(model.getGroupXL());
                    listinicouncils.setConfirm(model.getConfirm());
                    listinicouncils.setQualification(model.getQualification());
                    listinicouncils.setContributePercent(model.getContributePercent());
                    listinicouncils.setDateOfBirth(Util.getDates(model.getDateofBirth()));
                    log.info("DateOfBirth" + model.getDateofBirth());
                    councillRepository.save(listinicouncils);
                }
                log.info("End ListCouncill  IN CASE_INFO");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error ListCouncill  IN CASE_INFO");
        }
    }

    @Override
    public LstListIniCouncil getIniCouncil(int caseId) {
        LstListIniCouncil lstListIniCouncil = new LstListIniCouncil();

        List<ListIniCouncil> iniCouncils = iniCouncilRepository.findAllByCaseId(caseId);
        for (ListIniCouncil iniCouncil : iniCouncils) {
            ListIniCouncilModel listinicouncils = new ListIniCouncilModel();
            listinicouncils.setCaseId(caseId);
            listinicouncils.setUserId(iniCouncil.getUserId());
            listinicouncils.setFullName(iniCouncil.getFullName());
            listinicouncils.setJobTitle(iniCouncil.getJobTitle());
            listinicouncils.setEmail(iniCouncil.getEmail());
            listinicouncils.setPhoneNumber(iniCouncil.getPhoneNumber());
            listinicouncils.setUserName(iniCouncil.getUserName());
            listinicouncils.setBds(iniCouncil.getBds());
            listinicouncils.setCra(iniCouncil.getCra());
            listinicouncils.setBrn(iniCouncil.getBrn());
            listinicouncils.setBranch(iniCouncil.getBranch());
            listinicouncils.setDeparmentCode(iniCouncil.getDepartmentCode());
            listinicouncils.setDepartment(iniCouncil.getDepartment());
            listinicouncils.setBrnLevel(iniCouncil.getBrnLevel());
            listinicouncils.setGroupXL(iniCouncil.getGroupXl());
            listinicouncils.setConfirm(iniCouncil.getConfirm());
            listinicouncils.setQualification(iniCouncil.getQualification());
            listinicouncils.setContributePercent(iniCouncil.getContributePercent());
            listinicouncils.setDateofBirth(Util.convertDateToString(iniCouncil.getDateOfBirth()));
            lstListIniCouncil.addListIniCouncilModelItem(listinicouncils);
        }
        return lstListIniCouncil;
    }

    @Override
    public LstListCouncill getListCouncill(int caseId) {
        LstListCouncill lstListCouncill = new LstListCouncill();
        List<ListCouncill> listCouncills = councillRepository.findAllByCaseId(caseId);
        for (ListCouncill model : listCouncills) {
            ListCouncillModel listinicouncils = new ListCouncillModel();
            listinicouncils.setCaseId(caseId);
            listinicouncils.setUserId(model.getUserId());
            listinicouncils.setFullName(model.getFullName());
            listinicouncils.setJobTitle(model.getJobTitle());
            listinicouncils.setEmail(model.getEmail());
            listinicouncils.setPhoneNumber(model.getPhoneNumber());
            listinicouncils.setUserName(model.getUserName());
            listinicouncils.setBds(model.getBds());
            listinicouncils.setCra(model.getCra());
            listinicouncils.setBrn(model.getBrn());
            listinicouncils.setBranch(model.getBranch());
            listinicouncils.setDeparmentCode(model.getDepartmentCode());
            listinicouncils.setDepartment(model.getDepartment());
            listinicouncils.setBrnLevel(model.getBrnLevel());
            listinicouncils.setGroupXL(model.getGroupXl());
            listinicouncils.setConfirm(model.getConfirm());
            listinicouncils.setQualification(model.getQualification());
            listinicouncils.setContributePercent(model.getContributePercent());
            listinicouncils.setDateofBirth(Util.convertDateToString(model.getDateOfBirth()));
            lstListCouncill.addListCouncillModelItem(listinicouncils);
        }
        return lstListCouncill;
    }

    @Override
    public LstListCouncill findAllByCouncilId(int councilId) {
        return null;
    }
}
