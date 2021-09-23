package com.dc.drawer.drawerapi.core.usecase.service;

import com.dc.drawer.drawerapi.core.domain.Service;
import com.dc.drawer.drawerapi.core.domain.exception.DomainException;
import com.dc.drawer.drawerapi.core.usecase.UseCase;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class GetServiceByUUIDUseCase extends UseCase<GetServiceByUUIDUseCase.InputValues,GetServiceByUUIDUseCase.OutputValues> {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public GetServiceByUUIDUseCase.OutputValues execute(GetServiceByUUIDUseCase.InputValues input) {
        return serviceRepository
                .getByUUID(input.uuid)
                .map(OutputValues::new)
                .orElseThrow(()->new DomainException("Not found"));
    }
    @Value
    public static class InputValues implements UseCase.InputValues{
        private String uuid;
    }
    @Value
    public static class OutputValues implements UseCase.OutputValues{
        private Service service;
    }
}
