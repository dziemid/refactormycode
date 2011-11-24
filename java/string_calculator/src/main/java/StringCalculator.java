public class StringCalculator {

    public static final String STANDARD_SEPARATOR = ",";

    public int add(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (hasCustomSeparator(s)) {
            String separatedNumbers = s.substring(4);
            char customSeparator = s.charAt(2);

            int returnValue = 0;
            for (String n : separatedNumbers.split("[\n" + customSeparator + "]")) {
                returnValue += Integer.parseInt(n);
            }
            return returnValue;
        } else {
            return add(s, STANDARD_SEPARATOR);
        }
    }

    private int add(String separatedNumbers, String separator) {
        int result = 0;
        for (String n : separatedNumbers.split("[\n"+ separator +"]")) {
            result += Integer.parseInt(n);
        }
        return result;
    }

    private boolean hasCustomSeparator(String s) {
        return s.startsWith("//");
    }
}
