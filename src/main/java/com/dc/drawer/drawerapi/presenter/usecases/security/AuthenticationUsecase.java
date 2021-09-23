package com.dc.drawer.drawerapi.presenter.usecases.security;

import com.dc.drawer.drawerapi.core.usecase.UseCase;
import lombok.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUsecase extends UseCase<AuthenticationUsecase.InputValues,AuthenticationUsecase.OutputValues> {

    private AuthenticationManager authenticationManager;
    private JwtProvider jwtProvider;
    public AuthenticationUsecase(AuthenticationManager authenticationManager, JwtProvider jwtProvider){
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public OutputValues execute(InputValues input) {
        Authentication authentication = authenticationManager.authenticate(input.getAuthenticationToken());
        return new OutputValues(jwtProvider.generateToken(authentication));
    }

    @Value
    public static class InputValues implements UseCase.InputValues{
        private final UsernamePasswordAuthenticationToken authenticationToken;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues{
        private final String token;
    }
}
