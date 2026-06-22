import java.util.*;

public class Solution06 {
    public int solution(int[] people, int limit) {
        System.out.println("Arrays.toString(people) + " + Arrays.toString(people));
        System.out.println("limit = " + limit);

        // 보트는 2명까지 (1명도 가능)
        // 최대한 많은 사람 -> 2명이 타는 경우를 최대화
        // 가장 무거운 사람 <-> 가장 가벼운 사람 => 태울 수 있다면 가장 덜 남는 조합
        // 탐욕법? -> 투 포인터 -> 정렬 (여러 가지 제약 조건으로 인해서 순서랑 관계만 잘 정의하면 적당히 풀 수 있게)

        Arrays.sort(people); // Arrays.sort -> 원본에 영향을 미친다(사본이 아님)
        System.out.println("Arrays.toString(people) = " + Arrays.toString(people));

        int left = 0; // 가벼운 쪽
        int right = people.length - 1; // 무거운 쪽
        // 범위로 주어지면 이분탐색. 범위가 아니라 각각의 포인터 자체가 의미를 가지면 투 포인터.(mid 차이)

        int boats = 0;
        while(left <= right){ // right-- or left++ => right < left => 탐색 종료
            if(people[right] + people[left] <= limit){ // 두 사람의 무게를 합쳤을 때 한도 이하인가?
                left++; // 남는 무게에 그나마 가장 가벼운 사람을 보냈다.
            }
            right--; // 현재 가장 무거운 사람은 어차피 탑니다.
            boats++; // 보트는 하나는 씁니다.
        }
        int answer = boats;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("=== 구명보트 디버깅 및 테스트 ===");
        Solution06 solution = new Solution06();

        // 테스트 케이스 1
        int[] people1 = {70, 50, 80, 50};
        int limit1 = 100;
        int expected1 = 3;
        int result1 = solution.solution(people1.clone(), limit1);
        System.out.printf("Test Case 1: %s (결과: %d, 기대값: %d)\n",
                (result1 == expected1 ? "PASS" : "FAIL"), result1, expected1);

        // 테스트 케이스 2
        int[] people2 = {70, 80, 50};
        int limit2 = 100;
        int expected2 = 3;
        int result2 = solution.solution(people2.clone(), limit2);
        System.out.printf("Test Case 2: %s (결과: %d, 기대값: %d)\n",
                (result2 == expected2 ? "PASS" : "FAIL"), result2, expected2);
    }
}