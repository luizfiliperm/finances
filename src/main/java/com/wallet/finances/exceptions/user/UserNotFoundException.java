package com.wallet.finances.exceptions.user;

public class UserNotFoundException extends UserException{

    public UserNotFoundException(String msg){
        super(msg);
    }
    
    public UserNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }

    public UserNotFoundException(Throwable throwable){
        super(throwable);
    }
}
