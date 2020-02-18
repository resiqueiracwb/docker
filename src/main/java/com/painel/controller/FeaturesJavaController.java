package com.painel.controller;

import com.painel.service.IPredioService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Api(value = "FeaturesJavaController")
@RestController
public class FeaturesJavaController {

    @Autowired
    private IPredioService predioService;

    @GetMapping(value = "/features", produces = "application/json; charset=UTF-8")
    public void all() {

        this.predioService.newFeatures();

    }

}
