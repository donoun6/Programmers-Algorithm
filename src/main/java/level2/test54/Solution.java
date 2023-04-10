package level2.test54;
import java.util.*;

/* 
문제 설명
자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.

x에 n을 더합니다
x에 2를 곱합니다.
x에 3을 곱합니다.
자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
 */

class Solution {
    final int max = Integer.MAX_VALUE;
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y+1];
        
        for(int i = x + 1; i <= y; i++){
            int a = i - n >= x ? dp[i - n] : max;
            int b = i / 2 > 0 && i % 2 == 0 && i / 2 >= x ? dp[i / 2] : max;
            int c = i / 3 > 0 && i % 3 == 0 && i / 3 >= x ? dp[i / 3] : max;
            
            int min = Math.min(a,Math.min(b,c));
            dp[i] = min < max ? min + 1 : max;
            
        }
        
        return dp[y] < max ? dp[y] : -1;
    }

}