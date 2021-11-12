package com.bidv.qlhdkh.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-24T11:11:44.430828100+07:00[Asia/Bangkok]")

@Controller
@RequestMapping("${openapi.bPMService.base-path:/v2}")
public class ResearchApiController implements ResearchApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ResearchApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
