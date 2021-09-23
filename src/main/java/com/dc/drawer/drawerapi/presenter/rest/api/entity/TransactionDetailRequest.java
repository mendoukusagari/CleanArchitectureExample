package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetailRequest {
    private String transactionName;
    private String transactionDetail;
    private Double subTotal;
}
