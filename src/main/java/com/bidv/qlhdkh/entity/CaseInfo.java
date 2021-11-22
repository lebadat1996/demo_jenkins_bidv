package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.Date;

@Entity
@Table(name = "CASEINFO")
@Data
public class CaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CASETYPE")
    private String CaseType;
    @Column(name = "CASEID")
    private Integer caseId;
    @Column(name = "PROJECTNAME")
    private String ProjectName;
    @Column(name = "PROJECTCODE")
    private String ProjectCode;
    @Column(name = "CADRESNAME")
    private String CadresName;
    @Column(name = "CADRESEMAIL")
    private String CadresEmail;
    @Column(name = "QUANTITY")
    private Float Quantity;
    @Column(name = "CADRESPHONE")
    private String CadresPhone;
    @Column(name = "REGISTERCONDITION")
    private String RegisterCondition;
    @Column(name = "COST")
    private Float Cost;
    @Column(name = "STARTDATE")
    private Date StartDate;
    @Column(name = "ENDDATE")
    private Date EndDate;
    @Column(name = "NECESSITY")
    private String Necessity;
    @Column(name = "TARGET")
    private String Target;
    @Column(name = "RANGE")
    private String Range;
    @Column(name = "OBJECT")
    private String Object;
    @Column(name = "METHOD")
    private String Method;
    @Column(name = "DATA")
    private String Data;
    @Column(name = "CONTENT")
    private String Content;
    @Column(name = "CONSEQUENCE")
    private String Consequence;
    @Column(name = "CONTRIBUTE")
    private String Contribute;
    @Column(name = "WEAKNESS")
    private String Weakness;
    @Column(name = "TRANFERMETHOD")
    private String TranferMethod;
    @Column(name = "ACTION")
    private String Action;
    @Column(name = "PROJECTTYPE")
    private String ProjectType;
    @Column(name = "TOPICTYPE")
    private String TopicType;
    @Column(name = "DUTYOWNER")
    private String DutyOwner;
    @Column(name = "DUTYSECRETARY")
    private String DutySecretary;
    @Column(name = "CREATEDDATE")
    private Date CreatedDate;
    @Column(name = "PROJECTLEVEL")
    private String ProjectLevel;
    @Column(name = "TOPICCATEGORY")
    private String TopicCategory;
    @Column(name = "EVALUATEBUDGET")
    private String EvaluateBudget;
    @Column(name = "PRESIDENTCONCLUSION")
    private String PresidentConclusion;
    @Column(name = "RECOMMENTBUDGET")
    private Float RecommentBudget;
    @Column(name = "REQUESTPERFECT")
    private String RequestPerfect;
    @Column(name = "RESEARCHOVERVIEW")
    private String ResearchOverView;
    @Column(name = "RESEARCHMETHOD")
    private String ResearchMethod;
    @Column(name = "RESEARCHRESULT")
    private String ResearchResult;
    @Column(name = "ORIENTATION")
    private String Orientation;
    @Column(name = "REFERENCE")
    private String Reference;
    @Column(name = "EXTENSIONDATE")
    private Date ExtensionDate;
    @Column(name = "CONTRACTNO")
    private String ContractNo;
    @Column(name = "ACCOMANYDOC")
    private String AccomanyDoc;
    @Column(name = "NOTE")
    private String Note;
    @Column(name = "BUDGETPERCENT")
    private String BudgetPercent;
    @Column(name = "REPORTRANGE")
    private String ReportRange;
    @Column(name = "REPORTEFFECTIVE")
    private String ReportEffective;
    @Column(name = "REPORTDIFFICULT")
    private String ReportDifficult;
    @Column(name = "PRESTATUSSOL")
    private String PreStatusSol;
    @Column(name = "PROCESSAPP")
    private String ProcessApp;
    @Column(name = "EFFECSOL")
    private String EffecSol;
    @Column(name = "INTERESTSUB")
    private String InterestSub;
    @Column(name = "CONCLUSION")
    private String Conclusion;
    @Column(name = "INTEREST")
    private Float Interest;
    @Column(name = "REMUNERATION")
    private Float Remuneration;
    @Column(name = "CALINTERESTMETHOD")
    private String CalInterestMethod;
    @Column(name = "BACKGROUND")
    private String Background;
    @Column(name = "SHARES")
    private String Shares;
    @Column(name = "PLANPLUS")
    private String PlanPlus;
    @Column(name = "SUGGEST")
    private String Suggest;
    @Column(name = "STATUS")
    private String Status;
    @Column(name = "BDS")
    private String Bds;
    @Column(name = "CRA")
    private String Cra;
    @Column(name = "BRN")
    private String Brn;
    @Column(name = "BRANCH")
    private String Branch;
    @Column(name = "DEPARTMENTCODE")
    private String DeparmentCode;
    @Column(name = "DEPARTMENT")
    private String Department;
    @Column(name = "ACCEPTDATE")
    private Date AcceptDate;
    @Column(name = "RECOGNITIONDATE")
    private Date RecognitionDate;
    @Column(name = "STATUSREMUNERATION")
    private String StatusRemuneration;
    @Column(name = "STEPID")
    private String stepId;
    @Column(name = "FIELDTYPE")
    private String fieldType ;
    @Column(name = "NAME_COUNCIL")
    private String nameCouncil;
    @Column(name = "COUNCIL_ID")
    private String councilId;
    @Column(name = "CASEFOLDER_ID")
    private String caseFolderId;
    @Column(name = "SNAPSHOT_ID")
    private String snapshotId;
}
