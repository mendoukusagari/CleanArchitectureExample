package com.dc.drawer.drawerapi.core.domain;

import lombok.Value;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Value
public class Transaction {
    private final Long id;
    private final String uuid;
    private final User user;
    private final Service service;
    private final Set<TransactionDetail> transactionDetails;
    private final Double total;
    private final Instant createdAt;

    public static Transaction newInstance(User user, Service service, Set<TransactionDetail> transactionDetails){
        return new Transaction(
                null,
                UUID.randomUUID().toString().replace("-",""),
                user,
                service,
                transactionDetails,
                calculateTotal(transactionDetails),
                Instant.now()
        );
    }
    public static Double calculateTotal(Set<TransactionDetail> transactionDetails){
        return transactionDetails
                .stream()
                .mapToDouble(TransactionDetail::getSubTotal)
                .sum();
    }
}
