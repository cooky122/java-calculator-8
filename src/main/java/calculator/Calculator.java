package calculator;

public class Calculator {
    public int calculate(String inputText) {
        if (!inputText.contains("\\n")) {
            String numberWithDelimiter = inputText.replace(":", ",");

            return sumNumbers(numberWithDelimiter);
        } else {
            return 0;
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
}
