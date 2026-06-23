import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 문제 : 다리를 지나는 트럭
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42583
 *
 * 00. 기초 풀이
 * 다리 길이 : 최대 올라갈 수 있는 트럭 개수
 * 모든 트럭은 1초에 1칸씩 이동 => 1트럭이 다리를 빠져나온다면 시간은 다리 길이만큼 +
 * 다리를 큐로 설정
 */

public class bridgeTruck_01 {
    /** 01. 기본 풀이
     * 1) 큐 다리를 생성한다.
     * 2) 첫 차를 집어넣는다.
     * 3) 이후에 조건을 보면서 차를 올리거나 대기시킨다.
     * 확인하니 당연하게도 오답 -> 시간도 맞지 않고, indexOutOfBound 발생
     * */
    public int solution01(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        int w = weight;
        int on_truck = 0;
        int on_truck_weight = 0;
        int time = 0;

        // 제일 첫 차 입장
        queue.add(truck_weights[0]);
        on_truck++;
        on_truck_weight += truck_weights[0];
        time++;

        int pos = 1;
        for (int i = 1; i < truck_weights.length; i++) {
            if(on_truck_weight + truck_weights[i] < w // 현재 무게가 충분하다면서
                    && on_truck < bridge_length){ // 다리에 올라갈 공간이 있다면
                queue.add(truck_weights[i]);
                queue.add(truck_weights[i]);            // 트럭 추가
                on_truck++;                             // 올라간 트럭 개수 추가
                on_truck_weight += truck_weights[i];    // 현재 부하 추가
                time++;                                 // 시간 추가
            }
        }

        while(!queue.isEmpty() || pos <= truck_weights.length) { // 큐가 비지 않았거나, 트럭이 남아있으면
            if (truck_weights[pos] + on_truck_weight < w   // 현재 무게가 충분하면서
                    && on_truck < bridge_length         // 다리에 올라갈 공간이 있다면
            ) {
                queue.add(truck_weights[pos]);            // 트럭 추가
                on_truck++;                             // 올라간 트럭 개수 추가
                on_truck_weight += truck_weights[pos];    // 현재 부하 추가
                time++;                                 // 시간 추가
                pos++;                                    // 다음 차 대기
            } else if (pos == truck_weights.length - 1) {
                on_truck--;                             //
                on_truck_weight -= queue.poll();        // 차를 빼내면서 무게를 빼기
                time += bridge_length;                  // 완전히 빼낼때까지 대기
                break;
            } else { // 만약 올라가는게 불가능하다면
                on_truck--;                             //
                on_truck_weight -= queue.poll();        // 차를 빼내면서 무게를 빼기
                time += bridge_length;                  // 완전히 빼낼때까지 대기
            }
        }
        return time;
    }

    /** 02. 수정 풀이
     * 도저히 로직 구상을 할 수 없어 강사님께서 작성하신 예시 코드로 로직을 확인
     * 시간을 많이 소모할 것이라고 생각했던 큐 고정 로직 사용
     * 로직만 확인 후 코드는 작성 진행
     * 로직 구현 시 시간 복잡도는 섣불리 계산하지 않는 것으로
     * */
    public int solution02(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;

        Queue<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int on_truck_weight = 0; // 다리 위 트럭 무게 총합
        int time = 0; // 소요 시간
        int i = 0; // 대기 중 트럭 순서

        while(i < truck_weights.length){
            time++; // 시간 늘려
            int out = bridge.poll();
            if(out != 0){// 맨 앞에 있는 것을 끄집어 냈는데 트럭이였다면
                on_truck_weight -= out; // 무게 빼
            }

            if(on_truck_weight + truck_weights[i] <= weight){ // 만약 현재 무게 총합이 견디는 무게보다 작다면
                bridge.add(truck_weights[i]); // 다리 위에 올려
                on_truck_weight += truck_weights[i]; // 무게 늘려
                i++; // 다음 순서 대기해
            }
            else{ // 무게가 감당 안된다면
                bridge.add(0); // 1칸 이동
            }
            System.out.println(bridge + ", time : " + time);
        }
        time += bridge_length; // 막차 통과 시간 추가
        answer = time;

        return answer;
    }

    public static void main(String[] args){
        bridgeTruck_01 sol = new bridgeTruck_01();
        int[] truck_weights = {7, 4, 5, 6};
        int[] truck_weights2 = {10};
        int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(sol.solution02(2, 10, truck_weights));
        System.out.println(sol.solution02(100, 100, truck_weights2));
        System.out.println(sol.solution02(100, 100, truck_weights3));

    }
}
