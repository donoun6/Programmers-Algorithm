package level1.test57;

import java.util.*;

/*"명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고, 시청자들의 문자 투표수로 가수에게 점수를 부여합니다. 
 * 매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념합니다.
 *  즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다. 
 *  k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면, 출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.
 *  이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다. 
 *  예를 들어, k = 3이고, 7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]이라면, 명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다.
 */

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); //우선순위 큐 들어온 순서대로 데이터가 나가는 것이 아닌 우선순위를 먼저 결정하고 그 우선순위가 높은 데이터가 먼저 나가는 자료구조이다.
        //높은 숫자가 우선 순위인 int 형 우선순위 큐 선언
        //PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());


        for(int i = 0; i < score.length; i++) {

            priorityQueue.add(score[i]); //값을 추가 낮은 수가 첫번재 값이 된다
            if (priorityQueue.size() > k) { //크기가 k 를 넘으면
                priorityQueue.poll(); // 첫번째 값을 반환하고 제거
            }

            answer[i] = priorityQueue.peek();// 첫번째 값을 반환만 하고 제거 하지는 않는다.
        }
        


        return answer;
    }
}

class Solution2 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < score.length; i++){
            if(i < k) {
                list.add(score[i]);
                Collections.sort(list, Collections.reverseOrder());
                answer[i] = list.get(i);
            }else {
                list.add(score[i]);
                Collections.sort(list, Collections.reverseOrder());
                answer[i] = list.get(k-1);
            }
        }

        return answer;
    }
}