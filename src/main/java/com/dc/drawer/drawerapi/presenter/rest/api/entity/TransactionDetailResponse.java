package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import com.dc.drawer.drawerapi.core.domain.TransactionDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetailResponse {
    private String id;
    private String transactionName;
    private String transactionDetail;
    private Double subTotal;

    public static TransactionDetailResponse from(TransactionDetail transactionDetail){
        return new TransactionDetailResponse(
                transactionDetail.getUuid(),
                transactionDetail.getTransactionName(),
                transactionDetail.getTransactionDetail(),
                transactionDetail.getSubTotal()
        );
    }

    public static List<TransactionDetailResponse> from(Set<TransactionDetail> transactionDetails){
        return transactionDetails
                .stream()
                .map(TransactionDetailResponse::from)
                .collect(Collectors.toList());
    }
}
