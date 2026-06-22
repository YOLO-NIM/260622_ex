import java.util.*;

public class Solution01 {
    public int solution(String s) {
        System.out.println("s = "  + s);
        System.out.println("");
//        for(String v : s.split("")){
//            System.out.println("v = "+ v);
//        for(char c : s.toCharArray()){ // 위에보다 상대적으로 경량이면서 char -> 연산
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        // 인덱스가 곧 숫자이고, 그 인덱스에 대응하는 원소는 그 숫자의 문자열 표현
//        for (int i = 0; i < s.length(); i++) {
        for (int i = 0; i < numbers.length; i++) { //numbers를 돌면서 0~9까지를 치환
//            char c = s.charAt(i);
//            System.out.println("c = " + c);
            // 문자열.replace(바꾸자하는 문자열, 바꿀 문자열)
            s = s.replace(numbers[i], i + "");
//            System.out.print("");
        }

//        int answer = 0;
        int answer = Integer.parseInt(s); // 문자열을 정수로 바꿔주는...
        return answer;
    }


    public static void main(String[] args) {
        Solution01 sol = new Solution01();

        // [입력값, 기대하는 결과값]
        String[] inputs = {
                "one4seveneight", "23four5six7", "2three45sixseven", "123",
                "zero", "zerozero77", "oneoneoneone", "1", "zerothreefour"
        };

        int[] expected = {
                1478, 234567, 234567, 123,
                0, 77, 1111, 1, 34
        };

        System.out.println("--- 테스트 시작 ---");
        for (int i = 0; i < inputs.length; i++) {
            // int 범위를 넘지 않도록 안전한 테스트셋으로 조정해서 검증하세요.
            if (inputs[i].length() == 50) continue;

            int result = sol.solution(inputs[i]);
            if (result == expected[i]) {
                System.out.println("Pass: " + inputs[i] + " => " + result);
            } else {
                System.out.println("FAIL: " + inputs[i] + " => Expected: " + expected[i] + ", Got: " + result);
            }
        }
    }
}