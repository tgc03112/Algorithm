package BOJ1520_내리막길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int[][] dp;
	static boolean[][] visited;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int res;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dp[N-1][M-1] = 1;
		dfs(0,0);
		
		System.out.println(dp[0][0]);
	}

	private static void dfs(int i, int j) {

		if(i==N-1 && j==M-1) {
			return;
		}
		
		if(visited[i][j]) {
			return;
		}
		
		visited[i][j] = true;
		
		for(int d=0;d<4;d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			if(map[i][j]>map[nx][ny]) {
				if(dp[nx][ny]!=0) {
					dp[i][j]+=dp[nx][ny];
				}
				else{
					dfs(nx,ny);
					dp[i][j]+=dp[nx][ny];
				}
			}
		}
	}
}







