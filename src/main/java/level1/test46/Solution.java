package level1.test46;

import java.util.*;

/*
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 * (1은 소수가 아닙니다.)
 */

class Solution {
    public int solution(int n) {
        int answer = 0;
        //에라토스테네스의 법칙: n의 제곱근이하만큼 2부터 반복해서 나누어 떨어지지않으면 소수.
        for(int i = 2; i <= n; i++){
            boolean flag = true;
            for(int j = 2; j <= Math.sqrt(i); j++ ){ //에라토스테네스의 법칙인 N의 제곱근까지만 판별해도 소수인지 드러난다. 예를들어, 소수 31을 판별하는데, 2, 3, 4, 5 까지만 판별해도된다.
                if(i%j == 0)  {//소수가 아니므로 flag를 false로 만들고 break;
        	    flag = false;
                break;
        	  } 
            }  
            // flag가 true면 소수값이므로, 값 추가
            if(flag==true) answer++;
        }
        return answer;
    }
}