package level1.test58;

import java.util.*;

/*수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 */

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> set = new HashMap<>();
        for(int i = 0; i < participant.length;i++){
            if(!set.containsKey(participant[i])){
                set.put(participant[i],1);
            }else {
                set.put(participant[i],set.get(participant[i])+1);
            }
        }       
       
        for(int i = 0; i < completion.length; i++){            
            if(set.containsKey(completion[i])){
                 set.put(completion[i],set.get(completion[i])-1);
            }
        }    
       for (String key : set.keySet()) {
           Integer value = set.get(key);
           if(value != 0){
               answer = key;
           }
       }      
        return answer;
    }
}