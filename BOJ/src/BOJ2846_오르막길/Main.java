package BOJ2846_오르막길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int sum =0;
		int max = 0;
		
		for(int i=0;i<N-1;i++) {
			if(arr[i]<arr[i+1]) {	//오르막
				sum+=arr[i+1]-arr[i];
			}
			else {	//내리막 or 평지
				sum=0;
			}
			max=Math.max(max, sum);
		}
		System.out.println(max);
	}
}
