package com.java25wro.exceptions;

public class UserDoesntExsistException extends RuntimeException {
    protected String message;
    private Long id;
    public UserDoesntExsistException(Long id) {
        this.message = "Customer doesn't exsist";
        this.id = id;
    }
    public UserDoesntExsistException() {
    }
    public UserDoesntExsistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1, Long id) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
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
