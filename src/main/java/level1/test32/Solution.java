package level1.test32;

import java.util.*;

/*
 * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
 * 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
 * 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 */

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ",-1); // -1이 없으면 마지막 공백이 다 잘려나간다. Split limit
        for(int i = 0; i < arr.length; i++){            
            for(int j = 0; j < arr[i].length(); j++){
                answer += j%2 == 0? arr[i].substring(j,j+1).toUpperCase():arr[i].substring(j,j+1).toLowerCase(); //단어기준 홀수,짝수 일때 대소문자 구분   
            }
            answer += i<arr.length-1?" ":"";
        }
        return answer;
    }
}

