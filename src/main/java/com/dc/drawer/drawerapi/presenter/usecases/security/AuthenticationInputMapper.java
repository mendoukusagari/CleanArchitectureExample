package com.dc.drawer.drawerapi.presenter.usecases.security;


import com.dc.drawer.drawerapi.presenter.rest.api.entity.SignInRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationInputMapper {
    public static AuthenticationUsecase.InputValues map(SignInRequest signInRequest){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                signInRequest.getEmail(),
                signInRequest.getPassword()
        );
        return new AuthenticationUsecase.InputValues(usernamePasswordAuthenticationToken);
    }
}
