package calculator;

/**
 * 문자열에 포함된 숫자의 합을 계산합니다.
 * <p>
 * 이 클래스는 기본 구분자(쉼표, 콜론)와 사용자 지정(custom) 구분자를
 * 모두 지원하는 문자열 덧셈 기능을 제공합니다.
 */
public class Calculator {

    /**
     * 주어진 문자열을 파싱하여 숫자들의 합을 반환합니다.
     * <p>
     * 먼저 입력 문자열이 사전에 정의된 유효한 형식인지 검사하며, 유효하지 않을 경우 예외를 발생시킵니다.
     *
     * @param inputText 계산할 숫자들을 포함하는 문자열
     * @return 문자열에 포함된 숫자들의 총합
     * @throws IllegalArgumentException 입력 문자열이 유효한 형식이 아닐 경우
     */
    public int calculate(String inputText) {
        String numberWithDelimiter;
        // 정규식: (커스텀 구분자 형식) OR (기본 구분자 형식) OR (빈 문자열)
        String requiredFormat = "^(//(.)\\\\n\\d+(\\2\\d+)*)$|^(\\d+([,:]\\d+)*)$|^$";

        boolean isValidFormat = inputText.matches(requiredFormat);
        if(!isValidFormat) {
            throw new IllegalArgumentException("input error");
        }

        if (!inputText.contains("\\n")) {
            numberWithDelimiter = inputText.replace(":", ",");
        } else {
            numberWithDelimiter = getStringWithCustomDelimiter(inputText);
        }

        return sumNumbers(numberWithDelimiter);
    }

    /**
     * 쉼표로 구분된 숫자 문자열의 합계를 계산합니다.
     * <p>
     * 각 숫자는 정수로 변환되며, 변환할 수 없거나 빈 문자열이 아닌 경우 예외가 발생합니다.
     *
     * @param numberWithDelimiter 쉼표로만 구분된 숫자 문자열
     * @return 숫자들의 합
     */
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

    /**
     * 커스텀 구분자를 포함한 문자열에서 숫자 부분만 추출하여 쉼표로 구분된 문자열로 변환합니다.
     *
     * @param inputText 커스텀 구분자를 포함하는 전체 입력 문자열
     * @return 쉼표로 구분되도록 변환된 숫자 문자열
     */
    private String getStringWithCustomDelimiter(String inputText) {
        String[] lines = inputText.split("\\\\n");
        String seperator = lines[0].replace("//", "");
        String numbers = lines[1];

        return numbers.replace(":", ",").replace(seperator, ",");
    }
}
