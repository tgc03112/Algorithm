package BOJ15683_감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,res,cCnt;
	static int[][] map;
	static CCTV[] cctvs;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][][] cDir = {
			{{0}},
			{{1}, {2}, {3}, {0}}, // 1번 cctv
            {{1, 3}, {0, 2}}, // 2번 cctv
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 cctv
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}}, // 4번 cctv
            {{0, 1, 2, 3}} // 5번 cctv
	};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];	//배열 저장
		cctvs = new CCTV[8];	//CCTV최대 8개
		res = 0;
		int remain = N * M;	//처음 모든 개수에서 -- 하면서 내려감
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>=1 && map[i][j]<=5) {	//CCTV인 경우
					cctvs[cCnt] = new CCTV(map[i][j], i, j);	//cctv배열에 담아줌
					cCnt++;
				}
				else if(map[i][j]==6) remain--;	//벽인경우
			}
		}
		
		res = Integer.MAX_VALUE;
		
		solve(0,remain-cCnt,map);	//0의 개수만 들어감
		
		System.out.println(res);
		
	}
	private static void solve(int idx, int remain, int[][] map) {
		
		//모든 cctv의 감시 영역 확인완료
		if(idx == cCnt) {
			res = Math.min(res, remain);	//사각지대의 최소 크기 갱신
			return;
		}
		
		int[][] cmap = new int[N][M];
		copymap(cmap, map);
		
		CCTV cctv = cctvs[idx];	//cctv한 개씩 꺼내서 확인
		
		//해당 CCTV가 90도씩 회전하면서 감시
		for(int i=0;i<cDir[cctv.type].length;i++) {
			int check = 0;
			//현재 상태에서 감시할 수 있는 방향
			for(int j=0;j<cDir[cctv.type][i].length;j++) {
				int d = cDir[cctv.type][i][j];
				check+=turn(cctv.r,cctv.c,d,cmap);
			}
			solve(idx+1,remain-check,cmap);
			copymap(cmap, map);
		}

	}
	private static int turn(int r, int c, int d, int[][] map) {
		
		int cnt = 0;
		
		while(true) {
			r += dx[d];
			c += dy[d];
			
			//범위를 벗어나거나 벽이있다면
			if(r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 6 ) {
				return cnt;
			}
			//다른 CCTV가 있거나 이미 감시된 영역인 경우 지나침
			if((map[r][c] >= 1 && map[r][c] <= 5) || map[r][c] == -1) continue;
			
			//빈칸인 경우
			map[r][c] = -1;
			cnt++;
		}
	}
	private static void copymap(int[][] cmap, int[][] map) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				cmap[i][j]=map[i][j];
			}
		}
	}
}
class CCTV{
	int type,r,c;
	public CCTV(int type, int r, int c) {
		this.type = type;
		this.r = r;
		this.c = c;
	}
}










