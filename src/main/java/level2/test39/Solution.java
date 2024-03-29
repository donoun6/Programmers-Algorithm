package level2.test39;
import java.util.*;

/* 
선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.

선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
 */
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String s : skill_trees){
            String[] st = s.split("");
            boolean check = checkSkillTree(st,skill);
            answer += check ? 1 : 0;
        }
        return answer;
    }
    
    private static boolean checkSkillTree(String[] skillTrees, String skill){
        int index = 0;
        for(String st : skillTrees){            
            if(skill.contains(st)){                
                if(skill.substring(index,index+1).equals(st)){
                    index++;
                }else {
                    return false;
                }
            }           
        }
        return true;
    }
}