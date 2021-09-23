package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Value
public class SignInRequest {
    @Email
    @NotBlank
    private final String email;

    @NotBlank
    private final String password;
}
