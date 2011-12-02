require File.expand_path(File.dirname(__FILE__)) + '/../lib/string_calculator'
require 'test/unit'

class StringCalculatorTest < Test::Unit::TestCase

  def setup
    @calculator = StringCalculator.new
  end

  def test_should_treat_empty_string_as_zero
    assert_equal 0, @calculator.add("")
  end

  def test_should_add_single_numbers
    assert_equal 17, @calculator.add("17")
  end

  def test_should_add_comma_separated_numbers
    assert_equal 2356, @calculator.add("2341,15")
  end

  def test_should_treat_new_line_as_separator
    assert_equal 35, @calculator.add("34\n1")
  end

  def test_should_support_custom_separators
    assert_equal 7, @calculator.add("//;\n5;2")
  end

end