package SWEA5643_키순서;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_DFS {	//태희쌤
	static int N,M,adj[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int t=1; t<=TC; ++t) {
			N = sc.nextInt();
			M = sc.nextInt();
			adj = new int[N + 1][N + 1];
			int i,j;
			for(int m=0; m<M; ++m) {
				i = sc.nextInt();
				j = sc.nextInt();
				adj[i][j] = 1;
			}
			int res = 0;
			for(int k=1; k<=N; ++k) {
				gtCnt = ltCnt =  0;
				gtDfs(k, new boolean[N+1]);
				ltDfs(k, new boolean[N+1]);
				//				System.out.println(gtCnt+"/"+ltCnt);
				if(gtCnt + ltCnt ==N-1) res++;
			}
			System.out.println("#"+t+" "+res);
		}
	}
	static int gtCnt = 0,ltCnt = 0;
	private static void gtDfs(int cur,boolean[] v) {
		v[cur] = true;
		for(int i=1; i<=N; ++i) { //k보다 큰 놈 탐색 
			if(v[i])continue;
			if(adj[cur][i] == 0)continue;
			gtCnt++;
			gtDfs(i,v);
		}
	}
	private static void ltDfs(int cur,boolean[] v) {
		v[cur] = true;
		for(int i=1; i<=N; ++i) { // k보다 작은 놈 탐색
			if(v[i])continue;
			if(adj[i][cur] == 0)continue;
			ltCnt++;
			ltDfs(i,v);
		}
	}
}