package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "DUTYSTATUS")
@Data
public class DutyStatus {
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
