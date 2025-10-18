package calculator;

public class Calculator {
    public int calculate(String inputText) {
        if (!inputText.contains("\\n")) {
            String numberWithDelimiter = inputText.replace(":", ",");

            return sumNumbers(numberWithDelimiter);
        } else {
            String numberWithDelimiter = getStringWithCustomDelimiter(inputText);

            return sumNumbers(numberWithDelimiter);
        }
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
        if (inputText.indexOf("\\\\n") != inputText.lastIndexOf("\\\\n")) {
            throw new IllegalArgumentException("input error");
        }
        String[] lines = inputText.split("\\\\n");
        String seperator = lines[0].replace("//", "");
        String numbers = lines[1];

        return numbers.replace(":", ",").replace(seperator, ",");
    }
}
