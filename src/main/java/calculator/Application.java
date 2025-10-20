package calculator;

import camp.nextstep.edu.missionutils.Console;

/**
 * 문자열 덧셈 계산기 애플리케이션의 메인 진입점 클래스.
 * <p>
 * 이 클래스는 사용자로부터 문자열 입력을 받아
 * {@link Calculator}에 계산을 위임하고 결과를 출력합니다.
 */
public class Application {

    /**
     * 애플리케이션을 실행하여 사용자 입력을 받고 계산 결과를 출력합니다.
     *
     * @param args 프로그램 실행 시 전달되는 인자 (현재 사용되지 않음)
     */
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 문자열 입력
        String inputText = Console.readLine();

        try {
            Calculator calculator = new Calculator();   //계산 메소드 호출
            int result = calculator.calculate(inputText);

            // 결과 출력
            System.out.println("결과 : " + result);

        } catch (Exception e) {
            System.out.println("에러 발생");
        }
    }
}
