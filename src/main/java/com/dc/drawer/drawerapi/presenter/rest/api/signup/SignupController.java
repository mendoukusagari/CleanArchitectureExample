package com.dc.drawer.drawerapi.presenter.rest.api.signup;

import com.dc.drawer.drawerapi.core.usecase.UseCaseExecutor;
import com.dc.drawer.drawerapi.core.usecase.user.SignupUseCase;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.ApiResponse;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@Component
public class SignupController implements SignupResource {

    private UseCaseExecutor useCaseExecutor;
    private SignupUseCase signupUseCase;
    private SignupInputMapper signupInputMapper;
    private SignupOutputMapper signupOutputMapper;

    public SignupController(UseCaseExecutor useCaseExecutor,
                            SignupUseCase signupUseCase,
                            SignupInputMapper signupInputMapper,
                            SignupOutputMapper signupOutputMapper){
        this.useCaseExecutor = useCaseExecutor;
        this.signupUseCase = signupUseCase;
        this.signupInputMapper = signupInputMapper;
        this.signupOutputMapper = signupOutputMapper;
    }

    @Override
    public CompletableFuture<ResponseEntity<ApiResponse>> signUp(@Valid SignUpRequest signUpRequest, HttpServletRequest httpServletRequest) {
        return useCaseExecutor.execute(
                signupUseCase,
                signupInputMapper.map(signUpRequest),
                (outputValues)->signupOutputMapper.map(outputValues.getUser(),httpServletRequest)
        );
    }
}
