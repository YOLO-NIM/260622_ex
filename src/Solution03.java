import java.util.*;

public class Solution03 {
    public long solution(int n) {
//        System.out.println("n = " + n);
        // 1 또는 2
        return jump(n);
    }

    public long jump(int n){
        // n = 1 => 1, 1칸 뛰기
        // n = 2 => 2, 1칸 뛰기, 2칸 뛰기
        if (n == 1) return 1;
        if (n == 2) return 2;
        // 3칸째부터는 계산이 복잡함
        // 1 -> (1, 2)
        // 2 -> (1)
        // 1칸 뛴 결과와 2칸 뛴 결과의 조합
        // 남은 칸수가 있으면, 1칸 남았을 때랑 2칸 남았을 때는 고정
        // 3칸부터는 일단 1칸 남았을 때와 2칸 남았을 때까지의 조합
        return ((jump(n - 1) + jump(n - 2))) % 1234567; // 나머지 연산은 어차피 ( ??? ) x + 나머지
    }

    public static void main(String[] args) {
        Solution03 sol = new Solution03();
        System.out.println("=== 멀리 뛰기 디버깅 및 테스트 ===");

        // 테스트 케이스 1
        int n1 = 4;
        long expected1 = 5;
        long result1 = sol.solution(n1);
        System.out.printf("Test Case 1: %s (결과: %d, 기대값: %d)\n",
                (result1 == expected1 ? "PASS" : "FAIL"), result1, expected1);

        // 테스트 케이스 2
        int n2 = 3;
        long expected2 = 3;
        long result2 = sol.solution(n2);
        System.out.printf("Test Case 2: %s (결과: %d, 기대값: %d)\n",
                (result2 == expected2 ? "PASS" : "FAIL"), result2, expected2);
    }
}