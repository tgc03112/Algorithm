package BOJ12865_평범한_배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//물건 수
		int K = Integer.parseInt(st.nextToken());	//최대 무게
		
		int[][] arr = new int[N+1][2];
		int[][] map = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i][0]=a;
			arr[i][1]=b;
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(arr[i][0] > j) {	//물건을 담을 수 없을 때
					map[i][j]=map[i-1][j];
				} 
				else {	//물건을 담을 수 있을 때,둘 중 큰 값으로
					map[i][j]=Math.max(map[i-1][j], arr[i][1]+map[i-1][j-arr[i][0]]);
				}
			}
		}
		System.out.println(map[N][K]);		
	}
}