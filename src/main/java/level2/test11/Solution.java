package level2.test11;
import java.util.*;

/* 
Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.

Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow;

        for(int i = 3; i < size/2; i++){
            int num = size/i;
            if(size%i == 0 && i >= num){
                int center = (i-2) * (num-2);
                if(center == yellow){
                    answer[0] = i;
                    answer[1] = num;
                }
            }
        }
        return answer;
    }
}