package level2.test04;
import java.util.*;

/* 
괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어

"()()" 또는 "(())()" 는 올바른 괄호입니다.
")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 */

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Boolean> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') stack.push(true); // '('가 나오면 stack에 아무값이나 준다
            else { // ')' 가 들어올때
                if(stack.isEmpty()) return false; //만약 stack이 비었다면 false 그이유는 ) 가 첫번쨰로오면 완성된 괄호를 만들수 없기 떄문이다.
                stack.pop(); // () 완성된 괄호가 만들어지면 stack 마지막에있던 '(' 삭제 -> Stack의 top에 있는 item을 삭제하고 해당 item을 반환
            }
        }
        
        return !stack.isEmpty()? false : true;      
    }
}