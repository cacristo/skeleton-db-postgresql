package com.docker.postgresql.service.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnknownUserException extends Exception {
    private static final long serialVersionUID = -4178607679972246037L;

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UnknownUserException(long id) {
        super();
        this.id = id;
    }
}

