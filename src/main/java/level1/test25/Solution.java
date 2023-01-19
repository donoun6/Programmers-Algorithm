package level1.test25;

import java.util.*;

/*
 * 두 정수 left와 right가 매개변수로 주어집니다. 
 * left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 * 어떤 수를 나누어떨어지게 하는 수를 그 수의 약수라고 합니다.
 * 8을 1, 2, 4, 8,로 나누면 나누어떨어집니다.
 */

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int count = 0;
            for(int j = 1; j <= i; j++){              
                if(i%j == 0) count++;
            } 
            answer += count%2 != 0? i*-1:i;
        }
        return answer;
    }
}