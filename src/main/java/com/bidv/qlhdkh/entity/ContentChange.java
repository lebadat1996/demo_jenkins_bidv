package com.bidv.qlhdkh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CONTENTCHANGE")
@Data
public class ContentChange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer Id;
    @Column(name = "CASEID")
    private Integer CaseId;
    @Column(name = "STARTDATE")
    private Date StartDate;
    @Column(name = "ENDDATE")
    private Date EndDate;
    @Column(name = "CHANGETIMEREASON")
    private String ChangeTimeReason;
    @Column(name = "HOSTID")
    private Integer Host;
    @Column(name = "OWNERID")
    private Integer Owner;
    @Column(name = "CHANGEHOSTREASON")
    private String ChangeHostReason;
}
