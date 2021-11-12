package com.bidv.qlhdkh.util;

import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bidv.qlhdkh.model.CadresInforModel;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.EstimateBudgetModel;
import com.bidv.qlhdkh.model.EvaluateTranscriptModel;
import com.bidv.qlhdkh.model.HostModel;
import com.bidv.qlhdkh.model.ListAuthorModel;
import com.bidv.qlhdkh.model.ListMemberModel;
import com.bidv.qlhdkh.model.ListSolDepartmentModel;
import com.bidv.qlhdkh.model.LstPlan;
import com.bidv.qlhdkh.model.PlanModel;
import com.bidv.qlhdkh.model.ResultUntillChangeModel;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class mainTest {
    public static String template = "E:\\BIdV_SV\\bidv-qlhdkh-service\\src\\main\\resources\\report\\Form1.jrxml";
    public static String exportTo = "E:/";

    public static void main(String[] args) throws JRException {
//		PlanModel plan1 = new PlanModel("package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5");
//		PlanModel plan2 = new PlanModel("package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5");

//		ListMemberModel member1 = new ListMemberModel("package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","package com.bidv.qlhdkh.report 7","package com.bidv.qlhdkh.report 8","package com.bidv.qlhdkh.report 9");
//		ListMemberModel member2 = new ListMemberModel("package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","package com.bidv.qlhdkh.report 7","package com.bidv.qlhdkh.report 8","package com.bidv.qlhdkh.report 9");
//

        List<PlanModel> planCollectionBean = Arrays.asList();//Arrays.asList(plan1,plan2);
        List<ListMemberModel> MemberCollectionBean = Arrays.asList();
        List<EstimateBudgetModel> BudgetCollectionBean = Arrays.asList();
        JRDataSource dataSource = new JREmptyDataSource();
        Map<String, Object> parameters = new HashMap<String, Object>();
        ;
        parameters.put("departmentName", "departmentName");
        parameters.put("dutyYear", "dutyYear");
        parameters.put("host", "host");
        parameters.put("director", "director");
        parameters.put("dutyName", "dutyName");
        parameters.put("topicType", "topicType");
        parameters.put("startDate", "startDate");
        parameters.put("endDate", "endDate");
        //parameters.put("cost", (float)456);
        parameters.put("researchOverView", "researchOverView");
        parameters.put("researchMethod", "researchMethod");
        parameters.put("researchResult", "researchResult");
        parameters.put("researchTime", "researchTime");
        parameters.put("party", "party");

//			
        JRBeanCollectionDataSource PlanCollectionBeanDatasource = new JRBeanCollectionDataSource(planCollectionBean);
        parameters.put("PlanCollectionBean", PlanCollectionBeanDatasource);
        JRBeanCollectionDataSource MemberCollectionBeanDatasource = new JRBeanCollectionDataSource(MemberCollectionBean);
        parameters.put("MemberCollectionBean", MemberCollectionBeanDatasource);
        JRBeanCollectionDataSource BudgetCollectionBeanDatasource = new JRBeanCollectionDataSource(BudgetCollectionBean);
        parameters.put("BudgetCollectionBean", BudgetCollectionBeanDatasource);


        JasperReport jasperReport = JasperCompileManager.compileReport(template);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        File exportReportFile = new File(exportTo + "fileName.docx");
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
        exporter.exportReport();
        System.out.println("OK");


        CaseInfoModel caseInfo = new CaseInfoModel();
        caseInfo.setDeparmentCode("234");
        caseInfo.setTopicType("CHu Văn Huy");
        caseInfo.setStartDate("StartDate");
        caseInfo.setEndDate("EndDate");


        String a = genFile(caseInfo, "/report/Form1.jrxml");
        // String a = genFile(null,"D:/Download/qlnckh-datlb-81cae23c36c22f3ef4b3a997f074ba31e3e854e3/qlnckh-datlb-81cae23c36c22f3ef4b3a997f074ba31e3e854e3/3.Sourcecode/bidv-qlhdkh-service/src/main/resources/report/Form11.jrxml");
        //String a = genFile(null,"D:/Download/qlnckh-datlb-81cae23c36c22f3ef4b3a997f074ba31e3e854e3/qlnckh-datlb-81cae23c36c22f3ef4b3a997f074ba31e3e854e3/3.Sourcecode/bidv-qlhdkh-service/src/main/resources/report/Form8.jrxml");

        System.out.println(a);
    }


    private static String genFile(CaseInfoModel caseInfo, String temPath) throws JRException {
        Class clazz = mainTest.class;
        InputStream inputStream = clazz.getResourceAsStream(temPath);
        JRDataSource dataSource = new JREmptyDataSource();
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
        Date dateNow = new Date();

        String pathSaveFile = exportTo + "Report" + df.format(dateNow) + ".pdf";
        caseInfo = dummyData();
        Map<String, Object> parameters = new HashMap<String, Object>();
        caseInfo.setAction("Action");

        parameters.put("departmentName", getBranchName(caseInfo.getBranch()));
        parameters.put("dutyYear", "dutyYear");
        parameters.put("host", "abc");
        parameters.put("director", "director");
        parameters.put("dutyName", "abc");
        parameters.put("topicType", caseInfo.getTopicType());
        parameters.put("startDate", getStartDate(caseInfo));
        parameters.put("endDate", getEndDate(caseInfo));
        parameters.put("party", getParty(caseInfo));
        parameters.put("researchTime", convertDatetimeToString(new Date()));

        parameters.put("authorName", "123");

        parameters.put("caseType", caseInfo.getCaseType());
        parameters.put("projectName", caseInfo.getProjectName());
        parameters.put("projectCode", caseInfo.getProjectCode());
        parameters.put("ownerConfirm", caseInfo.getCadresName());
        parameters.put("secretaryConfirm", caseInfo.getCadresEmail());
        parameters.put("quantity", caseInfo.getQuantity());
        parameters.put("useReason", caseInfo.getCadresPhone());
        parameters.put("registerCondition", caseInfo.getRegisterCondition());
        //parameters.put("cost", caseInfo.getCost());
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
        parameters.put("dutyOwner", caseInfo.getDutyOwner());
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
        JRBeanCollectionDataSource ListEmployeeCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstListEmployee().getListEmployeeModel());
        parameters.put("ListEmployeeCollectionBean", ListEmployeeCollectionBeanDatasource);
        JRBeanCollectionDataSource ListCouncillCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstListCouncill().getListCouncillModel());
        //Danh sach dong chi tri-8
        parameters.put("ListCouncillCollectionBean", ListCouncillCollectionBeanDatasource);
        JRBeanCollectionDataSource ListAuthorCollectionBeanDatasource = new JRBeanCollectionDataSource(caseInfo.getLstListAuthor().getListAuthorModel());

        parameters.put("ListAuthorCollectionBean", ListAuthorCollectionBeanDatasource);
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


        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
