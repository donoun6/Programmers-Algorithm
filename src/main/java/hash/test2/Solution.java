package hash.test2;

import java.util.*;

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
       for (String key : set.keySet()) { //keySet클래스틑 통해 String에 key값을 담는다.
           Integer value = set.get(key); //get클래스에 key값을 넣어 value값을 담는다.
           if(value != 0){ //value값이 0이 아닌 key값을 출력
               answer = key;
           }
       }      
        return answer;
    }
}