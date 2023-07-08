package com.wallet.finances.exceptions.user;

public class UserException extends RuntimeException{
    
    public UserException(String msg){
        super(msg);
    }
    
    public UserException(String msg, Throwable throwable){
        super(msg, throwable);
    }

    public UserException(Throwable throwable){
        super(throwable);
    }
}
