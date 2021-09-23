package com.dc.drawer.drawerapi.core.usecase.service;

import com.dc.drawer.drawerapi.core.domain.Service;
import com.dc.drawer.drawerapi.core.domain.User;
import com.dc.drawer.drawerapi.core.domain.exception.DomainException;
import com.dc.drawer.drawerapi.core.usecase.UseCase;
import com.dc.drawer.drawerapi.core.usecase.user.UserRepository;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class CreateServiceUseCase extends UseCase<CreateServiceUseCase.InputValues, CreateServiceUseCase.OutputValues> {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OutputValues execute(InputValues input) {
        Service service = createService(input);
        return new OutputValues(service);
    }

    public Service createService(InputValues inputValues){
        Service service = Service.newinstance(
                inputValues.getServiceName(),
                getUserById(inputValues.getDeveloperId())
        );
        return serviceRepository.persist(service);
    }

    public User getUserById(Long id){
        return userRepository
                .findById(id)
                .orElse(null);
    }

    @Value
    public static class InputValues implements UseCase.InputValues{
        private final String serviceName;
        private final Long developerId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues{
        private final Service service;
    }

}
