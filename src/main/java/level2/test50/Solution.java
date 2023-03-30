package level2.test50;
import java.util.*;

/* 
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    static Set<Integer> set = new HashSet<>(); 
    
    public int solution(String numbers) {
        int answer = 0;
   
        getNum(numbers.toCharArray(),new boolean[numbers.length()],"");
        
        for(int num : set){
            answer += isPrime(num);
        }

        return answer;
    }
    
    public void getNum(char[] arr, boolean[] check, String num) {
        for(int i = 0; i < arr.length; i++){
            if(!check[i]) {
                num = num + arr[i];
                check[i] = true;
                getNum(arr,check,num);
                num = num.substring(0,num.length()-1);   
                check[i] = false;
            }else {
                set.add(Integer.parseInt(num));
            }
        }
    }
    
    public int isPrime (int num) {
        if(num <= 1) return 0;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) return 0;
        }
        return 1;
    }
    
}