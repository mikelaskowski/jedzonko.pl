package com.java25wro.exceptions;

public class UserDoesntExistException extends RuntimeException {
    protected String message;
    private Long id;
    public UserDoesntExistException(Long id) {
        this.message = "Customer doesn't exist";
        this.id = id;
    }
    public UserDoesntExistException() {
    }
    public UserDoesntExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Long id) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message;
        this.id = id;
    }
    @Override
    public String getMessage() {
        return message;
    }
    public Long getId() {
        return id;
    }
}
