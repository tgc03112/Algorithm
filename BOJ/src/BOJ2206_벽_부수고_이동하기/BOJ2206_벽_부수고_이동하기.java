package BOJ2206_벽_부수고_이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206_벽_부수고_이동하기 {	//벽 부수고 이동하기
	static int N,M;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static int res;
	static boolean[][][] v;
	static int[] dx = {1,-1, 0, 0};
	static int[] dy = {0, 0, 1, -1}; 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M][2];
		res = -1;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		bfs();
		System.out.println(res);
	}
	private static void bfs() {
		Queue<position> q = new LinkedList<position>();
		q.add(new position(0, 0, 1, 0));
		v[0][0][1] = true;
		v[0][0][0] = true;

		while(!q.isEmpty()) {
			position now = q.poll();
			if(now.x == M-1 && now.y == N-1) {
				res=now.cnt;
				return;
			}
			int x = now.x;
			int y = now.y;
			int cnt = now.cnt;
			int k = now.k;
			
			for(int d=0;d<4;d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
				
				if(map[ny][nx]==1) {	//벽을 만날 때					
					if(now.k == 0 && !v[ny][nx][1]) {	//벽을 부술 기회가 있는 경우 부수고 간다
						v[ny][nx][1]=true;
						q.add(new position(nx, ny, cnt+1, 1));
					}
				}
				else {	//벽이 아닐 때 
					if(!v[ny][nx][k]) {
						v[ny][nx][k]=true;
						q.add(new position(nx, ny, cnt+1, k));
					}
				}
			}
		}
	}
}
class position{
	int x,y;
	int cnt,k;
	public position(int x, int y, int cnt, int k) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;	//이동거리
		this.k = k;		//벽을 부쉈는지 
	}
}












