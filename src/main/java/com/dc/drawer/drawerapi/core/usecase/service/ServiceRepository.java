package com.dc.drawer.drawerapi.core.usecase.service;

import com.dc.drawer.drawerapi.core.domain.Service;
import com.dc.drawer.drawerapi.core.domain.User;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    Service persist(Service service);
    List<Service> getAll();
    List<Service> getByDeveloper(User user);
    Optional<Service> getByUUID(String uuid);
}
