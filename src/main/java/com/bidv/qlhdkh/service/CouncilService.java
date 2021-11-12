package com.bidv.qlhdkh.service;

import com.bidv.qlhdkh.entity.Council;
import com.bidv.qlhdkh.model.CouncilModel;
import com.bidv.qlhdkh.model.LstCouncilModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CouncilService {
    LstCouncilModel getAllCouncil();

    void createCouncil(CouncilModel councilModel);

    CouncilModel getInfoCouncil(int councilId);

    int deleteCouncil(int councilId);

    List<Council> list(String councilId, String subject);
}
