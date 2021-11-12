package com.bidv.qlhdkh.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;


/**
 * CaseInfoModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class CaseInfoModel {
    @JsonProperty("Id")
    private Integer id = null;

    @JsonProperty("CaseType")
    private String caseType = null;

    @JsonProperty("ProjectName")
    private String projectName = null;

    @JsonProperty("ProjectCode")
    private String projectCode = null;

    @JsonProperty("CadresName")
    private String cadresName = null;

    @JsonProperty("CadresEmail")
    private String cadresEmail = null;

    @JsonProperty("Quantity")
    private Float quantity = null;

    @JsonProperty("CadresPhone")
    private String cadresPhone = null;

    @JsonProperty("RegisterCondition")
    private String registerCondition = null;

    @JsonProperty("Cost")
    private Float cost = null;

    @JsonProperty("StartDate")
    private String startDate = null;

    @JsonProperty("EndDate")
    private String endDate = null;

    @JsonProperty("Necessity")
    private String necessity = null;

    @JsonProperty("Target")
    private String target = null;

    @JsonProperty("Range")
    private String range = null;

    @JsonProperty("Object")
    private String object = null;

    @JsonProperty("Method")
    private String method = null;

    @JsonProperty("Data")
    private String data = null;

    @JsonProperty("Content")
    private String content = null;

    @JsonProperty("Consequence")
    private String consequence = null;

    @JsonProperty("Contribute")
    private String contribute = null;

    @JsonProperty("Weakness")
    private String weakness = null;

    @JsonProperty("TranferMethod")
    private String tranferMethod = null;

    @JsonProperty("Action")
    private String action = null;

    @JsonProperty("ProjectType")
    private String projectType = null;

    @JsonProperty("TopicType")
    private String topicType = null;

    @JsonProperty("DutyOwner")
    private String dutyOwner = null;

    @JsonProperty("DutySecretary")
    private String dutySecretary = null;

    @JsonProperty("CreatedDate")
    private String createdDate = null;

    @JsonProperty("ProjectLevel")
    private String projectLevel = null;

    @JsonProperty("TopicCategory")
    private String topicCategory = null;

    @JsonProperty("EvaluateBudget")
    private String evaluateBudget = null;

    @JsonProperty("PresidentConclusion")
    private String presidentConclusion = null;

    @JsonProperty("RecommentBudget")
    private Float recommentBudget = null;

    @JsonProperty("RequestPerfect")
    private String requestPerfect = null;

    @JsonProperty("ResearchOverView")
    private String researchOverView = null;

    @JsonProperty("ResearchMethod")
    private String researchMethod = null;

    @JsonProperty("ResearchResult")
    private String researchResult = null;

    @JsonProperty("Orientation")
    private String orientation = null;

    @JsonProperty("Reference")
    private String reference = null;

    @JsonProperty("ExtensionDate")
    private String extensionDate = null;

    @JsonProperty("ContractNo")
    private String contractNo = null;

    @JsonProperty("AccomanyDoc")
    private String accomanyDoc = null;

    @JsonProperty("Note")
    private String note = null;

    @JsonProperty("BudgetPercent")
    private String budgetPercent = null;

    @JsonProperty("ReportRange")
    private String reportRange = null;

    @JsonProperty("ReportEffective")
    private String reportEffective = null;

    @JsonProperty("ReportDifficult")
    private String reportDifficult = null;

    @JsonProperty("PreStatusSol")
    private String preStatusSol = null;

    @JsonProperty("ProcessApp")
    private String processApp = null;

    @JsonProperty("EffecSol")
    private String effecSol = null;

    @JsonProperty("InterestSub")
    private String interestSub = null;

    @JsonProperty("Conclusion")
    private String conclusion = null;

    @JsonProperty("Interest")
    private Float interest = null;

    @JsonProperty("Remuneration")
    private Float remuneration = null;

    @JsonProperty("CalInterestMethod")
    private String calInterestMethod = null;

    @JsonProperty("Background")
    private String background = null;

    @JsonProperty("Share")
    private String share = null;

    @JsonProperty("PlanPlus")
    private String planPlus = null;

    @JsonProperty("Suggest")
    private String suggest = null;

    @JsonProperty("Status")
    private String status = null;

    @JsonProperty("CaseId")
    private Integer caseId = null;

    @JsonProperty("caseFolderId")
    private String caseFolderId = null;

    @JsonProperty("snapshotId")
    private String snapshotId = null;

    @JsonProperty("Bds")
    private String bds = null;

    @JsonProperty("Cra")
    private String cra = null;

    @JsonProperty("Brn")
    private String brn = null;

    @JsonProperty("Branch")
    private String branch = null;

    @JsonProperty("DeparmentCode")
    private String deparmentCode = null;

    @JsonProperty("Department")
    private String department = null;

    @JsonProperty("AcceptDate")
    private String acceptDate = null;

    @JsonProperty("RecognitionDate")
    private String recognitionDate = null;

    @JsonProperty("StatusRemuneration")
    private String statusRemuneration = null;

    @JsonProperty("StepId")
    private String stepId = null;

    @JsonProperty("nameCouncil")
    private String nameCouncil = null;

    @JsonProperty("fieldType")
    private String fieldType = null;

    @JsonProperty("LstReTranscript")
    private LstReTranscript lstReTranscript = null;

    @JsonProperty("LstResultUntillChange")
    private LstResultUntillChange lstResultUntillChange = null;

    @JsonProperty("LstPlanPlusTable")
    private LstPlanPlusTable lstPlanPlusTable = null;

    @JsonProperty("LstPlan")
    private LstPlan lstPlan = null;

    @JsonProperty("LstParty")
    private LstParty lstParty = null;

    @JsonProperty("LstListSolDepartment")
    private LstListSolDepartment lstListSolDepartment = null;

    @JsonProperty("LstListMember")
    private LstListMember lstListMember = null;

    @JsonProperty("LstListIniCouncil")
    private LstListIniCouncil lstListIniCouncil = null;

    @JsonProperty("LstListEmployee")
    private LstListEmployee lstListEmployee = null;

    @JsonProperty("LstListCouncill")
    private LstListCouncill lstListCouncill = null;

    @JsonProperty("LstListAuthor")
    private LstListAuthor lstListAuthor = null;

    @JsonProperty("LstListAcceprtCouncil")
    private LstListAcceprtCouncil lstListAcceprtCouncil = null;

    @JsonProperty("LstInitiativeTranScript")
    private LstInitiativeTranScript lstInitiativeTranScript = null;

    @JsonProperty("LstInitiativeStatus")
    private LstInitiativeStatus lstInitiativeStatus = null;

    @JsonProperty("LstHost")
    private LstHost lstHost = null;

    @JsonProperty("LstHistories")
    private LstHistories lstHistories = null;

    @JsonProperty("LstEvaluateTranscript")
    private LstEvaluateTranscript lstEvaluateTranscript = null;

    @JsonProperty("LstDutyStatus")
    private LstDutyStatus lstDutyStatus = null;

    @JsonProperty("LstEvaluateInitiative")
    private LstEvaluateInitiative lstEvaluateInitiative = null;

    @JsonProperty("LstEvaluateDuty")
    private LstEvaluateDuty lstEvaluateDuty = null;

    @JsonProperty("LstEstimateBudget")
    private LstEstimateBudget lstEstimateBudget = null;

    @JsonProperty("LstDutyPayment")
    private LstDutyPayment lstDutyPayment = null;

    @JsonProperty("LstContentStop")
    private LstContentStop lstContentStop = null;

    @JsonProperty("LstContentChange")
    private LstContentChange lstContentChange = null;

    @JsonProperty("LstCoHost")
    private LstCoHost lstCoHost = null;

    @JsonProperty("LstCadresInfor")
    private LstCadresInfor lstCadresInfor = null;

    @JsonProperty("LstAcceptTranscript")
    private LstAcceptTranscript lstAcceptTranscript = null;

    @JsonProperty("LstDocument")
    private LstDocument lstDocument = null;

    public CaseInfoModel lstDocument(LstDocument lstDocument) {
        this.lstDocument = lstDocument;
        return this;
    }

    /**
     * Get lstDocument
     *
     * @return lstDocument
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstDocument getLstDocument() {
        return lstDocument;
    }

    public void setLstDocument(LstDocument lstDocument) {
        this.lstDocument = lstDocument;
    }

    public CaseInfoModel id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(value = "")


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CaseInfoModel caseType(String caseType) {
        this.caseType = caseType;
        return this;
    }

    /**
     * Get caseType
     *
     * @return caseType
     **/
    @ApiModelProperty(value = "")


    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public CaseInfoModel projectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    /**
     * Get projectName
     *
     * @return projectName
     **/
    @ApiModelProperty(value = "")


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public CaseInfoModel projectCode(String projectCode) {
        this.projectCode = projectCode;
        return this;
    }

    public CaseInfoModel stepId(String stepId) {
        this.stepId = stepId;
        return this;
    }

    /**
     * Get stepId
     *
     * @return stepId
     **/
    @ApiModelProperty(value = "")


    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    /**
     * Get projectCode
     *
     * @return projectCode
     **/
    @ApiModelProperty(value = "")


    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public CaseInfoModel cadresName(String cadresName) {
        this.cadresName = cadresName;
        return this;
    }

    /**
     * Get cadresName
     * @return cadresName
     **/
    @ApiModelProperty(value = "")


    public String getCadresName() {
        return cadresName;
    }

    public void setCadresName(String cadresName) {
        this.cadresName = cadresName;
    }

    public CaseInfoModel cadresEmail(String cadresEmail) {
        this.cadresEmail = cadresEmail;
        return this;
    }

    /**
     * Get cadresEmail
     * @return cadresEmail
     **/
    @ApiModelProperty(value = "")


    public String getCadresEmail() {
        return cadresEmail;
    }

    public void setCadresEmail(String cadresEmail) {
        this.cadresEmail = cadresEmail;
    }



    public CaseInfoModel acceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
        return this;
    }

    /**
     * Get acceptDate
     *
     * @return acceptDate
     **/
    @ApiModelProperty(value = "")


    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    /**
     * Get recognitionDate
     *
     * @return recognitionDate
     **/
    @ApiModelProperty(value = "")


    public String getRecognitionDate() {
        return recognitionDate;
    }

    public void setRecognitionDate(String recognitionDate) {
        this.recognitionDate = recognitionDate;
    }

    public CaseInfoModel statusRemuneration(String statusRemuneration) {
        this.statusRemuneration = statusRemuneration;
        return this;
    }

    /**
     * Get statusRemuneration
     *
     * @return statusRemuneration
     **/
    @ApiModelProperty(value = "")


    public String getStatusRemuneration() {
        return statusRemuneration;
    }

    public void setStatusRemuneration(String statusRemuneration) {
        this.statusRemuneration = statusRemuneration;
    }



    public CaseInfoModel quantity(Float quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Get quantity
     *
     * @return quantity
     **/
    @ApiModelProperty(value = "")

    @Valid

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public CaseInfoModel cadresPhone(String cadresPhone) {
        this.cadresPhone = cadresPhone;
        return this;
    }

    /**
     * Get cadresPhone
     * @return cadresPhone
     **/
    @ApiModelProperty(value = "")


    public String getCadresPhone() {
        return cadresPhone;
    }

    public void setCadresPhone(String cadresPhone) {
        this.cadresPhone = cadresPhone;
    }


    /**
     * Get registerCondition
     *
     * @return registerCondition
     **/
    @ApiModelProperty(value = "")


    public String getRegisterCondition() {
        return registerCondition;
    }

    public void setRegisterCondition(String registerCondition) {
        this.registerCondition = registerCondition;
    }

    public CaseInfoModel cost(Float cost) {
        this.cost = cost;
        return this;
    }

    /**
     * Get cost
     *
     * @return cost
     **/
    @ApiModelProperty(value = "")

    @Valid

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public CaseInfoModel startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Get startDate
     *
     * @return startDate
     **/
    @ApiModelProperty(value = "")


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public CaseInfoModel endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Get endDate
     *
     * @return endDate
     **/
    @ApiModelProperty(value = "")


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public CaseInfoModel necessity(String necessity) {
        this.necessity = necessity;
        return this;
    }

    /**
     * Get necessity
     *
     * @return necessity
     **/
    @ApiModelProperty(value = "")


    public String getNecessity() {
        return necessity;
    }

    public void setNecessity(String necessity) {
        this.necessity = necessity;
    }

    public CaseInfoModel target(String target) {
        this.target = target;
        return this;
    }

    /**
     * Get target
     *
     * @return target
     **/
    @ApiModelProperty(value = "")


    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public CaseInfoModel range(String range) {
        this.range = range;
        return this;
    }

    /**
     * Get range
     *
     * @return range
     **/
    @ApiModelProperty(value = "")


    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public CaseInfoModel object(String object) {
        this.object = object;
        return this;
    }

    /**
     * Get object
     *
     * @return object
     **/
    @ApiModelProperty(value = "")


    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public CaseInfoModel method(String method) {
        this.method = method;
        return this;
    }

    /**
     * Get method
     *
     * @return method
     **/
    @ApiModelProperty(value = "")


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public CaseInfoModel data(String data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     **/
    @ApiModelProperty(value = "")


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public CaseInfoModel content(String content) {
        this.content = content;
        return this;
    }

    /**
     * Get content
     *
     * @return content
     **/
    @ApiModelProperty(value = "")


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CaseInfoModel consequence(String consequence) {
        this.consequence = consequence;
        return this;
    }

    /**
     * Get consequence
     *
     * @return consequence
     **/
    @ApiModelProperty(value = "")


    public String getConsequence() {
        return consequence;
    }

    public void setConsequence(String consequence) {
        this.consequence = consequence;
    }

    public CaseInfoModel contribute(String contribute) {
        this.contribute = contribute;
        return this;
    }

    /**
     * Get contribute
     *
     * @return contribute
     **/
    @ApiModelProperty(value = "")


    public String getContribute() {
        return contribute;
    }

    public void setContribute(String contribute) {
        this.contribute = contribute;
    }

    public CaseInfoModel weakness(String weakness) {
        this.weakness = weakness;
        return this;
    }

    /**
     * Get weakness
     *
     * @return weakness
     **/
    @ApiModelProperty(value = "")


    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public CaseInfoModel tranferMethod(String tranferMethod) {
        this.tranferMethod = tranferMethod;
        return this;
    }

    /**
     * Get tranferMethod
     *
     * @return tranferMethod
     **/
    @ApiModelProperty(value = "")


    public String getTranferMethod() {
        return tranferMethod;
    }

    public void setTranferMethod(String tranferMethod) {
        this.tranferMethod = tranferMethod;
    }

    public CaseInfoModel action(String action) {
        this.action = action;
        return this;
    }

    /**
     * Get action
     *
     * @return action
     **/
    @ApiModelProperty(value = "")


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public CaseInfoModel projectType(String projectType) {
        this.projectType = projectType;
        return this;
    }

    /**
     * Get projectType
     *
     * @return projectType
     **/
    @ApiModelProperty(value = "")


    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public CaseInfoModel topicType(String topicType) {
        this.topicType = topicType;
        return this;
    }

    /**
     * Get topicType
     *
     * @return topicType
     **/
    @ApiModelProperty(value = "")


    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public CaseInfoModel dutyOwner(String dutyOwner) {
        this.dutyOwner = dutyOwner;
        return this;
    }

    /**
     * Get dutyOwner
     *
     * @return dutyOwner
     **/
    @ApiModelProperty(value = "")


    public String getDutyOwner() {
        return dutyOwner;
    }

    public void setDutyOwner(String dutyOwner) {
        this.dutyOwner = dutyOwner;
    }

    public CaseInfoModel dutySecretary(String dutySecretary) {
        this.dutySecretary = dutySecretary;
        return this;
    }

    /**
     * Get dutySecretary
     *
     * @return dutySecretary
     **/
    @ApiModelProperty(value = "")


    public String getDutySecretary() {
        return dutySecretary;
    }

    public void setDutySecretary(String dutySecretary) {
        this.dutySecretary = dutySecretary;
    }

    public CaseInfoModel createdDate(String createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * Get createdDate
     *
     * @return createdDate
     **/
    @ApiModelProperty(value = "")


    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public CaseInfoModel projectLevel(String projectLevel) {
        this.projectLevel = projectLevel;
        return this;
    }

    /**
     * Get projectLevel
     *
     * @return projectLevel
     **/
    @ApiModelProperty(value = "")


    public String getProjectLevel() {
        return projectLevel;
    }

    public void setProjectLevel(String projectLevel) {
        this.projectLevel = projectLevel;
    }

    public CaseInfoModel topicCategory(String topicCategory) {
        this.topicCategory = topicCategory;
        return this;
    }

    /**
     * Get topicCategory
     *
     * @return topicCategory
     **/
    @ApiModelProperty(value = "")


    public String getTopicCategory() {
        return topicCategory;
    }

    public void setTopicCategory(String topicCategory) {
        this.topicCategory = topicCategory;
    }

    public CaseInfoModel evaluateBudget(String evaluateBudget) {
        this.evaluateBudget = evaluateBudget;
        return this;
    }

    /**
     * Get evaluateBudget
     *
     * @return evaluateBudget
     **/
    @ApiModelProperty(value = "")


    public String getEvaluateBudget() {
        return evaluateBudget;
    }

    public void setEvaluateBudget(String evaluateBudget) {
        this.evaluateBudget = evaluateBudget;
    }

    public CaseInfoModel presidentConclusion(String presidentConclusion) {
        this.presidentConclusion = presidentConclusion;
        return this;
    }

    /**
     * Get presidentConclusion
     *
     * @return presidentConclusion
     **/
    @ApiModelProperty(value = "")


    public String getPresidentConclusion() {
        return presidentConclusion;
    }

    public void setPresidentConclusion(String presidentConclusion) {
        this.presidentConclusion = presidentConclusion;
    }

    public CaseInfoModel recommentBudget(Float recommentBudget) {
        this.recommentBudget = recommentBudget;
        return this;
    }

    /**
     * Get recommentBudget
     *
     * @return recommentBudget
     **/
    @ApiModelProperty(value = "")

    @Valid

    public Float getRecommentBudget() {
        return recommentBudget;
    }

    public void setRecommentBudget(Float recommentBudget) {
        this.recommentBudget = recommentBudget;
    }

    public CaseInfoModel requestPerfect(String requestPerfect) {
        this.requestPerfect = requestPerfect;
        return this;
    }

    /**
     * Get requestPerfect
     *
     * @return requestPerfect
     **/
    @ApiModelProperty(value = "")


    public String getRequestPerfect() {
        return requestPerfect;
    }

    public void setRequestPerfect(String requestPerfect) {
        this.requestPerfect = requestPerfect;
    }

    public CaseInfoModel researchOverView(String researchOverView) {
        this.researchOverView = researchOverView;
        return this;
    }

    /**
     * Get researchOverView
     *
     * @return researchOverView
     **/
    @ApiModelProperty(value = "")


    public String getResearchOverView() {
        return researchOverView;
    }

    public void setResearchOverView(String researchOverView) {
        this.researchOverView = researchOverView;
    }

    public CaseInfoModel researchMethod(String researchMethod) {
        this.researchMethod = researchMethod;
        return this;
    }

    /**
     * Get researchMethod
     *
     * @return researchMethod
     **/
    @ApiModelProperty(value = "")


    public String getResearchMethod() {
        return researchMethod;
    }

    public void setResearchMethod(String researchMethod) {
        this.researchMethod = researchMethod;
    }

    public CaseInfoModel researchResult(String researchResult) {
        this.researchResult = researchResult;
        return this;
    }

    /**
     * Get researchResult
     *
     * @return researchResult
     **/
    @ApiModelProperty(value = "")


    public String getResearchResult() {
        return researchResult;
    }

    public void setResearchResult(String researchResult) {
        this.researchResult = researchResult;
    }

    public CaseInfoModel orientation(String orientation) {
        this.orientation = orientation;
        return this;
    }

    /**
     * Get orientation
     *
     * @return orientation
     **/
    @ApiModelProperty(value = "")


    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public CaseInfoModel reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * Get reference
     *
     * @return reference
     **/
    @ApiModelProperty(value = "")


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CaseInfoModel extensionDate(String extensionDate) {
        this.extensionDate = extensionDate;
        return this;
    }

    /**
     * Get extensionDate
     *
     * @return extensionDate
     **/
    @ApiModelProperty(value = "")


    public String getExtensionDate() {
        return extensionDate;
    }

    public void setExtensionDate(String extensionDate) {
        this.extensionDate = extensionDate;
    }

    public CaseInfoModel contractNo(String contractNo) {
        this.contractNo = contractNo;
        return this;
    }

    /**
     * Get contractNo
     *
     * @return contractNo
     **/
    @ApiModelProperty(value = "")


    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public CaseInfoModel accomanyDoc(String accomanyDoc) {
        this.accomanyDoc = accomanyDoc;
        return this;
    }

    /**
     * Get accomanyDoc
     *
     * @return accomanyDoc
     **/
    @ApiModelProperty(value = "")


    public String getAccomanyDoc() {
        return accomanyDoc;
    }

    public void setAccomanyDoc(String accomanyDoc) {
        this.accomanyDoc = accomanyDoc;
    }

    public CaseInfoModel note(String note) {
        this.note = note;
        return this;
    }

    /**
     * Get note
     *
     * @return note
     **/
    @ApiModelProperty(value = "")


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public CaseInfoModel budgetPercent(String budgetPercent) {
        this.budgetPercent = budgetPercent;
        return this;
    }

    /**
     * Get budgetPercent
     *
     * @return budgetPercent
     **/
    @ApiModelProperty(value = "")


    public String getBudgetPercent() {
        return budgetPercent;
    }

    public void setBudgetPercent(String budgetPercent) {
        this.budgetPercent = budgetPercent;
    }

    public CaseInfoModel reportRange(String reportRange) {
        this.reportRange = reportRange;
        return this;
    }

    /**
     * Get reportRange
     *
     * @return reportRange
     **/
    @ApiModelProperty(value = "")


    public String getReportRange() {
        return reportRange;
    }

    public void setReportRange(String reportRange) {
        this.reportRange = reportRange;
    }

    public CaseInfoModel reportEffective(String reportEffective) {
        this.reportEffective = reportEffective;
        return this;
    }

    /**
     * Get reportEffective
     *
     * @return reportEffective
     **/
    @ApiModelProperty(value = "")


    public String getReportEffective() {
        return reportEffective;
    }

    public void setReportEffective(String reportEffective) {
        this.reportEffective = reportEffective;
    }

    public CaseInfoModel reportDifficult(String reportDifficult) {
        this.reportDifficult = reportDifficult;
        return this;
    }

    /**
     * Get reportDifficult
     *
     * @return reportDifficult
     **/
    @ApiModelProperty(value = "")


    public String getReportDifficult() {
        return reportDifficult;
    }

    public void setReportDifficult(String reportDifficult) {
        this.reportDifficult = reportDifficult;
    }

    public CaseInfoModel preStatusSol(String preStatusSol) {
        this.preStatusSol = preStatusSol;
        return this;
    }

    /**
     * Get preStatusSol
     *
     * @return preStatusSol
     **/
    @ApiModelProperty(value = "")


    public String getPreStatusSol() {
        return preStatusSol;
    }

    public void setPreStatusSol(String preStatusSol) {
        this.preStatusSol = preStatusSol;
    }

    public CaseInfoModel processApp(String processApp) {
        this.processApp = processApp;
        return this;
    }

    /**
     * Get processApp
     *
     * @return processApp
     **/
    @ApiModelProperty(value = "")


    public String getProcessApp() {
        return processApp;
    }

    public void setProcessApp(String processApp) {
        this.processApp = processApp;
    }

    public CaseInfoModel effecSol(String effecSol) {
        this.effecSol = effecSol;
        return this;
    }

    /**
     * Get effecSol
     *
     * @return effecSol
     **/
    @ApiModelProperty(value = "")


    public String getEffecSol() {
        return effecSol;
    }

    public void setEffecSol(String effecSol) {
        this.effecSol = effecSol;
    }

    public CaseInfoModel interestSub(String interestSub) {
        this.interestSub = interestSub;
        return this;
    }

    /**
     * Get interestSub
     *
     * @return interestSub
     **/
    @ApiModelProperty(value = "")


    public String getInterestSub() {
        return interestSub;
    }

    public void setInterestSub(String interestSub) {
        this.interestSub = interestSub;
    }

    public CaseInfoModel conclusion(String conclusion) {
        this.conclusion = conclusion;
        return this;
    }

    /**
     * Get conclusion
     *
     * @return conclusion
     **/
    @ApiModelProperty(value = "")


    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public CaseInfoModel interest(Float interest) {
        this.interest = interest;
        return this;
    }

    /**
     * Get interest
     *
     * @return interest
     **/
    @ApiModelProperty(value = "")

    @Valid

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }

    public CaseInfoModel remuneration(Float remuneration) {
        this.remuneration = remuneration;
        return this;
    }

    /**
     * Get remuneration
     *
     * @return remuneration
     **/
    @ApiModelProperty(value = "")

    @Valid

    public Float getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(Float remuneration) {
        this.remuneration = remuneration;
    }

    public CaseInfoModel calInterestMethod(String calInterestMethod) {
        this.calInterestMethod = calInterestMethod;
        return this;
    }

    /**
     * Get calInterestMethod
     *
     * @return calInterestMethod
     **/
    @ApiModelProperty(value = "")


    public String getCalInterestMethod() {
        return calInterestMethod;
    }

    public void setCalInterestMethod(String calInterestMethod) {
        this.calInterestMethod = calInterestMethod;
    }

    public CaseInfoModel background(String background) {
        this.background = background;
        return this;
    }

    /**
     * Get background
     *
     * @return background
     **/
    @ApiModelProperty(value = "")


    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public CaseInfoModel share(String share) {
        this.share = share;
        return this;
    }

    /**
     * Get share
     *
     * @return share
     **/
    @ApiModelProperty(value = "")


    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public CaseInfoModel planPlus(String planPlus) {
        this.planPlus = planPlus;
        return this;
    }

    /**
     * Get planPlus
     *
     * @return planPlus
     **/
    @ApiModelProperty(value = "")


    public String getPlanPlus() {
        return planPlus;
    }

    public void setPlanPlus(String planPlus) {
        this.planPlus = planPlus;
    }

    public CaseInfoModel suggest(String suggest) {
        this.suggest = suggest;
        return this;
    }

    /**
     * Get suggest
     *
     * @return suggest
     **/
    @ApiModelProperty(value = "")


    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public CaseInfoModel status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    @ApiModelProperty(value = "")


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CaseInfoModel caseId(Integer caseId) {
        this.caseId = caseId;
        return this;
    }

    /**
     * Get caseId
     *
     * @return caseId
     **/
    @ApiModelProperty(value = "")


    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public CaseInfoModel bds(String bds) {
        this.bds = bds;
        return this;
    }

    /**
     * Get bds
     *
     * @return bds
     **/
    @ApiModelProperty(value = "")


    public String getBds() {
        return bds;
    }

    public void setBds(String bds) {
        this.bds = bds;
    }

    public CaseInfoModel cra(String cra) {
        this.cra = cra;
        return this;
    }

    /**
     * Get cra
     *
     * @return cra
     **/
    @ApiModelProperty(value = "")


    public String getCra() {
        return cra;
    }

    public void setCra(String cra) {
        this.cra = cra;
    }

    public CaseInfoModel brn(String brn) {
        this.brn = brn;
        return this;
    }

    /**
     * Get brn
     *
     * @return brn
     **/
    @ApiModelProperty(value = "")


    public String getBrn() {
        return brn;
    }

    public void setBrn(String brn) {
        this.brn = brn;
    }

    public CaseInfoModel branch(String branch) {
        this.branch = branch;
        return this;
    }

    /**
     * Get branch
     *
     * @return branch
     **/
    @ApiModelProperty(value = "")


    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public CaseInfoModel deparmentCode(String deparmentCode) {
        this.deparmentCode = deparmentCode;
        return this;
    }

    public CaseInfoModel fieldType(String fieldType) {
        this.fieldType = fieldType;
        return this;
    }

    /**
     * Get fieldType
     *
     * @return fieldType
     **/
    @ApiModelProperty(value = "")


    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public CaseInfoModel nameCouncil(String nameCouncil) {
        this.nameCouncil = nameCouncil;
        return this;
    }

    /**
     * Get nameCouncil
     *
     * @return nameCouncil
     **/
    @ApiModelProperty(value = "")


    public String getNameCouncil() {
        return nameCouncil;
    }

    public void setNameCouncil(String nameCouncil) {
        this.nameCouncil = nameCouncil;
    }

    /**
     * Get deparmentCode
     *
     * @return deparmentCode
     **/
    @ApiModelProperty(value = "")


    public String getDeparmentCode() {
        return deparmentCode;
    }

    public void setDeparmentCode(String deparmentCode) {
        this.deparmentCode = deparmentCode;
    }

    public CaseInfoModel department(String department) {
        this.department = department;
        return this;
    }

    /**
     * Get department
     *
     * @return department
     **/
    @ApiModelProperty(value = "")


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public CaseInfoModel lstReTranscript(LstReTranscript lstReTranscript) {
        this.lstReTranscript = lstReTranscript;
        return this;
    }

    /**
     * Get lstReTranscript
     *
     * @return lstReTranscript
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstReTranscript getLstReTranscript() {
        return lstReTranscript;
    }

    public void setLstReTranscript(LstReTranscript lstReTranscript) {
        this.lstReTranscript = lstReTranscript;
    }

    public CaseInfoModel lstResultUntillChange(LstResultUntillChange lstResultUntillChange) {
        this.lstResultUntillChange = lstResultUntillChange;
        return this;
    }

    public CaseInfoModel caseFolderId(String caseFolderId) {
        this.caseFolderId = caseFolderId;
        return this;
    }

    /**
     * Get caseFolderId
     *
     * @return caseFolderId
     **/
    @ApiModelProperty(value = "")


    public String getCaseFolderId() {
        return caseFolderId;
    }

    public void setCaseFolderId(String caseFolderId) {
        this.caseFolderId = caseFolderId;
    }

    /**
     * Get lstResultUntillChange
     *
     * @return lstResultUntillChange
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstResultUntillChange getLstResultUntillChange() {
        return lstResultUntillChange;
    }

    public void setLstResultUntillChange(LstResultUntillChange lstResultUntillChange) {
        this.lstResultUntillChange = lstResultUntillChange;
    }

    public CaseInfoModel lstPlanPlusTable(LstPlanPlusTable lstPlanPlusTable) {
        this.lstPlanPlusTable = lstPlanPlusTable;
        return this;
    }

    /**
     * Get lstPlanPlusTable
     *
     * @return lstPlanPlusTable
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstPlanPlusTable getLstPlanPlusTable() {
        return lstPlanPlusTable;
    }

    public void setLstPlanPlusTable(LstPlanPlusTable lstPlanPlusTable) {
        this.lstPlanPlusTable = lstPlanPlusTable;
    }

    public CaseInfoModel lstPlan(LstPlan lstPlan) {
        this.lstPlan = lstPlan;
        return this;
    }

    /**
     * Get lstPlan
     *
     * @return lstPlan
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstPlan getLstPlan() {
        return lstPlan;
    }

    public void setLstPlan(LstPlan lstPlan) {
        this.lstPlan = lstPlan;
    }

    public CaseInfoModel lstParty(LstParty lstParty) {
        this.lstParty = lstParty;
        return this;
    }

    /**
     * Get lstParty
     *
     * @return lstParty
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstParty getLstParty() {
        return lstParty;
    }

    public void setLstParty(LstParty lstParty) {
        this.lstParty = lstParty;
    }

    public CaseInfoModel lstListSolDepartment(LstListSolDepartment lstListSolDepartment) {
        this.lstListSolDepartment = lstListSolDepartment;
        return this;
    }

    /**
     * Get lstListSolDepartment
     *
     * @return lstListSolDepartment
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstListSolDepartment getLstListSolDepartment() {
        return lstListSolDepartment;
    }

    public void setLstListSolDepartment(LstListSolDepartment lstListSolDepartment) {
        this.lstListSolDepartment = lstListSolDepartment;
    }

    public CaseInfoModel lstListMember(LstListMember lstListMember) {
        this.lstListMember = lstListMember;
        return this;
    }

    /**
     * Get lstListMember
     *
     * @return lstListMember
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstListMember getLstListMember() {
        return lstListMember;
    }

    public void setLstListMember(LstListMember lstListMember) {
        this.lstListMember = lstListMember;
    }

    public CaseInfoModel lstListIniCouncil(LstListIniCouncil lstListIniCouncil) {
        this.lstListIniCouncil = lstListIniCouncil;
        return this;
    }

    /**
     * Get lstListIniCouncil
     *
     * @return lstListIniCouncil
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstListIniCouncil getLstListIniCouncil() {
        return lstListIniCouncil;
    }

    public void setLstListIniCouncil(LstListIniCouncil lstListIniCouncil) {
        this.lstListIniCouncil = lstListIniCouncil;
    }

    public CaseInfoModel lstListEmployee(LstListEmployee lstListEmployee) {
        this.lstListEmployee = lstListEmployee;
        return this;
    }

    /**
     * Get lstListEmployee
     *
     * @return lstListEmployee
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstListEmployee getLstListEmployee() {
        return lstListEmployee;
    }

    public void setLstListEmployee(LstListEmployee lstListEmployee) {
        this.lstListEmployee = lstListEmployee;
    }

    public CaseInfoModel lstListCouncill(LstListCouncill lstListCouncill) {
        this.lstListCouncill = lstListCouncill;
        return this;
    }

    /**
     * Get lstListCouncill
     *
     * @return lstListCouncill
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstListCouncill getLstListCouncill() {
        return lstListCouncill;
    }

    public void setLstListCouncill(LstListCouncill lstListCouncill) {
        this.lstListCouncill = lstListCouncill;
    }

    public CaseInfoModel lstListAuthor(LstListAuthor lstListAuthor) {
        this.lstListAuthor = lstListAuthor;
        return this;
    }

    /**
     * Get lstListAuthor
     *
     * @return lstListAuthor
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstListAuthor getLstListAuthor() {
        return lstListAuthor;
    }

    public void setLstListAuthor(LstListAuthor lstListAuthor) {
        this.lstListAuthor = lstListAuthor;
    }

    public CaseInfoModel lstListAcceprtCouncil(LstListAcceprtCouncil lstListAcceprtCouncil) {
        this.lstListAcceprtCouncil = lstListAcceprtCouncil;
        return this;
    }

    /**
     * Get lstListAcceprtCouncil
     *
     * @return lstListAcceprtCouncil
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstListAcceprtCouncil getLstListAcceprtCouncil() {
        return lstListAcceprtCouncil;
    }

    public void setLstListAcceprtCouncil(LstListAcceprtCouncil lstListAcceprtCouncil) {
        this.lstListAcceprtCouncil = lstListAcceprtCouncil;
    }

    public CaseInfoModel lstInitiativeTranScript(LstInitiativeTranScript lstInitiativeTranScript) {
        this.lstInitiativeTranScript = lstInitiativeTranScript;
        return this;
    }

    /**
     * Get lstInitiativeTranScript
     *
     * @return lstInitiativeTranScript
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstInitiativeTranScript getLstInitiativeTranScript() {
        return lstInitiativeTranScript;
    }

    public void setLstInitiativeTranScript(LstInitiativeTranScript lstInitiativeTranScript) {
        this.lstInitiativeTranScript = lstInitiativeTranScript;
    }

    public CaseInfoModel lstInitiativeStatus(LstInitiativeStatus lstInitiativeStatus) {
        this.lstInitiativeStatus = lstInitiativeStatus;
        return this;
    }

    /**
     * Get lstInitiativeStatus
     *
     * @return lstInitiativeStatus
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstInitiativeStatus getLstInitiativeStatus() {
        return lstInitiativeStatus;
    }

    public void setLstInitiativeStatus(LstInitiativeStatus lstInitiativeStatus) {
        this.lstInitiativeStatus = lstInitiativeStatus;
    }

    public CaseInfoModel lstHost(LstHost lstHost) {
        this.lstHost = lstHost;
        return this;
    }

    /**
     * Get lstHost
     *
     * @return lstHost
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstHost getLstHost() {
        return lstHost;
    }

    public void setLstHost(LstHost lstHost) {
        this.lstHost = lstHost;
    }

    public CaseInfoModel lstHistories(LstHistories lstHistories) {
        this.lstHistories = lstHistories;
        return this;
    }

    /**
     * Get lstHistories
     *
     * @return lstHistories
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstHistories getLstHistories() {
        return lstHistories;
    }

    public void setLstHistories(LstHistories lstHistories) {
        this.lstHistories = lstHistories;
    }

    public CaseInfoModel lstEvaluateTranscript(LstEvaluateTranscript lstEvaluateTranscript) {
        this.lstEvaluateTranscript = lstEvaluateTranscript;
        return this;
    }

    /**
     * Get lstEvaluateTranscript
     *
     * @return lstEvaluateTranscript
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstEvaluateTranscript getLstEvaluateTranscript() {
        return lstEvaluateTranscript;
    }

    public void setLstEvaluateTranscript(LstEvaluateTranscript lstEvaluateTranscript) {
        this.lstEvaluateTranscript = lstEvaluateTranscript;
    }

    public CaseInfoModel lstDutyStatus(LstDutyStatus lstDutyStatus) {
        this.lstDutyStatus = lstDutyStatus;
        return this;
    }

    /**
     * Get lstDutyStatus
     *
     * @return lstDutyStatus
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstDutyStatus getLstDutyStatus() {
        return lstDutyStatus;
    }

    public void setLstDutyStatus(LstDutyStatus lstDutyStatus) {
        this.lstDutyStatus = lstDutyStatus;
    }

    public CaseInfoModel lstEvaluateInitiative(LstEvaluateInitiative lstEvaluateInitiative) {
        this.lstEvaluateInitiative = lstEvaluateInitiative;
        return this;
    }

    /**
     * Get lstEvaluateInitiative
     *
     * @return lstEvaluateInitiative
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstEvaluateInitiative getLstEvaluateInitiative() {
        return lstEvaluateInitiative;
    }

    public void setLstEvaluateInitiative(LstEvaluateInitiative lstEvaluateInitiative) {
        this.lstEvaluateInitiative = lstEvaluateInitiative;
    }

    public CaseInfoModel lstEvaluateDuty(LstEvaluateDuty lstEvaluateDuty) {
        this.lstEvaluateDuty = lstEvaluateDuty;
        return this;
    }

    /**
     * Get lstEvaluateDuty
     *
     * @return lstEvaluateDuty
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstEvaluateDuty getLstEvaluateDuty() {
        return lstEvaluateDuty;
    }

    public void setLstEvaluateDuty(LstEvaluateDuty lstEvaluateDuty) {
        this.lstEvaluateDuty = lstEvaluateDuty;
    }

    public CaseInfoModel lstEstimateBudget(LstEstimateBudget lstEstimateBudget) {
        this.lstEstimateBudget = lstEstimateBudget;
        return this;
    }

    /**
     * Get lstEstimateBudget
     *
     * @return lstEstimateBudget
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstEstimateBudget getLstEstimateBudget() {
        return lstEstimateBudget;
    }

    public void setLstEstimateBudget(LstEstimateBudget lstEstimateBudget) {
        this.lstEstimateBudget = lstEstimateBudget;
    }

    public CaseInfoModel lstDutyPayment(LstDutyPayment lstDutyPayment) {
        this.lstDutyPayment = lstDutyPayment;
        return this;
    }

    /**
     * Get lstDutyPayment
     *
     * @return lstDutyPayment
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstDutyPayment getLstDutyPayment() {
        return lstDutyPayment;
    }

    public void setLstDutyPayment(LstDutyPayment lstDutyPayment) {
        this.lstDutyPayment = lstDutyPayment;
    }

    public CaseInfoModel lstContentStop(LstContentStop lstContentStop) {
        this.lstContentStop = lstContentStop;
        return this;
    }

    /**
     * Get lstContentStop
     *
     * @return lstContentStop
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstContentStop getLstContentStop() {
        return lstContentStop;
    }

    public void setLstContentStop(LstContentStop lstContentStop) {
        this.lstContentStop = lstContentStop;
    }

    public CaseInfoModel lstContentChange(LstContentChange lstContentChange) {
        this.lstContentChange = lstContentChange;
        return this;
    }

    /**
     * Get lstContentChange
     *
     * @return lstContentChange
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstContentChange getLstContentChange() {
        return lstContentChange;
    }

    public void setLstContentChange(LstContentChange lstContentChange) {
        this.lstContentChange = lstContentChange;
    }

    public CaseInfoModel lstCoHost(LstCoHost lstCoHost) {
        this.lstCoHost = lstCoHost;
        return this;
    }

    /**
     * Get lstCoHost
     *
     * @return lstCoHost
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstCoHost getLstCoHost() {
        return lstCoHost;
    }

    public void setLstCoHost(LstCoHost lstCoHost) {
        this.lstCoHost = lstCoHost;
    }

    public CaseInfoModel lstCadresInfor(LstCadresInfor lstCadresInfor) {
        this.lstCadresInfor = lstCadresInfor;
        return this;
    }

    /**
     * Get lstCadresInfor
     *
     * @return lstCadresInfor
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstCadresInfor getLstCadresInfor() {
        return lstCadresInfor;
    }

    public void setLstCadresInfor(LstCadresInfor lstCadresInfor) {
        this.lstCadresInfor = lstCadresInfor;
    }

    public CaseInfoModel lstAcceptTranscript(LstAcceptTranscript lstAcceptTranscript) {
        this.lstAcceptTranscript = lstAcceptTranscript;
        return this;
    }

    /**
     * Get lstAcceptTranscript
     *
     * @return lstAcceptTranscript
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstAcceptTranscript getLstAcceptTranscript() {
        return lstAcceptTranscript;
    }

    public void setLstAcceptTranscript(LstAcceptTranscript lstAcceptTranscript) {
        this.lstAcceptTranscript = lstAcceptTranscript;
    }

    public CaseInfoModel snapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
        return this;
    }

    /**
     * Get snapshotId
     * @return snapshotId
     **/
    @ApiModelProperty(value = "")


    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CaseInfoModel caseInfoModel = (CaseInfoModel) o;
        return Objects.equals(this.id, caseInfoModel.id) &&
                Objects.equals(this.caseType, caseInfoModel.caseType) &&
                Objects.equals(this.projectName, caseInfoModel.projectName) &&
                Objects.equals(this.projectCode, caseInfoModel.projectCode) &&
                Objects.equals(this.cadresName, caseInfoModel.cadresName) &&
                Objects.equals(this.cadresEmail, caseInfoModel.cadresEmail) &&
                Objects.equals(this.quantity, caseInfoModel.quantity) &&
                Objects.equals(this.cadresPhone, caseInfoModel.cadresPhone) &&
                Objects.equals(this.registerCondition, caseInfoModel.registerCondition) &&
                Objects.equals(this.cost, caseInfoModel.cost) &&
                Objects.equals(this.startDate, caseInfoModel.startDate) &&
                Objects.equals(this.endDate, caseInfoModel.endDate) &&
                Objects.equals(this.necessity, caseInfoModel.necessity) &&
                Objects.equals(this.target, caseInfoModel.target) &&
                Objects.equals(this.range, caseInfoModel.range) &&
                Objects.equals(this.object, caseInfoModel.object) &&
                Objects.equals(this.method, caseInfoModel.method) &&
                Objects.equals(this.data, caseInfoModel.data) &&
                Objects.equals(this.content, caseInfoModel.content) &&
                Objects.equals(this.consequence, caseInfoModel.consequence) &&
                Objects.equals(this.contribute, caseInfoModel.contribute) &&
                Objects.equals(this.weakness, caseInfoModel.weakness) &&
                Objects.equals(this.tranferMethod, caseInfoModel.tranferMethod) &&
                Objects.equals(this.action, caseInfoModel.action) &&
                Objects.equals(this.projectType, caseInfoModel.projectType) &&
                Objects.equals(this.topicType, caseInfoModel.topicType) &&
                Objects.equals(this.dutyOwner, caseInfoModel.dutyOwner) &&
                Objects.equals(this.dutySecretary, caseInfoModel.dutySecretary) &&
                Objects.equals(this.createdDate, caseInfoModel.createdDate) &&
                Objects.equals(this.projectLevel, caseInfoModel.projectLevel) &&
                Objects.equals(this.topicCategory, caseInfoModel.topicCategory) &&
                Objects.equals(this.evaluateBudget, caseInfoModel.evaluateBudget) &&
                Objects.equals(this.presidentConclusion, caseInfoModel.presidentConclusion) &&
                Objects.equals(this.recommentBudget, caseInfoModel.recommentBudget) &&
                Objects.equals(this.requestPerfect, caseInfoModel.requestPerfect) &&
                Objects.equals(this.researchOverView, caseInfoModel.researchOverView) &&
                Objects.equals(this.researchMethod, caseInfoModel.researchMethod) &&
                Objects.equals(this.researchResult, caseInfoModel.researchResult) &&
                Objects.equals(this.orientation, caseInfoModel.orientation) &&
                Objects.equals(this.reference, caseInfoModel.reference) &&
                Objects.equals(this.extensionDate, caseInfoModel.extensionDate) &&
                Objects.equals(this.contractNo, caseInfoModel.contractNo) &&
                Objects.equals(this.accomanyDoc, caseInfoModel.accomanyDoc) &&
                Objects.equals(this.note, caseInfoModel.note) &&
                Objects.equals(this.budgetPercent, caseInfoModel.budgetPercent) &&
                Objects.equals(this.reportRange, caseInfoModel.reportRange) &&
                Objects.equals(this.reportEffective, caseInfoModel.reportEffective) &&
                Objects.equals(this.reportDifficult, caseInfoModel.reportDifficult) &&
                Objects.equals(this.preStatusSol, caseInfoModel.preStatusSol) &&
                Objects.equals(this.processApp, caseInfoModel.processApp) &&
                Objects.equals(this.effecSol, caseInfoModel.effecSol) &&
                Objects.equals(this.interestSub, caseInfoModel.interestSub) &&
                Objects.equals(this.conclusion, caseInfoModel.conclusion) &&
                Objects.equals(this.interest, caseInfoModel.interest) &&
                Objects.equals(this.remuneration, caseInfoModel.remuneration) &&
                Objects.equals(this.calInterestMethod, caseInfoModel.calInterestMethod) &&
                Objects.equals(this.background, caseInfoModel.background) &&
                Objects.equals(this.share, caseInfoModel.share) &&
                Objects.equals(this.planPlus, caseInfoModel.planPlus) &&
                Objects.equals(this.suggest, caseInfoModel.suggest) &&
                Objects.equals(this.status, caseInfoModel.status) &&
                Objects.equals(this.caseId, caseInfoModel.caseId) &&
                Objects.equals(this.bds, caseInfoModel.bds) &&
                Objects.equals(this.cra, caseInfoModel.cra) &&
                Objects.equals(this.brn, caseInfoModel.brn) &&
                Objects.equals(this.branch, caseInfoModel.branch) &&
                Objects.equals(this.deparmentCode, caseInfoModel.deparmentCode) &&
                Objects.equals(this.department, caseInfoModel.department) &&
                Objects.equals(this.lstReTranscript, caseInfoModel.lstReTranscript) &&
                Objects.equals(this.lstResultUntillChange, caseInfoModel.lstResultUntillChange) &&
                Objects.equals(this.lstPlanPlusTable, caseInfoModel.lstPlanPlusTable) &&
                Objects.equals(this.lstPlan, caseInfoModel.lstPlan) &&
                Objects.equals(this.lstParty, caseInfoModel.lstParty) &&
                Objects.equals(this.lstListSolDepartment, caseInfoModel.lstListSolDepartment) &&
                Objects.equals(this.lstListMember, caseInfoModel.lstListMember) &&
                Objects.equals(this.lstListIniCouncil, caseInfoModel.lstListIniCouncil) &&
                Objects.equals(this.lstListEmployee, caseInfoModel.lstListEmployee) &&
                Objects.equals(this.lstListCouncill, caseInfoModel.lstListCouncill) &&
                Objects.equals(this.lstListAuthor, caseInfoModel.lstListAuthor) &&
                Objects.equals(this.lstListAcceprtCouncil, caseInfoModel.lstListAcceprtCouncil) &&
                Objects.equals(this.lstInitiativeTranScript, caseInfoModel.lstInitiativeTranScript) &&
                Objects.equals(this.lstInitiativeStatus, caseInfoModel.lstInitiativeStatus) &&
                Objects.equals(this.lstHost, caseInfoModel.lstHost) &&
                Objects.equals(this.acceptDate, caseInfoModel.acceptDate) &&
                Objects.equals(this.recognitionDate, caseInfoModel.recognitionDate) &&
                Objects.equals(this.statusRemuneration, caseInfoModel.statusRemuneration) &&
                Objects.equals(this.stepId, caseInfoModel.stepId) &&
                Objects.equals(this.fieldType, caseInfoModel.fieldType) &&
                Objects.equals(this.nameCouncil, caseInfoModel.nameCouncil) &&
                Objects.equals(this.caseFolderId, caseInfoModel.caseFolderId) &&
                Objects.equals(this.snapshotId, caseInfoModel.snapshotId) &&
                Objects.equals(this.lstHistories, caseInfoModel.lstHistories) &&
                Objects.equals(this.lstEvaluateTranscript, caseInfoModel.lstEvaluateTranscript) &&
                Objects.equals(this.lstDutyStatus, caseInfoModel.lstDutyStatus) &&
                Objects.equals(this.lstEvaluateInitiative, caseInfoModel.lstEvaluateInitiative) &&
                Objects.equals(this.lstEvaluateDuty, caseInfoModel.lstEvaluateDuty) &&
                Objects.equals(this.lstEstimateBudget, caseInfoModel.lstEstimateBudget) &&
                Objects.equals(this.lstDutyPayment, caseInfoModel.lstDutyPayment) &&
                Objects.equals(this.lstContentStop, caseInfoModel.lstContentStop) &&
                Objects.equals(this.lstContentChange, caseInfoModel.lstContentChange) &&
                Objects.equals(this.lstCoHost, caseInfoModel.lstCoHost) &&
                Objects.equals(this.lstCadresInfor, caseInfoModel.lstCadresInfor) &&
                Objects.equals(this.lstAcceptTranscript, caseInfoModel.lstAcceptTranscript) &&
                Objects.equals(this.lstDocument, caseInfoModel.lstDocument);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, caseType, projectName, projectCode,  cadresName, cadresEmail, quantity, cadresPhone, registerCondition, cost, startDate, endDate, necessity, target, range, object, method, data, content, consequence, contribute, weakness, tranferMethod, action, projectType, topicType, dutyOwner, dutySecretary, createdDate, projectLevel, topicCategory, evaluateBudget, presidentConclusion, recommentBudget, requestPerfect, researchOverView, researchMethod, researchResult, orientation, reference, extensionDate, contractNo, accomanyDoc, note, budgetPercent, reportRange, reportEffective, reportDifficult, preStatusSol, processApp, effecSol, interestSub, conclusion, interest, remuneration, calInterestMethod, background, share, planPlus, suggest, status, caseId, bds, cra, brn, branch, deparmentCode, department, acceptDate, recognitionDate, statusRemuneration, stepId, fieldType, nameCouncil, caseFolderId, snapshotId, lstReTranscript, lstResultUntillChange, lstPlanPlusTable, lstPlan, lstParty, lstListSolDepartment, lstListMember, lstListIniCouncil, lstListEmployee, lstListCouncill, lstListAuthor, lstListAcceprtCouncil, lstInitiativeTranScript, lstInitiativeStatus, lstHost, lstHistories, lstEvaluateTranscript, lstDutyStatus, lstEvaluateInitiative, lstEvaluateDuty, lstEstimateBudget, lstDutyPayment, lstContentStop, lstContentChange, lstCoHost, lstCadresInfor, lstAcceptTranscript, lstDocument);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CaseInfoModel {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    caseType: ").append(toIndentedString(caseType)).append("\n");
        sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
        sb.append("    projectCode: ").append(toIndentedString(projectCode)).append("\n");
        sb.append("    cadresName: ").append(toIndentedString(cadresName)).append("\n");
        sb.append("    cadresEmail: ").append(toIndentedString(cadresEmail)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("    cadresPhone: ").append(toIndentedString(cadresPhone)).append("\n");
        sb.append("    registerCondition: ").append(toIndentedString(registerCondition)).append("\n");
        sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    necessity: ").append(toIndentedString(necessity)).append("\n");
        sb.append("    target: ").append(toIndentedString(target)).append("\n");
        sb.append("    range: ").append(toIndentedString(range)).append("\n");
        sb.append("    object: ").append(toIndentedString(object)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    consequence: ").append(toIndentedString(consequence)).append("\n");
        sb.append("    contribute: ").append(toIndentedString(contribute)).append("\n");
        sb.append("    weakness: ").append(toIndentedString(weakness)).append("\n");
        sb.append("    tranferMethod: ").append(toIndentedString(tranferMethod)).append("\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    projectType: ").append(toIndentedString(projectType)).append("\n");
        sb.append("    topicType: ").append(toIndentedString(topicType)).append("\n");
        sb.append("    dutyOwner: ").append(toIndentedString(dutyOwner)).append("\n");
        sb.append("    dutySecretary: ").append(toIndentedString(dutySecretary)).append("\n");
        sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
        sb.append("    projectLevel: ").append(toIndentedString(projectLevel)).append("\n");
        sb.append("    topicCategory: ").append(toIndentedString(topicCategory)).append("\n");
        sb.append("    evaluateBudget: ").append(toIndentedString(evaluateBudget)).append("\n");
        sb.append("    presidentConclusion: ").append(toIndentedString(presidentConclusion)).append("\n");
        sb.append("    recommentBudget: ").append(toIndentedString(recommentBudget)).append("\n");
        sb.append("    requestPerfect: ").append(toIndentedString(requestPerfect)).append("\n");
        sb.append("    researchOverView: ").append(toIndentedString(researchOverView)).append("\n");
        sb.append("    researchMethod: ").append(toIndentedString(researchMethod)).append("\n");
        sb.append("    researchResult: ").append(toIndentedString(researchResult)).append("\n");
        sb.append("    orientation: ").append(toIndentedString(orientation)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    extensionDate: ").append(toIndentedString(extensionDate)).append("\n");
        sb.append("    contractNo: ").append(toIndentedString(contractNo)).append("\n");
        sb.append("    accomanyDoc: ").append(toIndentedString(accomanyDoc)).append("\n");
        sb.append("    note: ").append(toIndentedString(note)).append("\n");
        sb.append("    budgetPercent: ").append(toIndentedString(budgetPercent)).append("\n");
        sb.append("    reportRange: ").append(toIndentedString(reportRange)).append("\n");
        sb.append("    reportEffective: ").append(toIndentedString(reportEffective)).append("\n");
        sb.append("    reportDifficult: ").append(toIndentedString(reportDifficult)).append("\n");
        sb.append("    preStatusSol: ").append(toIndentedString(preStatusSol)).append("\n");
        sb.append("    processApp: ").append(toIndentedString(processApp)).append("\n");
        sb.append("    effecSol: ").append(toIndentedString(effecSol)).append("\n");
        sb.append("    interestSub: ").append(toIndentedString(interestSub)).append("\n");
        sb.append("    conclusion: ").append(toIndentedString(conclusion)).append("\n");
        sb.append("    interest: ").append(toIndentedString(interest)).append("\n");
        sb.append("    remuneration: ").append(toIndentedString(remuneration)).append("\n");
        sb.append("    calInterestMethod: ").append(toIndentedString(calInterestMethod)).append("\n");
        sb.append("    background: ").append(toIndentedString(background)).append("\n");
        sb.append("    share: ").append(toIndentedString(share)).append("\n");
        sb.append("    planPlus: ").append(toIndentedString(planPlus)).append("\n");
        sb.append("    suggest: ").append(toIndentedString(suggest)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
        sb.append("    bds: ").append(toIndentedString(bds)).append("\n");
        sb.append("    cra: ").append(toIndentedString(cra)).append("\n");
        sb.append("    brn: ").append(toIndentedString(brn)).append("\n");
        sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
        sb.append("    deparmentCode: ").append(toIndentedString(deparmentCode)).append("\n");
        sb.append("    department: ").append(toIndentedString(department)).append("\n");
        sb.append("    acceptDate: ").append(toIndentedString(acceptDate)).append("\n");
        sb.append("    recognitionDate: ").append(toIndentedString(recognitionDate)).append("\n");
        sb.append("    statusRemuneration: ").append(toIndentedString(statusRemuneration)).append("\n");
        sb.append("    stepId: ").append(toIndentedString(stepId)).append("\n");
        sb.append("    fieldType: ").append(toIndentedString(fieldType)).append("\n");
        sb.append("    nameCouncil: ").append(toIndentedString(nameCouncil)).append("\n");
        sb.append("    caseFolderId: ").append(toIndentedString(caseFolderId)).append("\n");
        sb.append("    snapshotId: ").append(toIndentedString(snapshotId)).append("\n");
        sb.append("    lstReTranscript: ").append(toIndentedString(lstReTranscript)).append("\n");
        sb.append("    lstResultUntillChange: ").append(toIndentedString(lstResultUntillChange)).append("\n");
        sb.append("    lstPlanPlusTable: ").append(toIndentedString(lstPlanPlusTable)).append("\n");
        sb.append("    lstPlan: ").append(toIndentedString(lstPlan)).append("\n");
        sb.append("    lstParty: ").append(toIndentedString(lstParty)).append("\n");
        sb.append("    lstListSolDepartment: ").append(toIndentedString(lstListSolDepartment)).append("\n");
        sb.append("    lstListMember: ").append(toIndentedString(lstListMember)).append("\n");
        sb.append("    lstListIniCouncil: ").append(toIndentedString(lstListIniCouncil)).append("\n");
        sb.append("    lstListEmployee: ").append(toIndentedString(lstListEmployee)).append("\n");
        sb.append("    lstListCouncill: ").append(toIndentedString(lstListCouncill)).append("\n");
        sb.append("    lstListAuthor: ").append(toIndentedString(lstListAuthor)).append("\n");
        sb.append("    lstListAcceprtCouncil: ").append(toIndentedString(lstListAcceprtCouncil)).append("\n");
        sb.append("    lstInitiativeTranScript: ").append(toIndentedString(lstInitiativeTranScript)).append("\n");
        sb.append("    lstInitiativeStatus: ").append(toIndentedString(lstInitiativeStatus)).append("\n");
        sb.append("    lstHost: ").append(toIndentedString(lstHost)).append("\n");
        sb.append("    lstHistories: ").append(toIndentedString(lstHistories)).append("\n");
        sb.append("    lstEvaluateTranscript: ").append(toIndentedString(lstEvaluateTranscript)).append("\n");
        sb.append("    lstDutyStatus: ").append(toIndentedString(lstDutyStatus)).append("\n");
        sb.append("    lstEvaluateInitiative: ").append(toIndentedString(lstEvaluateInitiative)).append("\n");
        sb.append("    lstEvaluateDuty: ").append(toIndentedString(lstEvaluateDuty)).append("\n");
        sb.append("    lstEstimateBudget: ").append(toIndentedString(lstEstimateBudget)).append("\n");
        sb.append("    lstDutyPayment: ").append(toIndentedString(lstDutyPayment)).append("\n");
        sb.append("    lstContentStop: ").append(toIndentedString(lstContentStop)).append("\n");
        sb.append("    lstContentChange: ").append(toIndentedString(lstContentChange)).append("\n");
        sb.append("    lstCoHost: ").append(toIndentedString(lstCoHost)).append("\n");
        sb.append("    lstCadresInfor: ").append(toIndentedString(lstCadresInfor)).append("\n");
        sb.append("    lstAcceptTranscript: ").append(toIndentedString(lstAcceptTranscript)).append("\n");
        sb.append("    lstDocument: ").append(toIndentedString(lstDocument)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

