package com.dc.drawer.drawerapi.presenter.rest.api.service;

import com.dc.drawer.drawerapi.core.usecase.service.CreateServiceUseCase;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.CreateServiceRequest;
import com.dc.drawer.drawerapi.presenter.usecases.security.UserPrincipal;
import org.springframework.stereotype.Service;

@Service
public class CreateServiceInputMapper {
    public static CreateServiceUseCase.InputValues map(CreateServiceRequest createServiceRequest, UserPrincipal userPrincipal){
        return new CreateServiceUseCase.InputValues(createServiceRequest.getServiceName(), userPrincipal.getId());
    }
}
