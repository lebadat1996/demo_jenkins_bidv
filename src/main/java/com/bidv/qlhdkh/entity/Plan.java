package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Plan")
@Data
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer id;
    @Column(name = "CASEID")
    Integer caseId;
    @Column(name = "CONTENT")
    String content;
    @Column(name = "RESULT")
    String result;
    @Column(name = "START_DATE")
    Date startDate;
    @Column(name = "END_DATE")
    Date endDate;
    @Column(name = "ASSIGNEETO")
    String assigneeTo;

}
