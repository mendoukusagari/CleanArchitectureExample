package com.dc.drawer.drawerapi.data.db.jpa.repositories;

import com.dc.drawer.drawerapi.core.domain.Transaction;
import com.dc.drawer.drawerapi.core.usecase.transaction.TransactionRepository;
import com.dc.drawer.drawerapi.data.db.jpa.entities.TransactionData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
    private JpaTransactionRepository repository;
    public TransactionRepositoryImpl(JpaTransactionRepository repository){
        this.repository = repository;
    }

    @Override
    public Transaction persist(Transaction transaction) {
        TransactionData transactionData = TransactionData.from(transaction);
        return repository.save(transactionData).fromThis();
    }

    @Override
    public List<Transaction> getByUser(Long userId) {
        return repository.findByUser(userId)
                .stream()
                .map(TransactionData::fromThis)
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getByService(String serviceId) {
        return repository.findByService(serviceId)
                .stream()
                .map(TransactionData::fromThis)
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getByUserAndService(Long userId, String serviceId) {
        return repository.findByUserAndService(userId,serviceId)
                .stream()
                .map(TransactionData::fromThis)
                .collect(Collectors.toList());
    }


}
