package com.dc.drawer.drawerapi.presenter.rest.api.service;

import com.dc.drawer.drawerapi.core.usecase.service.UpdateServiceUseCase;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateServiceOutputMapper {
    public static ResponseEntity<ApiResponse> map(){
        return ResponseEntity.ok(new ApiResponse(true,"Update is success"));
    }
}
