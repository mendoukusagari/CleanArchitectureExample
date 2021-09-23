package com.dc.drawer.drawerapi.presenter.rest.api.signup;

import com.dc.drawer.drawerapi.presenter.rest.api.entity.ApiResponse;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/signup")
public interface SignupResource {
    @PostMapping
    CompletableFuture<ResponseEntity<ApiResponse>> signUp(@Valid @RequestBody SignUpRequest signUpRequest, HttpServletRequest httpServletRequest);
}
