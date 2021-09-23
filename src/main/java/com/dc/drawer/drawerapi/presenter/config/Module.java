package com.dc.drawer.drawerapi.presenter.config;

import com.dc.drawer.drawerapi.core.usecase.user.CreateUserUseCase;
import com.dc.drawer.drawerapi.core.usecase.user.SignupUseCase;
import com.dc.drawer.drawerapi.core.usecase.user.UserRepository;
import com.dc.drawer.drawerapi.presenter.usecases.security.AuthenticationUsecase;
import com.dc.drawer.drawerapi.presenter.usecases.security.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class Module {
//    @Bean
//    public CreateUserUseCase createUserUseCase(UserRepository userRepository){
//        return new CreateUserUseCase(userRepository);
//    }
//
//    @Bean
//    public SignupUseCase signupUseCase(UserRepository userRepository){
//        return new SignupUseCase(userRepository);
//    }
//
//    @Bean
//    public AuthenticationUsecase authenticationUsecase(AuthenticationManager authenticationManager, JwtProvider jwtProvider){
//        return new AuthenticationUsecase(authenticationManager,jwtProvider);
//    }
}
