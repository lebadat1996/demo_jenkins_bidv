package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "NUMBER_AUTO")
@Data
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "NUMBER_SEQUENCE")
    private int numberSequence;
    @Column(name = "KEY_NUMBER")
    private String keyNumber;
}
