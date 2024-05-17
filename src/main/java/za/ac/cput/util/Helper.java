package za.ac.cput.util;

public class Helper {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
    public static boolean isNullOrEmpty(Integer integer) {
        return integer == null || integer.toString().isEmpty();
    }
}
