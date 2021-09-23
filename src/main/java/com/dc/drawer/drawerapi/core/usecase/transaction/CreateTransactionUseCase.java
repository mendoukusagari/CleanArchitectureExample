package com.dc.drawer.drawerapi.core.usecase.transaction;

import com.dc.drawer.drawerapi.core.domain.Service;
import com.dc.drawer.drawerapi.core.domain.Transaction;
import com.dc.drawer.drawerapi.core.domain.TransactionDetail;
import com.dc.drawer.drawerapi.core.domain.User;
import com.dc.drawer.drawerapi.core.domain.exception.DomainException;
import com.dc.drawer.drawerapi.core.usecase.UseCase;
import com.dc.drawer.drawerapi.core.usecase.service.ServiceRepository;
import com.dc.drawer.drawerapi.core.usecase.user.UserRepository;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class CreateTransactionUseCase extends UseCase<CreateTransactionUseCase.InputValues, CreateTransactionUseCase.OutputValues> {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public OutputValues execute(InputValues input) {
        Transaction transaction = Transaction.newInstance(
                getUser(input.getUserId()),
                getService(input.getServiceId()),
                input.getTransactionDetailList().stream().map(this::createTransactionDetail).collect(Collectors.toSet())
        );
        return new OutputValues(transactionRepository.persist(transaction));
    }

    public TransactionDetail createTransactionDetail(InputDetail inputDetail){
        return TransactionDetail.newInstance(
                inputDetail.getTransactionName(),
                inputDetail.getTransactionDetail(),
                inputDetail.getSubTotal()
        );
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(()->new DomainException("Not found"));
    }

    public Service getService(String id){
        return serviceRepository.getByUUID(id).orElseThrow(()->new DomainException("Not found"));
    }

    @Value
    public static class InputValues implements UseCase.InputValues{
        private final String serviceId;
        private final Set<InputDetail> transactionDetailList;
        private final Long userId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues{
        private final Transaction transaction;
    }

    @Value
    public static class InputDetail{
        private final String transactionName;
        private final String transactionDetail;
        private final Double subTotal;
    }
}
