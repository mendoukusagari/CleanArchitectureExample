package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import lombok.Value;

@Value
public class ApiResponse {
    private final Boolean success;
    private final String message;
}
