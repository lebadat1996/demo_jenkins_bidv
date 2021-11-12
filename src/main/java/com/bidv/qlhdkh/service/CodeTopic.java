package com.bidv.qlhdkh.service;

import java.util.Formatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bidv.qlhdkh.entity.Number;
import com.bidv.qlhdkh.repository.NumberRepository;

@Service
public class CodeTopic implements GenCodeTopic {
    private static final Logger log = LoggerFactory.getLogger(CodeTopic.class);

    @Autowired
    NumberRepository numberRepository;


    @Override
    public Number genCodeTopic(String codeH, String codeBds, String codeDepartment, String filed, String year) {
        Number numberSe = new Number();
        try {
            log.info("Start Api Service GenCode");
            log.debug("Debug Service GenCode");
            StringBuilder code = new StringBuilder();
            code.append(codeH);
            code.append(".");
            code.append(codeBds);
            code.append(".");
            code.append(codeDepartment);
            code.append(".");
            code.append(filed);
            code.append(".");
            code.append(year.substring(2, 4));
            Number number = numberRepository.getNumber(code.toString().toUpperCase());
            StringBuilder stringBuilder = new StringBuilder();
            Formatter formatter = new Formatter(stringBuilder);
            if (number != null) {
                numberSe.setNumberSequence(number.getNumberSequence() + 1);
                code.append(".");
                code.append(formatter.format("%03d", number.getNumberSequence() + 1));
                numberSe.setKeyNumber(code.toString());
                numberRepository.save(numberSe);
            } else {
                numberSe.setNumberSequence(1);
                code.append(".");
                code.append(formatter.format("%03d", 1));
                numberSe.setKeyNumber(code.toString());
                numberRepository.save(numberSe);
            }
            log.info("End Api Service GenCode");
            log.info("Key: " + numberSe.getKeyNumber());
        } catch (Exception e) {
            log.warn("Warn Api Service GenCode");
            log.error("Error Api Service GenCode");
            e.printStackTrace();
        }
        return numberSe;
    }

    @Override
    public Number genCodeTopicNew(String year, String project, String level, String type, String code) {
        Number numberGen = new Number();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(year.toUpperCase());
        stringBuilder.append("-");
        stringBuilder.append(project.toUpperCase());
        stringBuilder.append(level.toUpperCase());
        if (!StringUtils.isEmpty(type)) {
            stringBuilder.append(type.toUpperCase());
        }
        if (!StringUtils.isEmpty(code)) {
            stringBuilder.append(".");
        }
        if (!StringUtils.isEmpty(code)) {
            stringBuilder.append(code.toUpperCase());
        }
        StringBuilder stringBuilders = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilders);
        System.out.println(stringBuilder.toString().toUpperCase());
        Number number = numberRepository.getNumber(stringBuilder.toString().toUpperCase());
        if (number != null) {
            numberGen.setNumberSequence(number.getNumberSequence() + 1);
            stringBuilder.append(".");
            stringBuilder.append(formatter.format("%03d", number.getNumberSequence() + 1));
            numberGen.setKeyNumber(stringBuilder.toString());
            numberRepository.save(numberGen);
        } else {
            numberGen.setNumberSequence(1);
            stringBuilder.append(".");
            stringBuilder.append(formatter.format("%03d", 1));
            numberGen.setKeyNumber(stringBuilder.toString());
            numberRepository.save(numberGen);
        }
       return numberGen;
    }

}

