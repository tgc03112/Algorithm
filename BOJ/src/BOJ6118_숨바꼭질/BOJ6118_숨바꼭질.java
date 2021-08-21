package BOJ6118_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6118_숨바꼭질 {	//숨바꼭질
	static int N,M;
	static int[][] map ;
	static int[] v;
	static int a,b,c;	//제일작은 헛간 위치, 헛간까지의 거리 ( 배열의 값 -1 ), 헛간과 같은 거리의 개수 출력 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//헛간의 수
		M = Integer.parseInt(st.nextToken());	
		
		map = new int[N+1][N+1];
		v = new int[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[from][to] = map[to][from] = 1;
		}
		v[1] = 1;
		bfs();
		
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=1;i<N;i++) {
				if(map[now][i]!=0 && v[i]!=0) {
					c++;
					v[i]=v[now]+1;
					q.add(i);
					
				}
			}
		}
	}
}













