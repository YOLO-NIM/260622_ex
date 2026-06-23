/**
 * 문제 : 올바른 괄호
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12909
 *
 * 00. 기초 풀이
 * '('과 ')'은 반드시 한 쌍이 되어야 한다 -> '('를 +1, ')'를 -1로 계산하면 됨
 * 1) 문자열을 하나씩 분리 후 스택에 넣는다.
 * 2) 스택에서 pop하여 '('와 ')'의 개수를 계산한다.
 * 3) 계산이 0 일 경우 true, 아닐 경우 false를 부여한다.
 * */

import java.util.*;

public class correctPart_02 {
    /** 01. 기본 풀이
     * 1) 문자열을 하나씩 분리 후 스택에 넣는다.
     * 2) 스택에서 pop하여 '('와 ')'의 개수를 계산한다.
     * 3) 계산이 0 일 경우 true, 아닐 경우 false를 부여한다.
     * 확인하니 오답 -> why?!
     * */
    boolean solution01(String s){
        boolean answer = true;
        int count = 0;
        String[] str = s.split("");

        ArrayDeque<String> stack = new ArrayDeque<>();
        for(String v : str) {
            stack.push(v);
        }

        while(!stack.isEmpty()) {
            String check = stack.pop();
            if (check.equals("(")) {
                count++;
            } else if (check.equals(")")) {
                count--;
            }
        }

        if(count != 0){
            answer = false;
        }

        return answer;
    }

    /** 02. 기본 풀이
     * 엣지 케이스 : 3번 case ")()("
     * 해당 케이스에서는 '닫히지 않는' 괄호가 발생
     * 그러나 개수로 세면 0이기 때문에, 코드는 올바른 괄호라고 인식 << gpt 헬프!
     * count = 0 유지 중 반대쪽 괄호가 나올 경우 닫히지 않는 괄호가 무조건 발생
     * count > 0 이 되면 코드 바로 종료
     * 정확성 테스트는 전부 통과했지만, 효율성 테스트 1 시간 초과
     * */
    boolean solution02(String s){
        boolean answer = true;
        int count = 0;
        String[] str = s.split("");

        ArrayDeque<String> stack = new ArrayDeque<>();
        for(String v : str) {
            stack.push(v);
        }

        while(!stack.isEmpty()) {
            String check = stack.pop();
            if (check.equals("(")) {
                count++;
            } else if (check.equals(")")) {
                count--;
            }
            if(count > 0){
                answer = false;
                return answer;
            }
        }

        if(count != 0){
            answer = false;
        }

        return answer;
    }

    /** 03. 권장 풀이
     * 5/27에 풀어보았던 문제
     * 스택/큐 문제였으나 스택을 활용하지 않아도 됨
     * 문자열을 받아온 후 charAt() 함수를 사용하여 하나씩 확인
     * 풀이 방법은 위와 같았으나, 엣지 케이스 통과 방법을 GPT에게 확인
     * 정확성 테스트, 효율성 테스트 모두 통과
     * */
    boolean solution03(String s) {
        boolean answer = true;

        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                count += 1;
            }
            else if(c==')'){
                count -= 1;
            }
            if(count < 0){
                answer = false;
                return answer;
            }
        }
        if(count != 0){
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args){
        correctPart_02 sol = new correctPart_02();

        String[] str = {"()()", "(())()", ")()(", "(()("};
        System.out.println("solution01 Result1 :" + sol.solution01(str[0]));
        System.out.println("solution01 Result2 :" + sol.solution01(str[1]));
        System.out.println("solution01 Result3 :" + sol.solution01(str[2]));
        System.out.println("solution01 Result4 :" + sol.solution01(str[3]));
        /** solution1 결과
         * solution01 Result1 :true
         * solution01 Result2 :true
         * solution01 Result3 :true
         * solution01 Result4 :false
         */

        System.out.println("solution02 Result1 :" + sol.solution02(str[0]));
        System.out.println("solution02 Result2 :" + sol.solution02(str[1]));
        System.out.println("solution02 Result3 :" + sol.solution02(str[2]));
        System.out.println("solution02 Result4 :" + sol.solution02(str[3]));
        /** solution2 결과
         * solution02 Result1 :true
         * solution02 Result2 :true
         * solution02 Result3 :false => 정답!
         * solution02 Result4 :false
         */

        System.out.println("solution03 Result1 :" + sol.solution03(str[0]));
        System.out.println("solution03 Result2 :" + sol.solution03(str[1]));
        System.out.println("solution03 Result3 :" + sol.solution03(str[2]));
        System.out.println("solution03 Result4 :" + sol.solution03(str[3]));
        /** solution3 결과
         * solution03 Result1 :true
         * solution03 Result2 :true
         * solution03 Result3 :false
         * solution03 Result4 :false
         */
    }
}
