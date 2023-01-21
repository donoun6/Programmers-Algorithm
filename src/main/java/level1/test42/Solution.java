package level1.test42;

import java.util.*;

/*
 * 정수 배열 numbers가 주어집니다. 
 * numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>(); //HashSet은 중복값을 제거하지만 순서는 무작위
        for(int i = 0; i< numbers.length-1; i++ ){
            for(int j = i+1; j< numbers.length; j++ ){
                set.add(numbers[i]+numbers[j]);
            }
        }
        ArrayList<Integer> answer = new ArrayList<>(set); //Hash를 List형태로 바꿔준다
        Collections.sort(answer); //List 정렬
        return answer;
            
    }
}