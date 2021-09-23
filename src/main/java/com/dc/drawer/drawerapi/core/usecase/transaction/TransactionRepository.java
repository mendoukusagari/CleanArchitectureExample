package com.dc.drawer.drawerapi.core.usecase.transaction;

import com.dc.drawer.drawerapi.core.domain.Service;
import com.dc.drawer.drawerapi.core.domain.Transaction;
import com.dc.drawer.drawerapi.core.domain.User;

import java.util.List;

public interface TransactionRepository {
    Transaction persist(Transaction transaction);
    List<Transaction> getByUser(Long userId);
    List<Transaction> getByService(String serviceId);
    List<Transaction> getByUserAndService(Long userId, String serviceId);
}
