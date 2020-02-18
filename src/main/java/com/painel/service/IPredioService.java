package com.painel.service;

import com.painel.model.Predio;
import com.painel.vo.PredioVO;

import java.util.List;

public interface IPredioService {

    public List<PredioVO> getAllPredio();
    public Predio save(Predio predio);
    public void delete (Integer id);
    public Predio getById(Long id);
    public void newFeatures();
}
