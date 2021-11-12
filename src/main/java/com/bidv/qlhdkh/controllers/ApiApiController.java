package com.bidv.qlhdkh.controllers;

import com.bidv.qlhdkh.entity.Department;
import com.bidv.qlhdkh.constants.Constants;
import com.bidv.qlhdkh.entity.Number;
import com.bidv.qlhdkh.model.*;
import com.bidv.qlhdkh.service.CodeTopic;
import com.bidv.qlhdkh.service.DepartmentService;
import com.bidv.qlhdkh.service.impl.ConfigTopicServiceImpl;
import com.bidv.qlhdkh.service.impl.SendMailServicelImpl;
import com.bidv.qlhdkh.service.impl.UploadFileServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-25T12:58:10.898040100+07:00[Asia/Bangkok]")

@Controller
@RequestMapping("${openapi.bPMService.base-path:/v2}")
public class ApiApiController implements ApiApi {
    @Autowired
    CodeTopic codeTopic;

    @Autowired
    ConfigTopicServiceImpl topicService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    SendMailServicelImpl sendMailServicel;

    @Autowired
    UploadFileServiceImpl uploadFileService;

    private final NativeWebRequest request;

    private final ObjectMapper objectMapper;

    private static final Logger log = LoggerFactory.getLogger(ApiApiController.class);

    @Autowired
    public ApiApiController(NativeWebRequest request, ObjectMapper objectMapper) {
        this.request = request;
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<?> genCodeAuto(@NotNull @Valid String codeLevel, @NotNull @Valid String codeBds, @NotNull @Valid String codeDepartment, @NotNull @Valid String filed, @NotNull @Valid String year) {
        try {
            return new ResponseEntity<>(codeTopic.genCodeTopic(codeLevel, codeBds, codeDepartment, filed, year), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new Response(101, Constants.TYPE, Constants.RESPONSE_ERROR_GEN_CODE, ""), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/api/genCodeDuty")
    public ResponseEntity<?> getCodeDuty(@RequestParam(required = true) String year,
                                         @RequestParam(required = true) String project,
                                         @RequestParam(required = true) String level,
                                         @RequestParam(required = false) String type,
                                         @RequestParam(required = false) String code) {
        try {
            Number number = codeTopic.genCodeTopicNew(year, project, level, type, code);
            return new ResponseEntity<>(number, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, Constants.TYPE, Constants.RESPONSE_ERROR_GEN_CODE, ""), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getAllConfigTopic() {
        try {
            List<ConfigTopic> configTopics = topicService.listConfigTopic();
            return new ResponseEntity<>(configTopics, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, Constants.TYPE, Constants.RESPONSE_ERROR_FIND_DATA, ""), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/api/genReport")
    public ResponseEntity<?> genReport(@RequestBody CaseInfoModel caseInfoModel) throws FileNotFoundException, JRException {
        try {
            return new ResponseEntity<>(topicService.generateFilePdf(caseInfoModel), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, Constants.TYPE, Constants.RESPONSE_ERROR_REPORT, ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/findDepartments")
    public ResponseEntity<?> findDepartments() throws FileNotFoundException, JRException {
        try {
            List<Department> departmentList = departmentService.getAllDepartment();
            return new ResponseEntity<>(departmentList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, Constants.TYPE, Constants.RESPONSE_ERROR_FIND_DATA, ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/findDeByCodeAndName")
    public ResponseEntity<?> findDeparByCodeAndName(@RequestParam(required = false) String codeDepertment,
                                                    @RequestParam(required = false) String nameDepartment) throws FileNotFoundException, JRException {
        try {
            List<Department> departmentList = departmentService.getDepartmentByNameOrCode(codeDepertment, nameDepartment);
            return new ResponseEntity<>(departmentList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, Constants.TYPE, Constants.RESPONSE_ERROR_FIND_DATA, ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/findDeByBranch")
    public ResponseEntity<?> findfindDeByBranch(@RequestParam(required = false) String branch) throws FileNotFoundException, JRException {
        try {
            List<Department> departmentList = departmentService.getAllDepartmentByBranch(branch);
            return new ResponseEntity<>(departmentList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, Constants.TYPE, Constants.RESPONSE_ERROR_FIND_DATA, ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/findDeByBrn")
    public ResponseEntity<?> findDeByBrn() throws FileNotFoundException, JRException {
        try {
            List<Department> departmentList = departmentService.getAllDepartmentByBrnLevel();
            return new ResponseEntity<>(departmentList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, Constants.TYPE, Constants.RESPONSE_ERROR_FIND_DATA, ""), HttpStatus.BAD_REQUEST);
        }
    }

}
