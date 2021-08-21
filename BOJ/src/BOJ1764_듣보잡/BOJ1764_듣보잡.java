package BOJ1764_듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1764_듣보잡 {	//듣보잡

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<String>();
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		for(int i=0;i<K;i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				list.add(str);
			}
		}
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}