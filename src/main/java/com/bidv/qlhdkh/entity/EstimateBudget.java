package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ESTIMATEBUGET")
@Data
public class EstimateBudget {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CASEID")
    private Integer caseId;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "RATE")
    private Float rate;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "AMOUNT")
    private float amount;
    @Column(name = "NOTE")
    private String note;
}
