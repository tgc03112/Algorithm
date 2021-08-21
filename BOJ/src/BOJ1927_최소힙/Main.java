package BOJ1927_최소힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();	//최소힙
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int X = Integer.parseInt(br.readLine());
			if(X!=0) {
				pq.offer(X);
			}
			else {
				sb.append(pq.isEmpty()?0:pq.poll()).append("\n");
			}
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}
}
