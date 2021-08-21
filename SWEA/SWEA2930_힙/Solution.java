package SWEA2930_힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());	//최소힙-> reverseOrder -> 최대힙으로 바뀜
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			pq.clear();
			sb.append("#").append(tc);
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int op = Integer.parseInt(st.nextToken());
				if(op==1) {	//add
					pq.add(Integer.parseInt(st.nextToken()));
					continue;
				}
				if(pq.isEmpty()) {
					sb.append("-1");
					continue;
				}
				sb.append(" ").append(pq.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}