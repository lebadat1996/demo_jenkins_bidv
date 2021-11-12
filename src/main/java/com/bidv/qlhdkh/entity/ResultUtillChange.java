package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "RESULTUTILLCHANGE")
@Data
public class ResultUtillChange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer id;
    @Column(name = "CASEID")
    Integer caseId;
    @Column(name = "EXPECTPRODUCT")
    String ExpectProduct ;
    @Column(name = "ACTUALPRODUCT")
    String ActualProduct;
}
