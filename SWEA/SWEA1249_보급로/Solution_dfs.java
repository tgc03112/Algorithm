package SWEA1249_보급로;

import java.util.Scanner;

public class Solution_dfs {
	static int N;
	static int[][] map;
	static boolean[][] v;
	static int res = Integer.MAX_VALUE;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			
			N = sc.nextInt();
			map = new int[N][N];
			v = new boolean[N][N];
			res = Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				String str = sc.next();
				for(int j=0;j<N;j++) {
					map[i][j]=str.charAt(j)-'0';
				}
			}
			v[0][0] = true;
			dfs(0,0,0);
			
			System.out.println("#" + t + " " + res);
		}
	}
	private static void dfs(int i, int j, int k) {
		
		if(k>res) {
			return;
		}
		if(i==N-1 && j==N-1) {
			res=Math.min(res, k);
			return;
		}
		for(int d=0;d<4;d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			if(nx<0 || ny<0 || nx>=N || ny>=N) {
				continue;
			}
			if(v[nx][ny]) {
				continue;
			}
			v[nx][ny]=true;
			dfs(nx, ny, k+map[nx][ny]);
			v[nx][ny]=false;
		}
	}
}






