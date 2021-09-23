package com.dc.drawer.drawerapi.presenter.rest.api.service;

import com.dc.drawer.drawerapi.core.usecase.service.CreateServiceUseCase;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateServiceOutputMapper {
    public static ResponseEntity<ApiResponse> map(CreateServiceUseCase.OutputValues outputValues){
        return ResponseEntity.ok(new ApiResponse(true, "Create service is success"));
    }
}
