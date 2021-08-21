package SWEA5604_구간합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static long start,end,res,mul;	//long으로 선언
	static long[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Long.parseLong(st.nextToken());
			end = Long.parseLong(st.nextToken());
			
			arr = new long[10];
			res = 0;
			mul = 1;
			if(start==0) start=1;
			while(start<=end) {
				while(start%10!=0 && start<=end) {	//start위치 맞춰주기(0으로떨어질떄까지)
					solve(start);
					start++;
				}
				
				if(start>end) break;
				
				while(end%10!=9 && start<=end) {	//end위치 맞춰주기
					solve(end);
					end--;
				}
				long k = end/10-start/10+1;
				for(int i=0;i<10;i++) {
					arr[i]+=k*mul;
				}
				mul*=10;
				start/=10;
				end/=10;
			}
			for(int i=1;i<10;i++) {
				res+=(i*arr[i]);
			}
			System.out.println("#"+t+" "+res);
		}
	}
	private static void solve(long num) {
		for(long i=num;i>0;i/=10) {
			String str = Long.toString(i);
			int t = str.charAt(str.length()-1)-'0';
			arr[t]+=mul;
		}
	}
}