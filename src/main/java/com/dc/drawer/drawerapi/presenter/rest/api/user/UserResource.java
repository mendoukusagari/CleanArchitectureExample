package com.dc.drawer.drawerapi.presenter.rest.api.user;

import com.dc.drawer.drawerapi.presenter.rest.api.entity.ApiResponse;
import com.dc.drawer.drawerapi.presenter.rest.api.entity.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/user")
public interface UserResource {

    @PostMapping
    CompletableFuture<ResponseEntity<ApiResponse>> signIn(@Valid @RequestBody SignUpRequest signUpRequest, HttpServletRequest httpServletRequest);
}
