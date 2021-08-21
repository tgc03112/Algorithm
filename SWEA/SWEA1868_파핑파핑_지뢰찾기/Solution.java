package SWEA1868_파핑파핑_지뢰찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
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
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					
					if(map[i][j]==-1) {	//처음 0 집어넣기
						int x = i;
						int y = j;
						int flag = 0;
						
						for(int d=0;d<8;d++) {
							int nx = x+dx[d];
							int ny = y+dy[d];
							if(nx<0 || nx>=N || ny<0 || ny>=N)	continue;	//범위 벗어나거나
							if(map[nx][ny]==9) {
								flag++;	//주위에 9가 있으면
							}
						}
						if(flag==0) {
							map[i][j]=0;
							q.offer(new position(i, j));
						}
					}
				}
			}
//			for(int i=0;i<N;i++) {	//출력확인용
//				System.out.println(Arrays.toString(map[i]));
//			}
			bfs();
//			for(int i=0;i<N;i++) {	//출력확인용
//				System.out.println(Arrays.toString(map[i]));
//			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==-1) {
						res++;
					}
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
	private static void bfs() {

		while(!q.isEmpty()) {
			position now = q.poll();
			int x = now.x;
			int y = now.y;

			if(v[x][y]) continue;
			res++;
			v[x][y]=true;
			
			for(int d=0;d<8;d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx<0 || nx>=N || ny<0 || ny>=N)	continue;
				if(v[nx][ny]) continue;
				
				if(map[nx][ny]!=9) {
					v[nx][ny]=true;
					map[nx][ny]=isZero(nx,ny);
				}
			}
//			System.out.println("=============");
//			for(int i=0;i<N;i++) {	//출력확인용
//				System.out.println(Arrays.toString(map[i]));
//			}
		}
	}
	private static int isZero(int i,int j) {
		int pop = 0;
		
		for(int d=0;d<8;d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N)	continue;
			
			if(map[nx][ny]==9) {
				pop++;
			}
		}
		return pop;
	}
}









