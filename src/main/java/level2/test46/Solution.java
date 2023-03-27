package level2.test46;
import java.util.*;

/* 
가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다. 이 직사각형 타일을 이용하여 세로의 길이가 2이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다. 타일을 채울 때는 다음과 같이 2가지 방법이 있습니다.
 */

class Solution {
    public int solution(int n) {
        int answer = 0;
        int x = 1;
        int y = 1;
        
        for(int i = 1; i < n; i++ ){
            answer = (x+y) % 1000000007;
            x = y;
            y = answer; 
        }
               
        return answer;
    }
}