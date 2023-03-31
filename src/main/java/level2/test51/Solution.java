package level2.test51;
import java.util.*;

/* 
정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.
 */

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        
        Stack<Integer> st = new Stack<>();
        st.add(numbers[0]);
               
        for(int i = 1; i < numbers.length; i++){
            int index = i-1;            
            while(st.peek() < numbers[i]) {
                st.pop();
                while(answer[index] != -1) {
                    index--;
                }
                answer[index] = numbers[i];
                index--;
                if(st.isEmpty()) {
                    break;
                }
            }
            st.add(numbers[i]);
        } 
        
        return answer;
    }   
}