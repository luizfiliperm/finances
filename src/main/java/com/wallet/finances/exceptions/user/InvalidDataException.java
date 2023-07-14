package com.wallet.finances.exceptions.user;

public class InvalidDataException extends RuntimeException {

    public InvalidDataException(String msg){
        super(msg);
    }
    
    public InvalidDataException(String msg, Throwable throwable){
        super(msg, throwable);
    }

    public InvalidDataException(Throwable throwable){
        super(throwable);
    }
}
