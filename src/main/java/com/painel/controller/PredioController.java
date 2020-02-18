package com.painel.controller;

import com.painel.model.Predio;
import com.painel.service.IPredioService;
import com.painel.vo.PredioVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Api(value = "PredioController")
@RestController
public class PredioController {
    @Autowired
    private IPredioService predioService;


    @GetMapping("/predios")
    @ApiOperation(value = "Best Practices for GET Implementation", response = Iterable.class, tags = "predios")
    public List<PredioVO> getPredio() {

        return this.predioService.getAllPredio();
    }

    @GetMapping("/predios/{id}")
    @ApiOperation(value = "Best Practices for GET Implementation")
    public Predio getPredioId(@RequestParam("id") Long id) {

        return this.predioService.getById(id);
    }

    @PostMapping("/predios")
    @ApiOperation(value = "Best Practices for POST Implementation")
    public Predio add(@RequestParam() Predio predio) {
        return this.predioService.save(predio);
    }

    @PutMapping("/predios/{id}")
    @ApiOperation(value = "Best Practices for PUT Implementation")
    public void update(@PathParam("id") Integer id, Predio predio) {
        this.predioService.save(predio);
    }

    @DeleteMapping("/predios/{id}")
    @ApiOperation(value = "Best Practices for DELETE Implementation")
    public void delete(@PathParam("id") Integer id) {
        this.predioService.delete(id);

    }
}
