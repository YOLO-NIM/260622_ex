import java.util.*;

public class Solution03_1 {
    public long solution(int n) {
//        System.out.println("n = " + n);
        // 1칸 또는 2칸 -> n만큼 도달
        // sp
        int[] memo = new int[2001]; //0이 없음
        // 연산을 줄이기 위해 dp에서는 메모한다.
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i -1] + memo[i - 2]) % 1234567; // 점화식
        }

        return memo[n];
    }

    public static void main(String[] args) {
        Solution03_1 sol = new Solution03_1();
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