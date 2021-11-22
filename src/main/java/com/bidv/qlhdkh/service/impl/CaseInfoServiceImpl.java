package com.bidv.qlhdkh.service.impl;

import static com.bidv.qlhdkh.constants.Constants.BCCN_KHCN_CS;
import static com.bidv.qlhdkh.constants.Constants.BCCN_KHCN_HT;
import static com.bidv.qlhdkh.constants.Constants.BCNT_KHCN_CS;
import static com.bidv.qlhdkh.constants.Constants.BCNT_KHCN_HT;
import static com.bidv.qlhdkh.constants.Constants.DN_CTLSK_CS;
import static com.bidv.qlhdkh.constants.Constants.DN_CTLSK_HT;
import static com.bidv.qlhdkh.constants.Constants.KSTDTH_CS_DND;
import static com.bidv.qlhdkh.constants.Constants.KSTDTH_CS_DNDC;
import static com.bidv.qlhdkh.constants.Constants.KSTDTH_CS_DNL;
import static com.bidv.qlhdkh.constants.Constants.KSTDTH_HT_DND;
import static com.bidv.qlhdkh.constants.Constants.KSTDTH_HT_DNDC;
import static com.bidv.qlhdkh.constants.Constants.KSTDTH_HT_DNL;
import static com.bidv.qlhdkh.constants.Constants.NT_KHCN_CS;
import static com.bidv.qlhdkh.constants.Constants.NT_KHCN_HT;
import static com.bidv.qlhdkh.constants.Constants.NVCS09;
import static com.bidv.qlhdkh.constants.Constants.NVCS10;
import static com.bidv.qlhdkh.constants.Constants.NVHT09;
import static com.bidv.qlhdkh.constants.Constants.NVHT10;
import static com.bidv.qlhdkh.constants.Constants.SKCS06;
import static com.bidv.qlhdkh.constants.Constants.SKCS07;
import static com.bidv.qlhdkh.constants.Constants.SKHT06;
import static com.bidv.qlhdkh.constants.Constants.SKHT07;
import static com.bidv.qlhdkh.util.Util.getDates;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import com.bidv.qlhdkh.entity.ListIniCouncil;
import com.bidv.qlhdkh.repository.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bidv.qlhdkh.constants.Constants;
import com.bidv.qlhdkh.entity.CaseInfo;
import com.bidv.qlhdkh.entity.CaseInfoHistory;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.service.AcceptTranscriptService;
import com.bidv.qlhdkh.service.CaseInfoService;
import com.bidv.qlhdkh.service.CoHostService;
import com.bidv.qlhdkh.service.EvaluateTranscriptService;
import com.bidv.qlhdkh.service.ListAcceptCouncilService;
import com.bidv.qlhdkh.service.ListCouncillService;
import com.bidv.qlhdkh.service.ListMemberService;
import com.bidv.qlhdkh.service.PartyService;
import com.bidv.qlhdkh.service.PlanService;
import com.bidv.qlhdkh.util.Util;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

@Service
public class CaseInfoServiceImpl implements CaseInfoService {
    private static final Logger log = LoggerFactory.getLogger(CaseInfoServiceImpl.class);

    @Autowired
    CaseInfoRepository caseInfoRepository;

