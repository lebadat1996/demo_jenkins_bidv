package com.bidv.qlhdkh.service.impl;

import com.bidv.qlhdkh.entity.CaseInfo;
import com.bidv.qlhdkh.entity.CaseInfoHistory;
import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.repository.CaseInfoRepositoryCustom;
import com.bidv.qlhdkh.service.CaseInfoDetailService;
import com.bidv.qlhdkh.util.Util;
import com.google.common.collect.Lists;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@Repository
@Transactional(readOnly = true)
public class CaseInfoCustomRepositoryImpl implements CaseInfoRepositoryCustom {
    private static final Logger log = LoggerFactory.getLogger(CaseInfoCustomRepositoryImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    CaseInfoDetailService caseInfoDetailService;

    @Override
    public List<CaseInfoModel> getListCaseInfo(String status, String projectName, String projectCode, String startDate, String endDate, String departmentCode, String branch, String caseType, String topicCategory, String fieldType, String projectType) throws ParseException {
        List<CaseInfoModel> svCaseInfo = new ArrayList<>();
        try {
            log.info("Start Service Get Data CaseIno In System");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FROM  CaseInfo c ");
            stringBuilder.append("where 1 = 1 ");
            if (!Util.isNullOrEmpty(status)) {
                stringBuilder.append("and ");
                stringBuilder.append("lower(c.Status) like lower(concat('%', :status,'%')) ");
            }
            if (!Util.isNullOrEmpty(projectName)) {
                stringBuilder.append("and ");
                stringBuilder.append("lower(c.ProjectName) like lower(concat('%', :projectName,'%')) ");
            }
            if (!Util.isNullOrEmpty(projectCode)) {
                stringBuilder.append("and ");
                stringBuilder.append("lower(c.ProjectCode) like lower(concat('%', :projectCode,'%')) ");
            }
            if (!Util.isNullOrEmpty(departmentCode)) {
                stringBuilder.append("and ");
                stringBuilder.append("lower(c.DeparmentCode) like lower(concat('%', :departmentCode,'%')) ");
            }
            if (!Util.isNullOrEmpty(branch)) {
                stringBuilder.append("and ");
                stringBuilder.append("lower(c.Bds) like lower(concat('%', :branch,'%')) ");
            }
            if (!Util.isNullOrEmpty(caseType)) {
                stringBuilder.append("and ");
                stringBuilder.append("lower(c.CaseType) like lower(concat('%', :caseType,'%')) ");
            }
            if (!Util.isNullOrEmpty(topicCategory)) {
                stringBuilder.append("and ");
                stringBuilder.append("lower(c.TopicCategory) like lower(concat('%', :topicCategory,'%')) ");
            }
            if (!Util.isNullOrEmpty(fieldType)) {
                stringBuilder.append("and ");
                stringBuilder.append("lower(c.fieldType) like lower(concat('%', :fieldType,'%')) ");
            }
            if (!Util.isNullOrEmpty(projectType)) {
                stringBuilder.append("and ");
                stringBuilder.append("lower(c.ProjectType) like lower(concat('%', :projectType,'%')) ");
            }
            if (!Util.isNullOrEmpty(startDate)) {
                stringBuilder.append("and ");
                stringBuilder.append("c.CreatedDate >= :startDate ");
            }
            if (!Util.isNullOrEmpty(endDate)) {
                stringBuilder.append("and ");
                stringBuilder.append("c.CreatedDate <= :endDate ");
            }
            String sql = stringBuilder.toString();
            log.info("SQL: " + sql);
            Query query = entityManager.createQuery(sql);
            if (!Util.isNullOrEmpty(status)) {
                query.setParameter("status", status);
            }
            if (!Util.isNullOrEmpty(projectName)) {
                query.setParameter("projectName", projectName);
            }
            if (!Util.isNullOrEmpty(projectCode)) {
                query.setParameter("projectCode", projectCode);
            }
            if (!Util.isNullOrEmpty(departmentCode)) {
                query.setParameter("departmentCode", departmentCode);
            }
            if (!Util.isNullOrEmpty(branch)) {
                query.setParameter("branch", branch);
            }
            if (!Util.isNullOrEmpty(caseType)) {
                query.setParameter("caseType", caseType);
            }
            if (!Util.isNullOrEmpty(topicCategory)) {
                query.setParameter("topicCategory", topicCategory);
            }
            if (!Util.isNullOrEmpty(fieldType)) {
                query.setParameter("fieldType", fieldType);
            }
            if (!Util.isNullOrEmpty(projectType)) {
                query.setParameter("projectType", projectType);
            }
            if (!Util.isNullOrEmpty(startDate)) {
                Date stDate = Util.getDates(startDate);
                query.setParameter("startDate", stDate);
            }
            if (!Util.isNullOrEmpty(endDate)) {
                Date eDate = Util.getDates(endDate);
                query.setParameter("endDate", eDate);
            }
            List<CaseInfo> caseInfos = query.getResultList();
            List<CaseInfo> unique = caseInfos.stream()
                    .collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(CaseInfo::getId))),
                            ArrayList::new));
            for (CaseInfo caseInfo1 : unique) {
                CaseInfoModel caseInfo = caseInfoDetailService.detailCaseInfo(caseInfo1.getCaseId());
                svCaseInfo.add(caseInfo);
            }

            log.info("SIZE CASE: " + svCaseInfo.size());
            log.info("End Service Get Data CaseIno In System");
            return svCaseInfo;
        } catch (Exception e) {
            log.error("Error Service Get Information Case");
            e.printStackTrace();
            return svCaseInfo;
        }
    }
}
