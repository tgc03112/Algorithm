package P보석쇼핑;

import java.util.Arrays;
import java.util.HashMap;

public class Solution4 {

	public static void main(String[] args) {

//		String[] arr = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//		String[] arr = {"AA", "AB", "AC", "AA", "AC"};
//		String[] arr = {"XYZ", "XYZ", "XYZ"};
//		String[] arr = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		String[] arr = {"DIA", "EM", "EM", "RUB", "DIA"};
		
//		System.out.println(Arrays.toString(arr));
		
		int[] res = solution(arr);
		
		System.out.println(Arrays.toString(res));
	}
	public static int[] solution(String[] gems) {
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		int[] answer = new int[2];
		
		answer[0] = 1;
		answer[1] = gems.length;
		
		int idx = 0;
		for(int i=0;i<gems.length;i++) {
			if(!h.containsKey(gems[i])) {
				h.put(gems[i], idx++);
			}
		}
//		System.out.println(h.toString());	//출력확인
		
		int size = h.size();
		int min = Integer.MAX_VALUE;
		int[] arr = new int[h.size()];
		int cnt = 0;
		int start = 0;	//0
		int end = 0;	//3
				
		while(end<gems.length) {
			if(cnt >= size) {
				arr[h.get(gems[start])]--;
				if(arr[h.get(gems[start])]==0) {
					cnt--;
				}
				
				if(answer[1]-answer[0] > (end-1)-start) {
					answer[0] = start+1;
					answer[1] = end;
				}
//				System.out.println("2 :"+Arrays.toString(arr)+" "+cnt);
				start++;
			}
			else {
				arr[h.get(gems[end])]++;
				if(arr[h.get(gems[end])]==1) {
					cnt++;
				}
				end++;
//				System.out.println("1 :"+Arrays.toString(arr)+" "+cnt);
			}
//			System.out.println(start+","+end);
		}
        return answer;
    }
}
