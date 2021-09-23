package com.dc.drawer.drawerapi.presenter.rest.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {
    private final Object message;

}