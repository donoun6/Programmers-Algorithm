package level1.test5;

import java.util.*;
class Solution {
	/*
	 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
	 * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
	 */
    public int[] solution(long n) {
        String[] arr = String.valueOf(n).split(""); //값을 자른후 배열로 저장
        int[] answer = new int[arr.length];
        int index = arr.length-1;
        
        for(int i = 0; i < arr.length; i++){
            answer[i] = Integer.parseInt(arr[index]); //배열에 값이 반대로 들어가게 arr.length를 이용
            index--;
        }
        
        return answer;
    }
}