import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StringCalculatorShould {

    @Test
    public void should_treat_empty_string_as_zero() throws Exception {
        StringCalculator s = new StringCalculator();
        assertEquals(0, s.add(""));
    }

    @Test
    public void should_add_single_numbers() throws Exception {
        StringCalculator s = new StringCalculator();
        assertEquals(3, s.add("3"));
    }

    @Test
    public void should_add_comma_separated_numbers() throws Exception {
        StringCalculator s = new StringCalculator();
        assertEquals(3, s.add("1,2"));
    }

    @Test
    public void should_treat_new_line_as_separator() throws Exception {
        StringCalculator s = new StringCalculator();
        assertEquals(9, s.add("4\n5"));
    }

    @Test
    public void should_support_custom_separators() throws Exception {
        StringCalculator s = new StringCalculator();
        assertEquals(7, s.add("//;\n5;2"));
    }

}
