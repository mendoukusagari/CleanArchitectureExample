package com.dc.drawer.drawerapi.presenter.rest.api.login;

import com.dc.drawer.drawerapi.presenter.rest.api.entity.SignInRequest;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.SignInResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/login")
public interface LoginResource {
    @PostMapping
    public CompletableFuture<ResponseEntity<SignInResponse>> login(@Valid @RequestBody SignInRequest signInRequest, HttpServletRequest httpServletRequest);
}
