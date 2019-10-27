package com.painel.service;

import com.painel.model.Application;
import com.painel.vo.ApplicationVO;

import java.util.List;

public interface IApplicationService {

    void save(Application application);
    List<ApplicationVO> getAll();
}
