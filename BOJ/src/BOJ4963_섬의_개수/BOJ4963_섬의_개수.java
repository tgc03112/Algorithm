package BOJ4963_섬의_개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963_섬의_개수 {	//섬의 개수
	static int a,b;
	static int res;
	static int[][] map;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(a==0 && b==0) break;
			
			map = new int[b][a];
			for(int i=0;i<b;i++) {	//배열채우기
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<a;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i=0;i<b;i++) {
				for(int j=0;j<a;j++) {
					if(map[i][j]==1) {
						res++;
						dfs(i,j);
					}
				}
			}
			System.out.println(res);
		}
	}
	private static void dfs(int i, int j) {

		for(int d=0;d<8;d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];

			if(nx<0 || ny<0 || nx>=b || ny>=a) continue;
			if(map[nx][ny]==1) {
				map[nx][ny]=0;
				dfs(nx,ny);
			}
		}
	}
}
class position{
	int x,y;
	public position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}