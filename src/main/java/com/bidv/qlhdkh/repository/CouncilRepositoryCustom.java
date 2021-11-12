package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.Council;

import java.util.List;

public interface CouncilRepositoryCustom {
    List<Council> getCouncil(String councilId, String subject);
}
