package com.wallet.finances.services.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wallet.finances.entities.user.User;
import com.wallet.finances.exceptions.password.InvalidPasswordException;


public class PasswordUtil {
    
    private static final int MIN_LENGHT = 8;

    public static Boolean validatePassword(User user){
        if(!hasMinLenght(user.getPassword())){
            throw new InvalidPasswordException("The password must contains at least 8 digits!");
        }

        if(!hasLowerCaseCharacter(user.getPassword())){
            throw new InvalidPasswordException("The password must contains at least 1 lowercase letter!");
        }

        if(!hasUpperCaseCharacter(user.getPassword())){
            throw new InvalidPasswordException("The password must contains at least 1 uppercase letter!");
        }

        if(!hasNumber(user.getPassword())){
            throw new InvalidPasswordException("The password must contains at least 1 number!");
        }

        if(!hasSpecialCharacter(user.getPassword())){
            throw new InvalidPasswordException("The password must contains at least 1 special character!");
        }

        if(hasPersonalInformation(user)){
            throw new InvalidPasswordException("The password must not contain personal information!");
        }

        return true;
    }

    public static String hashPassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }



    private static Boolean hasMinLenght(String password){
        return password.length() >= MIN_LENGHT;
    }

    private static Boolean hasLowerCaseCharacter(String password){
        return password.matches(".*[a-z].*");
    }

    private static Boolean hasUpperCaseCharacter(String password){
        return password.matches(".*[A-Z].*");
    }

    private static Boolean hasSpecialCharacter(String password){
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    private static Boolean hasNumber(String password) {
        return password.matches(".*\\d.*");
    }

    private static Boolean hasPersonalInformation(User user){
        return user.getPassword().toLowerCase().contains(user.getName().toLowerCase());
    }

}
