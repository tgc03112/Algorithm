package SWEA5644_무선_충전;

import java.util.Scanner;

public class Solution {

	static int[][] map;
	static int[] A;	//A의 이동정보
	static int[] B;	//B의 이동정보
	static int[] dpA;
	static int[] dpB;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			int M = sc.nextInt();	//이동 시간(M)
			int BC = sc.nextInt();	//BC의 개수(A)
			
			map = new int[10+1][10+1];
			
			A = new int[M];	//이동 정보 저장
			B = new int[M];
			
			dpA = new int[M+1];	//충전양 저장
			dpB = new int[M+1];
			
			for(int i=0;i<M;i++) {
				A[i] = sc.nextInt();
			}
			for(int i=0;i<M;i++) {
				B[i] = sc.nextInt();
			}

			
			
		}
	}

}
