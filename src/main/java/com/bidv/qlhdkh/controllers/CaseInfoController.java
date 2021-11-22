package com.bidv.qlhdkh.controllers;

import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.Response;
import com.bidv.qlhdkh.service.CaseInfoDetailService;
import com.bidv.qlhdkh.service.CaseInfoService;
import com.bidv.qlhdkh.service.impl.CaseInfoCustomRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-14T07:52:33.572Z")

@Controller
public class CaseInfoController implements CaseInfoApi {
    private static final Logger log = LoggerFactory.getLogger(ApiApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public CaseInfoController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Autowired
    CaseInfoService caseInfoService;
    @Autowired
    CaseInfoDetailService caseInfoDetailService;
    @Autowired
    CaseInfoCustomRepositoryImpl infoCustomRepository;

    public ResponseEntity<?> saveCaseInfo(@ApiParam(value = "CaseInfo Object", required = true) @Valid @RequestBody CaseInfoModel body) {
        try {
            caseInfoService.saveCase(body);
            return new ResponseEntity<>(new Response(1000, "String", "save data caseInfo success", ""), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "save data caseInfo not success", ""), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("api/getCaseInfoByStatus")
    public ResponseEntity<?> getCaseInfoByStauts(@RequestParam(required = false) String status) {
        try {
            List<CaseInfoModel> svCaseInfo = caseInfoService.getCaseInfoByStatus(status);
            return new ResponseEntity<>(svCaseInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Find data caseInfo not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("api/searchCase")
    public ResponseEntity<?> searchCase(@RequestParam(required = false) String status,
                                        @RequestParam(required = false) String projectName,
                                        @RequestParam(required = false) String projectcode,
                                        @RequestParam(required = false) String startDate,
                                        @RequestParam(required = false) String endDate,
                                        @RequestParam(required = false) String departmentCode,
                                        @RequestParam(required = false) String branch,
                                        @RequestParam(required = false) String userId,
                                        @RequestParam(required = false) String caseType) {
        try {
            List<CaseInfoModel> svCaseInfo = caseInfoService.searchCaseInfo(userId, status, projectName, projectcode, startDate, endDate, departmentCode, branch, caseType);
            return new ResponseEntity<>(svCaseInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Find data caseInfo not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("api/searchCases")
    public ResponseEntity<?> searchCases(@RequestParam(required = false) String status,
                                         @RequestParam(required = false) String projectName,
                                         @RequestParam(required = false) String projectcode,
                                         @RequestParam(required = false) String startDate,
                                         @RequestParam(required = false) String endDate,
                                         @RequestParam(required = false) String departmentCode,
                                         @RequestParam(required = false) String branch,
                                         @RequestParam(required = false) String userId,
                                         @RequestParam(required = false) String caseType) {
        try {
            List<CaseInfoModel> svCaseInfo = caseInfoService.searchCaseInfoCTL(userId, status, projectName, projectcode, startDate, endDate, departmentCode, branch, caseType);
            return new ResponseEntity<>(svCaseInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Find data caseInfo not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("api/searchCaseInfosReport")
    public ResponseEntity<?> searchCasesInfo(@RequestParam(required = false) String status,
                                             @RequestParam(required = false) String projectcode,
                                             @RequestParam(required = false) String dateCurrent,
                                             @RequestParam(required = false) String projectName,
                                             @RequestParam(required = false) String departmentCode) {
        try {
            List<CaseInfoModel> svCaseInfo = caseInfoService.searchCaseInfosReport(projectName, departmentCode, projectcode, status, dateCurrent);
            return new ResponseEntity<>(svCaseInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Find data caseInfo not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("api/searchCaseInfosReportNT")
    public ResponseEntity<?> searchCasesInfoNT(@RequestParam(required = false) String status,
                                               @RequestParam(required = false) String projectcode,
                                               @RequestParam(required = false) String dateCurrent,
                                               @RequestParam(required = false) String projectName,
                                               @RequestParam(required = false) String departmentCode) {
        try {
            List<CaseInfoModel> svCaseInfo = caseInfoService.searchCaseInfosReportNT(projectName, departmentCode, projectcode, status, dateCurrent);
            return new ResponseEntity<>(svCaseInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Find data caseInfo not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("api/searchCaseInfosReportNTSK")
    public ResponseEntity<?> searchCasesInfoNTSK(@RequestParam(required = false) String status,
                                                 @RequestParam(required = false) String projectcode,
                                                 @RequestParam(required = false) String dateCurrent,
                                                 @RequestParam(required = false) String projectName,
                                                 @RequestParam(required = false) String departmentCode) {
        try {
            List<CaseInfoModel> svCaseInfo = caseInfoService.searchCaseInfosReportNTSK(projectName, departmentCode, projectcode, status, dateCurrent);
            return new ResponseEntity<>(svCaseInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Find data caseInfo not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("api/searchCaseInfosReportSK")
    public ResponseEntity<?> searchCasesInfoSK(@RequestParam(required = false) String status,
                                               @RequestParam(required = false) String projectcode,
                                               @RequestParam(required = false) String dateCurrent,
                                               @RequestParam(required = false) String projectName,
                                               @RequestParam(required = false) String departmentCode) {
        try {
            List<CaseInfoModel> svCaseInfo = caseInfoService.searchCaseInfosReportSK(projectName, departmentCode, projectcode, status, dateCurrent);
            return new ResponseEntity<>(svCaseInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Find data caseInfo not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/detailCase")
    public ResponseEntity<?> getInfoCase(@RequestParam String projectCode) {
        try {

            return new ResponseEntity<>(caseInfoService.detail(projectCode), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Find data caseInfo not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/detailCaseInfo")
    public ResponseEntity<?> InfoCase(@RequestParam int caseId) {
        try {
            CaseInfoModel caseInfoModel = caseInfoDetailService.detailCaseInfo(caseId);
            return new ResponseEntity<>(caseInfoModel, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Find data caseInfo not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/listCaseInfo")
    public ResponseEntity<?> listCaseInfo() {
        try {
            List<CaseInfoModel> caseInfoModel = caseInfoDetailService.ListCaseInfoSystem();
            return new ResponseEntity<>(caseInfoModel, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "Response", "Find Data List caseInfo Not Success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/validate")
    public ResponseEntity<?> validate(@RequestParam String projectCode,
                                      @RequestParam(required = false) int caseId,
                                      @RequestParam(required = false) String caseType) {
        try {
            boolean status = caseInfoService.checkCaseInfo(projectCode, caseType, caseId);
            if (status == true) {
                return new ResponseEntity<>(new Response(1000, "String", "Success", "TRUE"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Response(1001, "String", "Success", "FALSE"), HttpStatus.OK);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Error validate not success", ""), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("api/getCaseInfo")
    public ResponseEntity<?> getCaseInfo(@RequestParam(required = false) String status,
                                         @RequestParam(required = false) String projectName,
                                         @RequestParam(required = false) String projectcode,
                                         @RequestParam(required = false) String startDate,
                                         @RequestParam(required = false) String endDate,
                                         @RequestParam(required = false) String departmentCode,
                                         @RequestParam(required = false) String bds,
                                         @RequestParam(required = false) String caseType,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "50") int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            List<CaseInfoModel> svCaseInfo = caseInfoService.getCaseInfo(status, projectName, projectcode, startDate, endDate, departmentCode, bds, caseType, pageable);
            return new ResponseEntity<>(svCaseInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Find data caseInfo not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/getCaseInfoSystem")
    public ResponseEntity<?> getList(@RequestParam(required = false) String status,
                                     @RequestParam(required = false) String projectName,
                                     @RequestParam(required = false) String projectcode,
                                     @RequestParam(required = false) String startDate,
                                     @RequestParam(required = false) String endDate,
                                     @RequestParam(required = false) String departmentCode,
                                     @RequestParam(required = false) String bds,
                                     @RequestParam(required = false) String caseType,
                                     @RequestParam(required = false) String filedsType,
                                     @RequestParam(required = false) String topicType,
                                     @RequestParam(required = false) String projectType,
                                     @RequestParam(required = false) String userId,
                                     @RequestParam(required = false) String councilId) {
        try {
            List<CaseInfoModel> caseInfoList = infoCustomRepository.getListCaseInfo(status, projectName, projectcode, startDate, endDate, departmentCode, bds, caseType, topicType, filedsType, projectType, userId, councilId);
            return new ResponseEntity<>(caseInfoList, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "Response", "Error Get Data CaseInfo", "Bad Request"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/getListCaseInfo")
    public ResponseEntity<?> getListCaseInfo(@RequestParam(required = false) String status,
                                             @RequestParam(required = false) String projectName,
                                             @RequestParam(required = false) String projectcode,
                                             @RequestParam(required = false) String startDate,
                                             @RequestParam(required = false) String endDate,
                                             @RequestParam(required = false) String departmentCode,
                                             @RequestParam(required = false) String bds,
                                             @RequestParam(required = false) String caseType,
                                             @RequestParam(required = false) String filedsType,
                                             @RequestParam(required = false) String topicType,
                                             @RequestParam(required = false) String projectType,
                                             @RequestParam(required = false) String userId,
                                             @RequestParam(required = false) String councilId,
                                             @RequestParam(required = false) String title) {
        try {
            List<CaseInfoModel> caseInfoList = infoCustomRepository.getListCaseInfoSK(status, projectName, projectcode, startDate, endDate, departmentCode, bds, caseType, topicType, filedsType, projectType, userId, councilId,title);
            return new ResponseEntity<>(caseInfoList, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "Response", "Error Get Data CaseInfo", "Bad Request"), HttpStatus.BAD_REQUEST);
        }
    }
}
