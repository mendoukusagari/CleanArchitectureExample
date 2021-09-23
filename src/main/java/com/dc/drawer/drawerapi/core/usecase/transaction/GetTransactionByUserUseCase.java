package com.dc.drawer.drawerapi.core.usecase.transaction;

import com.dc.drawer.drawerapi.core.domain.Transaction;
import com.dc.drawer.drawerapi.core.usecase.UseCase;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTransactionByUserUseCase extends UseCase<GetTransactionByUserUseCase.InputValues, GetTransactionByUserUseCase.OutputValues> {
    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public OutputValues execute(InputValues input) {
        return new OutputValues(transactionRepository.getByUser(input.getUserId()));
    }

    @Value
    public static class InputValues implements UseCase.InputValues{
        private final Long userId;
    }
    @Value
    public static class OutputValues implements UseCase.OutputValues{
        private final List<Transaction> transactionList;
    }
}
