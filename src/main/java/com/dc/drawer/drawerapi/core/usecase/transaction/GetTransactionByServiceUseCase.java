package com.dc.drawer.drawerapi.core.usecase.transaction;

import com.dc.drawer.drawerapi.core.domain.Transaction;
import com.dc.drawer.drawerapi.core.usecase.UseCase;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTransactionByServiceUseCase extends UseCase<GetTransactionByServiceUseCase.InputValues,GetTransactionByServiceUseCase.OutputValues>{
    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public GetTransactionByServiceUseCase.OutputValues execute(GetTransactionByServiceUseCase.InputValues input) {
        return new GetTransactionByServiceUseCase.OutputValues(transactionRepository.getByService(input.getServiceId()));
    }

    @Value
    public static class InputValues implements UseCase.InputValues{
        private final String serviceId;
    }
    @Value
    public static class OutputValues implements UseCase.OutputValues{
        private final List<Transaction> transactionList;
    }
}
