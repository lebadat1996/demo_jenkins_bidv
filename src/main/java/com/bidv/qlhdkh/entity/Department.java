package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DEPARTMENT_CODE")
    private String codeDepartment;
    @Column(name = "DEPARTMENT_NAME")
    private String nameDepartment;
    @Column(name = "DEPARTMENT_CODE_PARENT")
    private String codeDepartmentParent;
    @Column(name = "CODE_BDS")
    private String codeBds;
    @Column(name = "CODE_CRA")
    private String codeCra;
    @Column(name = "LATESTUPD")
    private String lasteStupd;
    @Column(name = "BRNLEVEL")
    private String brnLevel;
    @Column(name = "MAKV")
    private String maKV;
    @Column(name = "CODE_BDS_PARENT")
    private String codeBdsParent;
    @Column(name = "EMAILOU")
    private String emailOU;
    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "NAMES")
    private String name;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "EMAILADDR")
    private String emailAddr;
}
