package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "COHOSTHISTORY")
@Data
public class CoHostHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CASEID")
    private Integer caseId;
    @Column(name = "DEPARTMENTID")
    private String departmentId;
    @Column(name = "DEPARTMENTNAME")
    private String departmentName;
}
