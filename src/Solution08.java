import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class Solution08 {
    public int[] solution(int[] arr) {
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        // Stack은 Stack<Integer>로 해도 되긴하는데...
        ArrayDeque<Integer> stack = new ArrayDeque<>(); // 통일성?

        for(int v : arr){
            if(stack.isEmpty() // stack에 아무 값이 없을 때
                    || stack.peek() != v // stack에 마지막 값이 v와 다를 때
                    // 같은 숫자는 싫다 => 직전 숫자만 달라지면 된다
                    // 직전 숫자 -> 가장 나중에 들어간 숫자 -> LIFO
            ){
                // 이 경우에만 값을 넣어주면 된다.
                stack.push(v);
            }

            // 직전의 숫자가 뭔지 알 수 있음
//            stack.pop(); // 뽑을 때
//            stack.peek(); // 확인할 때 (ArrayDeque 사용 시)
        }
        System.out.println("stack = " + stack);
        int[] answer = new int[stack.size()];
        while(!stack.isEmpty()){
            answer[stack.size() - 1] =stack.pop();
            // 끝에서 나온 걸 맨 끝에 하나씩 빼놓고
            // 하나씩 빠지만 전체 길이가 줄어들기 때문에 거기에 맞춰서 인덱스가 이동하게 됨.
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution08 solution = new Solution08();
        System.out.println("=== 같은 숫자는 싫어 디버깅 및 테스트 ===");

        // 테스트 케이스 1
        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] expected1 = {1, 3, 0, 1};
        int[] result1 = solution.solution(arr1);
        System.out.printf("Test Case 1: %s (결과: %s, 기대값: %s)\n",
                (Arrays.equals(result1, expected1) ? "PASS" : "FAIL"),
                Arrays.toString(result1), Arrays.toString(expected1));

        // 테스트 케이스 2
        int[] arr2 = {4, 4, 4, 3, 3};
        int[] expected2 = {4, 3};
        int[] result2 = solution.solution(arr2);
        System.out.printf("Test Case 2: %s (결과: %s, 기대값: %s)\n",
                (Arrays.equals(result2, expected2) ? "PASS" : "FAIL"),
                Arrays.toString(result2), Arrays.toString(expected2));
    }
}