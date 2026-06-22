import java.util.*;

public class Solution05 {
    public int solution(int n, int[] lost, int[] reserve) {
        System.out.println("n = " + n);
        int[] students = new int[n+2]; // +1 : 1부터 시작해서, +1 : 마지막 조건문을 덜 쓰기 위하여(IndexOutBound)
        System.out.println("Arrays.toString(lost) = " + Arrays.toString(lost));
        for (int i : lost) {
            students[i]--; // -1
        }
        System.out.println("Arrays.toString(reserve) = " + Arrays.toString(reserve));
        for (int i : reserve) {
            students[i]++; // 0, 1, -1
        }
        System.out.println("Arrays.toString(students) = " + Arrays.toString(students));
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            // 앞 뒤 친구에게 빌려오기 -> 여벌은 1벌이라는 조건 -> 굳이 여러 배치 X
            boolean imOk = students[i] >= 0;
            boolean prevOk = students[i - 1] == 1;
            boolean nextOk = students[i + 1] == 1;
            if(imOk || prevOk || nextOk){
                answer++;
            }

            if(!imOk && !prevOk && nextOk){
                students[i + 1]--;
            }
            System.out.println("");
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("=== 체육복 디버깅 및 테스트 ===");

        Solution05 solution = new Solution05();

        // 테스트 케이스 1
        int n1 = 5;
        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};
        int expected1 = 5;
        int result1 = solution.solution(n1, lost1.clone(), reserve1.clone());
        System.out.printf("Test Case 1: %s (결과: %d, 기대값: %d)\n",
                (result1 == expected1 ? "PASS" : "FAIL"), result1, expected1);

        // 테스트 케이스 2
        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};
        int expected2 = 4;
        int result2 = solution.solution(n2, lost2.clone(), reserve2.clone());
        System.out.printf("Test Case 2: %s (결과: %d, 기대값: %d)\n",
                (result2 == expected2 ? "PASS" : "FAIL"), result2, expected2);

        // 테스트 케이스 3
        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};
        int expected3 = 2;
        int result3 = solution.solution(n3, lost3.clone(), reserve3.clone());
        System.out.printf("Test Case 3: %s (결과: %d, 기대값: %d)\n",
                (result3 == expected3 ? "PASS" : "FAIL"), result3, expected3);
    }
}
