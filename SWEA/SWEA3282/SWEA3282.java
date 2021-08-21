package SWEA3282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3282 {	// 0/1 Knapsack

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	//물건의 개수
			int K = Integer.parseInt(st.nextToken());	//가방의 부피
			
			int[][] arr = new int[N+1][2];	//가방정보 저장 
			int[][] map = new int[N+1][K+1];
			
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[i][0] = a;
				arr[i][1] = b;
			}
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=K;j++) {
					if(arr[i][0]<=j) {	//넣을 수 있는 경우 
						map[i][j]=Math.max(map[i-1][j], arr[i][1]+map[i-1][j-arr[i][0]]);
					}
					else {	//넣을 수 없는 경우 
						map[i][j]=map[i-1][j];
					}
				}
			}
			System.out.println("#"+t+" "+map[N][K]);
		}
	}
}

















