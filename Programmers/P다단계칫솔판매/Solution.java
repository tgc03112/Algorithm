package P다단계칫솔판매;
/*
hashmap을 사용하는 문제, Hashmap<Key,Value> 쌍으로 나의 부모를 저장하고 또다른 해시 하나에는 index를 저장해서 배열에 접근하는 시간을 줄인다.

hash를 두 개 쓴다는 점이 번거롭긴 하지만 class를 만들거나 해서 해결할 수도 있을거 같다.

문제 모양이 트리로 되어있어서 조금 고민할뻔 헀지만 트리를 쓴다는 점과 반복해서 항상 꼭대기, center까지 올라간다고 생각하면 그렇게 어려운 문제는 아닌 듯 하다.

*/
import java.util.*;

public class Solution {
	public static void main(String[] args) {

		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};	//판매원들
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};	//판매원의 부모
		String[] seller = {"young", "john", "tod", "emily", "mary"};	//판매를 한 판매원들
		int[] amount = {12, 4, 2, 5, 10};
		//[360, 958, 108, 0, 450, 18, 180, 1080]	//결과
		
//		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
//		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
//		String[] seller = {"sam", "emily", "jaimie", "edward"};
//		int[] amount = {2, 3, 5, 4};
//		//[0, 110, 378, 180, 270, 450, 0, 0]
		
		int[] res = solution(enroll,referral,seller, amount);
		
		System.out.println(Arrays.toString(res));
	}

	private static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];
		
		HashMap<String, String> hashmap = new HashMap<>();	//자식, 부모 저장하는 hash
		HashMap<String, Integer> idxhashmap = new HashMap<>();	//idx저장 -> 배열에 바로 price 누적해주기 위해
		
		for(int i=0;i<enroll.length;i++) {
			hashmap.put(enroll[i], referral[i]);
			idxhashmap.put(enroll[i], i);
		}
		
		for(int i=0;i<seller.length;i++) {
			String str = seller[i];
			int price = amount[i] * 100;
			
			while(!str.equals("-")) {	//center에 도달할 때 까지 계속 반복
				int resprice = price - (price / 10);
				
				answer[idxhashmap.get(str)] += resprice;
				
				//부모 이름으로 바꾸고 가격도 1/10으로 바꿔준 뒤 계속 반복
				str = hashmap.get(str);
				price /= 10;
                
                if(price<1){	//price 1 미만되면 계산해줄 필요 x -> 마지막 테케 3개 시간초과 남
                    break;
                }
			}
		}
        return answer;
	}	
}







