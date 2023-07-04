package com.wallet.finances.services.util;

import com.wallet.finances.entities.User;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordUtil {
    
    private static final int MIN_LENGHT = 8;

    public static Boolean validatePassword(User user){
        if(!hasMinLenght(user.getPassword())){
            return false;
        }

        if(!hasLowerCaseCharacter(user.getPassword())){
            return false;
        }

        if(!hasUpperCaseCharacter(user.getPassword())){
            return false;
        }

        if(!hasSpecialCharacter(user.getPassword())){
            return false;
        }

        if(hasPersonalInformation(user)){
            return false;
        }

        return true;
    }

    public static String hashPassword(String password){
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    // public static Boolean comparePassword(String password, String comparePassword);


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

    private static Boolean hasPersonalInformation(User user){
        return user.getPassword().toLowerCase().contains(user.getName().toLowerCase());
    }

}
