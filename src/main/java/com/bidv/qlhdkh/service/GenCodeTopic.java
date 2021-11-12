package com.bidv.qlhdkh.service;

import com.bidv.qlhdkh.entity.Number;

public interface GenCodeTopic {
    Number genCodeTopic(String hnv, String bds, String codeDepartment, String filed, String year);

    Number genCodeTopicNew(String year,String project,String level,String type,String code);
}
