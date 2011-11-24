public class StringCalculator {

    public static final char STANDARD_SEPARATOR = ',';

    public int add(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (hasCustomSeparator(s)) {
            String separatedNumbers = s.substring(4);
            char customSeparator = s.charAt(2);
            return add(separatedNumbers, customSeparator);
        } else {
            return add(s, STANDARD_SEPARATOR);
        }
    }

    private int add(String separatedNumbers, char separator) {
        int result = 0;
        for (String n : separatedNumbers.split("[\n" + separator + "]")) {
            result += Integer.parseInt(n);
        }
        return result;
    }

    private boolean hasCustomSeparator(String s) {
        return s.startsWith("//");
    }
}
