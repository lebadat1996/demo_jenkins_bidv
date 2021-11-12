package com.bidv.qlhdkh.controllers;

import com.bidv.qlhdkh.entity.CaseInfo;
import com.bidv.qlhdkh.entity.Council;
import com.bidv.qlhdkh.model.CouncilModel;
import com.bidv.qlhdkh.model.Response;
import com.bidv.qlhdkh.service.impl.CaseInfoCustomRepositoryImpl;
import com.bidv.qlhdkh.service.impl.CouncilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-14T07:52:33.572Z")
@RestController
@RequestMapping("${openapi.bPMService.base-path:/v2}")
public class CouncilController {
    @Autowired
    CouncilServiceImpl councilService;

    @Autowired
    CaseInfoCustomRepositoryImpl infoCustomRepository;

    @PostMapping("/api/saveCouncil")
    public ResponseEntity<?> saveCouncil(@RequestBody CouncilModel councilModel) {
        try {
            councilService.createCouncil(councilModel);
            return new ResponseEntity<>(new Response(1000, "response", "create council success", "success"), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "response", "create council not success", "bad request"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/getAllCouncil")
    public ResponseEntity<?> getAllCouncil() {
        try {
            return new ResponseEntity<>(councilService.getAllCouncil(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "Response", "Error GetAll Info Council", "Bad Request"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/getInfoCouncil")
    public ResponseEntity<?> getInfoCouncil(@RequestParam int councilId) {
        try {
            CouncilModel council = councilService.getInfoCouncil(councilId);
            return new ResponseEntity<>(council, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "Response", "Error Get Detail Info Council", "Bad Request"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/removeCouncil")
    public ResponseEntity<?> removeCouncil(@RequestParam int councilId) {
        try {
            int response = councilService.deleteCouncil(councilId);
            if (response == 0) {
                return new ResponseEntity<>(new Response(1000, "Response", "Delete Infomation Council Success", "Successfull"), HttpStatus.OK);
            } else if (response == 1) {
                return new ResponseEntity<>(new Response(1001, "Response", "Not found Info Council", "Not Found Data"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Response(1002, "Response", "Not found Info Council", "Not Found Data"), HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1003, "Response", "Error Delete Info Council", "Bad Request"), HttpStatus.BAD_REQUEST);
        }
    }

}
