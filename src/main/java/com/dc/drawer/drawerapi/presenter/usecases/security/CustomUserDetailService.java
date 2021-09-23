package com.dc.drawer.drawerapi.presenter.usecases.security;

import com.dc.drawer.drawerapi.core.domain.User;
import com.dc.drawer.drawerapi.core.usecase.user.UserRepository;
import com.dc.drawer.drawerapi.data.db.jpa.entities.UserData;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("%s not found", email)));
        return UserPrincipal.from(UserData.from(user));
    }

    @Transactional
    public UserDetails loadUserById(Long id){
        User user = userRepository
                .findById(id)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("%s not found", id)));
        return UserPrincipal.from(UserData.from(user));
    }

}
