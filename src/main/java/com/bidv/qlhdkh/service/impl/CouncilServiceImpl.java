package com.bidv.qlhdkh.service.impl;

import com.bidv.qlhdkh.constants.Constants;
import com.bidv.qlhdkh.entity.Council;
import com.bidv.qlhdkh.entity.ListCouncill;
import com.bidv.qlhdkh.model.*;
import com.bidv.qlhdkh.repository.CouncilRepository;
import com.bidv.qlhdkh.repository.ListCouncillRepository;
import com.bidv.qlhdkh.service.CouncilService;
import com.bidv.qlhdkh.util.Util;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CouncilServiceImpl implements CouncilService {
    public static final Logger log = LoggerFactory.getLogger(CouncilServiceImpl.class);

    @Autowired
    CouncilRepository councilRepository;

    @Autowired
    ListCouncillRepository listCouncillRepository;

    @Autowired
    Constants constants;

    @Autowired
    CouncilRepositoryImpl councilRepoCustom;

    @Override
    public LstCouncilModel getAllCouncil() {
        LstCouncilModel lstCouncilModel = new LstCouncilModel();
        try {
            Date date = new Date();
            log.info("GET INFO COUNCIL");
            log.info("Time Start: " + Util.convertDateToString(date));
            ModelMapper modelMapper = new ModelMapper();
            List<Council> councilList = councilRepository.findAll();
            Collections.reverse(councilList);
            log.info("Total CouncilList: " + councilList.size());
            if (councilList.size() > 0) {
                for (Council council : councilList) {
                    CouncilModel councilModel = new CouncilModel();
                    councilModel.setId(council.getId());
                    councilModel.setCouncilId(council.getCouncilId());
                    councilModel.setSubject(council.getSubject());
                    councilModel.setTimeActive(Util.convertDateToString(council.getTimeActive()));
                    councilModel.setDateCreate(Util.convertDateToString(council.getDateCreate()));
                    councilModel.setDateModify(Util.convertDateToString(council.getDateModify()));
                    councilModel.setStatus(council.getStatus());
                    councilModel.setCreator(council.getCreator());
                    councilModel.setModifier(council.getModifier());
                    councilModel.setCouncilName(council.getCouncilName());
                    log.info("CouncilId" + ": " + council.getCouncilId());
                    List<ListCouncill> councilMembers = listCouncillRepository.findAllByCouncilId(councilModel.getId());
                    log.info("Size CouncilMember" + ": " + councilMembers.size());
                    List<ListCouncillModel> memberModels = councilMembers
                            .stream()
                            .map(user -> modelMapper.map(user, ListCouncillModel.class))
                            .collect(Collectors.toList());
                    LstListCouncill lstListCouncill = new LstListCouncill();
                    lstListCouncill.setListCouncillModel(memberModels);
                    councilModel.setLstCouncilMemberModel(lstListCouncill);
                    lstCouncilModel.addCouncilModelItem(councilModel);
                }
            }
            log.info("Get Info Council Time End: " + Util.convertDateToString(date));
            return lstCouncilModel;
        } catch (Exception e) {
            e.printStackTrace();
            return lstCouncilModel;
        }
    }

    @Override
    @Transactional
    public void createCouncil(CouncilModel councilModel) {
        try {
            log.info("Start Save Info Council");
            int councilId = councilModel.getId();
            log.info("CouncilId: " + councilId);
            Optional<Council> getCouncilByCouncilId = councilRepository.getCouncil(councilId);
            if (getCouncilByCouncilId.isPresent()) {
                log.info("Update Info Council");
                Council dataCouncil = getCouncilByCouncilId.get();
                dataCouncil.setCouncilName(councilModel.getCouncilName());
                dataCouncil.setSubject(councilModel.getSubject());
                dataCouncil.setStatus(councilModel.getStatus());
                dataCouncil.setModifier(councilModel.getModifier());
                councilRepository.save(dataCouncil);
                List<ListCouncill> councilMemberList = listCouncillRepository.findAllByCouncilId(councilId);
                log.info("MemberCouncil in Database Size: " + councilMemberList.size());
                if (councilMemberList.size() > 0) {
                    listCouncillRepository.deleteAll(councilMemberList);
                    log.info("MemberCouncil Update Size: " + councilModel.getLstCouncilMemberModel().getListCouncillModel().size());
                    for (ListCouncillModel councilMemberModel : councilModel.getLstCouncilMemberModel().getListCouncillModel()) {
                        createAndUpdateCouncil(councilId, councilMemberModel);
                    }
                }
                log.info("Update Info Council Successful");
            } else {
                Council council = new Council();
                council.setCouncilId(councilModel.getCouncilId());
                council.setCouncilName(councilModel.getCouncilName());
                council.setSubject(councilModel.getSubject());
                log.info("Creator: " + councilModel.getCreator());
                council.setCreator(councilModel.getCreator());
                log.info("Modifier: " + councilModel.getModifier());
                council.setModifier(councilModel.getModifier());
                council.setStatus(councilModel.getStatus());
                log.info("Status: " + councilModel.getStatus());
                council.setDateCreate(Util.getDates(councilModel.getDateCreate()));
                council.setDateModify(Util.getDates(councilModel.getDateModify()));
                council.setTimeActive(Util.getDates(councilModel.getTimeActive()));
                councilRepository.save(council);
                log.info("Size model CouncilMemberModel: " + councilModel.getLstCouncilMemberModel().getListCouncillModel().size());
                for (ListCouncillModel councilMemberModel : councilModel.getLstCouncilMemberModel().getListCouncillModel()) {
                    createAndUpdateCouncil(council.getId(), councilMemberModel);
                }
                log.info("Create Council and MemberCouncil Success !!");
            }
        } catch (Exception e) {
            log.info("Error Create And Update Information Council");
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    private void createAndUpdateCouncil(int councilId, ListCouncillModel councilMemberModel) throws ParseException {
        ListCouncill councilMember = new ListCouncill();
        councilMember.setCouncilId(councilId);
        councilMember.setUserName(councilMemberModel.getUserName());
        councilMember.setUserId(councilMemberModel.getUserId());
        councilMember.setFullName(councilMemberModel.getFullName());
        councilMember.setJobTitle(councilMemberModel.getJobTitle());
        councilMember.setEmail(councilMemberModel.getEmail());
        councilMember.setPhoneNumber(councilMemberModel.getPhoneNumber());
        councilMember.setBds(councilMemberModel.getBds());
        councilMember.setCra(councilMemberModel.getCra());
        councilMember.setBrn(councilMemberModel.getBrn());
        councilMember.setBranch(councilMemberModel.getBranch());
        councilMember.setDepartmentCode(councilMemberModel.getDeparmentCode());
        councilMember.setDepartment(councilMemberModel.getDepartment());
        councilMember.setBrnLevel(councilMemberModel.getBrnLevel());
        councilMember.setGroupXl(councilMemberModel.getGroupXL());
        councilMember.setConfirm(councilMemberModel.getConfirm());
        councilMember.setQualification(councilMemberModel.getQualification());
        councilMember.setContributePercent(councilMemberModel.getContributePercent());
        councilMember.setDateOfBirth(Util.getDates(councilMemberModel.getDateofBirth()));
        listCouncillRepository.save(councilMember);
    }


    @Override
    public CouncilModel getInfoCouncil(int councilId) {
        CouncilModel councilModel = new CouncilModel();
        try {
            log.info("Start get info council by CouncilId");
            log.info("CouncilId: " + councilId);
            Optional<Council> council = councilRepository.getCouncil(councilId);
            ModelMapper modelMapper = new ModelMapper();
            List<ListCouncill> councilMembers = listCouncillRepository.findAllByCouncilId(councilId);
            log.info("Size CouncilMembers: " + councilMembers.size());
            List<ListCouncillModel> memberModels = councilMembers
                    .stream()
                    .map(user -> modelMapper.map(user, ListCouncillModel.class))
                    .collect(Collectors.toList());
            LstListCouncill lstCouncilMemberModel = new LstListCouncill();
            lstCouncilMemberModel.setListCouncillModel(memberModels);
            if (council.isPresent()) {
                Council councilData = council.get();
                councilModel.setCouncilId(councilData.getCouncilId());
                councilModel.setCreator(councilData.getCreator());
                councilModel.setCouncilName(councilData.getCouncilName());
                if (councilData.getDateCreate() != null) {
                    councilModel.setDateCreate(Util.convertDateToString(councilData.getDateCreate()));
                }
                if (councilData.getDateModify() != null) {
                    councilModel.setDateModify(Util.convertDateToString(councilData.getDateModify()));
                }
                councilModel.setCreator(councilData.getCreator());
                councilModel.setModifier(councilData.getModifier());
                councilModel.setStatus(councilData.getStatus());
                councilModel.setSubject(councilData.getSubject());
                councilModel.setTimeActive(Util.convertDateToString(councilData.getTimeActive()));
            }
            councilModel.setLstCouncilMemberModel(lstCouncilMemberModel);
            log.info("Get Info Council and Info List Member in Council");
            log.info("End");
            return councilModel;
        } catch (Exception e) {
            log.info("Error Get Info Council");
            e.printStackTrace();
            return councilModel;
        }
    }

    @Override
    public int deleteCouncil(int councilId) {
        log.info("Remove Info Council");
        try {
            log.info("councilId: " + councilId);
            Optional<Council> council = councilRepository.getCouncil(councilId);
            if (council.isPresent()) {
                councilRepository.delete(council.get());
                List<ListCouncill> councilMembers = listCouncillRepository.findAllByCouncilId(councilId);
                listCouncillRepository.deleteAll(councilMembers);
                log.info("Remove Council Success");
                return 0;
            } else {
                log.info("Not found Info Council With CouncilId: " + councilId);
                return 1;
            }
        } catch (Exception e) {
            log.info("Error Remove Info Council");
            e.printStackTrace();
            return 2;
        }
    }

    @Override
    public List<Council> list(String councilId, String subject) {
        return councilRepoCustom.getCouncil(councilId, subject);
    }
}
