package com.special.covid_server.domain.core.ecveptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){super(message);
    }
}
