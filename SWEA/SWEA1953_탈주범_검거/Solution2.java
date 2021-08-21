package SWEA1953_탈주범_검거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.DocFlavor.STRING;

public class Solution2 {

	static int N,M,R,C,L;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1,0,0,1};	//상좌우하 
	static int[] dy = {0,-1,1,0};
	static String[] type = {
		null,
		"0312",	//1:상하좌우
		"03",	//2:상하
		"12",	//3:좌우
		"02",	//4:상우
		"32",	//5:하우
		"31",	//6:하좌
		"01"	//7:상좌
	};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//터널 세로
			M = Integer.parseInt(st.nextToken());	//터널 가로
			R = Integer.parseInt(st.nextToken());	//맨홀 세로
			C = Integer.parseInt(st.nextToken());	//맨홀 가로
			L = Integer.parseInt(st.nextToken());	//소요된 시간
			
			map = new int[N][M];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+t+" "+bfs());
		}
	}
	private static int bfs() {
		int result = 0, time = 1;
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new int[] {R,C});	//맨홀뚜껑 위치
		visited[R][C]=true;
		++result;
		
		while(time++<L) {	//L시간 만큼반복 
			int size = queue.size();	
			while(size-->0) {	//동시간대 처리
				int[] current = queue.poll();
				int r = current[0];
				int c = current[1];
				String info = type[map[r][c]];	//번호를 배열에서 찾음 
				
				for(int d=0,length = info.length();d<length;d++) {
					int dir = info.charAt(d)-'0';	//방향 뽑아오기
					int nr = r+dx[dir];
					int nc = c+dy[dir];
					if(nr>=0 && nc>=0 && nr<N && nc<M 
							&& map[nr][nc]>0 
							&& type[map[nr][nc]].contains(Integer.toString(3-dir)) 	//나랑 연결될 수 있는 상대 구조물인지 확인
							&& !visited[nr][nc] ) {	//경계체크,터널이있는지,방문체크
						queue.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
						++result;
						}
					}
				}
			}
		return result;
	}
}












