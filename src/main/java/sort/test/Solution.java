package sort.test;

import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int a,b,c;
            a = commands[i][0];
            b = commands[i][1];
            c = commands[i][2];
            int[] arr = Arrays.copyOfRange(array,a-1,b); //array의 인덱스 a-1부터 b까지 복사 
            Arrays.sort(arr); //정렬
            answer[i] = arr[c-1];
        }      
        return answer;
    }
}