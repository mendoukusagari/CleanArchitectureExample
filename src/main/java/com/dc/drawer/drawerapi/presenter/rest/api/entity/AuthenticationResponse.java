package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import lombok.Value;

@Value
public class AuthenticationResponse {
    private boolean success = true;
    private String token;
}
