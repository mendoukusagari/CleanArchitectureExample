package com.dc.drawer.drawerapi.presenter.usecases.security;

import com.dc.drawer.drawerapi.presenter.rest.api.entity.SignInResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationOutputMapper {
    public static ResponseEntity<SignInResponse> map(String token){
        return ResponseEntity.ok(new SignInResponse(token));
    }
}
