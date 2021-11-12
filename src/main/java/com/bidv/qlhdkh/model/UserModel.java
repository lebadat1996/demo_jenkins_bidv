package com.bidv.qlhdkh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    String username;
    String codeUser;
    String email;
    String brn;
    Integer status;
    String mavtvt;
    String title;
    String departmentCode;
    String contacts;
    String latestsync;
    String passflag;
    String passTime;
    String chgStatus;
    Date effectDate;
    String pslEMAIL;
    String bds;
    String htchucvu;
    String emplClass;
    String department;
    String departmentName;
    String departmentCodeMap;
    String nameTitle;
    String bdsParent;

    public interface info {
        String getUsername();
        String getCodeUser();
        String getEmail();
        String getBrn();
        Integer getStatus();
        String getMavtvt();
        String getTitle();
        String getDepartmentCode();
        String getContacts();
        String getLatestsync();
        String getPassflag();
        String getPassTime();
        String getChgStatus();
        Date getEffectDate();
        String getPslEMAIL();
        String getBds();
        String getHtchucvu();
        String getEmplClass();
        String getDepartment();
        String getDepartmentName();
        String getDepartmentCodeMap();
        String getNameTitle();
        String getBdsParent();
    }

    public UserModel(String username, String codeUser, String email, String brn, int status, String mavtvt, String title, String departmentCode, String contacts, String latestsync, String passflag, String passTime, String chgStatus, Date effectDate, String pslEMAIL, String bds, String htchucvu, String emplClass, String department, String departmentName, String departmentCodeMap, String nameTitle, String branchCode) {
        this.username = username;
        this.codeUser = codeUser;
        this.email = email;
        this.brn = brn;
        this.status = status;
        this.mavtvt = mavtvt;
        this.title = title;
        this.departmentCode = departmentCode;
        this.contacts = contacts;
        this.latestsync = latestsync;
        this.passflag = passflag;
        this.passTime = passTime;
        this.chgStatus = chgStatus;
        this.effectDate = effectDate;
        this.pslEMAIL = pslEMAIL;
        this.bds = bds;
        this.htchucvu = htchucvu;
        this.emplClass = emplClass;
        this.department = department;
        this.departmentName = departmentName;
        this.departmentCodeMap = departmentCodeMap;
        this.nameTitle = nameTitle;
        this.bdsParent = branchCode;
    }
}
