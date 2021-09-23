package com.dc.drawer.drawerapi.presenter.rest.api.transaction;

import com.dc.drawer.drawerapi.core.usecase.UseCaseExecutor;
import com.dc.drawer.drawerapi.core.usecase.transaction.CreateTransactionUseCase;
import com.dc.drawer.drawerapi.core.usecase.transaction.GetTransactionByServiceUseCase;
import com.dc.drawer.drawerapi.core.usecase.transaction.GetTransactionByUserAndServiceUseCase;
import com.dc.drawer.drawerapi.core.usecase.transaction.GetTransactionByUserUseCase;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.ApiResponse;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.CreateTransactionRequest;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.TransactionHeaderResponse;
import com.dc.drawer.drawerapi.presenter.usecases.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class TransactionController implements TransactionResource{
    @Autowired
    CreateTransactionUseCase createTransactionUseCase;
    @Autowired
    CreateTransactionInputMapper createTransactionInputMapper;
    @Autowired
    CreateTransactionOutputMapper createTransactionOutputMapper;
    @Autowired
    UseCaseExecutor useCaseExecutor;
    @Autowired
    GetTransactionByUserUseCase getTransactionByUserUseCase;
    @Autowired
    GetTransactionByServiceUseCase getTransactionByServiceUseCase;
    @Autowired
    GetTransactionByUserAndServiceUseCase getTransactionByUserAndServiceUseCase;

    @Override
    public CompletableFuture<ResponseEntity<ApiResponse>> create(UserPrincipal userPrincipal, @Valid CreateTransactionRequest createTransactionRequest) {
        return useCaseExecutor.execute(
                createTransactionUseCase,
                createTransactionInputMapper.map(userPrincipal, createTransactionRequest),
                (outputValues)->createTransactionOutputMapper.map()
        );
    }

    @Override
    public CompletableFuture<List<TransactionHeaderResponse>> getByService(String serviceId) {
        return useCaseExecutor.execute(
            getTransactionByServiceUseCase,
                new GetTransactionByServiceUseCase.InputValues(serviceId),
                (outputValues) -> TransactionHeaderResponse.from(outputValues.getTransactionList())
        );
    }

    @Override
    public CompletableFuture<List<TransactionHeaderResponse>> getByServiceAndUser(UserPrincipal userPrincipal, String serviceId) {
        return useCaseExecutor.execute(
                getTransactionByUserAndServiceUseCase,
                new GetTransactionByUserAndServiceUseCase.InputValues(serviceId, userPrincipal.getId()),
                (outputValues) -> TransactionHeaderResponse.from(outputValues.getTransactionList())
        );
    }
}
