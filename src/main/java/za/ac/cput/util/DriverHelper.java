package za.ac.cput.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Driver Helper
public class DriverHelper {

    private static final Set<String> USED_REGISTRATION_NUMBERS = new HashSet<>();

    public static boolean isRegistrationNumberUsed(String registrationNumber) {
        return USED_REGISTRATION_NUMBERS.contains(registrationNumber);
    }

    public static void addUsedRegistrationNumber(String registrationNumber) {
        USED_REGISTRATION_NUMBERS.add(registrationNumber);
    }

    public static boolean testValidRegistrationNumber(String obj) {
        String REGISTRATION_NUMBER_REGEX = "[A-Z]{2}[A-Z0-9]{1,5}";
        Pattern pattern = Pattern.compile(REGISTRATION_NUMBER_REGEX);

        Matcher matcher = pattern.matcher(obj);
        return matcher.matches();
    }
}