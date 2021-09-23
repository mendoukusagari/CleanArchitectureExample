package com.dc.drawer.drawerapi.presenter.rest.api.user;

import com.dc.drawer.drawerapi.core.usecase.user.CreateUserUseCase;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.SignUpRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CreateUserInputMapper {
    public static CreateUserUseCase.InputValues map(SignUpRequest signUpRequest){
        return new CreateUserUseCase.InputValues(
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword(),
                signUpRequest.isAdmin()
        );
    }
}
