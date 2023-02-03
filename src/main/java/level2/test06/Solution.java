package level2.test06;
import java.util.*;

/* 
Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.

1 + 2 + 3 + 4 + 5 = 15
4 + 5 + 6 = 15
7 + 8 = 15
15 = 15
자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
 */

class Solution {
	/*
	 * 1차방정식 활용 
	 * ex ) 15 = x + (x+1)+(x+2) 
	 * 3x + 3 = 15 
	 *  x = 4 
	 */
    public int solution(int n) { 
        int answer = 1; //자기자신은 무조건 포함이기에 
        int num = 0;
        int x = 0;
        for(int i = 1; i <= n; i++){            
            x = i+1;// x는 순서대로 증가 1 2 3 4 5 ... 
            num += i; // (x+1) (x+2) ...  ex)  1 3 6 10 15 21 ...  
            if(num > n || num == n) break; //num이 같거나 n보다 더 크면 for문 정지
            if((n-num)%x == 0) answer++; // 3x + 3 = 15   -->   3 = 15-3 의 형태로 나타낸다 
            //연속된 숫자가 n이 되는지 알기만 하면 되기떄문에 x의 값을 굳이 안구하고 몫이 0일때 answer을 카운팅한다.
        }

        return answer;
    }
}