package SWEA5643_키순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int max = 9999;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++) {
			int N = Integer.parseInt(br.readLine());	//사람 수
			int M = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			int res = 0;
			for(int i=0;i<N;i++) {
				Arrays.fill(map[i], max);
			}
			for(int i=0;i<M;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				map[from][to] = 1;
			}
			for(int i=0;i<N;i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			for(int k=0;k<N;k++) {	//경
				for(int i=0;i<N;i++) {	//출
					for(int j=0;j<N;j++) {	//도
						if(j==i || j==k || k==i)  continue;
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
					}
				}
			}
			System.out.println("------------------");
			for(int i=0;i<N;i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			for(int i=0;i<N;i++) {
				boolean flag = true;
				for(int j=0;j<N;j++) {
					if(i==j || map[i][j]!=max || map[j][i]!=max) continue;
					flag = false;
					break;
				}
				if(flag) {	//무한값이 없다
					res++;
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
}







