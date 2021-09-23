package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import com.dc.drawer.drawerapi.core.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserTransactionResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public static UserTransactionResponse from(User user){
        return new UserTransactionResponse(
                user.getUuid(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }
}
