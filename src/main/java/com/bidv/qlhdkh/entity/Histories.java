package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HISTORIES")
@Data
public class Histories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer id;
    @Column(name = "CASEID")
    Integer caseId;
    @Column(name = "CREATOR")
    String create;
    @Column(name = "CREATEDDATE")
    Date dateCreate;
    @Column(name = "ACTION")
    String action;
    @Column(name = "NOTE")
    String note;
    @Column(name = "ROLE")
    String role;
}
