package mobstacker.utils;

public class IntegerUtil {
    
    public static boolean isInteger(String name) {
        try {
            Integer.parseInt(name);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int parseInt(String name) {
        try {
            return Integer.parseInt(name);
        } catch (NumberFormatException e) {
            return 1;
        }
    }
}
