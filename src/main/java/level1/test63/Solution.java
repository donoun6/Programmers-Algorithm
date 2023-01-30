package level1.test63;

import java.util.*;

/*
 * 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다. 
 * 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 */

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String babblingWord : babbling){
            String compare = babblingWord.replace("aya","1").replace("ye","2").replace("woo","3").replace("ma","4"); //해당문자가 포함되면 숫자로 교체
            if(compare.matches("[0-9]+")){ //정규식을 이용하여 숫자일때만 
                answer++; //숫자일때 count up
                for(int i = 0; i < compare.length()-1; i++){ //같은단어가 연속으로 나올경우 체크
                    if(compare.charAt(i) == compare.charAt(i+1)){ //같은 단어(숫자)가 연속으로 있을경우 answer에서 마이너스
                        answer--;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
