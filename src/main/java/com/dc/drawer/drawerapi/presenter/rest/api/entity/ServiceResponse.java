package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import com.dc.drawer.drawerapi.core.domain.Service;
import lombok.Value;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class ServiceResponse {
    private final String id;
    private final String serviceName;
    private final DeveloperResponse developer;

    public static ServiceResponse from(Service service){
        return new ServiceResponse(
                service.getUuid(),
                service.getServiceName(),
                DeveloperResponse.from(service.getDeveloper())
        );
    }

    public static List<ServiceResponse> from(List<Service> services){
        return services
                .stream()
                .map(ServiceResponse::from)
                .collect(Collectors.toList());
    }
}
