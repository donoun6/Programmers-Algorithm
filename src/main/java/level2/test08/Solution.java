package level2.test08;
import java.util.*;

/* 
자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.

조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
 */

class Solution {
    public int solution(int n) {
        int answer = 0;
        int compare = n;
        String binary = String.valueOf(Integer.toBinaryString(n).replace("0","")); //1갯수를 비교하기위해 이진법으로 변환후 0을 잘라낸다
        while(true){
            compare++; //n보다 커야하는 수
            String compareBinary = String.valueOf(Integer.toBinaryString(compare).replace("0","")); //비교할 수의 1개수를 확인하기위해
            if(binary.equals(compareBinary)){ //주어진 n과 비교대상인 compare의 이진법변환후 1의 개수가 같을때
                answer = compare;
                break;
            }
        }
        return answer;
    }
}