    @Autowired
    Constants constants;
    @Autowired
    ListIniCouncilRepository listIniCouncilRepository;
    @Autowired
    ListMemberRepository memberRepository;
    @Autowired
    ListMemberHistoryRepository listMemberHistoryRepository;
    @Autowired
    CoHostService coHostService;
    @Autowired
    EvaluateTranscriptService evaluateTranscriptService;
    @Autowired
    ListCouncillService listCouncillService;
    @Autowired
    ListMemberService listMemberService;
    @Autowired
    PlanService planService;
    @Autowired
    PartyService partyService;
    @Autowired
    AcceptTranscriptService acceptTranscriptService;
    @Autowired
    ListAcceptCouncilService councilService;
    @Autowired
    CaseInfoHistoryRepository caseInfoHistoryRepository;
    @Autowired
    UploadFileServiceImpl uploadFileService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveCase(CaseInfoModel caseinfo) {
        log.info("API SAVE CaseInfo");
        try {
            log.info("Start API SAVE  CaseInfo");
            int caseId = saveInfoCase(caseinfo);
            int caseIdhis = saveCaseInfoHistory(caseinfo);
            uploadFileService.createDocument(caseinfo.getLstDocument(), caseId);
            int hostId = coHostService.saveHost(caseinfo, caseId);
            int cadresInfo = coHostService.saveCadresInfo(caseinfo, caseId);
            coHostService.saveListIniCouncil(caseinfo, caseId);
            listMemberService.saveListMember(caseinfo, caseId);
            listMemberService.saveListMemberHistory(caseinfo, caseIdhis);
            councilService.saveListAcceptCouncilS(caseinfo, caseId);
            acceptTranscriptService.saveAcceptTranscript(caseinfo, caseId);
            coHostService.saveCoHostService(caseinfo, caseId);
            coHostService.saveCoHostHistory(caseinfo, caseIdhis);
            coHostService.saveReTranscript(caseinfo, caseId);
            coHostService.savePlanPlusTable(caseinfo, caseId);
            coHostService.saveListSolDepartment(caseinfo, caseId);
            coHostService.saveInitiativeTranScript(caseinfo, caseId);
            coHostService.saveInitiativeStatus(caseinfo, caseId);
            coHostService.saveHistories(caseinfo, caseId);
            coHostService.saveEvaluateInitiative(caseinfo, caseId);
            coHostService.saveEvaluateDuty(caseinfo, caseId);
            coHostService.saveEstimateBudget(caseinfo, caseId);
            coHostService.saveDutyStatus(caseinfo, caseId);
            coHostService.saveDutyPayment(caseinfo, caseId);
            coHostService.saveContentStop(caseinfo, caseId);
            coHostService.saveResultUtillChange(caseinfo, caseId);
            coHostService.saveContentChange(caseinfo, caseId, hostId, cadresInfo);
            evaluateTranscriptService.saveListEvaluateTranscript(caseinfo, caseId);
            listCouncillService.saveListCouncill(caseinfo, caseId);
            planService.savePlan(caseinfo, caseId);
            partyService.saveParty(caseinfo, caseId);
            log.info("End API SAVE CaseInfo");
        } catch (Exception e) {
            log.warn("Warn API SAVE CaseInfo");
            e.printStackTrace();
            log.error("Error API SAVE CaseInfo");
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<CaseInfoModel> getCaseInfoByStatus(String status) {
        log.info("API FIND CASE INFO  BY STATUS ");
        log.info("debug enabled: {}", log.isDebugEnabled());
        List<CaseInfoModel> svCaseInfo = new ArrayList<>();
        try {
            List<CaseInfo> caseInfo = caseInfoRepository.getCaseInfos(status);
            ModelMapper modelMapper = new ModelMapper();
            for (CaseInfo caseInfo1 : caseInfo) {
                svCaseInfo.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
            }

        } catch (Exception e) {
            log.warn("WARN API FIND CASE INFO");
            log.error("Error API FIND CASE INFO");
            e.printStackTrace();
        }
        return svCaseInfo;
    }

    @Override
    public List<CaseInfoModel> searchCaseInfo(String userId, String status, String projectName, String projectcode, String startDate, String endDate, String departmentCode, String branch, String caseType) throws ParseException {
        log.info("API SEARCH CASE INFO History");
        log.info("debug enabled: {}", log.isDebugEnabled());
        List<CaseInfoModel> svCaseInfo = new ArrayList<>();
        try {
            log.info("START API SEARCH CASE INFO History ");
            if (status != null) {
                String[] statuss = status.split(";", 50);
                Date startDates = getDates(startDate);
                Date endDates = getDates(endDate);
                for (String s : statuss) {
                    List<CaseInfoHistory> caseInfos = caseInfoHistoryRepository.searchCase(s, projectName, projectcode, startDates, endDates, departmentCode, branch, caseType, userId);
                    List<CaseInfoHistory> unique = caseInfos.stream()
                            .collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(CaseInfoHistory::getId))),
                                    ArrayList::new));
                    ModelMapper modelMapper = new ModelMapper();
                    for (CaseInfoHistory caseInfo1 : unique) {
                        svCaseInfo.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                    }
                }
            } else {
                Date startDates = getDates(startDate);
                Date endDates = getDates(endDate);
                List<CaseInfoHistory> caseInfos = caseInfoHistoryRepository.searchCase(status, projectName, projectcode, startDates, endDates, departmentCode, branch, caseType, userId);
                List<CaseInfoHistory> unique = caseInfos.stream()
                        .collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(CaseInfoHistory::getId))),
                                ArrayList::new));
                ModelMapper modelMapper = new ModelMapper();
                for (CaseInfoHistory caseInfo1 : unique) {
                    svCaseInfo.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                }
            }
            log.info("End API SEARCH CASE INFO History");
        } catch (Exception e) {
            log.warn("Error API SEARCH CASE INFO History");
            log.error("Error API SEARCH CASE INFO History");
            e.printStackTrace();
        }
        return svCaseInfo;
    }

    @Override
    public CaseInfoModel detail(String projectCode) {
        CaseInfoModel caseInfoModel = new CaseInfoModel();
        try {
            caseInfoModel.setLstListMember(listMemberService.searchListMember(projectCode));
            caseInfoModel.setLstCoHost(listMemberService.searchListCoHost(projectCode));
            return caseInfoModel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return caseInfoModel;
    }

    @Override
    public boolean checkCaseInfo(String projectCode, String caseType, int caseId) {
        try {
            List<CaseInfo> caseInfoList = caseInfoRepository.checkCaseInfo(projectCode);
            List<String> statusList = new ArrayList<>();
            for (CaseInfo c : caseInfoList) {
                statusList.add(c.getStatus());

            }
            switch (caseType) {
                case BCNT_KHCN_CS:
                    if (statusList.contains(NVCS09) || statusList.contains(NVCS10)) {
                        return false;
                    }
                    break;
                case BCNT_KHCN_HT:
                    if (statusList.contains(NVHT09) || statusList.contains(NVHT10)) {
                        return false;
                    }
                    break;
                case KSTDTH_CS_DND:
                case KSTDTH_HT_DND:
                case KSTDTH_CS_DNDC:
                case KSTDTH_HT_DNDC:
                case KSTDTH_CS_DNL:
                case KSTDTH_HT_DNL:
                case NT_KHCN_CS:
                case NT_KHCN_HT:
                    for (CaseInfo c : caseInfoList) {
                        if (Util.listStatusCheck().contains(c.getStatus()) && c.getCaseId() != caseId) {
                            return false;
                        }
                    }
                    break;
                case DN_CTLSK_CS:
                    List<CaseInfo> infoLists = caseInfoRepository.listCaseCtl(projectCode, "SKCS04", "SKCS05");
                    if (infoLists.size() > 0) {
                        return false;
                    }
                    break;
                case DN_CTLSK_HT:
                    List<CaseInfo> infoList = caseInfoRepository.listCaseCtl(projectCode, "SKHT04", "SKHT05");
                    if (infoList.size() > 0) {
                        return false;
                    }
                    break;
                case BCCN_KHCN_HT:
                    if ((statusList.contains(SKHT06) || statusList.contains(SKHT07))) {
                        return false;
                    }
                    break;
                case BCCN_KHCN_CS:
                    if ((statusList.contains(SKCS06) || statusList.contains(SKCS07))) {
                        return false;
                    }
                    break;
                default:
                    return true;
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<CaseInfoModel> getCaseInfo(String status, String projectName, String projectcode, String startDate, String endDate, String departmentCode, String branch, String caseType, Pageable pageable) throws ParseException {
        log.info("API SEARCH CASE INFO ");
        log.info("debug enabled: {}", log.isDebugEnabled());
        List<CaseInfoModel> svCaseInfo = new ArrayList<>();
        try {
            log.info("START API SEARCH CASE INFO ");
            if (status != null) {
                String[] statuss = status.split(";", 50);
                Date startDates = getDates(startDate);
                Date endDates = getDates(endDate);
                for (String s : statuss) {
                    List<CaseInfo> caseInfos = caseInfoRepository.searchCase(s, projectName, projectcode, startDates, endDates, departmentCode, branch, caseType, pageable);
                    List<CaseInfo> unique = caseInfos.stream()
                            .collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(CaseInfo::getId))),
                                    ArrayList::new));
                    ModelMapper modelMapper = new ModelMapper();
                    for (CaseInfo caseInfo1 : unique) {
                        svCaseInfo.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                    }
                }
            } else {
                Date startDates = getDates(startDate);
                Date endDates = getDates(endDate);
                List<CaseInfo> caseInfos = caseInfoRepository.searchCase(null, projectName, projectcode, startDates, endDates, departmentCode, branch, caseType, pageable);
                List<CaseInfo> unique = caseInfos.stream()
                        .collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(CaseInfo::getId))),
                                ArrayList::new));
                ModelMapper modelMapper = new ModelMapper();
                for (CaseInfo caseInfo1 : unique) {
                    svCaseInfo.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                }
            }
            log.info("End API SEARCH CASE INFO ");
        } catch (Exception e) {
            log.warn("Error API SEARCH CASE INFO");
            log.error("Error API SEARCH CASE INFO");
            e.printStackTrace();
        }
        return svCaseInfo;
    }


    @Override
    public List<CaseInfoModel> searchCaseInfoCTL(String userId, String status, String projectName, String projectcode, String startDate, String endDate, String departmentCode, String branch, String caseType) throws ParseException {
        log.info("API SEARCH CTL CASE INFO ");
        log.info("debug enabled: {}", log.isDebugEnabled());
        List<CaseInfoModel> svCaseInfo = new ArrayList<>();
        try {
            log.info("START API SEARCH CASE INFO ");
            if (caseType.equals(DN_CTLSK_CS)) {
                Date startDates = getDates(startDate);
                Date endDates = getDates(endDate);
                String statusList = "SKCS02;SKCS07";
                String[] statuss = statusList.split(";", 50);
                for (String str : statuss) {
                    List<CaseInfoHistory> caseInfos = caseInfoHistoryRepository.searchCases(str, projectName, projectcode, startDates, endDates, departmentCode, branch, null, userId);
                    ModelMapper modelMapper = new ModelMapper();
                    for (CaseInfoHistory caseInfo1 : caseInfos) {
                        svCaseInfo.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                    }
                }
            }
            if (caseType.equals(DN_CTLSK_HT)) {
                Date startDates = getDates(startDate);
                Date endDates = getDates(endDate);
                String statusList = "SKHT02;SKHT07";
                String[] statuss = statusList.split(";", 50);
                for (String str : statuss) {
                    List<CaseInfoHistory> caseInfos = caseInfoHistoryRepository.searchCases(str, projectName, projectcode, startDates, endDates, departmentCode, branch, null, userId);
                    ModelMapper modelMapper = new ModelMapper();
                    for (CaseInfoHistory caseInfo1 : caseInfos) {
                        svCaseInfo.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                    }
                }
            }
            if (caseType.equals(BCCN_KHCN_CS)) {
                Date startDates = getDates(startDate);
                Date endDates = getDates(endDate);
                List<CaseInfoHistory> caseInfos = caseInfoHistoryRepository.searchCase("SKCS02", projectName, projectcode, startDates, endDates, departmentCode, branch, null, userId);
                ModelMapper modelMapper = new ModelMapper();
                for (CaseInfoHistory caseInfo1 : caseInfos) {
                    svCaseInfo.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                }
            }
            if (caseType.equals(BCCN_KHCN_HT)) {
                Date startDates = getDates(startDate);
                Date endDates = getDates(endDate);
                List<CaseInfoHistory> caseInfos = caseInfoHistoryRepository.searchCase("SKHT02", projectName, projectcode, startDates, endDates, departmentCode, branch, null, userId);
                ModelMapper modelMapper = new ModelMapper();
                for (CaseInfoHistory caseInfo1 : caseInfos) {
                    svCaseInfo.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                }
            }

            log.info("End API SEARCH CASE INFO ");
        } catch (Exception e) {
            log.warn("Error API SEARCH CASE INFO");
            log.error("Error API SEARCH CASE INFO");
            e.printStackTrace();
        }
        return svCaseInfo.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<CaseInfoModel> searchCaseInfosReport(String projectName, String departmentCode, String projectCode, String status, String dateCurrent) throws ParseException {
        log.info("API Start Service Case Report");
        List<CaseInfoModel> caseInfoModels = new ArrayList<>();
        try {
            List<CaseInfoHistory> caseInfoHistoryList = new ArrayList<>();
            LocalDate currentDate = LocalDate.parse(dateCurrent);
            log.info("currentDate: " + currentDate);
            LocalDate date1 = LocalDate.of(currentDate.getYear(), constants.getMonthI(), constants.getDayI());
            LocalDate date2 = LocalDate.of(currentDate.getYear(), constants.getMonthO(), constants.getDayO());
            LocalDate fromDate;
            LocalDate toDate;
            if (currentDate.compareTo(date1) >= 0 && currentDate.compareTo(date2) <= 0) {
                fromDate = LocalDate.of(currentDate.getYear() - 1, constants.getMonthII(), constants.getDayII());
                toDate = LocalDate.of(currentDate.getYear(), constants.getMonthT(), constants.getDayT());
                log.info("FromDate: " + fromDate);
                log.info("ToDate: " + toDate);
            } else {
                fromDate = date1;
                toDate = date2;
                log.info("FromDate: " + fromDate);
                log.info("ToDate: " + toDate);
            }
            if (status != null) {
                String[] statuss = status.split(";", 50);
                for (String sta : statuss) {
                    List<CaseInfoHistory> caseInfoHistories = caseInfoHistoryRepository.findCaseInfoHistory(projectName, departmentCode, projectCode, sta, convertToDateUsingInstant(fromDate), convertToDateUsingInstant(toDate));
                    caseInfoHistoryList.addAll(caseInfoHistories);
                }
                ModelMapper modelMapper = new ModelMapper();
                for (CaseInfoHistory caseInfo1 : caseInfoHistoryList) {
                    caseInfoModels.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                }
            } else {
                List<CaseInfoHistory> caseInfoHistories = caseInfoHistoryRepository.findCaseInfoHistory(projectName, departmentCode, projectCode, null, convertToDateUsingInstant(fromDate), convertToDateUsingInstant(toDate));
                caseInfoHistoryList.addAll(caseInfoHistories);
                ModelMapper modelMapper = new ModelMapper();
                for (CaseInfoHistory caseInfo1 : caseInfoHistoryList) {
                    caseInfoModels.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                }
            }
            log.info("API End Service Case Report");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("API Error Service Case Report");
        }
        return caseInfoModels.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<CaseInfoModel> searchCaseInfosReportSK(String projectName, String departmentCode, String projectCode, String status, String dateCurrent) throws ParseException {
        log.info("API Start Service Case Report");
        List<CaseInfoModel> caseInfoModels = new ArrayList<>();
        try {
            List<CaseInfoHistory> caseInfoHistoryList = new ArrayList<>();
            LocalDate currentDate = LocalDate.parse(dateCurrent);
            log.info("currentDate: " + currentDate);
            LocalDate date1 = LocalDate.of(currentDate.getYear(), constants.getMonthI(), constants.getDayI());
            LocalDate date2 = LocalDate.of(currentDate.getYear(), constants.getMonthO(), constants.getDayO());
            LocalDate fromDate;
            LocalDate toDate;
            if (currentDate.compareTo(date1) >= 0 && currentDate.compareTo(date2) <= 0) {
                fromDate = LocalDate.of(currentDate.getYear() - 1, constants.getMonthII(), constants.getDayII());
                toDate = LocalDate.of(currentDate.getYear(), constants.getMonthT(), constants.getDayT());
                log.info("FromDate: " + fromDate);
                log.info("ToDate: " + toDate);
            } else {
                fromDate = date1;
                toDate = date2;
                log.info("FromDate: " + fromDate);
                log.info("ToDate: " + toDate);
            }
            if (status != null) {
                String[] statuss = status.split(";", 50);
                for (String sta : statuss) {
                    List<CaseInfoHistory> caseInfoHistories = caseInfoHistoryRepository.findCaseInfoHistorySK(projectName, departmentCode, projectCode, sta, convertToDateUsingInstant(fromDate), convertToDateUsingInstant(toDate));
                    caseInfoHistoryList.addAll(caseInfoHistories);
                }
                ModelMapper modelMapper = new ModelMapper();
                for (CaseInfoHistory caseInfo1 : caseInfoHistoryList) {
                    caseInfoModels.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                }
            } else {
                List<CaseInfoHistory> caseInfoHistories = caseInfoHistoryRepository.findCaseInfoHistorySK(projectName, departmentCode, projectCode, null, convertToDateUsingInstant(fromDate), convertToDateUsingInstant(toDate));
                caseInfoHistoryList.addAll(caseInfoHistories);
                ModelMapper modelMapper = new ModelMapper();
                for (CaseInfoHistory caseInfo1 : caseInfoHistoryList) {
                    caseInfoModels.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                }
            }
            log.info("API End Service Case Report");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("API Error Service Case Report");
        }
        return caseInfoModels.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<CaseInfoModel> searchCaseInfosReportNT(String projectName, String departmentCode, String projectCode, String status, String dateCurrent) throws ParseException {
        log.info("API Start Service Case Report");
        List<CaseInfoModel> caseInfoModels = new ArrayList<>();
        try {
            List<CaseInfoHistory> caseInfoHistoryList = new ArrayList<>();
            LocalDate currentDate = LocalDate.parse(dateCurrent);
            log.info("currentDate: " + currentDate);
            LocalDate date1 = LocalDate.of(currentDate.getYear(), constants.getMonthI(), constants.getDayI());
            LocalDate date2 = LocalDate.of(currentDate.getYear(), constants.getMonthO(), constants.getDayO());
            LocalDate fromDate;
            LocalDate toDate;
            if (currentDate.compareTo(date1) >= 0 && currentDate.compareTo(date2) <= 0) {
                fromDate = LocalDate.of(currentDate.getYear() - 1, constants.getMonthII(), constants.getDayII());
                toDate = LocalDate.of(currentDate.getYear(), constants.getMonthT(), constants.getDayT());
                log.info("FromDate: " + fromDate);
                log.info("ToDate: " + toDate);
            } else {
                fromDate = date1;
                toDate = date2;
                log.info("FromDate: " + fromDate);
                log.info("ToDate: " + toDate);
            }
            if (status != null) {
                String[] statuss = status.split(";", 50);
                for (String sta : statuss) {
                    List<CaseInfoHistory> caseInfoHistories = caseInfoHistoryRepository.findCaseInfoHistoryNT(projectName, departmentCode, projectCode, sta);


                    for (CaseInfoHistory caseInfoHistory : caseInfoHistories) {
                        Date acceptDate = caseInfoHistory.getAcceptDate();
                        if (acceptDate != null) {
                            LocalDate acceptD = acceptDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            if (acceptD.plusMonths(6).compareTo(fromDate) >= 0 && acceptD.plusMonths(6).compareTo(toDate) <= 0) {
                                caseInfoHistoryList.add(caseInfoHistory);
                            }
                        }
                    }
                }
                ModelMapper modelMapper = new ModelMapper();
                for (CaseInfoHistory caseInfo1 : caseInfoHistoryList) {
                    caseInfoModels.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                }
            } else {
                getCaseHis(projectName, departmentCode, projectCode, caseInfoModels, caseInfoHistoryList, fromDate, toDate);
            }
            log.info("API End Service Case Report");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("API Error Service Case Report");
        }
        return caseInfoModels.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<CaseInfoModel> searchCaseInfosReportNTSK(String projectName, String departmentCode, String projectCode, String status, String dateCurrent) throws ParseException {
        log.info("API Start Service Case Report");
        List<CaseInfoModel> caseInfoModels = new ArrayList<>();
        try {
            List<CaseInfoHistory> caseInfoHistoryList = new ArrayList<>();
            LocalDate currentDate = LocalDate.parse(dateCurrent);
            log.info("currentDate: " + currentDate);
            LocalDate date1 = LocalDate.of(currentDate.getYear(), constants.getMonthI(), constants.getDayI());
            LocalDate date2 = LocalDate.of(currentDate.getYear(), constants.getMonthO(), constants.getDayO());
            LocalDate fromDate;
            LocalDate toDate;
            if (currentDate.compareTo(date1) >= 0 && currentDate.compareTo(date2) <= 0) {
                fromDate = LocalDate.of(currentDate.getYear() - 1, constants.getMonthII(), constants.getDayII());
                toDate = LocalDate.of(currentDate.getYear(), constants.getMonthT(), constants.getDayT());
                log.info("FromDate: " + fromDate);
                log.info("ToDate: " + toDate);
            } else {
                fromDate = date1;
                toDate = date2;
                log.info("FromDate: " + fromDate);
                log.info("ToDate: " + toDate);
            }
            if (status != null) {
                String[] statuss = status.split(";", 50);
                for (String sta : statuss) {
                    List<CaseInfoHistory> caseInfoHistories = caseInfoHistoryRepository.findCaseInfoHistoryNT(projectName, departmentCode, projectCode, sta);
                    for (CaseInfoHistory caseInfoHistory : caseInfoHistories) {
                        Date RecognitionDate = caseInfoHistory.getRecognitionDate();
                        if (RecognitionDate != null) {
                            LocalDate re = RecognitionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            if (re.plusMonths(6).compareTo(fromDate) >= 0 && re.plusMonths(6).compareTo(toDate) <= 0) {
                                caseInfoHistoryList.add(caseInfoHistory);
                            }
                        }
                    }
                }
                ModelMapper modelMapper = new ModelMapper();
                for (CaseInfoHistory caseInfo1 : caseInfoHistoryList) {
                    caseInfoModels.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
                }
            }
            log.info("API End Service Case Report");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("API Error Service Case Report");
        }
        return caseInfoModels.stream().distinct().collect(Collectors.toList());
    }


    private void getCaseHis(String projectName, String departmentCode, String projectCode, List<CaseInfoModel> caseInfoModels, List<CaseInfoHistory> caseInfoHistoryList, LocalDate fromDate, LocalDate toDate) {
        List<CaseInfoHistory> caseInfoHistories = caseInfoHistoryRepository.findCaseInfoHistoryNT(projectName, departmentCode, projectCode, null);
        for (CaseInfoHistory caseInfoHistory : caseInfoHistories) {
            Date acceptDate = caseInfoHistory.getAcceptDate();
            if (acceptDate != null) {
                LocalDate acceptD = acceptDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (acceptD.plusMonths(6).compareTo(fromDate) >= 0 && acceptD.plusMonths(6).compareTo(toDate) <= 0) {
                    caseInfoHistoryList.add(caseInfoHistory);
                }
            }
        }
        ModelMapper modelMapper = new ModelMapper();
        for (CaseInfoHistory caseInfo1 : caseInfoHistoryList) {
            caseInfoModels.add(modelMapper.map(caseInfo1, CaseInfoModel.class));
        }
    }


    public static Timestamp convertToDateUsingInstant(LocalDate date) {
        return Timestamp.valueOf(date.atStartOfDay());
    }


    public Integer saveInfoCase(CaseInfoModel caseinfo) {
        log.info("API SAVE INFO_Case");
        log.info("debug enabled: {}", log.isDebugEnabled());
        CaseInfo caseinfos = new CaseInfo();
        try {
            log.info("Start API SAVE INFO_Case");
            List<CaseInfo> cases = caseInfoRepository.findAllByCaseId(caseinfo.getCaseId());
            if (cases.size() > 0) {
                for (CaseInfo caseInf : cases) {
                    caseInf.setCouncilId(caseinfo.getCouncilId());
                    caseInf.setNameCouncil(caseinfo.getNameCouncil());
                    caseInf.setProjectName(caseinfo.getProjectName());
                    caseInf.setProjectCode(caseinfo.getProjectCode());
                    caseInf.setCadresName(caseinfo.getCadresName());
                    caseInf.setCadresEmail(caseinfo.getCadresEmail());
                    caseInf.setQuantity(caseinfo.getQuantity());
                    caseInf.setCadresPhone(caseinfo.getCadresPhone());
                    caseInf.setRegisterCondition(caseinfo.getRegisterCondition());
                    caseInf.setCost(caseinfo.getCost());
                    caseInf.setStartDate(getDates(caseinfo.getStartDate()));
                    caseInf.setEndDate(getDates(caseinfo.getEndDate()));
                    caseInf.setNecessity(caseinfo.getNecessity());
                    caseInf.setTarget(caseinfo.getTarget());
                    caseInf.setRange(caseinfo.getRange());
                    caseInf.setObject(caseinfo.getObject());
                    caseInf.setMethod(caseinfo.getMethod());
                    caseInf.setData(caseinfo.getData());
                    caseInf.setContent(caseinfo.getContent());
                    caseInf.setConsequence(caseinfo.getConsequence());
                    caseInf.setContribute(caseinfo.getContribute());
                    caseInf.setWeakness(caseinfo.getWeakness());
                    caseInf.setTranferMethod(caseinfo.getTranferMethod());
                    caseInf.setAction(caseinfo.getAction());
                    caseInf.setProjectType(caseinfo.getProjectType());
                    caseInf.setTopicType(caseinfo.getTopicType());
                    caseInf.setDutyOwner(caseinfo.getDutyOwner());
                    caseInf.setDutySecretary(caseinfo.getDutySecretary());
                    caseInf.setCreatedDate(getDates(caseinfo.getCreatedDate()));
                    caseInf.setProjectLevel(caseinfo.getProjectLevel());
                    caseInf.setTopicCategory(caseinfo.getTopicCategory());
                    caseInf.setEvaluateBudget(caseinfo.getEvaluateBudget());
                    caseInf.setPresidentConclusion(caseinfo.getPresidentConclusion());
                    caseInf.setRecommentBudget(caseinfo.getRecommentBudget());
                    caseInf.setRequestPerfect(caseinfo.getRequestPerfect());
                    caseInf.setResearchOverView(caseinfo.getResearchOverView());
                    caseInf.setResearchMethod(caseinfo.getResearchMethod());
                    caseInf.setResearchResult(caseinfo.getResearchResult());
                    caseInf.setOrientation(caseinfo.getOrientation());
                    caseInf.setReference(caseinfo.getReference());
                    caseInf.setExtensionDate(getDates(caseinfo.getExtensionDate()));
                    caseInf.setContractNo(caseinfo.getContractNo());
                    caseInf.setAccomanyDoc(caseinfo.getAccomanyDoc());
                    caseInf.setNote(caseinfo.getNote());
                    caseInf.setBudgetPercent(caseinfo.getBudgetPercent());
                    caseInf.setReportRange(caseinfo.getReportRange());
                    caseInf.setReportEffective(caseinfo.getReportEffective());
                    caseInf.setReportDifficult(caseinfo.getReportDifficult());
                    caseInf.setPreStatusSol(caseinfo.getPreStatusSol());
                    caseInf.setProcessApp(caseinfo.getProcessApp());
                    caseInf.setEffecSol(caseinfo.getEffecSol());
                    caseInf.setInterestSub(caseinfo.getInterestSub());
                    caseInf.setConclusion(caseinfo.getConclusion());
                    caseInf.setInterest(caseinfo.getInterest());
                    caseInf.setRemuneration(caseinfo.getRemuneration());
                    caseInf.setCalInterestMethod(caseinfo.getCalInterestMethod());
                    caseInf.setBackground(caseinfo.getBackground());
                    caseInf.setShares(caseinfo.getShare());
                    caseInf.setPlanPlus(caseinfo.getPlanPlus());
                    caseInf.setSuggest(caseinfo.getSuggest());
                    caseInf.setStatus(caseinfo.getStatus());
                    caseInf.setBds(caseinfo.getBds());
                    caseInf.setDeparmentCode(caseinfo.getDeparmentCode());
                    caseInf.setDepartment(caseinfo.getDepartment());
                    caseInf.setBrn(caseinfo.getBrn());
                    caseInf.setBranch(caseinfo.getBranch());
                    caseInf.setCra(caseinfo.getCra());
                    caseInf.setAcceptDate(getDates(caseinfo.getAcceptDate()));
                    caseInf.setStatusRemuneration(caseinfo.getStatusRemuneration());
                    caseInf.setRecognitionDate(getDates(caseinfo.getRecognitionDate()));
                    caseInf.setStepId(caseinfo.getStepId());
                    caseInf.setFieldType(caseinfo.getFieldType());
                    caseInf.setNameCouncil(caseinfo.getNameCouncil());
                    caseInf.setCaseFolderId(caseinfo.getCaseFolderId());
                    caseInf.setSnapshotId(caseinfo.getSnapshotId());
                    caseInfoRepository.save(caseInf);
                    if (!Util.isNullOrEmpty(caseInf.getCouncilId())) {
                        List<ListIniCouncil> listIniCouncil = listIniCouncilRepository.findAllByCouncilId(caseInf.getCouncilId());
                        for (ListIniCouncil lstC : listIniCouncil) {
                            lstC.setCaseId(caseInf.getCaseId());
                            listIniCouncilRepository.save(lstC);
                        }
                    }
                    return caseInf.getId();
                }
            } else {
                caseinfos.setCouncilId(caseinfo.getCouncilId());
                caseinfos.setNameCouncil(caseinfo.getNameCouncil());
                caseinfos.setProjectName(caseinfo.getProjectName());
                caseinfos.setProjectCode(caseinfo.getProjectCode());
                caseinfos.setCaseType(caseinfo.getCaseType());
                caseinfos.setCadresName(caseinfo.getCadresName());
                caseinfos.setCadresEmail(caseinfo.getCadresEmail());
                caseinfos.setQuantity(caseinfo.getQuantity());
                caseinfos.setCadresPhone(caseinfo.getCadresPhone());
                caseinfos.setRegisterCondition(caseinfo.getRegisterCondition());
                caseinfos.setCost(caseinfo.getCost());
                caseinfos.setStartDate(getDates(caseinfo.getStartDate()));
                caseinfos.setEndDate(getDates(caseinfo.getEndDate()));
                caseinfos.setNecessity(caseinfo.getNecessity());
                caseinfos.setTarget(caseinfo.getTarget());
                caseinfos.setRange(caseinfo.getRange());
                caseinfos.setObject(caseinfo.getObject());
                caseinfos.setMethod(caseinfo.getMethod());
                caseinfos.setData(caseinfo.getData());
                caseinfos.setContent(caseinfo.getContent());
                caseinfos.setConsequence(caseinfo.getConsequence());
                caseinfos.setContribute(caseinfo.getContribute());
                caseinfos.setWeakness(caseinfo.getWeakness());
                caseinfos.setTranferMethod(caseinfo.getTranferMethod());
                caseinfos.setAction(caseinfo.getAction());
                caseinfos.setProjectType(caseinfo.getProjectType());
                caseinfos.setTopicType(caseinfo.getTopicType());
                caseinfos.setDutyOwner(caseinfo.getDutyOwner());
                caseinfos.setDutySecretary(caseinfo.getDutySecretary());
                caseinfos.setCreatedDate(getDates(caseinfo.getCreatedDate()));
                caseinfos.setProjectLevel(caseinfo.getProjectLevel());
                caseinfos.setTopicCategory(caseinfo.getTopicCategory());
                caseinfos.setEvaluateBudget(caseinfo.getEvaluateBudget());
                caseinfos.setPresidentConclusion(caseinfo.getPresidentConclusion());
                caseinfos.setRecommentBudget(caseinfo.getRecommentBudget());
                caseinfos.setRequestPerfect(caseinfo.getRequestPerfect());
                caseinfos.setResearchOverView(caseinfo.getResearchOverView());
                caseinfos.setResearchMethod(caseinfo.getResearchMethod());
                caseinfos.setResearchResult(caseinfo.getResearchResult());
                caseinfos.setOrientation(caseinfo.getOrientation());
                caseinfos.setReference(caseinfo.getReference());
                caseinfos.setExtensionDate(getDates(caseinfo.getExtensionDate()));
                caseinfos.setContractNo(caseinfo.getContractNo());
                caseinfos.setAccomanyDoc(caseinfo.getAccomanyDoc());
                caseinfos.setNote(caseinfo.getNote());
                caseinfos.setBudgetPercent(caseinfo.getBudgetPercent());
                caseinfos.setReportRange(caseinfo.getReportRange());
                caseinfos.setReportEffective(caseinfo.getReportEffective());
                caseinfos.setReportDifficult(caseinfo.getReportDifficult());
                caseinfos.setPreStatusSol(caseinfo.getPreStatusSol());
                caseinfos.setProcessApp(caseinfo.getProcessApp());
                caseinfos.setEffecSol(caseinfo.getEffecSol());
                caseinfos.setInterestSub(caseinfo.getInterestSub());
                caseinfos.setConclusion(caseinfo.getConclusion());
                caseinfos.setInterest(caseinfo.getInterest());
                caseinfos.setRemuneration(caseinfo.getRemuneration());
                caseinfos.setCalInterestMethod(caseinfo.getCalInterestMethod());
                caseinfos.setBackground(caseinfo.getBackground());
                caseinfos.setShares(caseinfo.getShare());
                caseinfos.setPlanPlus(caseinfo.getPlanPlus());
                caseinfos.setSuggest(caseinfo.getSuggest());
                caseinfos.setStatus(caseinfo.getStatus());
                caseinfos.setBds(caseinfo.getBds());
                caseinfos.setDeparmentCode(caseinfo.getDeparmentCode());
                caseinfos.setDepartment(caseinfo.getDepartment());
                caseinfos.setBrn(caseinfo.getBrn());
                caseinfos.setBranch(caseinfo.getBranch());
                caseinfos.setCaseId(caseinfo.getCaseId());
                caseinfos.setCra(caseinfo.getCra());
                caseinfos.setAcceptDate(getDates(caseinfo.getAcceptDate()));
                caseinfos.setStatusRemuneration(caseinfo.getStatusRemuneration());
                caseinfos.setRecognitionDate(getDates(caseinfo.getRecognitionDate()));
                caseinfos.setStepId(caseinfo.getStepId());
                caseinfos.setFieldType(caseinfo.getFieldType());
                caseinfos.setCaseFolderId(caseinfo.getCaseFolderId());
                caseinfos.setSnapshotId(caseinfo.getSnapshotId());
                caseInfoRepository.save(caseinfos);
            }
            log.info("END API SAVE INFO_Case");
        } catch (Exception e) {
            log.warn("WARN API SAVE INFO_Case");
            log.error("ERROR API SAVE INFO_Case");
            e.printStackTrace();
        }
        return caseinfos.getId();
    }

    public int saveCaseInfoHistory(CaseInfoModel caseinfo) throws ParseException {
        log.info("API Update INFO_Case");
        log.info("debug enabled: {}", log.isDebugEnabled());
        try {
            log.info("Start API Update and Save INFO Case");
            List<CaseInfoHistory> caseInfoHistorys = caseInfoHistoryRepository.getCaseInfo(caseinfo.getProjectCode());
            log.info(caseinfo.getStatus() + " :status");
            if (caseInfoHistorys.size() > 0 && Util.listStatus().contains(caseinfo.getStatus())) {
                for (CaseInfoHistory caseInfoHistory : caseInfoHistorys) {
                    updateCaseInfo(caseInfoHistory, caseinfo);
                    return caseInfoHistory.getId();
                }
            } else if (Util.listStatusNewCase().contains(caseinfo.getStatus())) {
                log.info("status: " + caseinfo.getStatus());
                return saveCaseHistory(caseinfo);
            }
            log.info("End API Update and Save  INFO_Case");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Warn API Update and Save  INFO_Case");
            log.info("Error API Update and Save  INFO_Case");
        }
        return 0;
    }

    public int saveCaseHistory(CaseInfoModel caseinfo) throws ParseException {
        log.info("API saveCaseHistory  INFO New");
        log.info("debug enabled: {}", log.isDebugEnabled());
        CaseInfoHistory caseInfoHistory = new CaseInfoHistory();
        try {
            log.info("Start API saveCaseHistory  INFO New");
            caseInfoHistory.setCouncilId(caseinfo.getCouncilId());
            caseInfoHistory.setCaseType(caseinfo.getCaseType());
            caseInfoHistory.setProjectName(caseinfo.getProjectName());
            caseInfoHistory.setProjectCode(caseinfo.getProjectCode());
            caseInfoHistory.setCadresName(caseinfo.getCadresName());
            caseInfoHistory.setCadresEmail(caseinfo.getCadresEmail());
            caseInfoHistory.setQuantity(caseinfo.getQuantity());
            caseInfoHistory.setCadresPhone(caseinfo.getCadresPhone());
            caseInfoHistory.setRegisterCondition(caseinfo.getRegisterCondition());
            caseInfoHistory.setCost(caseinfo.getCost());
            caseInfoHistory.setStartDate(getDates(caseinfo.getStartDate()));
            caseInfoHistory.setEndDate(getDates(caseinfo.getEndDate()));
            caseInfoHistory.setNecessity(caseinfo.getNecessity());
            caseInfoHistory.setTarget(caseinfo.getTarget());
            caseInfoHistory.setRange(caseinfo.getRange());
            caseInfoHistory.setObject(caseinfo.getObject());
            caseInfoHistory.setMethod(caseinfo.getMethod());
            caseInfoHistory.setData(caseinfo.getData());
            caseInfoHistory.setContent(caseinfo.getContent());
            caseInfoHistory.setConsequence(caseinfo.getConsequence());
            caseInfoHistory.setContribute(caseinfo.getContribute());
            caseInfoHistory.setWeakness(caseinfo.getWeakness());
            caseInfoHistory.setTranferMethod(caseinfo.getTranferMethod());
            caseInfoHistory.setAction(caseinfo.getAction());
            caseInfoHistory.setProjectType(caseinfo.getProjectType());
            caseInfoHistory.setTopicType(caseinfo.getTopicType());
            caseInfoHistory.setDutyOwner(caseinfo.getDutyOwner());
            caseInfoHistory.setDutySecretary(caseinfo.getDutySecretary());
            caseInfoHistory.setCreatedDate(getDates(caseinfo.getCreatedDate()));
            caseInfoHistory.setProjectLevel(caseinfo.getProjectLevel());
            caseInfoHistory.setTopicCategory(caseinfo.getTopicCategory());
            caseInfoHistory.setEvaluateBudget(caseinfo.getEvaluateBudget());
            caseInfoHistory.setPresidentConclusion(caseinfo.getPresidentConclusion());
            caseInfoHistory.setRecommentBudget(caseinfo.getRecommentBudget());
            caseInfoHistory.setRequestPerfect(caseinfo.getRequestPerfect());
            caseInfoHistory.setResearchOverView(caseinfo.getResearchOverView());
            caseInfoHistory.setResearchMethod(caseinfo.getResearchMethod());
            caseInfoHistory.setResearchResult(caseinfo.getResearchResult());
            caseInfoHistory.setOrientation(caseinfo.getOrientation());
            caseInfoHistory.setReference(caseinfo.getReference());
            caseInfoHistory.setExtensionDate(getDates(caseinfo.getExtensionDate()));
            caseInfoHistory.setContractNo(caseinfo.getContractNo());
            caseInfoHistory.setAccomanyDoc(caseinfo.getAccomanyDoc());
            caseInfoHistory.setNote(caseinfo.getNote());
            caseInfoHistory.setBudgetPercent(caseinfo.getBudgetPercent());
            caseInfoHistory.setReportRange(caseinfo.getReportRange());
            caseInfoHistory.setReportEffective(caseinfo.getReportEffective());
            caseInfoHistory.setReportDifficult(caseinfo.getReportDifficult());
            caseInfoHistory.setPreStatusSol(caseinfo.getPreStatusSol());
            caseInfoHistory.setProcessApp(caseinfo.getProcessApp());
            caseInfoHistory.setEffecSol(caseinfo.getEffecSol());
            caseInfoHistory.setInterestSub(caseinfo.getInterestSub());
            caseInfoHistory.setConclusion(caseinfo.getConclusion());
            caseInfoHistory.setInterest(caseinfo.getInterest());
            caseInfoHistory.setRemuneration(caseinfo.getRemuneration());
            caseInfoHistory.setCalInterestMethod(caseinfo.getCalInterestMethod());
            caseInfoHistory.setBackground(caseinfo.getBackground());
            caseInfoHistory.setShares(caseinfo.getShare());
            caseInfoHistory.setPlanPlus(caseinfo.getPlanPlus());
            caseInfoHistory.setSuggest(caseinfo.getSuggest());
            caseInfoHistory.setStatus(caseinfo.getStatus());
            caseInfoHistory.setBds(caseinfo.getBds());
            caseInfoHistory.setDeparmentCode(caseinfo.getDeparmentCode());
            caseInfoHistory.setDepartment(caseinfo.getDepartment());
            caseInfoHistory.setBrn(caseinfo.getBrn());
            caseInfoHistory.setBranch(caseinfo.getBranch());
            caseInfoHistory.setCaseId(caseinfo.getCaseId());
            caseInfoHistory.setCra(caseinfo.getCra());
            caseInfoHistory.setAcceptDate(getDates(caseinfo.getAcceptDate()));
            caseInfoHistory.setStatusRemuneration(caseinfo.getStatusRemuneration());
            caseInfoHistory.setRecognitionDate(getDates(caseinfo.getRecognitionDate()));
            caseInfoHistory.setStepId(caseinfo.getStepId());
            caseInfoHistory.setNameCouncil(caseinfo.getNameCouncil());
            caseInfoHistory.setFieldType(caseinfo.getFieldType());
            caseInfoHistory.setCaseFolderId(caseinfo.getCaseFolderId());
            caseInfoHistory.setSnapshotId(caseinfo.getSnapshotId());
            caseInfoHistoryRepository.save(caseInfoHistory);
            log.info("End API saveCaseHistory  INFO New");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Warn API saveCaseHistory  INFO New");
            log.error("Error API saveCaseHistory  INFO New");
        }
        return caseInfoHistory.getId();
    }

    public void updateCaseInfo(CaseInfoHistory caseInfoHistory, CaseInfoModel caseinfo) throws ParseException {
        log.info("API updateCaseInfo  INFO ");
        log.info("debug enabled: {}", log.isDebugEnabled());
        try {
            log.info("Start API updateCaseInfo  INFO ");
            if (!caseinfo.getCaseType().equals(DN_CTLSK_HT) && !caseinfo.getCaseType().equals(DN_CTLSK_CS)) {
                caseInfoHistory.setStatus(caseinfo.getStatus());
            }
            caseInfoHistory.setCouncilId(caseinfo.getCouncilId());
            caseInfoHistory.setNameCouncil(caseinfo.getNameCouncil());
            caseInfoHistory.setStepId(caseinfo.getStepId());
            caseInfoHistory.setStartDate(Util.getDates(caseinfo.getStartDate()));
            caseInfoHistory.setEndDate(Util.getDates(caseinfo.getEndDate()));
            caseInfoHistory.setStatusRemuneration(caseinfo.getStatusRemuneration());
            if (caseinfo.getCaseType().equals(NT_KHCN_CS) || caseinfo.getCaseType().equals(NT_KHCN_HT)) {
                caseInfoHistory.setAcceptDate(Util.getDates(caseinfo.getAcceptDate()));
            }
            caseInfoHistoryRepository.save(caseInfoHistory);
            log.info("End  API updateCaseInfo  INFO ");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Warn API update CaseHistory  INFO ");
            log.error("Error API  update CaseHistory  INFO ");
        }
    }

}
