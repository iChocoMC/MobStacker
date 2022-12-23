package mobstacker.utils;

public class IntegerUtil {
    
    public static int parseInt(String name) {
        try {
            return Integer.parseInt(name);
        } catch (NumberFormatException e) {
            return 1;
        }
    }
}
