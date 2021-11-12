package com.bidv.qlhdkh.service.impl;

import static com.bidv.qlhdkh.constants.Constants.CHECK_NULL;
import static com.bidv.qlhdkh.constants.Constants.DN_CTLSK_CS;
import static com.bidv.qlhdkh.constants.Constants.DN_CTLSK_HT;
import static com.bidv.qlhdkh.constants.Constants.XDTC_KHCN_CS;
import static com.bidv.qlhdkh.constants.Constants.XDTC_KHCN_HT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bidv.qlhdkh.constants.Constants;
import com.bidv.qlhdkh.entity.Department;
import com.bidv.qlhdkh.model.CadresInforModel;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.CoHostModel;
import com.bidv.qlhdkh.model.ConfigTopic;
import com.bidv.qlhdkh.model.ListMemberModel;
import com.bidv.qlhdkh.model.PartyModel;
import com.bidv.qlhdkh.model.ResponseFile;
import com.bidv.qlhdkh.repository.ConfigTopicRepository;
import com.bidv.qlhdkh.repository.DepartmentRepository;
import com.bidv.qlhdkh.service.ConfigTopicService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Service
public class ConfigTopicServiceImpl implements ConfigTopicService {
    private static final Logger log = LoggerFactory.getLogger(ConfigTopicServiceImpl.class);

    @Autowired
    ConfigTopicRepository configTopicRepository;
    @Autowired
    Constants constants;
    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ConfigTopic> listConfigTopic() {
        log.info("Start get list config");
        log.debug("Get List Config Topic !!!");
        List<com.bidv.qlhdkh.entity.ConfigTopic> configTopics = configTopicRepository.findAll();
        List<ConfigTopic> topicList = new ArrayList<>();
        try {
            for (com.bidv.qlhdkh.entity.ConfigTopic config : configTopics) {
                ConfigTopic configTopic = new ConfigTopic();
                configTopic.setId(config.getId().toString());
                configTopic.setCodeTopic(config.getCodeTopic());
                configTopic.setKeyTopic(config.getKeyTopic());
                configTopic.setNameTopic(config.getNameTopic());
                configTopic.setParentId(config.getParentId());
                topicList.add(configTopic);
            }
            List<Department> departmentList = departmentRepository.findDepartmentByBrnLevelNotNull();
            for (Department d : departmentList) {
                ConfigTopic configTopic = new ConfigTopic();
                configTopic.setCodeTopic(d.getCodeDepartment());
                if ((d.getBrnLevel().equals("HO"))) {
                    configTopic.setKeyTopic("DS_HE_THONG_HO");
                }
                if (d.getBrnLevel().equals("CN")) {
                    configTopic.setKeyTopic("DS_HE_THONG_CN");
                }
                if (d.getBrnLevel().equals("PH")) {
                    configTopic.setKeyTopic("DS_CO_SO_PH");
                }
                if (d.getBrnLevel().equals("TW")) {
                    configTopic.setKeyTopic("DS_CO_SO_TW");
                }
                configTopic.setNameTopic(d.getNameDepartment());
                configTopic.setParentId(d.getCodeBdsParent());
                topicList.add(configTopic);
            }
            log.info("End get list config");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Warn get list config");
            log.error("Error get list config");
        }
        return topicList;
    }

    @Override
    public void generatePDF() throws JRException, IOException {
//        log.info("path: " + constants.getResourceFile().getURL().getPath());
//        log.info("Export Report from JasperReport !!!");
//        exportPDFDataReport(constants.getResourceFile().getURL().getPath());
    }

    @Override
    public void exportPDFDataReport(String path) throws FileNotFoundException, JRException {
        log.info("Start Export Report");
        InputStream inputStream = new FileInputStream(new File(path));
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JRDataSource dataSource = new JREmptyDataSource();
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("departmentName", "A");
        parameters.put("dutyYear", "2021");
        parameters.put("director", "B");
        parameters.put("notyDate", "12");
        JasperPrint pdfPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(pdfPrint, null);
        log.info("Export Report Success");
    }

    @Override
    public ResponseFile generateFilePdf(CaseInfoModel caseInfo) throws IOException, JRException {
        log.info("Export Report from JasperReport !!!");
        ResponseFile responseFile = new ResponseFile();
        Class clazz = ConfigTopicServiceImpl.class;
        switch (caseInfo.getCaseType()) {
            case XDTC_KHCN_CS:
            case XDTC_KHCN_HT:
                InputStream inputStream = clazz.getResourceAsStream("/report/Form1.jrxml");
                String nameFile1 = "Form1.jrxml";
                responseFile = genFile(caseInfo, inputStream, nameFile1);
                inputStream.close();
                break;
            case "DNCNSK_CS":
            case "DNCNSK_HT":
                InputStream inputStreams = clazz.getResourceAsStream("/report/Form8.jrxml");
                String nameFile8 = "Form8.jrxml";
                responseFile = genFile(caseInfo, inputStreams, nameFile8);
                inputStreams.close();
                break;
            case DN_CTLSK_CS:
            case DN_CTLSK_HT:
                InputStream inputStreamse = clazz.getResourceAsStream("/report/Form11.jrxml");
                String nameFile11 = "Form11.jrxml";
                responseFile = genFile(caseInfo, inputStreamse, nameFile11);
                inputStreamse.close();
                break;
        }
        log.info("End Export Report from JasperReport !!!");
        return responseFile;
    }


