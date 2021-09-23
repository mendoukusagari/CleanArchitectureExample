package com.dc.drawer.drawerapi.core.usecase.service;

import com.dc.drawer.drawerapi.core.domain.Service;
import com.dc.drawer.drawerapi.core.domain.User;
import com.dc.drawer.drawerapi.core.domain.exception.DomainException;
import com.dc.drawer.drawerapi.core.usecase.UseCase;
import com.dc.drawer.drawerapi.core.usecase.user.UserRepository;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class UpdateServiceUseCase extends UseCase<UpdateServiceUseCase.InputValues, UpdateServiceUseCase.OutputValues> {
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public OutputValues execute(InputValues input) {
        Service newService = Service.newinstance(
                input.getServiceName(),
                getDeveloper(input.getDeveloperId())
                );
        return serviceRepository
                .getByUUID(input.getId())
                .map(s -> s.newInstanceWith(newService))
                .map(this::persistAndReturn)
                .orElseThrow(()->new DomainException("Not found"));
    }

    public User getDeveloper(Long id){
        return userRepository.findById(id).get();
    }

    public OutputValues persistAndReturn(Service service){
        return new OutputValues(this.serviceRepository.persist(service));
    }

    @Value
    public static class InputValues implements UseCase.InputValues{
        private final String id;
        private final String serviceName;
        private final Long developerId;
    }
    @Value
    public static class OutputValues implements UseCase.OutputValues{
        private final Service service;
    }
}
