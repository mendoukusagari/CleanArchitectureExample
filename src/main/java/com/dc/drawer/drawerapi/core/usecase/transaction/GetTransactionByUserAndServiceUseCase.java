package com.dc.drawer.drawerapi.core.usecase.transaction;

import com.dc.drawer.drawerapi.core.domain.Transaction;
import com.dc.drawer.drawerapi.core.usecase.UseCase;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTransactionByUserAndServiceUseCase extends UseCase<GetTransactionByUserAndServiceUseCase.InputValues, GetTransactionByUserAndServiceUseCase.OutputValues> {
    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public GetTransactionByUserAndServiceUseCase.OutputValues execute(GetTransactionByUserAndServiceUseCase.InputValues input) {
        if(input.serviceId!=null)
            return new GetTransactionByUserAndServiceUseCase.OutputValues(transactionRepository.getByUserAndService(input.getUserId(), input.getServiceId()));
        else
            return new GetTransactionByUserAndServiceUseCase.OutputValues(transactionRepository.getByUser(input.getUserId()));
    }

    @Value
    public static class InputValues implements UseCase.InputValues{
        private final String serviceId;
        private final Long userId;
    }
    @Value
    public static class OutputValues implements UseCase.OutputValues{
        private final List<Transaction> transactionList;
    }
}
