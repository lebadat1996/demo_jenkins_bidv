package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "INITIATIVETRANSCRIPT")
@Data
public class InitiativeTranScript {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer id;
    @Column(name = "CASEID")
    Integer caseId;
    @Column(name = "CREATIVITYSCORE")
    Float creativityScore;
    @Column(name = "SCIENCESCORE")
    Float sciencesScore;
    @Column(name = "REALITYSCORE")
    Float realityScore;
    @Column(name = "EFFECSCORE")
    Float effecScore;
    @Column(name = "AVERAGE")
    Float average;
    @Column(name = "CONCLUSION")
    String Conclusion;
    @Column(name = "SUGGUEST")
    String Sugguest;
    @Column(name = "ADDREQUEST")
    String AddRequest;
    @Column(name = "DEPARTMENT")
    String Department;
    @Column(name = "STARTDATE")
    Date startDate;
    @Column(name = "INTEREST")
    Float interest;
    @Column(name = "AUTHOR")
    String author;
}
