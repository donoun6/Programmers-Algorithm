package level2.test43;
import java.util.*;

/* 

입력으로 판의 높이 m, 폭 n과 판의 배치 정보 board가 들어온다.
2 ≦ n, m ≦ 30
board는 길이 n인 문자열 m개의 배열로 주어진다. 블록을 나타내는 문자는 대문자 A에서 Z가 사용된다.
 */

class Solution {
     private static boolean[][] visit;
     private static char[][] arr;
    public int solution(int m, int n, String[] board) {  
        int answer = 0;
        arr = new char[m][n];       
        
        for(int i=0; i<m ; i++){
            arr[i] = board[i].toCharArray();
        }
   
        while(true){
            int count = 0;
            visit = new boolean[m][n];
            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){
                    check(i,j);
                }                
            }
            count = renewal(m,n);
            if(count == 0 ) break;
            answer += count;        
        }        
               
        return answer;
    }
    
    private void check (int y , int x) {
        char target = arr[y][x];
        char right = arr[y][x+1];
        char down = arr[y+1][x];
        char diagonal = arr[y+1][x+1];
        if(target != '0' && target==right && target==down && target==diagonal){
            visit[y][x] = true;
            visit[y][x+1] = true;
            visit[y+1][x] = true;
            visit[y+1][x+1] = true;
        }
    }    
    
    private int renewal (int y , int x) {  
        int count = 0;
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(visit[i][j]){
                    arr[i][j] = '0';
                    count++;
                }
            }            
        }
        
        for(int i = 0; i < x; i++){
            for(int j = y-1; j >= 0; j--){
                if(arr[j][i] == '0') {
					for(int k = j - 1 ; k >= 0 ; --k) {
						if(arr[k][i] != '0') {
							arr[j][i] = arr[k][i];
							arr[k][i] = '0';
							break;
						}
					}
				}
            }
        } 
        
        return count;
    } 
    
}