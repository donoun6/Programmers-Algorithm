package level2.test05;
import java.util.*;

/* 
0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.

x의 모든 0을 제거합니다.
x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.

0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(s.length() > 1){
            int delete = s.length(); //0 제거전 문자의 길이
            s = s.replaceAll("0","");
            answer[1] += delete - s.length(); //제거전 문자길이와 제거후 문자길이를 빼주어서 제거된 수를 배열의 0번에 더해준다. (제거된 0개수 더해주기)
            answer[0]++; //반복횟수를 더해준다
            s = Integer.toBinaryString(s.length()); //위 작업이 완료되었으면 0이 제거된 s의 문자열 길이를 이진법형태로 바꾸어준다.
        }
             
        return answer;
    }
}