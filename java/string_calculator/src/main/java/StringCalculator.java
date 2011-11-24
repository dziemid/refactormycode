public class StringCalculator {
    public int add(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (hasCustomSeparator(s)) {
            int returnValue = 0;
            for (String n : s.substring(4).split("[\n"+ s.charAt(2) +"]")) {
                returnValue += Integer.parseInt(n);
            }
            return returnValue;
        } else {
            int r = 0; // result
            for (String n : s.split("[\n,]")) {
                r += Integer.parseInt(n);
            }
            return r;
        }
    }

    private boolean hasCustomSeparator(String s) {
        return s.startsWith("//");
    }
}
