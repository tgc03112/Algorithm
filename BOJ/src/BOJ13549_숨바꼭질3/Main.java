package BOJ13549_숨바꼭질3;

/*
숨바꼭질 실버 문제와 비슷하게 풀었음 단지 다른 점은?

1. x2 로 하는 경우 즉, 순간이동 하는 경우 먼저 체크 해줘야됨
   ex) 수빈이가 1이고 동생이 2일 때 +1을 해서 1비용을 쓰는 것 보다 x2를 써서 비용이 없는 경우가 최소 비용이기 떄문에 x2먼저 해주는게 유리
2. 방문체크 배열 따로 만들어 줘야 됨, 처음에 방문체크 배열 따로 안 만들고 if문에서 hide[subin]==0 으로 조건을 줬는데
   처음 수빈이가 출발한 위치도 0이기 떄문에 방문 안한것으로 들어가서 틀렸습니다 나옴.
   
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static Queue<Integer> q;
	static int[] hide;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	//수빈
		K = Integer.parseInt(st.nextToken());	//동생
		
		hide = new int[100000+1];
		visited = new boolean[100000+1];
		
		bfs();
		
		System.out.println(hide[K]);
	}
	
	private static void bfs() {
		q = new LinkedList<Integer>();
		q.add(N);
		visited[N] = true;
		
		while(!q.isEmpty()) {
			int subin = q.poll();

			if(subin==K) {
				return;
			}

			if(subin*2<=100000 && !visited[subin*2]) {
				q.add(subin*2);
				visited[subin*2]=true;
				hide[subin*2] = hide[subin];
			}
			if(subin-1>=0 && !visited[subin-1]) {
				q.add(subin-1);
				visited[subin-1]=true;
				hide[subin-1] = hide[subin]+1;
			}
			if(subin+1<=100000 && !visited[subin+1]) {
				q.add(subin+1);
				visited[subin+1]=true;
				hide[subin+1] = hide[subin]+1;
			}
		}
	}
}








