package level1.test7;
/*
 * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 * 정수는 +(양),-(음)기호가 붙은 모든 자연수를 뜻한다 0포함 가지런한수를 의미
 */
class Solution {
    public long solution(long n) {
        long answer = -1;
        /*
         * 주어진 n을 제곱근으로 만든다 이때 소수가 생기면 ceil로 인하여 반올림이 되기떄문에 두수를 비교하여 다르면 소수이다.
         */
        if(Math.sqrt(n)==Math.ceil(Math.sqrt(n))){ //소수점이 있으면 무조건 반올림이 되는 ceil을 통하여 소수인지 아닌지 판별
            long a = Math.round(Math.sqrt(n)+1); 
            answer = a*a;
        }       
        return answer;
    }
}
