package com.dc.drawer.drawerapi.core.usecase.service;


import com.dc.drawer.drawerapi.core.domain.Service;
import com.dc.drawer.drawerapi.core.usecase.UseCase;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class GetAllServiceUseCase extends UseCase<GetAllServiceUseCase.InputValues,GetAllServiceUseCase.OutputValues> {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public OutputValues execute(InputValues input) {
        return new OutputValues(serviceRepository.getAll());
    }
    public static class InputValues implements UseCase.InputValues{

    }
    @Value
    public static class OutputValues implements UseCase.OutputValues{
        List<Service> services;
    }
}
