package SWEA1249_보급로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_bfs {	//보급로
	static int N;
	static int[][] map;
	static int[][] v;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new int[N][N];
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j]= str.charAt(j)-'0';
					v[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bfs();
			
			System.out.println("#" + t + " " + v[N-1][N-1]);
		}
		br.close();
	}

	private static void bfs() {
		Queue<Data> q = new LinkedList<Data>();
		q.offer(new Data(0, 0, 0));
		
		while(!q.isEmpty()) {
			Data data = q.poll();
			
			int x = data.x;
			int y = data.y;
			int sum = data.sum;
			
			for(int d=0;d<4;d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N) {	//범위체크
					continue;
				}
				
				int nsum = sum + map[nx][ny];	//땅파는비용
				
				if(nsum >= v[nx][ny]) {	//새로구한 비용이 이전 비용보다 크면 진행 안해도됨
					continue;
				}
				v[nx][ny] = nsum;	//nsum이 더 작으면 갱신
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






