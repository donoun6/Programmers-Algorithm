package level1.test59;

import java.util.*;

/*두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다). 
 * X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
 * 예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 
 * 다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
 * 두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
 */

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int[] Xarr = new int[10]; //숫자는 0~9 까지 이므로 배열 길이를 10으로 지정
        int[] Yarr = new int[10];
        
        for(int i = 0; i < X.length(); i++){
            Xarr[X.charAt(i) - 48 ]++;// 해당숫자 index는 1을 추가
        }
        for(int i = 0; i < Y.length(); i++){
            Yarr[Y.charAt(i) - 48 ]++;
        }
        
        for(int i = 9; i >= 0; i--){//가장 큰수가 나와야하기 떄문에 내림차순으로
            for(int j = 0; j < Math.min(Xarr[i],Yarr[i]); j++){ //x,y 둘중 하나라도 0이면 min함수를 통해 0이 나온다 x가 3 y가 2라면 해당 반복문은 2번만 반복한다.
                sb.append(i); //가변클래스를 이용하여 속도를 높인다
            } 
        }
        
        if(sb.toString().equals("")) return "-1"; //빈값이면 -1을 반환
        else if(sb.toString().charAt(0)==48) return "0"; //첫번쨰 시작단어가 0으로 시작하면 0을 반환
        else return sb.toString(); //이외에는 입력값을 반환
    }
}