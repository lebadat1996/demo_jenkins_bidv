package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DUTYPAYMENT")
@Data
public class DutyPayment {
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
