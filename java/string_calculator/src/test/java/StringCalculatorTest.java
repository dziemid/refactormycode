import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void should_add_single_numbers() throws Exception {
        StringCalculator s = new StringCalculator();
        assertEquals(17, s.add("17"));
    }

    @Test
    public void should_add_comma_separated_numbers() throws Exception {
        StringCalculator s = new StringCalculator();
        assertEquals(2356, s.add("2341,15"));
    }

    @Test
    public void should_treat_new_line_as_separator() throws Exception {
        StringCalculator s = new StringCalculator();
        assertEquals(35, s.add("34\n1"));
    }

    @Test
    public void should_support_custom_separators() throws Exception {
        StringCalculator s = new StringCalculator();
        assertEquals(7, s.add("//;\n5;2"));
    }

    @Test
    public void should_treat_empty_string_as_zero() throws Exception {
        StringCalculator s = new StringCalculator();
        assertEquals(0, s.add(""));
    }
}
