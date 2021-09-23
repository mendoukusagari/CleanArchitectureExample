package com.dc.drawer.drawerapi.data.db.jpa.entities;

import com.dc.drawer.drawerapi.core.domain.Service;
import com.dc.drawer.drawerapi.core.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "user")
@Table(name="user")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(
            fetch=FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "user_service",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="service_id")
    )
    private Set<ServiceData> serviceDatas;
    private boolean isAdmin;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant loginAt;

    public static UserData from(User user){
        UserData userData = new UserData(
                user.getId(),
                user.getUuid(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                ServiceData.from(user.getServices()),
                user.isAdmin(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getLoginAt()
        );

        return userData;

    }

    public Set<Service> fromServiceData(){
        return serviceDatas
                .stream()
                .map(ServiceData::fromThis)
                .collect(Collectors.toSet());
    }

    public User fromThis(){
        return new User(
                id,
                uuid,
                firstName,
                lastName,
                email,
                password,
                isAdmin,
                fromServiceData(),
                createdAt,
                updatedAt,
                loginAt
        );
    }

}
