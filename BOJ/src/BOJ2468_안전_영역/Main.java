package BOJ2468_안전_영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int max=0;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				max = Math.max(max, num);
				map[i][j]=num;	//1 ~ max값 까지 모두 해봐야됨 
			}
		}
		int res = 1;
		int cnt = 0;
		
		for(int k=1;k<=max;k++) {
			v = new boolean[N][N];	//매번 1 ~ MAX 까지 새로운 k에 대해서 모든경우 검사 해야됨 
			cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] > k && !v[i][j]) {	//방문하지 않았고, 물에 잠기지 않는 구간이 있으면 dfs실행해서 연결된곳 방문처리해줌
						cnt++;
						dfs(i,j,k);
					}
				}
			}
			res = Math.max(res, cnt);
		}
		System.out.println(res);
	}
	private static void dfs(int x, int y, int c) {
		v[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
			if(v[nx][ny]) continue;
			
			if(map[nx][ny]>c) {	//물이 깊이보다 높은곳 연결되어있으니 방문처리 함 
				dfs(nx, ny, c);
			}
		}
	}
}