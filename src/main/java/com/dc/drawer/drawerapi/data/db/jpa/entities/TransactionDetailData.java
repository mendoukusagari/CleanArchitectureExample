package com.dc.drawer.drawerapi.data.db.jpa.entities;

import com.dc.drawer.drawerapi.core.domain.TransactionDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "transactionDetail")
@Table(name="transaction_detail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetailData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String transactionName;
    private String transactionDetail;
    @ManyToOne
    @JoinColumn(name="transaction_header_id")
    private TransactionData transactionHeader;
    private Double subTotal;
    private Instant createdAt;
    private Instant updatedAt;

    public static Set<TransactionDetailData> from(Set<TransactionDetail> transactionDetails){
        return transactionDetails
                .stream()
                .map(TransactionDetailData::from)
                .collect(Collectors.toSet());
    }

    public static TransactionDetailData from(TransactionDetail transactionDetail){
        return new TransactionDetailData(
                transactionDetail.getId(),
                transactionDetail.getUuid(),
                transactionDetail.getTransactionName(),
                transactionDetail.getTransactionDetail(),
                null,
                transactionDetail.getSubTotal(),
                transactionDetail.getCreatedAt(),
                transactionDetail.getUpdatedAt()
        );
    }

    public TransactionDetail fromThis(){
        return new TransactionDetail(
                id,
                uuid,
                transactionName,
                transactionDetail,
                subTotal,
                createdAt,
                updatedAt
        );
    }
}
