package BOJ1717_집합의_표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			arr[i]=i;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//합집합연산
			if(type==0) {
				union(a,b);
			}
			//두 원소가 같은 집합에 포함되어 있는지 확인
			else {
				//같은 집합에 있다면
				if(find(a)==find(b)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
	}
	
	private static void union(int a, int b) {
		//루트노드 찾아서 부모 변경
		a = find(a);
		b = find(b);
		arr[b] = a;
	}
	
	private static int find(int a) {
		if(arr[a] == a) {
			return a;
		}
		//루트 노드를 부모노드로 만들어줌
		return arr[a] = find(arr[a]);
	}
}