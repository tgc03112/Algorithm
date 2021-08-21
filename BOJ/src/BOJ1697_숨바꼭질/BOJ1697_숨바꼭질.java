package BOJ1697_숨바꼭질;

/*
십만을 만으로 처리해줘서  런타임 에러남 ,, 
bfs를 풀기에 적당한 문제같은데 아이디어는 쉽게 떠오르지 않았던 문제 !! 
bfs가 Q의 트리구조를 이용한다는 점을 생각하면 풀기 어렵지 않음 
작은 수부터 그려가면서 아이디어를 생각하면 괜찮음 
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697_숨바꼭질 {	//숨바꼭질
	static int N,K;
	static int[] v;
	static int res;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	//출발
		K = sc.nextInt();	//도착
		v = new int[100000+1];
		res = 0;
		
		v[N]=0;
		bfs();
		
		System.out.println(v[K]);
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == K) break;
			
			if(now-1 >=0 && v[now-1]==0) {
				q.add(now-1);
				v[now-1] = v[now]+1;
			}
			if(now+1 <=100000 && v[now+1]==0) {
				q.add(now+1);
				v[now+1] = v[now]+1;
			}
			if(now*2 <=100000 && v[now*2]==0) {
				q.add(now*2);
				v[now*2] = v[now]+1;
			}
		}
	}
}