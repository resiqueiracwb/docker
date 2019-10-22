package com.roadmap.assembler;

import com.roadmap.controller.BuildingController;
import com.roadmap.model.Predio;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Component
public class PredioResourceAssembler implements ResourceAssembler<Predio, Resource<Predio>> {
    @Override
    public Resource<Predio> toResource(Predio predio) {

        Resource<Predio> predioResource = new Resource<>(predio,
                linkTo(methodOn(BuildingController.class).one(predio.getId())).withSelfRel(),
                linkTo(methodOn(BuildingController.class).all()).withRel("buildings"),
                linkTo(methodOn(BuildingController.class).complete(predio.getId())).withSelfRel()
        );
        return predioResource;
    }
}
