package SWEA4014_활주로_건설;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] map;
	static int N,X;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+t+" "+process());
			
		}
		
	}
	private static int process() {

		int count = 0;
		for (int i = 0; i < N; i++) {
			if(makeRoadByRow(i)) ++count;
			if(makeRoadByCol(i)) ++count;
		}
		
		return count;
	}
	private static boolean makeRoadByRow(int i) {	//활주로 건설 가능한지 여부

		int beforeHeight = map[i][0];
		int size = 0;	//연속된 동일높이
		int j = 0;	//탐색하는 열 위치
		
		while(j<N) {
			if(beforeHeight == map[i][j]) {	//연속 동일높이 증가 
				++size;
				++j;
			}
			else if(beforeHeight+1 == map[i][j]) {	//높이 1이 큰 오르막
				if(size<X)	return false;	//경사로 설치 불가
				beforeHeight++;
				size = 1;
				j++;
			}
			else if(beforeHeight-1 == map[i][j]) {	//내리막 경사 가능한지
				int count=0;
				for (int k = j; k < N; k++) {
					if(beforeHeight-1 != map[i][k]) {	//끊기는 상황 
						break;
					}
					if(++count==X) {
						break;
					}
				}
				if(count<X) return false;	//경사로 설치 불가
				beforeHeight--;
				size = 0;
				j+=X;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	private static boolean makeRoadByCol(int i) {
		int beforeHeight = map[0][i];
		int size = 0;	//연속된 동일높이
		int j = 0;	//탐색하는 열 위치
		
		while(j<N) {
			if(beforeHeight == map[j][i]) {	//연속 동일높이 증가 
				++size;
				++j;
			}
			else if(beforeHeight+1 == map[j][i]) {	//높이 1이 큰 오르막
				if(size<X)	return false;	//경사로 설치 불가
				beforeHeight++;
				size = 1;
				j++;
			}
			else if(beforeHeight-1 == map[j][i]) {	//내리막 경사 가능한지
				int count=0;
				for (int k = j; k < N; k++) {
					if(beforeHeight-1 != map[k][i]) {	//끊기는 상황 
						break;
					}
					if(++count==X) {
						break;
					}
				}
				if(count<X) return false;	//경사로 설치 불가
				beforeHeight--;
				size = 0;
				j+=X;
			}
			else {
				return false;
			}
		}
		return true;
	}
}