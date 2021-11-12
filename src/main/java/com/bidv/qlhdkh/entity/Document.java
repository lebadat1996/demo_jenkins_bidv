package com.bidv.qlhdkh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DOCUMENT_INFO")
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CASEID")
    private Integer caseId;
    @Column(name = "URL")
    private String url;
    @Column(name = "SERVER_NAME")
    private String serverName;
    @Column(name = "OBJECTID")
    private String objectId;
    @Column(name = "DOCID")
    private String docId;
    @Column(name = "FILENAME")
    private String fileName;
    @Column(name = "DOCNAME")
    private String docName;
    @Column(name = "MIMETYPE")
    private String mimeType;
}
