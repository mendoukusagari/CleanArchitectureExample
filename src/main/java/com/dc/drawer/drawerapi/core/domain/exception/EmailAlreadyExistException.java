package com.dc.drawer.drawerapi.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmailAlreadyExistException extends DomainException{
    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
