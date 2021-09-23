package com.dc.drawer.drawerapi.core.domain;

import lombok.Value;

import java.time.Instant;
import java.util.UUID;

@Value
public class TransactionDetail {
    private final Long id;
    private final String uuid;
    private final String transactionName;
    private final String transactionDetail;
    private final Double subTotal;
    private final Instant createdAt;
    private final Instant updatedAt;

    public static TransactionDetail newInstance(String transactionName, String transactionDetail, double subTotal){
        return new TransactionDetail(
                null,
                UUID.randomUUID().toString().replace("-",""),
                transactionName,
                transactionDetail,
                subTotal,
                Instant.now(),
                Instant.now()
        );
    }
}
