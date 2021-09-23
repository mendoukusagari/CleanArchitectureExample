package com.dc.drawer.drawerapi.data.db.jpa.repositories;

import com.dc.drawer.drawerapi.core.domain.User;
import com.dc.drawer.drawerapi.core.usecase.user.UserRepository;
import com.dc.drawer.drawerapi.data.db.jpa.entities.UserData;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private JpaUserRepository repository;

    public UserRepositoryImpl(JpaUserRepository repository){
        this.repository = repository;
    }

    @Override
    public User persist(User user) {
        UserData userData = UserData.from(user);
        return repository.save(userData).fromThis();
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return repository.findByEmail(email).map(UserData::fromThis);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id).map(UserData::fromThis);
    }

    @Override
    public boolean existByEmail(String email) {
        return repository.findByEmail(email).map(userData -> userData!=null).orElse(false);
    }

    @Override
    public Optional<User> findByUuid(String id) {
        return repository.findByUUID(id).map(UserData::fromThis);
    }
}
