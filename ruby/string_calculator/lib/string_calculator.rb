# This is code kata 'string calculator'. Kata can be found at: http://osherove.com/tdd-kata-1/
#
# This code is crappy by intention. Your task is to reformat it (including docs & code
# best practices). You have unit test describing behaviour of this class.
class StringCalculator

  def add(values)
    if values.empty?
      return 0
    end

    if values =~ /^\/\//
      result = 0
      values[4..values.size].split(/[\n#{values[2]}]/).each do |value|
        result += value.to_i
      end
      return result
    else
      result = 0
      values.split(/[,\n]/).each do |value|
        result += value.to_i
      end
      return result
    end
  end
end