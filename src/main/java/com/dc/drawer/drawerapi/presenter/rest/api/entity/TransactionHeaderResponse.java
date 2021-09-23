package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import com.dc.drawer.drawerapi.core.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHeaderResponse {
    private String id;
    private Double total;
    private ServiceResponse service;
    private UserTransactionResponse user;
    private List<TransactionDetailResponse> transactionDetails;

    public static TransactionHeaderResponse from(Transaction transaction){
        return new TransactionHeaderResponse(
                transaction.getUuid(),
                transaction.getTotal(),
                ServiceResponse.from(transaction.getService()),
                UserTransactionResponse.from(transaction.getUser()),
                TransactionDetailResponse.from(transaction.getTransactionDetails())
        );
    }

    public static List<TransactionHeaderResponse> from(List<Transaction> transactionList){
        return transactionList
                .stream()
                .map(TransactionHeaderResponse::from)
                .collect(Collectors.toList());
    }
}
