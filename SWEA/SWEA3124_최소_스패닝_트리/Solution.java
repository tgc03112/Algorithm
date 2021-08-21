package SWEA3124_최소_스패닝_트리;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {	//d4_3124_최소스패닝트리_MST3_PrimPQListTest
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String args[]) throws Exception{
//		System.setIn(new FileInputStream("res/input_d4_3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();	
		int T=Integer.parseInt(br.readLine());	

		for(int tc=1; tc<=T; tc++){	
			StringTokenizer st = new StringTokenizer(br.readLine()," ");	 
			int V = Integer.parseInt(st.nextToken());	
			int E = Integer.parseInt(st.nextToken());	
			
			//int[][] adjMatrix = new int[V][V];
			List<Edge>[] adjList=new ArrayList[V];
			for (int i = 0; i < V; i++) {	
				adjList[i] = new ArrayList<Edge>();
			}
			boolean[] visited = new boolean[V];
			long[] minEdge = new long[V];				
			for (int i = 0; i < V; i++) {	
				minEdge[i] = Long.MAX_VALUE;			
			}
			
			for (int i = 0; i < E; i++) {						
				st = new StringTokenizer(br.readLine()," ");	
				int from = Integer.parseInt(st.nextToken())-1;	
				int to = Integer.parseInt(st.nextToken())-1;	
				int weight = Integer.parseInt(st.nextToken());	
				//adjMatrix[from][to] = weight;					
				//adjMatrix[to][from] = weight;
				adjList[from].add(new Edge(from,to,weight));
				adjList[to].add(new Edge(to,from,weight));
			}
			
			long result = 0;	
			minEdge[0] = 0;
			
//			PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
			
//			PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(new Comparator<Vertex>() {
//				@Override
//				public int compare(Vertex o1, Vertex o2) {	//오름차순 정렬
//					return Long.compare(o1.cost, o2.cost);
//				}
//			});
			
//			PriorityQueue<Vertex> queue = new PriorityQueue<>(( o1,  o2)->{
//					return Long.compare(o1.cost, o2.cost);
//			});
			
			PriorityQueue<Vertex> queue = new PriorityQueue<>(( o1,  o2)->Long.compare(o1.cost, o2.cost));
			
			queue.offer(new Vertex(0, minEdge[0]));
			int cnt = 0; // 정점 개수
			
			while(!queue.isEmpty()) {			
				Vertex minVertex = queue.poll();
				if(visited[minVertex.no]) continue;
				
				result += minVertex.cost;
				visited[minVertex.no] = true;
				if(++cnt == V) break;
				
				//for (int i = 0; i < V; i++) {
				//	if(!visited[i] && adjMatrix[minVertex.no][i] != 0 && 
				//			minEdge[i] > adjMatrix[minVertex.no][i]) {
				//		    minEdge[i] = adjMatrix[minVertex.no][i];
				//		    queue.offer(new Vertex(i,minEdge[i]));
				//	}
				//}
				for (Edge edge:adjList[minVertex.no]) {
					if(!visited[edge.to] && edge.weight != 0 && 
							minEdge[edge.to] > edge.weight) {
						    minEdge[edge.to] = edge.weight;
						    queue.offer(new Vertex(edge.to,minEdge[edge.to]));
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");	
		}
		System.out.print(sb.toString());	
		br.close();	
	}
	static class Vertex /*implements Comparable<Vertex>*/{
		int no;
		long cost;
		
		public Vertex(int no, long cost) {
			this.no = no;
			this.cost = cost;
		}

//		@Override
//		public int compareTo(Vertex o) {
//			return Long.compare(this.cost, o.cost);
//		}
	}
}
