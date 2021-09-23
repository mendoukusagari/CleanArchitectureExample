package com.dc.drawer.drawerapi.core.usecase.user;

import com.dc.drawer.drawerapi.core.domain.User;

import java.util.Optional;

public interface UserRepository {
    User persist(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    boolean existByEmail(String email);
    Optional<User> findByUuid(String id);

}
