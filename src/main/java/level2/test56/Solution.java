package level2.test56;
import java.util.*;

/* 
정수 n이 매개변수로 주어집니다. 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];
        int x = 0; int y = -1;
        int num = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0) {
                    y++;
                }
                if(i % 3 == 1) {
                    x++;
                }
                if(i % 3 == 2) {
                    x--;
                    y--;
                }
                arr[y][x] = num++;   
            }
        }
        
        int count = 0;
        for(int[] i : arr) {
            for(int j : i) {
                if( j == 0) break;
                answer[count] = j;
                count++;
            }
        }
        
        return answer;
    }
}