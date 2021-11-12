package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "INITIATIVESTATUS")
@Data
public class InitiativeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer id;
    @Column(name = "CASEID")
    Integer caseId;
    @Column(name = "CONTENT")
    String content;
    @Column(name = "COST")
    Float cost;
    @Column(name = "EVALUATEEFFECT")
    String EvaluateEffect;
    @Column(name = "NOTE")
    String note;
}
