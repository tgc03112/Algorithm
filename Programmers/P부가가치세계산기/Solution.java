package P부가가치세계산기;

public class Solution {
	public static void main(String[] args) {
		
	}
	public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액          // taxFreeAmount : 비과세      // serviceFee : 봉사료
		
		//부가세
		long answer = 0;
		
		//봉사료가 있으면? 주문금액 - 봉사료 = 공급대가
		if(serviceFee>0) {
			orderAmount -= serviceFee;
		}
		
		answer = (orderAmount-taxFreeAmount) * 1/10;
		
		answer = (long) Math.ceil(answer);
		
		if(orderAmount-taxFreeAmount<=1) {
			answer = 0;
		}

        return answer;
    }	
}