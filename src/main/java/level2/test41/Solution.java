package level2.test41;
import java.util.*;

/* 
게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.

U: 위쪽으로 한 칸 가기

D: 아래쪽으로 한 칸 가기

R: 오른쪽으로 한 칸 가기

L: 왼쪽으로 한 칸 가기
 */
class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        for(char c : dirs.toCharArray()){
            String start = String.valueOf(x)+String.valueOf(y);           
            switch (c){
                case 'U' : y += y == 5 ? 0 : 1;
                    break;
                case 'D' : y -= y == -5 ? 0 : 1;
                    break;
                case 'R' : x += x == 5 ? 0 : 1;
                    break;
                case 'L' : x -= x == -5 ? 0 : 1;
                    break;    
            }            
            String last = String.valueOf(x)+String.valueOf(y);            
            if(!start.equals(last)){
                set.add(start+last);
                set.add(last+start);
            }            
        }
        
        return set.size()/2;
    }
}