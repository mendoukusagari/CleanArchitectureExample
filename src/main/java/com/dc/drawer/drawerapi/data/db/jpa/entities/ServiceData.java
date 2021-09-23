package com.dc.drawer.drawerapi.data.db.jpa.entities;

import com.dc.drawer.drawerapi.core.domain.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "service")
@Table(name="service")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String serviceName;

    @ManyToOne
    @JoinColumn(name="developerId", nullable = false)
    private UserData developer;
    private Instant createdAt;
    private Instant updatedAt;

    public static ServiceData from(Service service){
        return new ServiceData(
                service.getId(),
                service.getUuid(),
                service.getServiceName(),
                UserData.from(service.getDeveloper()),
                service.getCreatedAt(),
                service.getUpdatedAt()
        );
    }

    public static Set<ServiceData> from(Set<Service> services){
        return services
                .stream()
                .map(ServiceData::from)
                .collect(Collectors.toSet());
    }

    public Service fromThis(){
        return new Service(
                id,
                uuid,
                serviceName,
                developer.fromThis(),
                createdAt,
                updatedAt
        );
    }

}
