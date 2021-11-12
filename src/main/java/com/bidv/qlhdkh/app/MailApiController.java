package com.bidv.qlhdkh.app;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.bidv.qlhdkh.model.Email;
import com.bidv.qlhdkh.model.Response;
import com.bidv.qlhdkh.service.MailService;
import com.bidv.qlhdkh.service.SendMailService;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-24T11:11:44.430828100+07:00[Asia/Bangkok]")

@Controller
@RequestMapping("${openapi.bPMService.base-path:/v2}")
public class MailApiController implements MailApi {

    private final NativeWebRequest request;

    @Autowired
    MailService mailService;

    @Autowired
    SendMailService sendMailService;

    @GetMapping("/api/sendInfoMail")
    public ResponseEntity<?> emailNotify() throws MessagingException {
        try {
            sendMailService.sendMailServiceReport();
            return new ResponseEntity<>(new Response(1001, "String", "Error Send Mail Not Success", ""),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Error Send Mail Not Success", ""), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Response> sendMail(@Valid Email body) throws MessagingException {
        try {
            mailService.sendMails(body);
            return new ResponseEntity<>(new Response(1000, "String", "Send Mail Success", ""), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Response(1001, "String", "Error Send Mail Success", ""), HttpStatus.BAD_REQUEST);
        }
    }


    @Autowired
    public MailApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
