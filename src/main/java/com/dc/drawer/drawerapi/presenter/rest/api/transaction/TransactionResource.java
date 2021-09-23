package com.dc.drawer.drawerapi.presenter.rest.api.transaction;

import com.dc.drawer.drawerapi.presenter.rest.api.entity.ApiResponse;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.CreateTransactionRequest;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.TransactionHeaderResponse;
import com.dc.drawer.drawerapi.presenter.usecases.security.CurrentUser;
import com.dc.drawer.drawerapi.presenter.usecases.security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("transaction")
public interface TransactionResource {
    @PostMapping
    CompletableFuture<ResponseEntity<ApiResponse>> create(@CurrentUser UserPrincipal userPrincipal, @Valid @RequestBody CreateTransactionRequest createTransactionRequest);

    @GetMapping("getByServiceOnly")
    CompletableFuture<List<TransactionHeaderResponse>> getByService(@RequestParam("service") String serviceId);

    @GetMapping
    CompletableFuture<List<TransactionHeaderResponse>> getByServiceAndUser(@CurrentUser UserPrincipal userPrincipal, @RequestParam(value = "service" ,required = false) String serviceId);
}
