package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import com.dc.drawer.drawerapi.core.domain.User;
import lombok.Value;

@Value
public class DeveloperResponse {
    private final String id;
    private final String email;
    private final String firstName;
    private final String lastName;

    public static DeveloperResponse from(User user){
        return new DeveloperResponse(
                user.getUuid(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