    public ResponseFile genFile(CaseInfoModel caseInfo, InputStream inputStream, String nameFile) throws JRException, IOException {
        JRDataSource dataSource = new JREmptyDataSource();
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
        Date dateNow = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        String year = dateFormat.format(dateNow);
//        String pathSaveFile = constants.getFolderDownload() + "Report" + df.format(dateNow) + ".pdf";
        Map<String, Object> parameters = new HashMap<String, Object>();
        caseInfo.setAction("Action");
        parameters.put("departmentName", getBranchName(caseInfo));
        parameters.put("dutyYear", year);
        if (caseInfo.getInterestSub() != null && !caseInfo.getInterestSub().isEmpty()) {
            if (caseInfo.getInterestSub().equals(CHECK_NULL)) {
                parameters.put("checkedNULL", true);
                parameters.put("checkedOK", false);
            } else {
                parameters.put("checkedNULL", false);
                parameters.put("checkedOK", true);
            }
        }
        parameters.put("director", "director");
        parameters.put("dutyName", getDutyName(caseInfo));
        parameters.put("topicType", caseInfo.getTopicType());
        parameters.put("startDate", getStartDate(caseInfo));
        parameters.put("endDate", getEndDate(caseInfo));
        parameters.put("party", getParty(caseInfo));
        parameters.put("researchTime", convertDatetimeToString(new Date()));
        parameters.put("authorName", getCadresInforModel(caseInfo));
        parameters.put("host", getCoHost(caseInfo));
        parameters.put("caseType", caseInfo.getCaseType());
        parameters.put("projectName", caseInfo.getProjectName());
        parameters.put("projectCode", caseInfo.getProjectCode());
        parameters.put("ownerConfirm", caseInfo.getCadresName());
        parameters.put("secretaryConfirm", caseInfo.getCadresEmail());
        parameters.put("quantity", caseInfo.getQuantity());
        parameters.put("useReason", caseInfo.getCadresPhone());
        parameters.put("registerCondition", caseInfo.getRegisterCondition());
        parameters.put("cost", String.valueOf(caseInfo.getCost()));
        log.info(String.valueOf(caseInfo.getCost()));
        parameters.put("startDate", caseInfo.getStartDate());
        parameters.put("endDate", caseInfo.getEndDate());
        parameters.put("necessity", caseInfo.getNecessity());
        parameters.put("target", caseInfo.getTarget());
        parameters.put("range", caseInfo.getRange());
        parameters.put("object", caseInfo.getObject());
        parameters.put("method", caseInfo.getMethod());
        parameters.put("data", caseInfo.getData());
        parameters.put("content", caseInfo.getContent());
        parameters.put("consequence", caseInfo.getConsequence());
        parameters.put("contribute", caseInfo.getContribute());
        parameters.put("weakness", caseInfo.getWeakness());
        parameters.put("tranferMethod", caseInfo.getTranferMethod());
        parameters.put("action", caseInfo.getAction());
        parameters.put("projectType", caseInfo.getProjectType());
        parameters.put("topicType", caseInfo.getTopicType());
        parameters.put("dutySecretary", caseInfo.getDutySecretary());
        parameters.put("createdDate", caseInfo.getCreatedDate());
        parameters.put("projectLevel", caseInfo.getProjectLevel());
        parameters.put("topicCategory", caseInfo.getTopicCategory());
        parameters.put("evaluateBudget", caseInfo.getEvaluateBudget());
        parameters.put("presidentConclusion", caseInfo.getPresidentConclusion());
        parameters.put("recommentBudget", caseInfo.getRecommentBudget());
        parameters.put("requestPerfect", caseInfo.getRequestPerfect());
        parameters.put("researchOverView", caseInfo.getResearchOverView());

        parameters.put("researchMethod", caseInfo.getResearchMethod());
        parameters.put("researchResult", caseInfo.getResearchResult());
        parameters.put("orientation", caseInfo.getOrientation());
        parameters.put("reference", caseInfo.getReference());
        parameters.put("extensionDate", caseInfo.getExtensionDate());
        parameters.put("contractNo", caseInfo.getContractNo());
        parameters.put("accomanyDoc", caseInfo.getAccomanyDoc());
        parameters.put("note", caseInfo.getNote());
        parameters.put("budgetPercent", caseInfo.getBudgetPercent());
        parameters.put("reportRange", caseInfo.getReportRange());
        parameters.put("reportEffective", caseInfo.getReportEffective());
        parameters.put("reportDifficult", caseInfo.getReportDifficult());
        parameters.put("preStatusSol", caseInfo.getPreStatusSol());
        parameters.put("processApp", caseInfo.getProcessApp());
        parameters.put("effecSol", caseInfo.getEffecSol());
        parameters.put("interestSub", caseInfo.getInterestSub());
        parameters.put("conclusion", caseInfo.getConclusion());
        parameters.put("interest", caseInfo.getInterest());
        parameters.put("remuneration", caseInfo.getRemuneration());
        parameters.put("calInterestMethod", caseInfo.getCalInterestMethod());
        parameters.put("background", caseInfo.getBackground());
        parameters.put("share", caseInfo.getShare());
        parameters.put("planPlus", caseInfo.getPlanPlus());
        parameters.put("suggest", caseInfo.getSuggest());
        parameters.put("status", caseInfo.getStatus());
        parameters.put("dutyOwner", getUserMember(caseInfo));
        JRBeanCollectionDataSource ReTranscriptCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstReTranscript().getReTranscriptModel());// getLstReTranscript());
        parameters.put("ReTranscriptCollectionBean", ReTranscriptCollectionBeanDatasource);
        //Dieu chinh mau 4
        JRBeanCollectionDataSource ResultUtillChangeCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstResultUntillChange().getResultUntillChangeModel());
        parameters.put("ResultUtillChangeCollectionBean", ResultUtillChangeCollectionBeanDatasource);
        JRBeanCollectionDataSource PlanPlusTableCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstPlanPlusTable().getPlanPlusTableModel());
        parameters.put("PlanPlusTableCollectionBean", PlanPlusTableCollectionBeanDatasource);
        //////////////Ke hoach thuc hien
        JRBeanCollectionDataSource PlanCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstPlan().getPlanModel());
        parameters.put("PlanCollectionBean", PlanCollectionBeanDatasource);
        JRBeanCollectionDataSource PartyCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstParty().getPartyModel());
        parameters.put("PartyCollectionBean", PartyCollectionBeanDatasource);

        ///////
        JRBeanCollectionDataSource ListSolDepartmentCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstListSolDepartment().getListSolDepartmentModel());
        parameters.put("ListSolDepartmentCollectionBean", ListSolDepartmentCollectionBeanDatasource);
        //////////////Danh sach thanh vien tham gia
        JRBeanCollectionDataSource ListMemberCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstListMember().getListMemberModel());
        parameters.put("ListMemberCollectionBean", ListMemberCollectionBeanDatasource);
        JRBeanCollectionDataSource ListIniCouncilCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstListIniCouncil().getListIniCouncilModel());
        parameters.put("ListIniCouncilCollectionBean", ListIniCouncilCollectionBeanDatasource);
        JRBeanCollectionDataSource ListCouncillCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstListCouncill().getListCouncillModel());
        //Danh sach dong chi tri-8
        parameters.put("ListCouncillCollectionBean", ListCouncillCollectionBeanDatasource);
        JRBeanCollectionDataSource ListAcceprtCouncilCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstListAcceprtCouncil().getListAcceprtCouncilModel());
        parameters.put("ListAcceprtCouncilCollectionBean", ListAcceprtCouncilCollectionBeanDatasource);
        JRBeanCollectionDataSource InitiativeTranScriptCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstInitiativeTranScript().getInitiativeTranScriptModel());
        parameters.put("InitiativeTranScriptCollectionBean", InitiativeTranScriptCollectionBeanDatasource);
        JRBeanCollectionDataSource InitiativeStatusCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstInitiativeStatus().getInitiativeStatusModel());
        parameters.put("InitiativeStatusCollectionBean", InitiativeStatusCollectionBeanDatasource);
        JRBeanCollectionDataSource HostCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstHost().getHostModel());
        parameters.put("HostCollectionBean", HostCollectionBeanDatasource);
        JRBeanCollectionDataSource HistoriesCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstHistories().getHistoriesModel());
        parameters.put("HistoriesCollectionBean", HistoriesCollectionBeanDatasource);
        /////////Bang danh gia
        JRBeanCollectionDataSource EvaluateTranscriptCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstEvaluateTranscript().getEvaluateTranscriptModel());
        parameters.put("EvaluateTranscriptCollectionBean", EvaluateTranscriptCollectionBeanDatasource);
        JRBeanCollectionDataSource EvaluateInitiativeCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstEvaluateInitiative().getEvaluateInitiativeModel());
        parameters.put("EvaluateInitiativeCollectionBean", EvaluateInitiativeCollectionBeanDatasource);
        JRBeanCollectionDataSource EvaluateDutyCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstEvaluateDuty().getEvaluateDutyModel());
        parameters.put("EvaluateDutyCollectionBean", EvaluateDutyCollectionBeanDatasource);
        //////////////////////
        JRBeanCollectionDataSource EstimateBudgetCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstEstimateBudget().getEstimateBudgetModel());
        parameters.put("EstimateBudgetCollectionBean", EstimateBudgetCollectionBeanDatasource);

        JRBeanCollectionDataSource DutyStatusCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstDutyStatus().getDutyStatusModel());
        parameters.put("DutyStatusCollectionBean", DutyStatusCollectionBeanDatasource);
        JRBeanCollectionDataSource DutyPaymentCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstDutyPayment().getDutyPaymentModel());
        parameters.put("DutyPaymentCollectionBean", DutyPaymentCollectionBeanDatasource);
        JRBeanCollectionDataSource ContentStopCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstContentStop().getContentStopModel());
        parameters.put("ContentStopCollectionBean", ContentStopCollectionBeanDatasource);
        JRBeanCollectionDataSource ContentChangeCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstContentChange().getContentChangeModel());
        parameters.put("ContentChangeCollectionBean", ContentChangeCollectionBeanDatasource);
        JRBeanCollectionDataSource CoHostCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstCoHost().getCoHostModel());
        parameters.put("CoHostCollectionBean", CoHostCollectionBeanDatasource);
        JRBeanCollectionDataSource CadresInforCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstCadresInfor().getCadresInforModel());
        parameters.put("CadresInforCollectionBean", CadresInforCollectionBeanDatasource);
        JRBeanCollectionDataSource AcceptTranscriptCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstAcceptTranscript().getAcceptTranscriptModel());
        parameters.put("AcceptTranscriptCollectionBean", AcceptTranscriptCollectionBeanDatasource);
        // JasperReport jasperReport = JasperCompileManager.compileReport(temPath);
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        File exportReportFile = File.createTempFile("output.",".pdf");
//        File exportReportFile = new File(pathSaveFile);
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
        exporter.exportReport();
