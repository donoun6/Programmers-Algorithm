package level1.test3;

class Solution {
	/*
	 * 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
	 */
    public double solution(int[] arr) {
        double answer = 0;
        double max = 0;
        double size = arr.length;
        for(int num : arr){ //forEach사용
            max += num;
        }
        answer = max/size;
        return answer;
    }
}