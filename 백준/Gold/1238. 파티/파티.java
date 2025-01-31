import java.util.*;
import java.io.*;

class Road implements Comparable<Road>{
	int v; //도착 도시
	int w; //시간
	
	Road(int v, int w){
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int compareTo(Road o) {
		return this.w - o.w; //시간 오름차순 정렬
	}
}

public class Main {
	static int N, M, X;
	static boolean[] visited;
	
	static int[] dijkstra(ArrayList<ArrayList<Road>> graph, int[] dist) {
		PriorityQueue<Road> q = new PriorityQueue<>();
		dist[X] = 0;
		q.add(new Road(X, 0));
		
		while(!q.isEmpty()) {
			Road now = q.poll();
			
			//이미 방문한 경우 패스
			if(visited[now.v]) {
				continue;
			}
			
			visited[now.v] = true; //방문처리
			
			//연결된 마을 체크
			for(Road next : graph.get(now.v)) {
				//현재 노드를 거쳐 가는게 더 짧을 경우
				if(dist[next.v] > dist[now.v]+next.w) {
					dist[next.v] = dist[now.v]+next.w; //시간 갱신
					q.add(new Road(next.v, dist[next.v])); //큐 삽입
				}
			}
		}
		
		return dist;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //학생 수
		M = Integer.parseInt(st.nextToken()); //도로 수
		X = Integer.parseInt(st.nextToken()); //파티할 마을
		
		ArrayList<ArrayList<Road>> graph; //정방향 그래프 X->N 구하기 위해
		ArrayList<ArrayList<Road>> reGraph; //역방향 그래프 N->X 구하기 위해
		int[] dist; //정방향 시간
		int[] reDist; //역방향 시간
		
		//초기화
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		reGraph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			reGraph.add(new ArrayList<>());
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		reDist = new int[N+1];
		Arrays.fill(reDist, Integer.MAX_VALUE);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //도시 A
			int b = Integer.parseInt(st.nextToken()); //도시 B
			int t = Integer.parseInt(st.nextToken()); //소비 시간
			
			graph.get(a).add(new Road(b, t));
			reGraph.get(b).add(new Road(a, t)); //역방향 그래프
		}
		
		visited = new boolean[N+1];
		dist = dijkstra(graph, dist);
		visited = new boolean[N+1];
		reDist = dijkstra(reGraph, reDist);
		
		//최대 시간 계산
		int max = 0;
		//1부터 N까지
		for(int i=1; i<=N; i++) {
			max = Math.max(max, dist[i]+reDist[i]);
		}
		
		System.out.println(max);
	}

}
