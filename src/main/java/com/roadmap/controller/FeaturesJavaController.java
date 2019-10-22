package com.roadmap.controller;

import com.roadmap.assembler.PredioResourceAssembler;
import com.roadmap.model.Predio;
import com.roadmap.repository.IPredioRepository;
import com.roadmap.service.IPredioService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
