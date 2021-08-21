package SWEA1868_파핑파핑_지뢰찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
	static int[][] map;
	static boolean[][] v;
	static int N;
	static int res;
	static Queue<position> q;
	static int[] dx = {0,1,1,1,0,-1,-1,-1};	//8방
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++) {
			N = Integer.parseInt(br.readLine());
			q = new LinkedList<position>();
			map = new int[N][N];
			v = new boolean[N][N];
			res=0;
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					char input = str.charAt(j);
					if(input=='.') {	//맨바닥
						map[i][j]=-1;
					}
					else {	//지뢰
						map[i][j]=9;
					}
				}
			}
//			for(int i=0;i<N;i++) {	//출력확인용
//				System.out.println(Arrays.toString(map[i]));
//			}
			bfs();
//			for(int i=0;i<N;i++) {	//출력확인용
//				System.out.println(Arrays.toString(v[i]));
//			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==-1 && !v[i][j]) {
						res++;
					}
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
	private static void bfs() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				if(map[i][j]==-1 && !v[i][j] && isZero(i, j)) {	//처음 0 집어넣기, 0이두번 들어가도 방문배열에 걸려서
					
					v[i][j]=true;
					q.offer(new position(i, j));
					res++;
					
					while(!q.isEmpty()) {
						position now = q.poll();
						int x = now.x;
						int y = now.y;
						
						for(int d=0;d<8;d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							if(nx<0 || nx>=N || ny<0 || ny>=N)	continue;
							if(v[nx][ny]) continue;
							if(map[nx][ny]==-1) {
								if(isZero(nx, ny)) {	//0이면 다 집어넣기 -> 어차피 방문체크에서 걸러짐
									q.offer(new position(nx, ny));
									v[nx][ny]=true;
								}
								else {
									v[nx][ny]=true;
								}
							}
						}
					}
				}
			}
		}
	}
	private static boolean isZero(int i,int j) {
		
		boolean zero = true;
		
		for(int d=0;d<8;d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N)	continue;
			
			if(map[nx][ny]==9) {
				zero=false;
				break;
			}
		}
		return zero;
	}
}

class position{
	int x,y;

	public position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}