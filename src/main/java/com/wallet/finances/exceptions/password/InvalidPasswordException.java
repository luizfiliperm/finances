package com.wallet.finances.exceptions.password;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String msg){
        super(msg);
    }
    
    public InvalidPasswordException(String msg, Throwable throwable){
        super(msg, throwable);
    }

    public InvalidPasswordException(Throwable throwable){
        super(throwable);
    }
}
