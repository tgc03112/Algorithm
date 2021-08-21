package BOJ15961_회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_회전초밥 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//접시의 수 8
		int d = Integer.parseInt(st.nextToken());	//초밥의 가짓수 30
		int k = Integer.parseInt(st.nextToken());	//연속해서 먹는 접시의 수 4
		int c = Integer.parseInt(st.nextToken());	//쿠폰 번호 30
		
		int[] arr = new int[N];
		int[] check = new int[d+1];	//누적
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int res = 0;
		int max = -1;
		
		for(int i=0;i<k;i++) {	//처음 0~k 중에 초밥종류 선택
			check[arr[i]]++;
		}
		
		check[c]++;	//서비스초밥
		
		for(int i=0;i<check.length;i++) {	//0~k까지 몇가지 종류 있는지 확인
			if(check[i]!=0) res++;
		}
		
		for(int i=1;i<N;i++) {	//1부터 시작
			if(check[arr[(i+k-1)%N]]==0) res++;		//다음에 먹을 초밥이 처음 먹는거라면 ++
			check[arr[(i+k-1)%N]]++;	
			check[arr[i-1]]--;	//먹고 지나쳐온 초밥
			if(check[arr[i-1]]==0) res--;	//선택에서 지나친 초밥이 없는 종류라면 --
			max=Math.max(max, res);
		}
		System.out.println(max);
	}
}