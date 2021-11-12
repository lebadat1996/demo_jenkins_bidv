package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PLANPLUSTABLE")
@Data
public class PlanPlusTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer id;
    @Column(name = "CASEID")
    Integer caseId;
    @Column(name = "COST")
    Float cost;
    @Column(name = "CONTENT")
    String content;
    @Column(name = "EVALUATEEFFECT")
    String EvaluateEffect;
    @Column(name = "NOTE")
    String note;
}
