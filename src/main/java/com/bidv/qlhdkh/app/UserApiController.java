package com.bidv.qlhdkh.app;

import com.bidv.qlhdkh.model.CadresInforModel;
import com.bidv.qlhdkh.model.InfoUser;
import com.bidv.qlhdkh.model.Response;
import com.bidv.qlhdkh.model.UserModel;
import com.bidv.qlhdkh.service.UserServiceImpl;
import com.bidv.qlhdkh.service.impl.CallSoapService;
import com.bidv.qlhdkh.service.impl.UserServiceXmlImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-24T11:11:44.430828100+07:00[Asia/Bangkok]")

@Controller
@RequestMapping("${openapi.bPMService.base-path:/v2}")
public class UserApiController implements UserApi {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CallSoapService callSoapService;
    @Autowired
    UserServiceXmlImpl userServiceXml;
    private final NativeWebRequest request;

    @Autowired
    public UserApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    @GetMapping("/api/findUsers")
    public ResponseEntity<?> getUser(@RequestParam(value = "username", required = false) String username,
                                     @RequestParam(value = "codeUser", required = false) String codeUser,
                                     @RequestParam(value = "email", required = false) String email,
                                     @RequestParam(value = "brn", required = false) String brn,
                                     @RequestParam(value = "departmentCode", required = false) String departmentCode,
                                     @RequestParam(value = "brnLevel", required = false) String brnLevel,
                                     @RequestParam(value = "title", required = false) String title,
                                     @RequestParam(value = "department", required = false) String department,
                                     @RequestParam(value = "bds", required = false) String bds,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "50") int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            return new ResponseEntity<>(userService.getAllUserModel(username, codeUser, email, brn, departmentCode, title, department, brnLevel, bds, pageable), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "search data not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserBycodeUser(@RequestParam String codeUser) {
        try {
            UserModel userModel = userService.findUserBuCodeUser(codeUser);
            return new ResponseEntity<>(userModel, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "search data not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/getUsersByBranchAndRole")
    public ResponseEntity<?> getUsersByBranchAndRole(@RequestParam(required = false) String bdsid,
                                                     @RequestParam(required = false) String depcode,
                                                     @RequestParam(required = false) String rolecode) {
        try {
            List<CadresInforModel> cadresInforModels = callSoapService.callSoap(bdsid, depcode, rolecode);
            return new ResponseEntity<>(cadresInforModels, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Not success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/getUserInfo")
    public ResponseEntity<?> getUsersByBranchAndRole(@RequestParam(required = false) String email,
                                                     @RequestParam(required = false) String codeApp) {
        try {
            InfoUser infoUser = userServiceXml.getUserInfo(email, codeApp);
            return new ResponseEntity<>(infoUser,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Error Server Not Find Info User", ""), HttpStatus.BAD_REQUEST);
        }
    }
}
