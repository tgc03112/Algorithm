package BOJ2623_음악프로그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		int[] indegree = new int[N+1];
		
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			int idx = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<num-1;j++) {
				int time = Integer.parseInt(st.nextToken());
				list[idx].add(time);
				indegree[time]++;
				
				idx=time;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();

		for(int i=1;i<N+1;i++) {
			if(indegree[i]==0) {
				queue.add(i);
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			result.add(now);
			
			for(int i : list[now]) {
				indegree[i]--;
				
				if(indegree[i]==0) {
					queue.add(i);
				}
			}
		}
		
		if(result.size()!=N) {
			System.out.println(0);
			return;
		}
		for(int i : result) {
			System.out.println(i);
		}
	}
}







