package com.bidv.qlhdkh.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "COHOST")
@Data
@ToString
public class CoHost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CASEID")
    private Integer caseId;
    @Column(name = "DEPARTMENTID")
    private String departmentId;
    @Column(name = "DEPARTMENTNAME")
    private String departmentName;
}
