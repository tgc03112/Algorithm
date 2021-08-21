package SWEA1953_탈주범_검거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int H,W,R,C,L;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1,0,0,1};	//상좌우하 
	static int[] dy = {0,-1,1,0};
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());	//터널 세로
			W = Integer.parseInt(st.nextToken());	//터널 가로
			R = Integer.parseInt(st.nextToken());	//맨홀 세로
			C = Integer.parseInt(st.nextToken());	//맨홀 가로
			L = Integer.parseInt(st.nextToken());	//소요된 시간
			
			map = new int[H][W];
			v = new boolean[H][W];
			res = 0;
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			
			
			System.out.println(res);
			
		}
	}
	private static void bfs() {
		Queue<Position> q = new LinkedList<Position>();
		v[R][C] = true;
		res++;
		q.offer(new Position(R, C, 1));
		
		for(int l=0;l<L;l++) {	//소요된 시간만큼만 퍼트리기
			Position now = q.poll();
			int x = now.x;
			int y = now.y;
			int sum = now.sum;
			switch(map[x][y]) {
			case 1:
				
				break;
			case 2:
				break;
			case 3:
					if(y-1>=0) {	//범위안에있고
						if(map[x][y-1]==1 || map[x][y-1]==3 || map[x][y-1]==4 || map[x][y-1]==5) {	//진행가능한 파이프라면
							
						}
					}
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			}
		}
		
	}

}
class Position{
	int x,y,sum;

	public Position(int x, int y, int sum) {
		this.x = x;
		this.y = y;
		this.sum = sum;
	}
}











