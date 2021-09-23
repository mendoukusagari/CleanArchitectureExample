package com.dc.drawer.drawerapi.data.db.jpa.repositories;

import com.dc.drawer.drawerapi.data.db.jpa.entities.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface JpaUserRepository extends JpaRepository<UserData, Long> {
    Optional<UserData> findByEmail(String email);
    @Query("select u from user u where u.uuid = ?1")
    Optional<UserData> findByUUID(String uuid);
}
