package com.auth.sample.authentication.exception;

public class UserApplicationException extends Exception{

    private String errorCode;

    public UserApplicationException(String message,String errorCode){
        super(message);
        this.errorCode=errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
