package level1.test75;
import java.util.*;
/*
코딩테스트를 준비하는 머쓱이는 프로그래머스에서 문제를 풀고 나중에 다시 코드를 보면서 공부하려고 작성한 코드를 컴퓨터 바탕화면에 아무 위치에나 저장해 둡니다. 저장한 코드가 많아지면서 머쓱이는 본인의 컴퓨터 바탕화면이 너무 지저분하다고 생각했습니다. 프로그래머스에서 작성했던 코드는 그 문제에 가서 다시 볼 수 있기 때문에 저장해 둔 파일들을 전부 삭제하기로 했습니다.

컴퓨터 바탕화면은 각 칸이 정사각형인 격자판입니다. 이때 컴퓨터 바탕화면의 상태를 나타낸 문자열 배열 wallpaper가 주어집니다. 파일들은 바탕화면의 격자칸에 위치하고 바탕화면의 격자점들은 바탕화면의 가장 왼쪽 위를 (0, 0)으로 시작해 (세로 좌표, 가로 좌표)로 표현합니다. 빈칸은 ".", 파일이 있는 칸은 "#"의 값을 가집니다. 드래그를 하면 파일들을 선택할 수 있고, 선택된 파일들을 삭제할 수 있습니다. 머쓱이는 최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서 한 번에 지우려고 하며 드래그로 파일들을 선택하는 방법은 다음과 같습니다.
 */
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minA = Integer.MAX_VALUE; int minB = Integer.MAX_VALUE;
        int maxA = 0; int maxB = 0;
        
        for(int i = 0; i < wallpaper.length; i++) {
            String[] arr = wallpaper[i].split("");
            for(int j = 0; j < arr.length; j++){
                if(arr[j].equals("#")){
                    if(minA > i) {
                        minA = i;
                    }
                    if (maxA < i) {
                        maxA = i;
                    }
                    if(minB > j) {
                        minB = j;
                    }
                    if (maxB < j) {
                        maxB = j;
                    }
                }
            }
        }
        
        answer[0] = minA; answer[1] = minB;
        answer[2] = maxA+1; answer[3] = maxB+1;
        return answer;
    }
}