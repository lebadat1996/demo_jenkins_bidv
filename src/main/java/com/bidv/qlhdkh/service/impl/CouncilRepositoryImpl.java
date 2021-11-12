package com.bidv.qlhdkh.service.impl;

import com.bidv.qlhdkh.entity.Council;
import com.bidv.qlhdkh.repository.CouncilRepositoryCustom;
import com.bidv.qlhdkh.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Constructor;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CouncilRepositoryImpl implements CouncilRepositoryCustom {
    public static final Logger log = LoggerFactory.getLogger(CouncilRepositoryImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Council> getCouncil(String councilId, String subject) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from COUNCIL ");
//        stringBuilder.append("where 1 = 1");
        if (!Util.isNullOrEmpty(councilId)) {
            stringBuilder.append("and ");
            stringBuilder.append("c.councilId = ");
            stringBuilder.append(councilId);
            stringBuilder.append(new Date());
        }
        if (!Util.isNullOrEmpty(subject)) {
            stringBuilder.append("and ");
            stringBuilder.append("c.subject = ");
            stringBuilder.append(subject);
        }
        String sql = stringBuilder.toString();
        log.info("SQL: " + sql);
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> councilList = query.getResultList();
        for (Object[] row : councilList) {
            String a = (String) row[1];
            System.out.println(a);
        }
        return null;
    }


}
