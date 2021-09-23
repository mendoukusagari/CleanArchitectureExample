package com.dc.drawer.drawerapi.presenter.rest.api.service;

import com.dc.drawer.drawerapi.core.usecase.service.UpdateServiceUseCase;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.UpdateServiceRequest;
import com.dc.drawer.drawerapi.presenter.usecases.security.UserPrincipal;
import org.springframework.stereotype.Service;

@Service
public class UpdateServiceInputMapper {
    public static UpdateServiceUseCase.InputValues map(UpdateServiceRequest updateServiceRequest, UserPrincipal userPrincipal){
        return new UpdateServiceUseCase.InputValues(
                updateServiceRequest.getId(),
                updateServiceRequest.getServiceName(),
                userPrincipal.getId());
    }
}
