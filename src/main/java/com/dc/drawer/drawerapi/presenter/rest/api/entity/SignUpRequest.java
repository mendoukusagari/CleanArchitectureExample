package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import com.dc.drawer.drawerapi.core.usecase.user.CreateUserUseCase;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
public class SignUpRequest {
    @NotBlank
    @Email
    private final String email;

    @NotBlank
    @Size(min = 2, max=50)
    private final String firstName;

    @NotBlank
    @Size(min=2, max = 50)
    private final String lastName;

    @NotBlank
    @Size(min=6, max=50)
    private final String password;

    private final boolean isAdmin;

    public static CreateUserUseCase.InputValues from(SignUpRequest signUpRequest){
        return new CreateUserUseCase.InputValues(
                signUpRequest.firstName,
                signUpRequest.lastName,
                signUpRequest.email,
                signUpRequest.password,
                signUpRequest.isAdmin
        );
    }
}
