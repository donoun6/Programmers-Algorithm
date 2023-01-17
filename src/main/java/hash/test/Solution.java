package hash.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}
    	public int solution(int[] nums) {
		int answer = 0;
		HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length; i++){
                set.add(nums[i]);
            }
            if(set.size() > nums.length/2){
                answer = nums.length/2;
            }else {
                answer = set.size();
            }
		return answer;
	}
}