package level2.test38;
import java.util.*;

/* 
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 */
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];       
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                if(prices[i] > prices[j]){
                    answer[i] = j-i;
                    break; 
                }
            }
            if(answer[i] == 0){
               answer[i] = prices.length - (i+1); 
            }          
        }

        return answer;
    }
}