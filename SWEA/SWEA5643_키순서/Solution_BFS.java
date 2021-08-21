package SWEA5643_키순서;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_BFS {	//태희쌤
	static int N,M;
	static int adj[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int t=1; t<=TC; ++t) {
			N = sc.nextInt();
			M = sc.nextInt();
			adj = new int[N + 1][N + 1];// 0행, 0열 메모 목적으로 1씩 크기 늘림 (각행 0열 : 자신보다 큰 대상 개수, 0행 각열 : 자신보다 작은 대상  개수)
			int i,j;
			for(int m=0; m<M; ++m) {
				i = sc.nextInt();
				j = sc.nextInt();
				adj[i][j] = 1;
			}
			int res = 0;
			for(int k=1; k<=N; ++k) {
				gtCnt = ltCnt =  0;
				gtBFS(k, new boolean[N+1]);	//자신보다 큰 학생
				ltBFS(k, new boolean[N+1]);	//자신보다 작은 학생 탐색
				//				System.out.println(gtCnt+"/"+ltCnt);
				if(gtCnt + ltCnt ==N-1) res++;
			}
			System.out.println("#"+t+" "+res);
		}
	}
	static int gtCnt = 0,ltCnt = 0;
	private static void gtBFS(int start,boolean[] v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		v[start] = true;
		while(!q.isEmpty()) {
			int k = q.poll();
			for(int i=1; i<=N; ++i) {
				if(v[i])continue;
				if(adj[i][k]==0)continue;
				
				gtCnt++;  // 나보다 큰 사람 카운트처리
				v[i] = true;
				q.offer(i);
			}
		}
	}
	private static void ltBFS(int start,boolean[] v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		v[start] = true;
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for(int i=1; i<=N; ++i) {
				if(v[i])continue;
				if(adj[k][i]==0)continue;
				
				ltCnt++; // 나보다 작은 사람 카운트 처리
				v[i] = true;
				queue.offer(i);
			}
		}
	}
}