package level1.test53;

import java.util.*;

/*
 * 다트 게임은 총 3번의 기회로 구성된다.
각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
 */

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int[] score = new int[3];       
        int index = -1;
        
        String[] dart = dartResult.split("");     
        for(int i = 0; i < dart.length; i++){               
            if(dart[i].matches("[0-9]")){//정규식을 이용하여 dart[i] 가 숫자인지 확인
                index++; //숫자가 맞다면 index를 -1부터 ++가 되도록
                score[index] = Integer.parseInt(dart[i]); //해당 배열에 점수를 기입
                if(dart[i+1].matches("[0-9]")){ //연속적으로 숫자가 들어간다면
                    score[index] *= 10; // 최대 값이 10이므로 1*10 을 하여 10으로 만든다
                    i++; //다음 i값을 위에서 사용했기 때문에 증감연산자를 통하여 ++해준다
                }
            }
            switch(dart[i]){ //if문과 마찬가지로 조건문이지만 변수가 어떤값을 갖느냐에 따라 실행문이 선택
                case "D" : 
                    score[index] = (int)Math.pow(score[index],2); //Math.pow 는 해당 수를 제곱하는 메드이다. 
                    break;
                case "T" :
                    score[index] = (int)Math.pow(score[index],3);
                    break; 
                case "*" :
                    score[index] *= 2;
                    if(index - 1 >= 0) score[index-1] *= 2; //index 값이 0보다 작으면 안되기 때문에 조건을 걸어준다
                    break;
                case "#" :
                    score[index] *= -1;
                    break;
            }             
        }
        
        for(int s : score) { //forEach를 사용하여 배열에 있는 값을 answer에 각각 더해준다
            answer += s;
        }
         
        return answer;
    }
}