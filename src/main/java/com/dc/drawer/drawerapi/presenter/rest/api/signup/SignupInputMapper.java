package com.dc.drawer.drawerapi.presenter.rest.api.signup;

import com.dc.drawer.drawerapi.core.usecase.user.CreateUserUseCase;
import com.dc.drawer.drawerapi.core.usecase.user.SignupUseCase;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public class SignupInputMapper {
    public static SignupUseCase.InputValues map(SignUpRequest signUpRequest){
        return new SignupUseCase.InputValues(
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword(),
                signUpRequest.isAdmin()
        );
    }
}
