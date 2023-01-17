package level1.test2;

class Solution {
	/*
	 * 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
	 * 약수: 약수 또는 인수는 어떤 수를 나누어떨어지게 하는 수를 말한다. 
	 */
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(n%i == 0){ //0을 제외한 입력값 보다 적은 수를 가지고 입력값을 나누었을때 나머지가 0이 나와야지 약수이다.
                answer += i;
            }
        }
        return answer;
    }
}