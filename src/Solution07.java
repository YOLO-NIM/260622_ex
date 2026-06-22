import java.util.*;

public class Solution07 {
    public int[] solution(int[] progresses, int[] speeds) {
//        System.out.println("Arrays.toString(progresses) = " + Arrays.toString(progresses));
//        System.out.println("Arrays.toString(speeds) = " + Arrays.toString(speeds));
        Queue<Integer> queue = new ArrayDeque<>(); // 덱 -> 양방향 큐 -> 상황에 따라서 스택처럼도 쓸 수 있는 큐
        for (int i = 0; i < progresses.length; i++) {
            // for문을 사용해서 길이 같은 배열을 같은 인덱스로 일괄 조회
            int remain = 100 - progresses[i]; // 남은 진척도 -> 속도로 나누면 필요한 일자
            int days = remain / speeds[i]; // 소수점/나머지가 있음
            if (remain % speeds[i] != 0) {
                days++; // 나머지가 있을 경우 +1. // 삼항연산자를 해도 괜찮음
            }
            queue.add(days);
        }
//        System.out.println("queue = " + queue);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) { // 안 비었다면...
            int first = queue.poll();
            int count = 1;

            while (!queue.isEmpty() // 배포될 게 남았고
                    // peek <- 제거하지 않고 첫 값(가장 오래된 값)을 보기
                    && queue.peek() <= first // 새로운 기능이 기존에 묶음에 있는 잔여 일보다 작으면
                // peek 가장 오래된값 보기, poll 가장 오래된 값 보고 제거하기
            ) {
                queue.poll(); // 큐에서 제거하되 그 값을 쓰지 않고
                count++;
            }
            // 한 배포일에 묶인 기능 개수
            list.add(count);
        }

//        int[] answer = {};
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("=== 기능개발 디버깅 및 테스트 ===");
        Solution07 solution = new Solution07();

        // 테스트 케이스 1
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] expected1 = {2, 1};
        int[] result1 = solution.solution(progresses1, speeds1);
        System.out.printf("Test Case 1: %s (결과: %s, 기대값: %s)\n",
                (Arrays.equals(result1, expected1) ? "PASS" : "FAIL"),
                Arrays.toString(result1), Arrays.toString(expected1));

        // 테스트 케이스 2
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        int[] expected2 = {1, 3, 2};
        int[] result2 = solution.solution(progresses2, speeds2);
        System.out.printf("Test Case 2: %s (결과: %s, 기대값: %s)\n",
                (Arrays.equals(result2, expected2) ? "PASS" : "FAIL"),
                Arrays.toString(result2), Arrays.toString(expected2));
    }
}