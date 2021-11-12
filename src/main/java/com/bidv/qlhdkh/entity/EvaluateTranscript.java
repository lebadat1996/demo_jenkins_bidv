package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "EVALUATETRANSCRIPT")
@Data
public class EvaluateTranscript {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer Id;
    @Column(name = "CASEID")
    private Integer CaseId;
    @Column(name = "CLEARSCORE")
    private Integer ClearScore;
    @Column(name = "TARGETSCORE")
    private Integer TargetScore;
    @Column(name = "CONTENTSCORE")
    private Integer ContentScore;
    @Column(name = "METHODSCORE")
    private Integer MethodScore;
    @Column(name = "SATIFYSCORE")
    private Integer SatifyScore;
    @Column(name = "BENEFITSCORE")
    private Integer BenefitScore;
    @Column(name = "REALITYSCORE")
    private Integer RealityScore;
    @Column(name = "PROGRESSSCORE")
    private Integer ProgressScore;
    @Column(name = "ABILITYOWNER")
    private Integer AbilityOwner;
    @Column(name = "EVALUATEBUDGET")
    private String EvaluateBudget;
    @Column(name = "BUDGETCOMMENT")
    private String BudgetComment;
    @Column(name = "CONCLUSION")
    private String Conclusion;
    @Column(name = "CONTENTCONCLUSION")
    private String ContentConclusion;
    @Column(name = "ESTIMATECONCLUSION")
    private String EstimateConclusion;
    @Column(name = "AUTHOR")
    private String Author;
    @Column(name = "SUM")
    private Integer Sum;
}
