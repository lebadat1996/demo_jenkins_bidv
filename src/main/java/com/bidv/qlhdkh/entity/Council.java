package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COUNCIL")
@Data
public class Council {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer Id;
    @Column(name = "COUNCILID")
    private String councilId;
    @Column(name = "COUNCILNAME")
    private String councilName;
    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "DATE_CREATE")
    private Date dateCreate;
    @Column(name = "DATE_MODIFY")
    private Date dateModify;
    @Column(name = "CREATOR")
    private String creator;
    @Column(name = "MODIFIER")
    private String modifier;
    @Column(name = "TIMEACTIVE")
    private Date timeActive;
    @Column(name = "STATUS")
    private String status;

}
