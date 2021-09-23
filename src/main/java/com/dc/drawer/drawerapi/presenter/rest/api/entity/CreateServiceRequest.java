package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateServiceRequest {
    @NotBlank
    private String serviceName;
}