//        File file = new File(pathSaveFile);
        ResponseFile responseFile = new ResponseFile();
        responseFile.setContent(encodeFileToBase64Binary(exportReportFile));
        responseFile.setNameFile(nameFile);
        responseFile.setMimeType(("application/pdf"));
        return responseFile;
    }

    private static String encodeFileToBase64Binary(File file) {
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return encodedfile;
    }

    private static String getBranchName(CaseInfoModel caseInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CadresInforModel cadresInforModel1 : caseInfo.getLstCadresInfor().getCadresInforModel()) {
            stringBuilder.append(cadresInforModel1.getDepartment());
        }
        return stringBuilder.toString();
    }

    //Chu nhiem-Bieu mau 1
    private static String getDutyName(CaseInfoModel caseInfo) {
        return "DutyOwner";
    }

    private static String getStartDate(CaseInfoModel caseInfo) {
        return caseInfo.getStartDate();
    }

    private static String getEndDate(CaseInfoModel caseInfo) {
        return caseInfo.getEndDate();
    }

    private static String getParty(CaseInfoModel caseInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        for (PartyModel partyModel : caseInfo.getLstParty().getPartyModel()) {
            stringBuilder.append(partyModel.getDepartmentName());
            stringBuilder.append(";");
        }
        return method(stringBuilder.toString());
    }

    private static String getCoHost(CaseInfoModel caseInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CoHostModel coHostModel : caseInfo.getLstCoHost().getCoHostModel()) {
            stringBuilder.append(coHostModel.getDepartmentName());
            stringBuilder.append(";");
        }
        return method(stringBuilder.toString());
    }

    private static String getUserMember(CaseInfoModel caseInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ListMemberModel listMemberModel : caseInfo.getLstListMember().getListMemberModel()) {
            if (listMemberModel.getJobTitle().equals("Chủ nhiệm")) {
                stringBuilder.append(listMemberModel.getUserName());
                stringBuilder.append(";");
            }
        }
        return method(stringBuilder.toString());
    }

    private static String getCadresInforModel(CaseInfoModel caseInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CadresInforModel cadresInforModel : caseInfo.getLstCadresInfor().getCadresInforModel()) {
            stringBuilder.append(cadresInforModel.getFullName());
            stringBuilder.append(";");
        }
        return method(stringBuilder.toString());
    }

    private static String convertDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    private static String convertDatetimeToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public static String method(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ';') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

}
