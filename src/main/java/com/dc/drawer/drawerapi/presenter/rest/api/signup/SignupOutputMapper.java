package com.dc.drawer.drawerapi.presenter.rest.api.signup;

import com.dc.drawer.drawerapi.core.domain.User;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@Service
public class SignupOutputMapper {
    public static ResponseEntity<ApiResponse> map(User user, HttpServletRequest httpServletRequest){
        URI uri = ServletUriComponentsBuilder
                .fromContextPath(httpServletRequest)
                .path("/user/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new ApiResponse(true, "Register is success"));
    }
}
