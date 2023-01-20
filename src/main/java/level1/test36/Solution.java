package level1.test36;

import java.util.*;

/*
 * 명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 
 * 이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
 * 아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.
 * 명함 번호	가로 길이	  세로 길이
 * 	1		  60		50
 * 	2		  30		70
 * 	3	  	  60		30
 * 	4	   	  80		40
 * 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다. 
 * 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.
 * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
	/*
	 * 나는 배열을 만들어 h가 w보다 클시 카드를 회전시켜 w와 h값을 바꿨다 
	 * 이후 두 배열의 행열중 가장 큰수들을 곱하였다. 
	 */
    public int solution(int[][] sizes) {
        int[] w = new int[sizes.length];
        int[] h = new int[sizes.length];
        for(int i = 0 ; i < sizes.length; i++){  
            w[i] = sizes[i][0] < sizes[i][1] ? sizes[i][1] : sizes[i][0]; // h 가 w보다 크면 h에 w값을 w에 h값을 넣었다. 
            h[i] = sizes[i][0] < sizes[i][1] ? sizes[i][0] : sizes[i][1]; // 위와 동일
        }
        int wMax = 0;
        int hMax = 0;
        for(int i : w )  wMax = Math.max( i, wMax ); //w배열중 가장 큰 수 출력
        for(int i : h )  hMax = Math.max( i, hMax ); //h배열중 가장 큰 수 출력
        return wMax * hMax;
    }
}