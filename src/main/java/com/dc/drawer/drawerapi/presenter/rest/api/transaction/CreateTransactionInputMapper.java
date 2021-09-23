package com.dc.drawer.drawerapi.presenter.rest.api.transaction;

import com.dc.drawer.drawerapi.core.domain.TransactionDetail;
import com.dc.drawer.drawerapi.core.usecase.transaction.CreateTransactionUseCase;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.CreateTransactionRequest;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.TransactionDetailRequest;
import com.dc.drawer.drawerapi.presenter.usecases.security.UserPrincipal;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CreateTransactionInputMapper {
    public static CreateTransactionUseCase.InputValues map(UserPrincipal userPrincipal, CreateTransactionRequest createTransactionRequest){
        return new CreateTransactionUseCase.InputValues(
                createTransactionRequest.getServiceId(),
                map(createTransactionRequest.getTransactionDetail()),
                userPrincipal.getId()
        );
    }
    public static Set<CreateTransactionUseCase.InputDetail> map(Set<TransactionDetailRequest> transactionDetailRequests){
        return transactionDetailRequests
                .stream()
                .map(CreateTransactionInputMapper::map)
                .collect(Collectors.toSet());
    }
    public static CreateTransactionUseCase.InputDetail map(TransactionDetailRequest transactionDetailRequest){
        return new CreateTransactionUseCase.InputDetail(
                transactionDetailRequest.getTransactionName(),
                transactionDetailRequest.getTransactionDetail(),
                transactionDetailRequest.getSubTotal());
    }
}
