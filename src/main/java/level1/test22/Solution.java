package level1.test22;

import java.util.*;

/*
 * 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 
 * 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
 */
class Solution {
    public String solution(int n) {
        String answer = "";
        for(int i = 1; i <= n; i++){
            answer += i%2!=0? "수" : "박";  //홀수면 수 짝수면 박
        }
        return answer;
    }
}