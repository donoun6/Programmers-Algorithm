package level2.test44;
import java.util.*;

/* 
사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.

단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    static char[] arr =  {'A','E','I','O','U'};
    static boolean flag;
    static int count;
    public int solution(String word) {        
        for(int i = 0; i < arr.length; i++){
            dfs(String.valueOf(arr[i]),word);
        }          
        
        return count+1;
    }
    
    public void dfs(String s,String word){       
        if(s.equals(word)) flag = true;
        if(flag || s.length() > 5) return;
        for(int i = 0; i < arr.length; i++){
            StringBuilder sb = new StringBuilder(s);
            sb.append(arr[i]);
            dfs(sb.toString(),word);
        }
        
        count++;
    }
    
}