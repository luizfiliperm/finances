package com.wallet.finances.exceptions.user;

public class UserAlreadyExistsException extends UserException{

      public UserAlreadyExistsException(String msg){
        super(msg);
    }
    
    public UserAlreadyExistsException(String msg, Throwable throwable){
        super(msg, throwable);
    }

    public UserAlreadyExistsException(Throwable throwable){
        super(throwable);
    }
}
