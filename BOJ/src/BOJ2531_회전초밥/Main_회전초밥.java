package BOJ2531_회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_회전초밥 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//접시의 수
		int d = Integer.parseInt(st.nextToken());	//초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());	//연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken());	//쿠폰 번호
		
		int[] arr = new int[N];
		boolean[] check = new boolean[d+1];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int res = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			int sum = 0;
			Arrays.fill(check, false);
			for(int j = i;j<i+k;j++) {
				check[arr[(j+N)%N]]=true;
			}
			check[c] = true;
			for(int l=0;l<check.length;l++) {
				if(check[l]==true) sum++;
			}
			res = Math.max(res, sum);
		}
		System.out.println(res);
	}
}