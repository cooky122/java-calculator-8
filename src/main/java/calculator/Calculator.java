package calculator;

import java.util.IllegalFormatException;
import java.util.regex.Pattern;

public class Calculator {
    public int calculate(String inputText) {
        String numberWithDelimiter;
        String requiredFormat = "^(//(.)\\\\n\\d+(\\2\\d+)*)$|^(\\d+([,:]\\d+)*)$|^$";

        boolean isValidFormat = inputText.matches(requiredFormat);
        if(!isValidFormat){
            throw new IllegalArgumentException("input error");
        }

        if (!inputText.contains("\\n")) {
            numberWithDelimiter = inputText.replace(":", ",");
        } else {
            numberWithDelimiter = getStringWithCustomDelimiter(inputText);
        }

        return sumNumbers(numberWithDelimiter);
    }

    private int sumNumbers(String numberWithDelimiter) {
        int sum = 0;

        String[] numbers = numberWithDelimiter.split(",");
        for (String number : numbers) {
            try {
                if (!number.isEmpty()) {
                    sum += Integer.parseInt(number);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("input error");
            }
        }
        return sum;
    }

    private String getStringWithCustomDelimiter(String inputText) {
        String[] lines = inputText.split("\\\\n");
        String seperator = lines[0].replace("//", "");
        String numbers = lines[1];

        return numbers.replace(":", ",").replace(seperator, ",");
    }
}
