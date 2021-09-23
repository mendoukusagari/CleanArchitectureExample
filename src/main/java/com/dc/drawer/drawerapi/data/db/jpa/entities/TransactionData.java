package com.dc.drawer.drawerapi.data.db.jpa.entities;

import com.dc.drawer.drawerapi.core.domain.Transaction;
import com.dc.drawer.drawerapi.core.domain.TransactionDetail;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "transactionHeader")
@Table(name = "transaction_header")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private UserData user;

    @ManyToOne
    @JoinColumn(name="service_id", nullable = false)
    private ServiceData service;

    @OneToMany(
            fetch= FetchType.EAGER,
            mappedBy = "transactionHeader",
            cascade = {CascadeType.MERGE,CascadeType.PERSIST},
            orphanRemoval = true
    )
    private Set<TransactionDetailData> transactionDetails;

    private Double total;
    private Instant createdAt;

    public void addTransactionDetail(TransactionDetailData transactionDetailData){
        transactionDetailData.setTransactionHeader(this);
        this.transactionDetails.add(transactionDetailData);
    }

    public static TransactionData from(Transaction transaction){
        TransactionData transactionData = new TransactionData(
                transaction.getId(),
                transaction.getUuid(),
                UserData.from(transaction.getUser()),
                ServiceData.from(transaction.getService()),
                new HashSet<>(),
                transaction.getTotal(),
                transaction.getCreatedAt()
        );
        TransactionDetailData
                .from(transaction.getTransactionDetails())
                .forEach(transactionData::addTransactionDetail);

        return transactionData;
    }

    public Set<TransactionDetail> fromTransactionDetailData(){
        return transactionDetails
                .stream()
                .map(TransactionDetailData::fromThis)
                .collect(Collectors.toSet());
    }

    public Transaction fromThis(){
        return new Transaction(
                id,
                uuid,
                user.fromThis(),
                service.fromThis(),
                fromTransactionDetailData(),
                total,
                createdAt

        );
    }
}
