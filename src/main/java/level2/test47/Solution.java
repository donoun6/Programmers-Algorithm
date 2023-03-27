package level2.test47;
import java.util.*;

/* 
양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다. x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
정수들이 담긴 배열 numbers가 매개변수로 주어집니다. numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i]%2 == 0) {
                answer[i] = numbers[i]+1;
                continue;
            }
            String code = Long.toBinaryString(numbers[i]);     
            answer[i] = check(code);
        }
        return answer;
    }

    public long check(String code) {
        StringBuilder binary = new StringBuilder(code);
        if (binary.toString().contains("01")) {
            for(int i = binary.length(); i >0 ; i--){
                if(binary.substring(i - 2, i).equals("01")){
                    binary.setCharAt(i - 1, '0');
                    binary.setCharAt(i - 2, '1');
                    break;
                }
            }
        } else {
            binary.insert(1, "0");
        }
        return Long.valueOf(binary.toString(),2);
    }
}