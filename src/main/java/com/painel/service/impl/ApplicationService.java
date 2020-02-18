package com.painel.service.impl;

import com.painel.model.Application;
import com.painel.repository.IApplicationRepository;
import com.painel.service.IApplicationService;
import com.painel.vo.ApplicationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService implements IApplicationService {

    @Autowired
    private IApplicationRepository applicationRepository;

    @Override
    public void save(Application application) {

    }

    @Override
    public List<ApplicationVO> getAll() {
        List<ApplicationVO> applicationVOS = new ArrayList<ApplicationVO>();
        this.applicationRepository.findAll().forEach(application -> {
            applicationVOS.add(new ApplicationVO(application));
        });

        return applicationVOS;
    }
}
