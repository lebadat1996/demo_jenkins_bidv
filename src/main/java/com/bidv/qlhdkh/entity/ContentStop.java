package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "CONTENTSTOP")
@Data
public class ContentStop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer Id;
    @Column(name = "CASEID")
    private Integer CaseId;
    @Column(name = "STOPREASON")
    private String StopReason;
    @Column(name = "DUTYCOST")
    private Float DutyCost;
    @Column(name = "OTHERCOST")
    private Float OtherCost;
    @Column(name = "TOTALCOST")
    private Float TotalCost;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getCaseId() {
        return CaseId;
    }

    public void setCaseId(Integer caseId) {
        CaseId = caseId;
    }

    public String getStopReason() {
        return StopReason;
    }

    public void setStopReason(String stopReason) {
        StopReason = stopReason;
    }

    public Float getDutyCost() {
        return DutyCost;
    }

    public void setDutyCost(Float dutyCost) {
        DutyCost = dutyCost;
    }

    public Float getOtherCost() {
        return OtherCost;
    }

    public void setOtherCost(Float otherCost) {
        OtherCost = otherCost;
    }

    public Float getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(Float totalCost) {
        TotalCost = totalCost;
    }
}
