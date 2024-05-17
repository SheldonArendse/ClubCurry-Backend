package za.ac.cput.util;

public class Helper {
    public static boolean isNullOrEmpty(Object object) {
        return object == null || object.toString().isEmpty();
    }

    public static boolean isNullOrEmpty(String obj){
        return obj == null || obj.isEmpty();
    }
    public static boolean isNull(int obj){
        return obj<=0;
    }
}
