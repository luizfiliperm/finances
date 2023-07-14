package com.wallet.finances.exceptions.user;

public class UserAuthenticationException extends UserException{

    public UserAuthenticationException(String msg){
        super(msg);
    }
    
    public UserAuthenticationException(String msg, Throwable throwable){
        super(msg, throwable);
    }

    public UserAuthenticationException(Throwable throwable){
        super(throwable);
    }
    
}
