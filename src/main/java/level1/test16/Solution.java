package level1.test16;

import java.util.*;

/*
 * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 */
class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int num : arr){
            if(num%divisor == 0)list.add(num);
        }
        Collections.sort(list);
        if(list.isEmpty())list.add(-1); //list가 비었을때
        return list;
    }
}