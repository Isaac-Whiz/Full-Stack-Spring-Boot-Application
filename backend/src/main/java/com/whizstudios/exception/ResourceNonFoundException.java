package com.whizstudios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNonFoundException extends RuntimeException {
    public ResourceNonFoundException(String message) {
        super(message);
    }

}
