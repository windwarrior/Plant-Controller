package nl.utwente.plantcontroller.util;

import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {
    static final String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String generatePass(){
        SecureRandom rand = new SecureRandom();
        String pass = "";
        int lenght = Math.abs(rand.nextInt()) % 10 + 6; //minimaal 6 maximaal 16 chars genereren :)
        for(int i = 0; i< lenght; i++){
            pass += allowedChars.charAt(Math.abs(rand.nextInt()) % allowedChars.length());
        }
        
        return pass;
        
    }
    

}
