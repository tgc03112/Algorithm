package BOJ16562_친구비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_친구비 {
static int[] p,pay;
	
	static int find(int a) {
		if(a==p[a]) return a;	//같은집합
		else return p[a] = find(p[a]);
	}
	static void union(int a,int b) {
		int pa = find(a);
		int pb = find(b);
		if(pay[pb]>pay[pa])	//최소 비용 친구를 부모로 지정
			p[pb] = pa;
		else
			p[pa]=pb;
//		p[find(b)] = find(a);
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		pay = new int [N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			pay[i] = Integer.parseInt(st.nextToken());	
		}
		
		p=new int[N+1];
		for(int i=1;i<=N;i++) {	//make-set
			p[i]=i;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(st.nextToken());	
			int w = Integer.parseInt(st.nextToken());
			union(v,w);
		}
		int sum = 0;
		for(int i=1;i<=N;i++) {
			if(i==p[i]) sum+=pay[i];	//친구 비용 계속 뽑아줌 -> 집합에 한 번씩
		}
		System.out.println(sum<=K ? sum : "Oh no");
		br.close();
	}
}