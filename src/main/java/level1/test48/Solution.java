package level1.test48;

import java.util.*;

/*
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length-2; i++){ //원소가 5개일때 i는 0~2까지
            for(int j = i+1; j < nums.length-1; j++){ //원소가 5개일때 j는 1~3까지
                 for(int k =  j+1; k < nums.length; k++){ //원소가 5개일때 k는 2~4까지 각각 겹치지 않도록 수를 뽑아온다.
                     int num = nums[i]+nums[j]+nums[k];
                     boolean flag = true;
                     for(int l = 2; l <= Math.sqrt(num); l++){ //제곱근을 이용하여 소수를 구하는 방법                      
                         if(num%l == 0) {
                             flag = false;
                             break;
                         }
                     }
                     if(flag==true){ //소수일시 1을 더한다.
                         answer++;
                     }
                 }
            }
        }
        return answer;
    }
}