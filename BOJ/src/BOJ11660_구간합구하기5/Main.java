package BOJ11660_구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		int[][] dp = new int[N+1][N+1];

		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				dp[i][j]=dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1]+map[i][j];
			}
		}

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());	//2 2 3 4
			int x1 = Integer.parseInt(st.nextToken());	//2
			int y1 = Integer.parseInt(st.nextToken());	//2
			int x2 = Integer.parseInt(st.nextToken());	//3
			int y2 = Integer.parseInt(st.nextToken());	//4
			
			int res = dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];		
			
			System.out.println(res);
		}
	}
}
