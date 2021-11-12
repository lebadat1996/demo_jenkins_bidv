package com.bidv.qlhdkh.controllers;

import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.Response;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-14T07:15:08.600Z")

@Validated
@Api(value = "api", description = "the api API")
@RequestMapping(value = "/v2")
public interface CaseInfoApi {
    @ApiOperation(value = "saveCaseInfo", nickname = "saveCaseInfo", notes = "saveCaseInfo", response = Response.class, responseContainer = "List", tags={ "service", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Response.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Error save CaseInfo", response = Response.class) })
    @RequestMapping(value = "/api/saveCaseInfo",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<?> saveCaseInfo(@ApiParam(value = "CaseInfo Object" ,required=true )  @Valid @RequestBody CaseInfoModel body);
}
