package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LISTEMPLOYEE")
@Data
public class ListEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer id;
    @Column(name = "CASEID")
    String caseId;
    @Column(name = "USERID")
    String userId;
    @Column(name = "FULLNAME")
    private String fullName;
    @Column(name = "JOBTITLE")
    String jobTitle;
    @Column(name = "EMAIL")
    String email;
    @Column(name = "PHONENUMBER")
    String phoneNumber;
    @Column(name = "USERNAME")
    String userName;
    @Column(name = "BDS")
    String bds;
    @Column(name = "CRA")
    String cra;
    @Column(name = "BRN")
    String brn;
    @Column(name = "BRANCH")
    String branch;
    @Column(name = "DEPARMENTCODE")
    String departmentCode;
    @Column(name = "DEPARTMENT")
    String department;
    @Column(name = "BRNLEVEL")
    String brnLevel;
    @Column(name = "GROUPXL")
    String groupXl;
    @Column(name = "CONFIRM")
    String confirm;
    @Column(name = "QUALIFICATION")
    String qualification;
    @Column(name = "CONTRIBUTEPERCENT")
    String contributePercent;
    @Column(name = "DATEOFBIRTH")
    Date dateOfBirth;
}
