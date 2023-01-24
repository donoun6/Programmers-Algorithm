package level1.test47;

import java.util.*;

/*
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */

class Solution {
    public int[] solution(int[] answers) {
        
        int[] a = { 1, 2, 3, 4, 5};
        int[] b = { 2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == a[i%5]) count[0]++; //0~4 까지 만약 5가 넘으면 5를 나눈 나머지값으로 반복 ex)i = 7 / 7%5 = 2
            if(answers[i] == b[i%8]) count[1]++;
            if(answers[i] == c[i%10]) count[2]++;
        }
        List<Integer> list = new ArrayList<>();
        int max = Math.max(count[0],Math.max(count[1],count[2])); //count[1],count[2] 를 비교해서 큰값과 count[0] 을 비교해서 큰값을 max변수에 담는다.
        if(max == count[0]) list.add(1); //큰값이 해당 배열의 수와 같으면 list에 추가
        if(max == count[1]) list.add(2);
        if(max == count[2]) list.add(3);
            
        int[] answer = new int[list.size()]; //배열을 리스트 사이즈에 맞게 생성
        for(int i = 0; i < list.size(); i++){ //리스트에 있는 값을 추가
            answer[i] = list.get(i);
        }
        return answer;
    }
}