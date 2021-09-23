package com.dc.drawer.drawerapi.data.db.jpa.repositories;

import com.dc.drawer.drawerapi.data.db.jpa.entities.ServiceData;
import com.dc.drawer.drawerapi.data.db.jpa.entities.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JpaServiceRepository extends JpaRepository<ServiceData, Long> {
    List<ServiceData> findByDeveloper(UserData developer);
    @Query("select s from service s where s.uuid = ?1")
    Optional<ServiceData> findByUUID(String uuid);
}
