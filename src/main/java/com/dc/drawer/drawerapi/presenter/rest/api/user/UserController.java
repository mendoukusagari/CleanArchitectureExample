package com.dc.drawer.drawerapi.presenter.rest.api.user;

import com.dc.drawer.drawerapi.core.domain.exception.EmailAlreadyExistException;
import com.dc.drawer.drawerapi.core.usecase.UseCaseExecutor;
import com.dc.drawer.drawerapi.core.usecase.user.CreateUserUseCase;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.ApiResponse;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.ErrorResponse;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.SignUpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Email;
import java.util.concurrent.CompletableFuture;

@Component
public class UserController implements UserResource{
    private UseCaseExecutor useCaseExecutor;
    private CreateUserUseCase createUserUseCase;
    private CreateUserInputMapper createUserInputMapper;
    private CreateUserOutputMapper createUserOutputMapper;

    public UserController(UseCaseExecutor useCaseExecutor,
                          CreateUserUseCase createUserUseCase,
                          CreateUserInputMapper createUserInputMapper,
                          CreateUserOutputMapper createUserOutputMapper){
        this.useCaseExecutor = useCaseExecutor;
        this.createUserUseCase = createUserUseCase;
        this.createUserInputMapper = createUserInputMapper;
        this.createUserOutputMapper = createUserOutputMapper;
    }

    @Override
    public CompletableFuture<ResponseEntity<ApiResponse>> signIn(@Valid SignUpRequest signUpRequest, HttpServletRequest httpServletRequest) {
        return useCaseExecutor.execute(
                createUserUseCase,
                createUserInputMapper.map(signUpRequest),
                (outputValues)-> createUserOutputMapper.map(outputValues.getUser(), httpServletRequest)

        );
    }


}
