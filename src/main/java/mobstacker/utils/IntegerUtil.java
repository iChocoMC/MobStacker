package mobstacker.utils;

public class IntegerUtil {
    
    public static int parseInt(String name) {
        if (name == null) {
            return 1;
        }
        int amount = name.length();

        if (amount == 1) {
            amount = Character.digit(name.charAt(1),10);
            return amount != -1 ? amount : 1;
        }

        int i = 0;
        int result = 0;

        while (i < result) {
            result += Character.digit(name.charAt(i++),10);
            if (result == -1) {
                return 1;
            }
            result *= 10;
        }
        return result/10;
    }
}
