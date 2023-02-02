package level1.test67;

import java.util.*;

/*햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고, 
 * 상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 
 * 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때, 
세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
 */

import java.util.Stack;
class Solution {
    public int solution(int[] ingredient) {
        int result = 0;
		Stack<Integer> stack = new Stack<>();
		for (int in : ingredient) {
			stack.push(in);
			if (stack.size() >= 4) {
				int size = stack.size();
				if(stack.get(size - 1) == 1
						&& stack.get(size - 2) == 3
						&& stack.get(size - 3) == 2
						&& stack.get(size - 4) == 1) {
					result++;
					stack.pop();
					stack.pop();
					stack.pop();
					stack.pop();
				}
			}
		}
		return result;
    }
}

class Solution2 {
    public int solution(int[] ingredient) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for(int n : ingredient){
            list.add(n); //재료를 하나씩추가
            if(list.size() >= 4) { //재료가 4개이상일때 아래 비교문을 실행
                if(list.get(list.size() - 4) == 1 && list.get(list.size() - 3) == 2 &&  //현재 받은 재료 index가 3이면 size를 통해 0 1 2 3 순으로 처리해준다 
                   list.get(list.size() - 2) == 3 && list.get(list.size() - 1) == 1){ //1,2,3,1 이 맞으면 answer을 count하고 해당 재료들을 치운다 remove
                    answer++;
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                }
            }
        } 
        return answer;
    }
}