package com.dc.drawer.drawerapi.data.db.jpa.repositories;

import com.dc.drawer.drawerapi.data.db.jpa.entities.TransactionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaTransactionRepository extends JpaRepository<TransactionData, Long> {
    @Query(value = "select * from transaction_header h where h.user_id = ?1", nativeQuery = true)
    List<TransactionData> findByUser(Long userId);
    @Query(value = "select * from transaction_header h join service s on s.id = h.service_id where s.uuid=?1", nativeQuery = true)
    List<TransactionData> findByService(String serviceId);
    @Query(value = "select * from transaction_header h join service s on s.id = h.service_id where s.uuid=?2 and h.user_id=?1", nativeQuery = true)
    List<TransactionData> findByUserAndService(Long userId, String serviceId);
}
