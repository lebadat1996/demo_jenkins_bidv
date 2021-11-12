package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USERINFO")
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_NAME")
    String username;
    @Column(name = "USER_ID")
    String codeUser;
    @Column(name = "EMAIL")
    String email;
    @Column(name = "BRN")
    String brn;
    @Column(name = "STATUS")
    int status;
    @Column(name = "MAVTCT")
    String mavtvt;
    @Column(name = "TITLE")
    String title;
    @Column(name = "DEPARTMENT_CODE")
    String departmentCode;
    @Column(name = "CONTACTS")
    String contacts;
    @Column(name = "LATESTSYNC")
    String latestsync;
    @Column(name = "PASSFLAG")
    String passflag;
    @Column(name = "PASSTIME")
    String passTime;
    @Column(name = "CHGSTATUS")
    String chgStatus;
    @Column(name = "EFFECTDATE")
    Date effectDate;
    @Column(name = "PSL_EMAIL")
    String pslEMAIL;
    @Column(name = "BDS")
    String bds;
    @Column(name = "HTCHUCVU")
    String htchucvu;
    @Column(name = "EMPLCLASS")
    String emplClass;
    @Column(name = "DEPARTMENT")
    String department;
    @Column(name = "DEPARTMENT_NAME")
    String departmentName;
    @Column(name = "DEPARTMENT_CODE_MAP")
    String departmentCodeMap;
    @Column(name = "NAME_TITLE")
    String nameTitle;
}