//		 JasperReport jasperReport = JasperCompileManager.compileReport(temPath);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        //JRDocxExporter exporter = new JRDocxExporter();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        File exportReportFile = new File(pathSaveFile);
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
        exporter.exportReport();
        return pathSaveFile;
    }

    private static CaseInfoModel dummyData() {
        CaseInfoModel caseInfo = new CaseInfoModel();

        caseInfo.setCaseType("CaseType");
        caseInfo.setProjectName("In the letter, the Prime Minister hoped that the ministries and soldiers would continue to show the will of \"hard feet, soft rocks\", enthusiastic hearts, and benevolent hearts to serve the compatriots... Vietnam has the belief that it will win the great victory. Translate! ");
        caseInfo.setProjectCode("ProjectCode");
        caseInfo.setCadresName("CadresName");
        caseInfo.setCadresEmail("CadresEmail");
        caseInfo.setQuantity((float) 110);
        caseInfo.setCadresPhone("CadresPhone");
        caseInfo.setRegisterCondition("RegisterCondition");
        //caseInfo.setCost((float) 111);
        caseInfo.setStartDate("StartDate");
        caseInfo.setEndDate("EndDate");
        caseInfo.setNecessity("Necessity");
        caseInfo.setTarget("Target");
        caseInfo.setRange("Range");
        caseInfo.setObject("Object");
        caseInfo.setMethod("Method");
        caseInfo.setData("Data");
        caseInfo.setContent("195 / 5000\r\n"
                + "Kết quả dịch\r\n"
                + "In the letter, the Prime Minister hoped that the ministries and soldiers would continue to show the will of \"hard feet, soft rocks\", enthusiastic hearts, and benevolent hearts to serve the compatriots... Vietnam has the belief that it will win the great victory. Translate! ");
        caseInfo.setConsequence("Consequence");
        caseInfo.setContribute("Contribute");
        caseInfo.setWeakness("Weakness");
        caseInfo.setTranferMethod("TranferMethod");
        caseInfo.setAction("Action");
        caseInfo.setProjectType("In the letter, the Prime Minister hoped that the ministries and soldiers would continue to show the will of \"hard feet, soft rocks\", enthusiastic hearts, and benevolent hearts to serve the compatriots... Vietnam has the belief that it will win the great victory. Translate! ");
        caseInfo.setTopicType("TopicType");
        caseInfo.setDutyOwner("DutyOwner");
        caseInfo.setDutySecretary("DutySecretary");
        caseInfo.setCreatedDate("CreatedDate");
        caseInfo.setProjectLevel("ProjectLevel");
        caseInfo.setTopicCategory("TopicCategory");
        caseInfo.setEvaluateBudget("EvaluateBudget");
        caseInfo.setPresidentConclusion("PresidentConclusion");
        caseInfo.setRecommentBudget((float) 112);
        caseInfo.setRequestPerfect("RequestPerfect");
        caseInfo.setResearchOverView("195 / 5000\r\n"
                + "Kết quả dịch\r\n"
                + "In the letter, the Prime Minister hoped that the ministries and soldiers would continue to show the will of \"hard feet, soft rocks\", enthusiastic hearts, and benevolent hearts to serve the compatriots... Vietnam has the belief that it will win the great victory. Translate! ");
        caseInfo.setResearchMethod("195 / 5000\r\n"
                + "Kết quả dịch\r\n"
                + "In the letter, the Prime Minister hoped that the ministries and soldiers would continue to show the will of \"hard feet, soft rocks\", enthusiastic hearts, and benevolent hearts to serve the compatriots... Vietnam has the belief that it will win the great victory. Translate! ");
        caseInfo.setResearchResult("195 / 5000\r\n"
                + "Kết quả dịch\r\n"
                + "In the letter, the Prime Minister hoped that the ministries and soldiers would continue to show the will of \"hard feet, soft rocks\", enthusiastic hearts, and benevolent hearts to serve the compatriots... Vietnam has the belief that it will win the great victory. Translate! ");
        caseInfo.setOrientation("Orientation");
        caseInfo.setReference("In the letter, the Prime Minister hoped that the ministries and soldiers would continue to show the will of \"hard feet, soft rocks\", enthusiastic hearts, and benevolent hearts to serve the compatriots... Vietnam has the belief that it will win the great victory. Translate! ");
        caseInfo.setExtensionDate("ExtensionDate");
        caseInfo.setContractNo("ContractNo");
        caseInfo.setAccomanyDoc("AccomanyDoc");
        caseInfo.setNote("Note");
        caseInfo.setBudgetPercent("BudgetPercent");
        caseInfo.setReportRange("ReportRange");
        caseInfo.setReportEffective("ReportEffective");
        caseInfo.setReportDifficult("ReportDifficult");
        caseInfo.setPreStatusSol("195 / 5000\r\n"
                + "Kết quả dịch\r\n"
                + "In the letter, the Prime Minister hoped that the ministries and soldiers would continue to show the will of \"hard feet, soft rocks\", enthusiastic hearts, and benevolent hearts to serve the compatriots... Vietnam has the belief that it will win the great victory. Translate! ");
        caseInfo.setProcessApp("195 / 5000\r\n"
                + "Kết quả dịch\r\n"
                + "In the letter, the Prime Minister hoped that the ministries and soldiers would continue to show the will of \"hard feet, soft rocks\", enthusiastic hearts, and benevolent hearts to serve the compatriots... Vietnam has the belief that it will win the great victory. Translate! ");
        caseInfo.setEffecSol("195 / 5000\r\n"
                + "Kết quả dịch\r\n"
                + "In the letter, the Prime Minister hoped that the ministries and soldiers would continue to show the will of \"hard feet, soft rocks\", enthusiastic hearts, and benevolent hearts to serve the compatriots... Vietnam has the belief that it will win the great victory. Translate! ");
        caseInfo.setInterestSub("InterestSub");
        caseInfo.setConclusion("Conclusion");
        caseInfo.setInterest((float) 113);
        caseInfo.setRemuneration((float) 114);
        caseInfo.setCalInterestMethod("CalInterestMethod");
        caseInfo.setBackground("Background");
        caseInfo.setShare("Share");
        caseInfo.setPlanPlus("PlanPlus");
        caseInfo.setSuggest("Suggest");
        caseInfo.setStatus("Status");

        //com.bidv.qlhdkh.model.CaseInfoModel.getLstEvaluateTranscript()

        caseInfo.setLstReTranscript(new com.bidv.qlhdkh.model.LstReTranscript());
        caseInfo.setLstResultUntillChange(new com.bidv.qlhdkh.model.LstResultUntillChange());
        caseInfo.setLstPlanPlusTable(new com.bidv.qlhdkh.model.LstPlanPlusTable());
        caseInfo.setLstPlan(new LstPlan());
        caseInfo.setLstParty(new com.bidv.qlhdkh.model.LstParty());
        //
//		ListSolDepartmentModel departmentModel = new ListSolDepartmentModel(1,2,"MaChiNhanh001","Chi nhánh thành phố Hà Nội Chi nhánh thành phố Hà Nội","Chi nhánh thành phố Hà Nội Chi nhánh thành phố Hà Nội");
//		ListSolDepartmentModel departmentMode2 = new ListSolDepartmentModel(1,2,"MaChiNhanh001","Chi nhánh thành phố Hà Nội Chi nhánh thành phố Hà Nội","Chi nhánh thành phố Hà Nội Chi nhánh thành phố Hà Nội");
//
        List<ListSolDepartmentModel> lstDepartment = Arrays.asList();

        caseInfo.setLstListSolDepartment(new com.bidv.qlhdkh.model.LstListSolDepartment());
        caseInfo.getLstListSolDepartment().setListSolDepartmentModel(lstDepartment);


        caseInfo.setLstListMember(new com.bidv.qlhdkh.model.LstListMember());
        caseInfo.setLstListIniCouncil(new com.bidv.qlhdkh.model.LstListIniCouncil());
        caseInfo.setLstListEmployee(new com.bidv.qlhdkh.model.LstListEmployee());
        caseInfo.setLstListCouncill(new com.bidv.qlhdkh.model.LstListCouncill());
        caseInfo.setLstListAuthor(new com.bidv.qlhdkh.model.LstListAuthor());
        caseInfo.setLstListAcceprtCouncil(new com.bidv.qlhdkh.model.LstListAcceprtCouncil());
        caseInfo.setLstInitiativeTranScript(new com.bidv.qlhdkh.model.LstInitiativeTranScript());
        caseInfo.setLstInitiativeStatus(new com.bidv.qlhdkh.model.LstInitiativeStatus());

        caseInfo.setLstHost(new com.bidv.qlhdkh.model.LstHost());
//		HostModel host = new HostModel(1,1,"HOST0001","HOST NAME 001");
        List<HostModel> lstHost = Arrays.asList();
        caseInfo.getLstHost().setHostModel(lstHost);


        caseInfo.setLstHistories(new com.bidv.qlhdkh.model.LstHistories());
        caseInfo.setLstEvaluateTranscript(new com.bidv.qlhdkh.model.LstEvaluateTranscript());
        caseInfo.setLstEvaluateInitiative(new com.bidv.qlhdkh.model.LstEvaluateInitiative());
        caseInfo.setLstEvaluateDuty(new com.bidv.qlhdkh.model.LstEvaluateDuty());
        caseInfo.setLstEstimateBudget(new com.bidv.qlhdkh.model.LstEstimateBudget());
        caseInfo.setLstDutyStatus(new com.bidv.qlhdkh.model.LstDutyStatus());
        caseInfo.setLstDutyPayment(new com.bidv.qlhdkh.model.LstDutyPayment());
        caseInfo.setLstContentStop(new com.bidv.qlhdkh.model.LstContentStop());
        caseInfo.setLstContentChange(new com.bidv.qlhdkh.model.LstContentChange());
        caseInfo.setLstCoHost(new com.bidv.qlhdkh.model.LstCoHost());
        caseInfo.setLstCadresInfor(new com.bidv.qlhdkh.model.LstCadresInfor());
        caseInfo.setLstAcceptTranscript(new com.bidv.qlhdkh.model.LstAcceptTranscript());


        /////////Bang danh gia
//		EvaluateTranscriptModel evaluateTranscriptModel = new EvaluateTranscriptModel(1,2,3,4,5,6,"package com.bidv.qlhdkh.report 7","package com.bidv.qlhdkh.report 8","package com.bidv.qlhdkh.report 9","package com.bidv.qlhdkh.report 10","package com.bidv.qlhdkh.report 11","package com.bidv.qlhdkh.report 12",13);
//		EvaluateTranscriptModel evaluateTranscriptModel2 = new EvaluateTranscriptModel(1,2,3,4,5,6,"package com.bidv.qlhdkh.report 7","package com.bidv.qlhdkh.report 8","package com.bidv.qlhdkh.report 9","package com.bidv.qlhdkh.report 10","package com.bidv.qlhdkh.report 11","package com.bidv.qlhdkh.report 12",13);
        List<EvaluateTranscriptModel> lstEvaluateTranscriptModel = Arrays.asList();
        //caseInfo.setLstEvaluateTranscript(new com.bidv.qlhdkh.model.LstEvaluateTranscript());
        caseInfo.getLstEvaluateTranscript().setEvaluateTranscriptModel(lstEvaluateTranscriptModel);

        //Dieu chinh mau 4
        //ResultUntillChangeModel resultUtillChange = new ResultUntillChangeModel("package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2");
        //ResultUntillChangeModel resultUtillChange2 = new ResultUntillChangeModel("package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4");
        List<ResultUntillChangeModel> lstResultUtillChange = Arrays.asList();
        //caseInfo.setLstResultUntillChange(new com.bidv.qlhdkh.model.LstResultUntillChange());
        caseInfo.getLstResultUntillChange().setResultUntillChangeModel(lstResultUtillChange);


        //////////////Ke hoach thuc hien
//		PlanModel plan1 = new PlanModel("package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5");
//		PlanModel plan2 = new PlanModel("package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5");
        List<PlanModel> lstPlan = Arrays.asList();
        //caseInfo.setLstPlan(new com.bidv.qlhdkh.model.LstPlan());
        caseInfo.getLstPlan().setPlanModel(lstPlan);


        //////////////Danh sach thanh vien tham gia
        //ListMemberModel member1 = new ListMemberModel("package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","package com.bidv.qlhdkh.report 7","package com.bidv.qlhdkh.report 8","package com.bidv.qlhdkh.report 9");
        //ListMemberModel member2 = new ListMemberModel("package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","package com.bidv.qlhdkh.report 7","package com.bidv.qlhdkh.report 8","package com.bidv.qlhdkh.report 9");
        List<ListMemberModel> LstMemberCollectionBean = Arrays.asList();
        //caseInfo.setLstListMember(new com.bidv.qlhdkh.model.LstListMember());
        caseInfo.getLstListMember().setListMemberModel(LstMemberCollectionBean);


        //////////////////////Du toan kinh phi
        Float a = (float) 1;
        Integer i = 2;
        //EstimateBudgetModel estimateBudget1 = new EstimateBudgetModel("package com.bidv.qlhdkh.report 1", a, i, a, "package com.bidv.qlhdkh.report 5");
        //EstimateBudgetModel estimateBudget2 = new EstimateBudgetModel("package com.bidv.qlhdkh.report 1", a, i, a, "package com.bidv.qlhdkh.report 5");
        List<EstimateBudgetModel> LstEstimateBudgetModel = Arrays.asList();
        //caseInfo.setLstEstimateBudget(new com.bidv.qlhdkh.model.LstEstimateBudget());
        caseInfo.getLstEstimateBudget().setEstimateBudgetModel(LstEstimateBudgetModel);

//Them nguoi thuc hien
        //CadresInforModel cadres1 = new CadresInforModel("package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","");
        List<CadresInforModel> lstCadres = Arrays.asList();
        //caseInfo.setLstPlan(new com.bidv.qlhdkh.model.LstPlan());
        caseInfo.getLstCadresInfor().setCadresInforModel(lstCadres);

//Danh sach dong tac gia
        // ListAuthorModel autho1 = new ListAuthorModel("the Prime Minister hoped that 1","the Prime Minister hoped that2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","");
        // ListAuthorModel autho2 = new ListAuthorModel("package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","package com.bidv.qlhdkh.report 1","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","package com.bidv.qlhdkh.report 2","package com.bidv.qlhdkh.report 3","package com.bidv.qlhdkh.report 4","package com.bidv.qlhdkh.report 5","package com.bidv.qlhdkh.report 6","");
        List<ListAuthorModel> lstAuth = Arrays.asList();
        caseInfo.getLstListAuthor().setListAuthorModel(lstAuth);

        return caseInfo;

    }

    private static String getBranchName(String branchCode) {
        return "Branch Name";
    }

    //Chu nhiem-Bieu mau 1
    private static String getDutyName(CaseInfoModel caseInfo) {
        return "DutyOwner";
    }

    private static String getStartDate(CaseInfoModel caseInfo) {
        return "01/01/2021";
    }

    private static String getEndDate(CaseInfoModel caseInfo) {
        return "01/01/2021";
    }

    private static String getParty(CaseInfoModel caseInfo) {
        return "Party";
    }

    private static String convertDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    private static String convertDatetimeToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return dateFormat.format(date);
    }
}
