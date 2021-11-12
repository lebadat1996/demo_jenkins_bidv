package com.bidv.qlhdkh.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CONFIG_TOPIC")
@Data
public class ConfigTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME_TOPIC")
    private String nameTopic;
    @Column(name = "TOPIC_CODE")
    private String codeTopic;
    @Column(name = "KEY_TOPIC")
    private String keyTopic;
    @Column(name = "PARENT_ID")
    private String parentId;
}
