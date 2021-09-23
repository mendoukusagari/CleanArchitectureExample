package com.dc.drawer.drawerapi.presenter.rest.api.service;

import com.dc.drawer.drawerapi.presenter.rest.api.entity.ApiResponse;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.CreateServiceRequest;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.ServiceResponse;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.UpdateServiceRequest;
import com.dc.drawer.drawerapi.presenter.usecases.security.CurrentUser;
import com.dc.drawer.drawerapi.presenter.usecases.security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/service")
public interface ServiceResource {
    @PostMapping
    CompletableFuture<ResponseEntity<ApiResponse>> create(@CurrentUser UserPrincipal userPrincipal, @Valid @RequestBody CreateServiceRequest createServiceRequest);

    @GetMapping("{id}")
    CompletableFuture<ServiceResponse> getService(@PathVariable String id);

    @GetMapping("")
    CompletableFuture<List<ServiceResponse>> getAll();

    @PutMapping("")
    CompletableFuture<ResponseEntity<ApiResponse>> update(@CurrentUser UserPrincipal userPrincipal, @Valid @RequestBody UpdateServiceRequest updateServiceRequest);

}
