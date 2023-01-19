package level1.test33;

import java.util.*;

/*
 * 자연수 n이 매개변수로 주어집니다. 
 * n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 * 3진법 1 3 9 27 81 124 ... 3의 배수대로 올라가는 형태를 보인다
 * 
 * 삼진법을 10진수로 나타내는법
 * 만약 0  1  2  0 이면 삼진법으로
 *    27 9  3  1  의 시작점을 가지게되고  
 *    0  9  6  0  형태로 아래위를 곱해주고 더해주면 15가 나온다
 *    
 * 10진법을 3진수로 나타내는법
 * 15를 3의 배수로 뺐을때 음수가 안되는 최대수를 구한다. ex) 15 - 27 = 음수   15 - 9 = 양수
 * 9는 3의 3승이기 때문에 
 *  1 0 0 의 형태로 일단 나타낸다 이후 15에서 9를 뺸후 똑같은 작업을 반복한다 
 *  이때 3의 배수 * 2 의 수로 값을 밸수있다면 2로 표기 ex) 6 - 3 = 3  -> 6 - 3*2 = 0
 *  1 2 0 의 형태로 출력 값은 0이 됐으므로 끝 
 * 
 * // 10진법 -> 3진법
        while(n != 0) {
            list.add(n%3);
            n /= 3;
        } 
     더쉬운방법 3으로 나누었을때 몫을 list에 추가
 */

class Solution {
    public int solution(int n) {
        int answer = 0; 
        String code = "";              
        int three = 3;
        while(n-three >= 0){ three *= 3; }
        
        three /= 3; //삼진법 자릿수 시작점
        int num = n;
        while(three != 0){ //삼진법형태로 만들기
            if(num >= three*2){
                num -= three*2;
                code += "2";
            }else if(num >= three) {
                num -= three;
                code += "1";
            }else code += "0";
            three /= 3;
        }
        
        three = 1;
        String[] splCode = code.split("");
        for(int i = 0; i < splCode.length; i++){
            answer += Integer.parseInt(splCode[i])*three; //0,1,2 에 *자릿수(3의배수)를 해준다
            three *= 3;
        }
        return answer;
    }
}
