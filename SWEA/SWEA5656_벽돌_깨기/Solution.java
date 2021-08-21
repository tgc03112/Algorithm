package SWEA5656_벽돌_깨기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N,W,H,min;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			for(int i=0;i<H;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = -1;
			solve(0,map);
			
			if(min == -1)	//벽돌을 다 깼을 때
				System.out.println("#"+t+" "+0);
			else
				System.out.println("#"+t+" "+min);
		}
	}
	private static void solve(int cnt, int[][] map) {

		if(cnt==N) {
			int res = 0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j]!=0) {
						res++;
					}
				}
			}
			if(min==-1 || min>res) {
				min=res;
			}
			return;
		}
		
		for(int j=0;j<W;j++) {	//열 따라서 경우의 수 구하기
			int i=0;
			while(i<H) {
				if(map[i][j]!=0) {
					break;
				}
				i++;
			}
			if(i==H) {	//모두 빈칸이면 다음칸으로 
				continue;
			}
			int[][] cmap = copy(map);
			pop(i,j,cmap);	//부수기
			move(cmap);
			solve(cnt+1,cmap);
		}
		
	}
	private static void move(int[][] cmap) {	//빈칸 내리기
		
		for(int j=0;j<W;j++) {
			for(int i=H-1;i>0;i--) {
				if(cmap[i][j]==0) {
					int k=i-1;
					while(k>=0) {
						if(cmap[k][j]!=0) {
							cmap[i][j]=cmap[k][j];
							cmap[k][j]=0;
							break;
						}
						k--;
					}
					if(k==-1) break;
				}
			}
		}
	}
	private static void pop(int x, int y, int[][] cmap) {
		Queue<Data> q = new LinkedList<Data>();
		q.offer(new Data(x, y, cmap[x][y]));
		cmap[x][y]=0;
		
		while(!q.isEmpty()) {
			Data d = q.poll();
			for(int i=0;i<4;i++) {
				int nx = d.x;
				int ny = d.y;
				int num = d.num;
				for(int j=0;j<num-1;j++) {
					nx += dx[i];
					ny += dy[i];
					if(nx<0 || ny<0 || nx>=H || ny >=W) break;
					if(cmap[nx][ny]==0) continue;
					if(cmap[nx][ny] > 1 ) {
						q.offer(new Data(nx, ny, cmap[nx][ny]));
					}
					cmap[nx][ny]=0;	//깨기
				}
			}
		}
		
	}
	private static int[][] copy(int[][] map) {	//복사(복사한 배열로 진행하기위해)
		int[][] cmap = new int[H][W];
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				cmap[i][j] = map[i][j];
			}
		}
		return cmap;
	}
}
class Data{
	int x,y,num;
	public Data(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}