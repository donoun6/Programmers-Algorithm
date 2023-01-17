package level1.test;

class Solution {
	/*
	 * 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
	 */
    public String solution(int num) {
    	String answer = "Odd";
        if(num%2 == 0){ //값을 2로 나누었을때 나머지가 0인것은 짝수
            answer = "Even";
        }
        return answer;
    }
}
