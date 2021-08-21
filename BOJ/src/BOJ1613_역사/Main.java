package BOJ1613_역사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//개수
		int K = Integer.parseInt(st.nextToken());	//반복문
		
		int[][] map = new int[N+1][N+1];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[from][to] = 1;	
		}
		
		for(int k=1;k<=N;k++) {	//경
			for(int i=1;i<=N;i++) {	//출
				for(int j=1;j<=N;j++) {	//도
					if(map[i][k]==1 && map[k][j]==1) {
						map[i][j]=1;
					}
				}
			}
		}
		int S = Integer.parseInt(br.readLine());
		
		for(int i=0;i<S;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(map[start][end] == map[end][start]) {	//모른다
				System.out.println("0");
			}
			else if(map[start][end]==1){	//1이면 start->end 가능 (start가 앞선 경우)
				System.out.println("-1");
			}
			else {
				System.out.println("1");
			}
		}
	}
}
