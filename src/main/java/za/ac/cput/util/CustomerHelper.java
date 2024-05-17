package za.ac.cput.util;

/*
Customer.Java
Customer Helper Class
Author: Aa'ishah Van Witt
Date:  17 May 2024
 */

import org.apache.commons.validator.routines.EmailValidator;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.PaymentMethod;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerHelper {
    public static boolean testLong(Long obj) {

        return obj != null;
    }

    public static boolean testString(String obj) {
        return obj != null && !obj.isEmpty();
    }

    public static boolean testListAddress(List<Address> obj) {
        return obj != null && !obj.isEmpty();
    }

    public static boolean testListPayMethod(List<PaymentMethod> obj) {
        return obj != null && !obj.isEmpty();
    }

    public static boolean testEmail(String obj) {
        return EmailValidator.getInstance().isValid(obj);
    }

    public static boolean testValidMobile(String obj) {
        String regexPattern = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(obj);
        return matcher.matches();
    }
}
