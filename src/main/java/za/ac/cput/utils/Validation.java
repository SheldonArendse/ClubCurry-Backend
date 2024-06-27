package za.ac.cput.utils;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {


    public static boolean isValidString(String obj){
        // validate string input.
        return obj != null && !obj.isEmpty();
    }

    public static boolean isValidPostalCode(int obj){
        // validate postal code by making sure its over 4 digits.
        return obj >= 1000;
    }


    public static boolean isValidStreetNo(String obj){
        // validate that streetNo is not null, not longer than 4 characters and is a valid integer.
        if(obj == null || obj.isEmpty()){
            return false;
        }

        if(obj.length() > 4){
            return false;
        }

        try{
            int i = Integer.parseInt(obj);
        }catch (NumberFormatException ex){
            System.out.println("Input Error: " + ex.getLocalizedMessage());
            return false;
        }

        return true;
    }

    public static boolean isValidEmail(String obj){
        // validates email
        EmailValidator emailValidator = EmailValidator.getInstance();
        return obj !=null && emailValidator.isValid(obj);
    }

    public static boolean isValidMobileNo(String obj){
        // validate mobile no
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(obj);
        return matcher.matches();
    }

    public static boolean isValidPassword(String obj){
        // validate password
        String regx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(obj);
        return matcher.matches();
    }
}
