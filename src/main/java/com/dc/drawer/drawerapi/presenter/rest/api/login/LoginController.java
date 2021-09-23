package com.dc.drawer.drawerapi.presenter.rest.api.login;

import com.dc.drawer.drawerapi.core.usecase.UseCaseExecutor;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.SignInRequest;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.SignInResponse;
import com.dc.drawer.drawerapi.presenter.usecases.security.AuthenticationInputMapper;
import com.dc.drawer.drawerapi.presenter.usecases.security.AuthenticationOutputMapper;
import com.dc.drawer.drawerapi.presenter.usecases.security.AuthenticationUsecase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@Component
public class LoginController implements LoginResource {
    private UseCaseExecutor useCaseExecutor;
    private AuthenticationUsecase authenticationUsecase;
    private AuthenticationInputMapper authenticationInputMapper;
    private AuthenticationOutputMapper authenticationOutputMapper;
    public LoginController(UseCaseExecutor useCaseExecutor,
                           AuthenticationUsecase authenticationUsecase,
                           AuthenticationInputMapper authenticationInputMapper,
                           AuthenticationOutputMapper authenticationOutputMapper){
        this.useCaseExecutor = useCaseExecutor;
        this.authenticationUsecase = authenticationUsecase;
        this.authenticationInputMapper = authenticationInputMapper;
        this.authenticationOutputMapper = authenticationOutputMapper;
    }


    @Override
    public CompletableFuture<ResponseEntity<SignInResponse>> login(@Valid SignInRequest signInRequest, HttpServletRequest httpServletRequest) {
        return useCaseExecutor.execute(
                authenticationUsecase,
                authenticationInputMapper.map(signInRequest),
                (outputValues)->authenticationOutputMapper.map(outputValues.getToken())
        );
    }
}
