package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("enter a string:");

        // 문자열 입력
        String inputText = Console.readLine();

        try {
            // 2. 핵심 로직은 StringCalculator 객체에 위임한다.
            Calculator calculator = new Calculator();
            int result = calculator.calculate(inputText); // add가 아닌 calculate로 이름 변경

            // 결과 출력
            System.out.println("result: " + result);

        } catch (Exception e) {
            // 5. 예외를 처리한다.
            e.printStackTrace();
        }
    }
}
