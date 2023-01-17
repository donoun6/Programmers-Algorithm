package level1.test8;
/*
 * 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 
 * 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
 * 자연수는 1이상의 모든 정수이다.
 */
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x; //첫번쨰 배열에 x값을 넣어준다
        for(int i = 1; i < n; i++){ //i는 1부터시작
            answer[i] = answer[i-1]+x; //이전값+x값을 더해서 배열에 넣어준다
        }        
        return answer;
    }
}
