package BOJ1806_부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	//백준

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int res = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		
		while(true) {
			if(sum>=S) {	//경우가 있을 때
				sum = sum - arr[start++];
				res = Math.min(res, (end-start)+1);
			}
			else if(end == N) break;
			else {	//없으면 계속 진행
				sum = sum + arr[end++];
			}
		}
		if(res==Integer.MAX_VALUE) res=0;
		System.out.println(res);
	}
}
























