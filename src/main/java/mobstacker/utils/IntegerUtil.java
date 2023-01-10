package mobstacker.utils;

public class IntegerUtil {
    
    public static int parseInt(String name) {
        if (name == null) {
            return 1;
        }
        int length = name.length(),
            result = 0,
            i = 0;

        while (i < length) {
            result += Character.digit(name.charAt(i++),10);
            if (result == -1) {
                return 1;
            }
            result *= 10;
        }
        return result/10;
    }
}
