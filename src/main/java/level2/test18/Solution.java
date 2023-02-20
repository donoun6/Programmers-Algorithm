package level2.test18;
import java.util.*;

/* 
다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.

(), [], {} 는 모두 올바른 괄호 문자열입니다.
만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            int count = 0;
            int index = i;
            
            while(count != s.length()){
                stack.push(s.charAt(index));               
                if(stack.elementAt(0) == '}' || stack.elementAt(0) == ']' || stack.elementAt(0) == ')' ) break;
                if( (stack.peek() == '}' && stack.elementAt(stack.size()-2) == '{') ||
                  (stack.peek() == ']' && stack.elementAt(stack.size()-2) == '[') ||
                  (stack.peek() == ')' && stack.elementAt(stack.size()-2) == '('))  {
                    stack.pop(); stack.pop();
                }
                count++; index++;
                if(index == s.length()) index = 0;
                
            }  
            answer += stack.size() == 0 ? 1 : 0;
            stack.clear();
        }     
        return answer;
    }
}