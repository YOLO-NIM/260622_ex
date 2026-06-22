import java.util.*;

public class Solution04 {
    public int solution(int[][] triangle) {
//        System.out.println("Arrays.deepToString(triangle) = " + Arrays.deepToString(triangle));
        // 원본이 변환이 되지 않아야 할 경우에 복제하여 memo를 사용
        // 아닐경우 그냥 바로 triangle 쓰는 것도 방법
        int[][] memo = new int[triangle.length][triangle.length];
//        for (int[] ints : triangle) {
//            System.out.println(Arrays.toString(ints));
//        }
//        for (int[] ints : triangle) {
//            System.out.println(Arrays.toString(ints));
//        }
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                memo[i][j] = triangle[i][j];
            }
        }
//        for (int[] ints : memo) {
//            System.out.println(Arrays.toString(ints));
//        }
        for (int i = 1; i < memo.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    // 맨 왼쪽의 값 -> 바로 위의 값 [i-1][j]만 누적 가능
                    memo[i][j] += memo[i-1][j];
                    continue;
                }
                if (j == i) {
                    // 맨 오른쪽의 값 -> 대각선 왼쪽 위의 값만 누적 가능
                    memo[i][j] += memo[i-1][j-1];
                    continue;
                }
                memo[i][j] += Math.max(memo[i-1][j], memo[i-1][j-1]);
            }
        }
//        int[][] memo = new int[triangle.length][];
//        int[][] memo = new int[2000][2000];
//        System.out.println("Arrays.deepToString(memo) = " + Arrays.deepToString(memo));

        int answer = 0;
        for (int v : memo[memo.length - 1]) {
            answer = Math.max(answer, v);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("=== 정수 삼각형 디버깅 및 테스트 ===");
        Solution04 solution = new Solution04();

        // 테스트 케이스 1
        int[][] triangle1 = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        int expected1 = 30;
        int result1 = solution.solution(triangle1);
        System.out.printf("Test Case 1: %s (결과: %d, 기대값: %d)\n",
                (result1 == expected1 ? "PASS" : "FAIL"), result1, expected1);
    }
}
