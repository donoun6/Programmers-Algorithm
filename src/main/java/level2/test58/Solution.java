package level2.test58;
import java.util.*;

/* 
124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

124 나라에는 자연수만 존재합니다.
124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
 */

class Solution {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        
        while(n > 0) {
            int num = n%3;
            if(num == 0) {
                sb.insert(0,"4");
                n = n/3 - 1;
            }else {
                sb.insert(0,num);
                n /= 3;
            }
        }
        
        return sb.toString();
    }
}