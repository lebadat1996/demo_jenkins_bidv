package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "RETRANSCRIPT")
@Data
public class ReTranScript {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer id;
    @Column(name = "CASEID")
    Integer caseId;
    @Column(name = "INTERESTAFTERYEAR")
    Integer interestAfterYear;
    @Column(name = "CONTENT")
    String content;
    @Column(name = "NOTE")
    String note;
    @Column(name = "AUTHOR")
    String author;
}
