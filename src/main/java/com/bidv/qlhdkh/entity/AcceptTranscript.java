package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "ACCEPTTRANSCRIPT")
@Data
public class AcceptTranscript {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer Id;
    @Column(name = "CASEID")
    private Integer CaseId;
    @Column(name = "NESCESARYSCORE")
    private Integer NescesaryScore;
    @Column(name = "SUIABLESCORE")
    private Integer SuiableScore;
    @Column(name = "PROGRESSSCORE")
    private Integer ProgressScore;
    @Column(name = "QUALITYSCORE")
    private Integer QualityScore;
    @Column(name = "REALITYSCORE")
    private Integer RealityScore;
    @Column(name = "CONTRIBUTESCORE")
    private Integer ContributeScore;
    @Column(name = "EFFECSCORE")
    private Integer EffecScore;
    @Column(name = "RANGESCORE")
    private Integer RangeScore;
    @Column(name = "ABILITYDEVELOP")
    private Integer AbilityDevelop;
    @Column(name = "SPECIFICREVIEW ")
    private String SpecificReview;
    @Column(name = "CONTENTCONCLUSION")
    private String ContentConclusion;
    @Column(name = "AUTHOR")
    private String Author;
    @Column(name = "SUM")
    private Integer Sum;
}
