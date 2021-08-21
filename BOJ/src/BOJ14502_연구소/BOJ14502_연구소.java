package BOJ14502_연구소;
/*
1. 벽을 3개씩 세운다.
2. 벽을 세운 상태로 2를 전파시킨다. 
3. 안전영역 구한뒤 최대값 찾는다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502_연구소 {	//연구소
	static int N,M,max;
	static int[][] map;
	static int[][] cmap;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cmap = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {	//0만났을 때 벽세우러 들어감
					map[i][j]=1;
					dfs(1);
					map[i][j]=0;
				}
			}
		}
		System.out.println(max);
	}
	//1.벽 3개 세우기
	private static void dfs(int cnt) {	
		if(cnt==3) {
			bfs();	//벽 3개 세웠으면 바이러스 퍼트리러
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(cnt+1);
					map[i][j]=0;
				}
			}
		}
	}
	//2.0인곳에 바이러스 2로 채우고 안전영역 구하기
	private static void bfs() {
		Queue<position> q = new LinkedList<position>();
		
		for(int i=0;i<N;i++) {	//2로 퍼트리기 전에 복사해두기 
			for(int j=0;j<M;j++) {
				cmap[i][j] = map[i][j];
			}
		}
		for(int i=0;i<N;i++) {	
			for(int j=0;j<M;j++) {
				if(cmap[i][j] == 2) {	//2를 만나면 bfs를 위해 넣어두기
					q.add(new position(i,j));
				}
			}
		}
		while(!q.isEmpty()) {
			position now = q.poll();
			
			for(int d=0;d<4;d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if(nx<0 || ny<0 || nx>=M || ny>=N) continue;				
				if(cmap[ny][nx]==0) {	//빈공간 만나면 바이러스로 퍼트림
					cmap[ny][nx]=2;
					System.out.println("=================");
					for(int i=0;i<N;i++) {
						System.out.println(Arrays.toString(cmap));
					}
					q.add(new position(nx, ny));
				}
			}
		}
		int cnt = 0;
		for(int i=0;i<N;i++) {	//안전영역 갯수 구하기
			for(int j=0;j<M;j++) {
				if(cmap[i][j]==0){	
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);
	}
}
class position{
	int x;
	int y;
	public position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

















