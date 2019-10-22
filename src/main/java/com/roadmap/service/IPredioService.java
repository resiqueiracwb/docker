package com.roadmap.service;

import com.roadmap.model.Predio;
import com.roadmap.vo.PredioVO;

import java.util.List;

public interface IPredioService {

    public List<PredioVO> getAllPredio();
    public Predio save(Predio predio);
    public void delete (Integer id);
    public Predio getById(Long id);
    public void newFeatures();
}
