package level1.test62;

import java.util.*;

/*
 * 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때, 
 * 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int move : moves){ //forEach
            for(int i = 0; i < board.length; i++){
                if(board[i][move-1]!=0){
                    if(list.size() == 0 ){
                        list.add(board[i][move-1]);
                    }else if(list.get(list.size()-1) == board[i][move-1]){
                        list.remove(list.size()-1);
                        answer += 2;
                    }else {
                        list.add(board[i][move-1]);
                    }
                    
                    board[i][move-1] = 0;
                    break;
                }
            }                  
        }
        return answer;
    }
}
//아래는 stack 방식 위는 list 방식

class Solution2 {
	   public int solution(int[][] board, int[] moves) {
	       int answer = 0;
	       Stack<Integer> s = new Stack<>();
	       for(int i : moves){
	           for(int j = 0; j < board.length; j++){
	               if(board[j][i-1] != 0){
	                   if(s.isEmpty()) s.push(board[j][i-1]);
	                   else {
	                       if(s.peek() == board[j][i-1]){
	                           s.pop();
	                           answer +=2;
	                       }else {
	                           s.push(board[j][i-1]);
	                       }
	                   }
	                   board[j][i-1] = 0;
	                   break;
	               }
	           }                  
	       }

	       return answer;
	   }
	}
