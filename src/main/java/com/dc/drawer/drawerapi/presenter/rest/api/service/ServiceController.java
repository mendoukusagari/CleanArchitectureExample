package com.dc.drawer.drawerapi.presenter.rest.api.service;

import com.dc.drawer.drawerapi.core.usecase.UseCaseExecutor;
import com.dc.drawer.drawerapi.core.usecase.service.CreateServiceUseCase;
import com.dc.drawer.drawerapi.core.usecase.service.GetAllServiceUseCase;
import com.dc.drawer.drawerapi.core.usecase.service.GetServiceByUUIDUseCase;
import com.dc.drawer.drawerapi.core.usecase.service.UpdateServiceUseCase;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.ApiResponse;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.CreateServiceRequest;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.ServiceResponse;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.UpdateServiceRequest;
import com.dc.drawer.drawerapi.presenter.usecases.security.CurrentUser;
import com.dc.drawer.drawerapi.presenter.usecases.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class ServiceController implements ServiceResource {

    @Autowired
    private UseCaseExecutor useCaseExecutor;
    @Autowired
    private CreateServiceUseCase createServiceUseCase;
    @Autowired
    private CreateServiceInputMapper createServiceInputMapper;
    @Autowired
    private CreateServiceOutputMapper createServiceOutputMapper;
    @Autowired
    private GetServiceByUUIDUseCase getServiceByUUIDUseCase;
    @Autowired
    private GetAllServiceUseCase getAllServiceUseCase;
    @Autowired
    private UpdateServiceUseCase updateServiceUseCase;
    @Autowired
    private UpdateServiceInputMapper updateServiceInputMapper;
    @Autowired
    private UpdateServiceOutputMapper updateServiceOutputMapper;

    @Override
    public CompletableFuture<ResponseEntity<ApiResponse>> create(@CurrentUser UserPrincipal userPrincipal, @Valid  @RequestBody CreateServiceRequest createServiceRequest) {
        return useCaseExecutor.execute(
                createServiceUseCase,
                createServiceInputMapper.map(createServiceRequest,userPrincipal),
                (outputValues)-> createServiceOutputMapper.map(outputValues)
        );
    }

    @Override
    public CompletableFuture<ServiceResponse> getService(String id) {
        return useCaseExecutor.execute(
                getServiceByUUIDUseCase,
                new GetServiceByUUIDUseCase.InputValues(id),
                (outputValues)-> ServiceResponse.from(outputValues.getService())
        );
    }

    @Override
    public CompletableFuture<List<ServiceResponse>> getAll() {
        return useCaseExecutor.execute(
                getAllServiceUseCase,
                new GetAllServiceUseCase.InputValues(),
                (outputValues)-> ServiceResponse.from(outputValues.getServices())
        );
    }

    @Override
    public CompletableFuture<ResponseEntity<ApiResponse>> update(UserPrincipal userPrincipal, @Valid UpdateServiceRequest updateServiceRequest) {
        return useCaseExecutor.execute(
                updateServiceUseCase,
                new UpdateServiceInputMapper().map(updateServiceRequest,userPrincipal),
                (outputValues) -> new UpdateServiceOutputMapper().map()
        );
    }
}
