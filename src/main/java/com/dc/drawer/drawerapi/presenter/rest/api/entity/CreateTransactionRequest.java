package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionRequest {
    private String serviceId;
    private Set<TransactionDetailRequest> transactionDetail;
}
