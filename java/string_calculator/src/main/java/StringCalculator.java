public class StringCalculator {
    public int add(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (hasCustomSeparator(s)) {
            int returnValue = 0;
            char customSeparator = s.charAt(2);
            for (String n : s.substring(4).split("[\n"+ customSeparator +"]")) {
                returnValue += Integer.parseInt(n);
            }
            return returnValue;
        } else {
            String standardSeparator = ",";
            int r = 0; // result
            for (String n : s.split("[\n"+ standardSeparator +"]")) {
                r += Integer.parseInt(n);
            }
            return r;
        }
    }

    private boolean hasCustomSeparator(String s) {
        return s.startsWith("//");
    }
}
