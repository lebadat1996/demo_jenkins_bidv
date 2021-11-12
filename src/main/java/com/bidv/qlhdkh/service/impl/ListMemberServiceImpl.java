package com.bidv.qlhdkh.service.impl;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidv.qlhdkh.entity.CoHostHistory;
import com.bidv.qlhdkh.entity.ListMember;
import com.bidv.qlhdkh.entity.ListMemberHistory;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.CoHostModel;
import com.bidv.qlhdkh.model.ListMemberModel;
import com.bidv.qlhdkh.model.LstCoHost;
import com.bidv.qlhdkh.model.LstListMember;
import com.bidv.qlhdkh.repository.CoHostHistoryRepository;
import com.bidv.qlhdkh.repository.ListMemberHistoryRepository;
import com.bidv.qlhdkh.repository.ListMemberRepository;
import com.bidv.qlhdkh.service.ListMemberService;
import com.bidv.qlhdkh.util.Util;

@Service
public class ListMemberServiceImpl implements ListMemberService {
    private static final Logger log = LoggerFactory.getLogger(ListMemberServiceImpl.class);

    @Autowired
    ListMemberRepository listMemberRepository;
    @Autowired
    ListMemberHistoryRepository memberHistoryRepository;
    @Autowired
    CoHostHistoryRepository coHostHistoryRepository;

    @Override
    public void saveListMember(CaseInfoModel svCaseInfo, int caseId) throws ParseException {
        log.info("SAVE ListMember IN CASE_INFO");
        try {
            log.info("START ListMember  IN CASE_INFO");
            List<ListMember> listmemberss = listMemberRepository.findAllByCaseId(caseId);
            if (listmemberss.size() > 0) {
                listMemberRepository.deleteAll(listmemberss);
                for (ListMemberModel lstListMember : svCaseInfo.getLstListMember().getListMemberModel()) {
                    ListMember listMemberHistory = new ListMember();
                    listMemberHistory.setCaseId(caseId);
                    listMemberHistory.setUserId(lstListMember.getUserId());
                    listMemberHistory.setFullName(lstListMember.getFullName());
                    listMemberHistory.setJobTitle(lstListMember.getJobTitle());
                    listMemberHistory.setEmail(lstListMember.getEmail());
                    listMemberHistory.setPhoneNumber(lstListMember.getPhoneNumber());
                    listMemberHistory.setUserName(lstListMember.getUserName());
                    listMemberHistory.setBds(lstListMember.getBds());
                    listMemberHistory.setCra(lstListMember.getCra());
                    listMemberHistory.setBrn(lstListMember.getBrn());
                    listMemberHistory.setBranch(lstListMember.getBranch());
                    listMemberHistory.setDepartmentCode(lstListMember.getDeparmentCode());
                    listMemberHistory.setDepartment(lstListMember.getDepartment());
                    listMemberHistory.setBrnLevel(lstListMember.getBrnLevel());
                    listMemberHistory.setGroupXl(lstListMember.getGroupXL());
                    listMemberHistory.setConfirm(lstListMember.getConfirm());
                    listMemberHistory.setContributePercent(lstListMember.getContributePercent());
                    listMemberHistory.setQualification(lstListMember.getQualification());
                    listMemberHistory.setDateOfBirth(Util.getDates(lstListMember.getDateofBirth()));
                    listMemberRepository.save(listMemberHistory);
                }
            } else {
                for (ListMemberModel model : svCaseInfo.getLstListMember().getListMemberModel()) {
                    ListMember listmembers = new ListMember();
                    listmembers.setCaseId(caseId);
                    listmembers.setUserId(model.getUserId());
                    listmembers.setFullName(model.getFullName());
                    listmembers.setJobTitle(model.getJobTitle());
                    listmembers.setEmail(model.getEmail());
                    listmembers.setPhoneNumber(model.getPhoneNumber());
                    listmembers.setUserName(model.getUserName());
                    listmembers.setBds(model.getBds());
                    listmembers.setCra(model.getCra());
                    listmembers.setBrn(model.getBrn());
                    listmembers.setBranch(model.getBranch());
                    listmembers.setDepartmentCode(model.getDeparmentCode());
                    listmembers.setDepartment(model.getDepartment());
                    listmembers.setBrnLevel(model.getBrnLevel());
                    listmembers.setGroupXl(model.getGroupXL());
                    listmembers.setConfirm(model.getConfirm());
                    listmembers.setQualification(model.getQualification());
                    listmembers.setContributePercent(model.getContributePercent());
                    listmembers.setDateOfBirth(Util.getDates(model.getDateofBirth()));
                    listMemberRepository.save(listmembers);
                }
            }
            log.info("END SAVE ListMember IN CASE_INFO");
        } catch (
                Exception e) {
            e.printStackTrace();
            log.error("ERROR  SAVE ListMember IN CASE_INFO");
        }

    }

