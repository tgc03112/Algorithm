package SWEA5607_조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, R;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			long result = nCr(N,R,1234567891);
			System.out.println("#"+t+" "+result);
		}
	}
	
	public static long nCr(int n, int r, int p) {

		if(r==0) {
			return 1;
		}
		long[] f = new long[n+1];
		f[0]=1;
		for(int i=1;i<=n;i++) {
			f[i] = f[i-1]*i%p;
		}
		// 7! * ( (2! mod p) * (5! mod p) ) mod p ;
		return (f[n]*power(f[r],p-2,p)%p 
				*power(f[n-r],p-2,p)%p)
				%p;
	}
	
	private static long power(long x, long y, long p) {

		long res = 1;
		x = x % p;	//숫자 커지지말라고 모듈러 연산
		
		while(y>0) {
			if(y%2 ==1) {	//홀수일떄 한 개 먼저  곱해줌
				res = (res*x)%p;
			}
			y = y>>1;	// y = y/2
			x = (x*x)%p;	//x제곱 % p
		}
		
		return res;
	}
}


