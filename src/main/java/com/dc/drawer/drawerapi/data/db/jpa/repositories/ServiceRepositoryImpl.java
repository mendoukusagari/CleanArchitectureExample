package com.dc.drawer.drawerapi.data.db.jpa.repositories;

import com.dc.drawer.drawerapi.core.domain.Service;
import com.dc.drawer.drawerapi.core.domain.User;
import com.dc.drawer.drawerapi.core.usecase.service.ServiceRepository;
import com.dc.drawer.drawerapi.data.db.jpa.entities.ServiceData;
import com.dc.drawer.drawerapi.data.db.jpa.entities.UserData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ServiceRepositoryImpl implements ServiceRepository {
    private JpaServiceRepository repository;
    public ServiceRepositoryImpl(JpaServiceRepository repository){
        this.repository = repository;
    }

    @Override
    public Service persist(Service service) {
        ServiceData serviceData = ServiceData.from(service);
        return repository.save(serviceData).fromThis();
    }

    @Override
    public List<Service> getAll() {
        return repository.findAll()
                .stream()
                .map(ServiceData::fromThis)
                .collect(Collectors.toList());
    }

    @Override
    public List<Service> getByDeveloper(User user) {
        return repository.findByDeveloper(UserData.from(user))
                .stream()
                .map(ServiceData::fromThis)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Service> getByUUID(String uuid) {
        return repository
                .findByUUID(uuid)
                .map(ServiceData::fromThis);
    }


}
