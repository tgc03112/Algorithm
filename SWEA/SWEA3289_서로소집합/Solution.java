package SWEA3289_서로소집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] p;
	
	static int find(int a) {
		if(a==p[a]) return a;	//같은집합
		else return p[a] = find(p[a]);
	}
	static void union(int a,int b) {
//		a = find(a);
//		b = find(b);
//		p[b] = a;
		p[find(b)] = find(a);
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			p=new int[N+1];
			for(int i=1;i<=N;i++) {	//make-set
				p[i]=i;
			}
			sb.append("#").append(t).append(" ");
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());	//0 or 1
				int a = Integer.parseInt(st.nextToken());	
				int b = Integer.parseInt(st.nextToken());
				if(c==0) union(a,b);
				else
					sb.append(find(a)==find(b)?1:0);
				
				
				
			}
			sb.append("\n");
		}
		
		
		System.out.print(sb.toString());
		br.close();
	}

}





