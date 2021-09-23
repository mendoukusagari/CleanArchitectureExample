package com.dc.drawer.drawerapi.core.usecase.user;

import com.dc.drawer.drawerapi.core.domain.User;
import com.dc.drawer.drawerapi.core.domain.exception.EmailAlreadyExistException;
import com.dc.drawer.drawerapi.core.usecase.UseCase;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupUseCase extends UseCase<SignupUseCase.InputValues,SignupUseCase.OutputValues> {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SignupUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        if (userRepository.existByEmail(input.getEmail())){
            throw new EmailAlreadyExistException("Email address is already registered!");
        }
        User user = User.newInstance(
                input.getFirstName(),
                input.getLastName(),
                input.getEmail(),
                passwordEncoder.encode(input.getPassword()),
                input.isAdmin()
        );
        return new SignupUseCase.OutputValues(userRepository.persist(user));
    }
    @Value
    public static class InputValues implements UseCase.InputValues{
        private final String firstName;
        private final String lastName;
        private final String email;
        private final String password;
        private final boolean isAdmin;
    }
    @Value
    public static class OutputValues implements UseCase.OutputValues{
        private final User user;
    }
}
