package BOJ2606_바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606_바이러스 {	//바이러스
	static int N,K;
	static int[][] map;
	static boolean[] v;
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine());	//컴퓨터의 수 
		K = Integer.parseInt(br.readLine());	//반복
		res = 0;
		
		map = new int[N+1][N+1];
		v = new boolean[N+1];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		v[1]=true;
		bfs();
		
		System.out.println(res);
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=1;i<=N;i++) {
				if(map[now][i]!=0 && !v[i]) {
					res++;
					v[i]=true;
					q.add(i);
				}
			}
		}
	}
}












