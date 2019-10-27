package com.painel.controller;

import com.painel.service.IApplicationService;
import com.painel.vo.ApplicationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "ApplicationsoController")
@RestController
public class ApplicationController {

    @Autowired
    private IApplicationService applicationService;


    @GetMapping("/applications")
    @ApiOperation(value = "Best Practices for GET Implementation", response = Iterable.class, tags = "applications")
    public List<ApplicationVO> getApplications() {

        return this.applicationService.getAll();
    }

}
