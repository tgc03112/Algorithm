package BOJ2564_경비원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());	//가로
		int Y = Integer.parseInt(st.nextToken());	//세로
		
		int N = Integer.parseInt(br.readLine());	//상점 수
		
		int[][] store = new int[N][2];	//상점 저장 
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());	//상점 위치들
			for(int j=0;j<2;j++) {
				store[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int dong = Integer.parseInt(st.nextToken());	//동근이 동서남북
		int dongX = Integer.parseInt(st.nextToken());	//동근이 거리 
		
		int sum = 0;
		
		switch(dong) {
		case 1:	//북
			for(int i=0;i<N;i++) {
				if(store[i][0]==1) {
					sum+=Math.abs(dongX-store[i][1]);
				}
				else if(store[i][0]==2) {
					sum+=Y+Math.min(dongX+store[i][1], (X-dongX)+(X-store[i][1]));
				}
				else if (store[i][0]==3) {
					sum+=dongX+store[i][1];
				}
				else if (store[i][0]==4) {
					sum+=(X-dongX)+store[i][1];
				}
			}
			break;
		case 2:	//남
			for(int i=0;i<N;i++) {
				if(store[i][0]==1) {
					sum+=Y+Math.min(dongX+store[i][1], (X-dongX)+(X-store[i][1]));
				}
				else if(store[i][0]==2) {
					sum+=Math.abs(dongX-store[i][1]);
				}
				else if (store[i][0]==3) {
					sum+=dongX+(Y-store[i][1]);
				}
				else if (store[i][0]==4) {
					sum+=(X-dongX)+(Y-store[i][1]);
				}
			}
			break;
		case 3:	//서
			for(int i=0;i<N;i++) {
				if(store[i][0]==1) {
					sum+=dongX+store[i][1];
				}
				else if(store[i][0]==2) {
					sum+=(Y-dongX)+store[i][1];
				}
				else if (store[i][0]==3) {
					sum+=Math.abs(dongX-store[i][1]);
				}
				else if (store[i][0]==4) {
					sum+=X+Math.min(dongX+store[i][1],(Y-dongX)+(Y-store[i][1]));
				}
			}
			break;
		case 4:	//동
			for(int i=0;i<N;i++) {
				if(store[i][0]==1) {
					sum+=(X-store[i][1])+dongX;
				}
				else if(store[i][0]==2) {
					sum+=(X-store[i][1])+(Y-dongX);
				}
				else if (store[i][0]==3) {
					sum+=X+Math.min(dongX+store[i][1],(Y-dongX)+(Y-store[i][1]));
				}
				else if (store[i][0]==4) {
					sum+=Math.abs(dongX-store[i][1]);
				}
			}
			break;
		}
			System.out.println(sum);
	}
}