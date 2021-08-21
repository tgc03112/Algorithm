package BOJ7576_토마토;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] map;
	static int M,N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int res=0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();	//가로
		N = sc.nextInt();	//세로
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		bfs();
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		System.out.println(res);
	}
	private static void bfs() {
		Queue<Data> q = new LinkedList<Data>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) {
					q.offer(new Data(i, j, 0));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Data now = q.poll();
			
			for(int d=0;d<4;d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				int nsum = now.sum+1;
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(map[nx][ny]!=0) continue;
				
				map[nx][ny]=nsum;
				res=nsum;
				q.offer(new Data(nx, ny, nsum));
			}
		}
	}
}
class Data{
	int x,y,sum;
	public Data(int x, int y, int sum) {
		this.x = x;
		this.y = y;
		this.sum = sum;
	}
}
