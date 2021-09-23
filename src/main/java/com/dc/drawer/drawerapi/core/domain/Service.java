package com.dc.drawer.drawerapi.core.domain;

import lombok.Value;

import java.time.Instant;
import java.util.UUID;

@Value
public class Service {
    private Long id;
    private String uuid;
    private String serviceName;
    private User developer;
    private Instant createdAt;
    private Instant updatedAt;

    public static Service newinstance(String serviceName, User developer){
        return new Service(
                null,
                UUID.randomUUID().toString().replace("-",""),
                serviceName,
                developer,
                Instant.now(),
                Instant.now()
        );
    }


    public Service newInstanceWith(Service service){
        return new Service(
                id,
                uuid,
                service.getServiceName() == null ? serviceName : service.getServiceName(),
                service.getDeveloper() == null ? developer : service.getDeveloper(),
                createdAt,
                Instant.now()
        );
    }
}