    @Override
    public LstListMember searchListMember(String projectCode) {
        log.info("Search ListMember IN CASE_INFO");
        LstListMember lstListMember = new LstListMember();
        try {
            log.info("Start Search ListMember  IN CASE_INFO");
            List<ListMemberHistory> listMembers = memberHistoryRepository.getListMember(projectCode);
            List<ListMemberHistory> unique = listMembers.stream()
                    .collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(ListMemberHistory::getUserId))),
                            ArrayList::new));
            for (ListMemberHistory model : unique) {
                ListMemberModel listmembers = new ListMemberModel();
                listmembers.setCaseId(model.getCaseId());
                listmembers.setUserId(model.getUserId());
                listmembers.setFullName(model.getFullName());
                listmembers.setJobTitle(model.getJobTitle());
                listmembers.setEmail(model.getEmail());
                listmembers.setPhoneNumber(model.getPhoneNumber());
                listmembers.setUserName(model.getUserName());
                listmembers.setBds(model.getBds());
                listmembers.setCra(model.getCra());
                listmembers.setBrn(model.getBrn());
                listmembers.setBranch(model.getBranch());
                listmembers.setDeparmentCode(model.getDepartmentCode());
                listmembers.setDepartment(model.getDepartment());
                listmembers.setBrnLevel(model.getBrnLevel());
                listmembers.setGroupXL(model.getGroupXl());
                listmembers.setConfirm(model.getConfirm());
                listmembers.setQualification(model.getQualification());
                listmembers.setContributePercent(model.getContributePercent());
                listmembers.setDateofBirth(Util.convertDateToString(model.getDateOfBirth()));
                lstListMember.addListMemberModelItem(listmembers);
            }
            log.info("End Search ListMember  IN CASE_INFO");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("ERROR  Search ListMemberIN CASE_INFO");
        }
        return lstListMember;
    }


    @Override
    public void saveListMemberHistory(CaseInfoModel svCaseInfo, int caseId) {
        log.info("SAVE ListMember IN CASE_INFO");
        try {
            log.info("START ListMemberHistory  IN CASE_INFO");
            if (caseId == 0) {
                return;
            }
            List<ListMemberHistory> listmemberssHistory = memberHistoryRepository.getListMember(svCaseInfo.getProjectCode());
            if (listmemberssHistory.size() > 0 && Util.listUpdate().contains(svCaseInfo.getStatus())) {
                memberHistoryRepository.deleteAll(listmemberssHistory);
                for (ListMemberModel model : svCaseInfo.getLstListMember().getListMemberModel()) {
                    ListMemberHistory listmembers = new ListMemberHistory();
                    listmembers.setCaseId(caseId);
                    listmembers.setUserId(model.getUserId());
                    listmembers.setFullName(model.getFullName());
                    listmembers.setJobTitle(model.getJobTitle());
                    listmembers.setEmail(model.getEmail());
                    listmembers.setPhoneNumber(model.getPhoneNumber());
                    listmembers.setUserName(model.getUserName());
                    listmembers.setBds(model.getBds());
                    listmembers.setCra(model.getCra());
                    listmembers.setBrn(model.getBrn());
                    listmembers.setBranch(model.getBranch());
                    listmembers.setDepartmentCode(model.getDeparmentCode());
                    listmembers.setDepartment(model.getDepartment());
                    listmembers.setBrnLevel(model.getBrnLevel());
                    listmembers.setGroupXl(model.getGroupXL());
                    listmembers.setConfirm(model.getConfirm());
                    listmembers.setQualification(model.getQualification());
                    listmembers.setContributePercent(model.getContributePercent());
                    listmembers.setDateOfBirth(Util.getDates(model.getDateofBirth()));
                    log.info("DateOfBirth" + model.getDateofBirth());
                    memberHistoryRepository.save(listmembers);
                }
            } else {
                if (Util.listStatusNewCase().contains(svCaseInfo.getStatus())) {
                    for (ListMemberModel model : svCaseInfo.getLstListMember().getListMemberModel()) {
                        ListMemberHistory listmembers = new ListMemberHistory();
                        listmembers.setCaseId(caseId);
                        listmembers.setUserId(model.getUserId());
                        listmembers.setFullName(model.getFullName());
                        listmembers.setJobTitle(model.getJobTitle());
                        listmembers.setEmail(model.getEmail());
                        listmembers.setPhoneNumber(model.getPhoneNumber());
                        listmembers.setUserName(model.getUserName());
                        listmembers.setBds(model.getBds());
                        listmembers.setCra(model.getCra());
                        listmembers.setBrn(model.getBrn());
                        listmembers.setBranch(model.getBranch());
                        listmembers.setDepartmentCode(model.getDeparmentCode());
                        listmembers.setDepartment(model.getDepartment());
                        listmembers.setBrnLevel(model.getBrnLevel());
                        listmembers.setGroupXl(model.getGroupXL());
                        listmembers.setConfirm(model.getConfirm());
                        listmembers.setQualification(model.getQualification());
                        listmembers.setContributePercent(model.getContributePercent());
                        listmembers.setDateOfBirth(Util.getDates(model.getDateofBirth()));
                        log.info("DateOfBirth" + model.getDateofBirth());
                        memberHistoryRepository.save(listmembers);
                    }
                }
            }
            log.info("END SAVE ListMember IN CASE_INFO");
        } catch (
                Exception e) {
            e.printStackTrace();
            log.error("ERROR  SAVE ListMember IN CASE_INFO");
        }
    }

    @Override
    public LstCoHost searchListCoHost(String projectCode) {

        LstCoHost lstHost = new LstCoHost();
        List<CoHostHistory> coHostHist = coHostHistoryRepository.getCoHostHist(projectCode);
        for (CoHostHistory coHostHistory : coHostHist) {
            CoHostModel hostModel = new CoHostModel();
            hostModel.setCaseId(coHostHistory.getCaseId());
            hostModel.setDepartmentId(coHostHistory.getDepartmentId());
            hostModel.setDepartmentName(coHostHistory.getDepartmentName());
            lstHost.addCoHostModelItem(hostModel);
        }
        return lstHost;
    }

    @Override
    public LstListMember getMember(Integer caseId) {
        LstListMember lstListMember = new LstListMember();

        try {
            List<ListMember> listMembers = listMemberRepository.findAllByCaseId(caseId);
            for (ListMember lst : listMembers) {
                ListMemberModel listMemberModel = new ListMemberModel();
                listMemberModel.setCaseId(lst.getCaseId());
                listMemberModel.setUserId(lst.getUserId());
                listMemberModel.setFullName(lst.getFullName());
                listMemberModel.setJobTitle(lst.getJobTitle());
                listMemberModel.setEmail(lst.getEmail());
                listMemberModel.setPhoneNumber(lst.getPhoneNumber());
                listMemberModel.setUserName(lst.getUserName());
                listMemberModel.setBds(lst.getBds());
                listMemberModel.setCra(lst.getCra());
                listMemberModel.setBrn(lst.getBrn());
                listMemberModel.setBranch(lst.getBranch());
                listMemberModel.setDeparmentCode(lst.getDepartmentCode());
                listMemberModel.setDepartment(lst.getDepartment());
                listMemberModel.setBrnLevel(lst.getBrnLevel());
                listMemberModel.setGroupXL(lst.getGroupXl());
                listMemberModel.setConfirm(lst.getConfirm());
                listMemberModel.setQualification(lst.getQualification());
                listMemberModel.setContributePercent(lst.getContributePercent());
                listMemberModel.setDateofBirth(Util.convertDateToString(lst.getDateOfBirth()));
                lstListMember.addListMemberModelItem(listMemberModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstListMember;
    }
}
