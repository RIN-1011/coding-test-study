import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
	int v; //도착 정점
	int w; //가중치
	
	public Edge(int v, int w) {
		super();
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int compareTo(Edge o) {
		//가중치 오름차순 정렬
		return this.w - o.w;
	}
}
public class Main {
	static ArrayList<ArrayList<Edge>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //컴퓨터의 수(정점)
		int M = Integer.parseInt(br.readLine()); //선의 수(간선)
		
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			//양방향 연결
			list.get(a).add(new Edge(b, c));
			list.get(b).add(new Edge(a, c));
		}
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		boolean visited[] = new boolean[N+1];
		int result = 0; //최소비용
		
		//시작 정점
		q.add(new Edge(1, 0));
		
		int cnt = 0; //처리한 간선 수
		while(!q.isEmpty()) {
			Edge e = q.remove();
			//아직 방문하지 않았으면 탐색
			if(!visited[e.v]) {
				visited[e.v] = true; //방문처리
				result += e.w;
				
				for (Edge edge : list.get(e.v)) {
					//아직 방문하지 않았다면 큐에 삽입
					if(!visited[edge.v]) {
						q.add(edge);
					}
				}
			}
		}
		
		System.out.println(result);
	}

}
