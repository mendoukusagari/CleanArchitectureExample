package com.dc.drawer.drawerapi.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.Instant;
import java.util.*;

@Value
public class User {
    private final Long id;
    private final String uuid;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final boolean isAdmin;
    private final Set<Service> services;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant loginAt;


    public static User newInstance(String firstName, String lastName, String email, String password, boolean isAdmin){
        return new User(
                null,
                UUID.randomUUID().toString().replace("-",""),
                firstName,
                lastName,
                email,
                password,
                isAdmin,
                new HashSet<Service>(),
                Instant.now(),
                Instant.now(),
                null
        );
    }
}
