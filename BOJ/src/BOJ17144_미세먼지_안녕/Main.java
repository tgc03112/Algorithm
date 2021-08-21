package BOJ17144_미세먼지_안녕;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int R,C,T;
	static int[][] map;
	static int[][] cmap;
	static boolean[][] v;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();	//세로 7
		C = sc.nextInt();	//가로 8
		T = sc.nextInt();	//초 1
		map = new int[R][C];
		cmap = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]=sc.nextInt();
			}
		}

//		System.out.println("map");	//출력확인
//		for(int i=0;i<R;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		for(int t=0;t<T;t++) {	//초 반복

			for(int i=0;i<map.length;i++) {	//2차원 배열 복사
				System.arraycopy(map[i], 0, cmap[i], 0, map[i].length);
			}
			
			for(int i=0;i<R;i++) {
				
			}

			
		}
		
	}

}
