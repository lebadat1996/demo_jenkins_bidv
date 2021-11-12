package com.bidv.qlhdkh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "EVALUATEINITIATIVE")
@Data
public class EvaluateInitiative {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer Id;
    @Column(name = "CASEID")
    private Integer CaseId;
    @Column(name = "CONTENT")
    private String Content;
    @Column(name = "COST")
    private Float Cost;
    @Column(name = "EVALUATEEFFECT")
    private String EvaluateEffect;
    @Column(name = "NOTE")
    private String Note;
}
