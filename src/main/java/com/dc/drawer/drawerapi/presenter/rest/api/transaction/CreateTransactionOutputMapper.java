package com.dc.drawer.drawerapi.presenter.rest.api.transaction;

import com.dc.drawer.drawerapi.presenter.rest.api.entity.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionOutputMapper {
    public static ResponseEntity<ApiResponse> map(){
        return ResponseEntity.ok(new ApiResponse(true, "success"));
    }
}
