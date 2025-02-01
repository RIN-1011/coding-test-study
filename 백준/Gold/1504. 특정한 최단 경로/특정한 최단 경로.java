import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
	int v; //도착 정점
	int w; //가중치
	
	Node(int v, int w) {
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.w - o.w; //오름차순 정렬
	}
}

public class Main {
	static int N, E;
	static ArrayList<ArrayList<Node>> graph;
	static int[] dist;
	static boolean[] visited;
	
	static int dijkstra(int start, int end) {
		//초기화
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[N+1];
		
		//우선순위 큐
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		
		//시작 정점
		dist[start] = 0;
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			//이미 방문한 정점이면 패스
			if(visited[now.v]) {
				continue;
			}
			visited[now.v] = true; //방문 처리
			
			//연결된 정점 체크
			for(Node next : graph.get(now.v)) {
				if(dist[next.v] > dist[now.v]+next.w) { //거쳐가는 경우가 더 짧으면
					dist[next.v] = dist[now.v]+next.w; //갱신
					q.add(new Node(next.v, dist[next.v])); //큐 삽입
				}
			}
		}
		
		return dist[end] == Integer.MAX_VALUE ? -1:dist[end]; //도달할 수 없는 경우 -1 반환
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		E = Integer.parseInt(st.nextToken()); //간선의 개수
		
		//초기화
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//경로 입력
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //시작 정점
			int b = Integer.parseInt(st.nextToken()); //도착 정점
			int c = Integer.parseInt(st.nextToken()); //거리
			
			//양방향 그래프 추가
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken()); //거쳐야 하는 정점 v1
		int v2 = Integer.parseInt(st.nextToken()); //거쳐야 하는 정점 v2
		
		int min = Integer.MAX_VALUE;
		
		//경로 계산
		int path1 = dijkstra(1, v1);
	    int path2 = dijkstra(v1, v2);
	    int path3 = dijkstra(v2, N);
	    int path4 = dijkstra(1, v2);
	    int path5 = path2;
	    int path6 = dijkstra(v1, N);

	    // 필수 정점 v1, v2 간 이동이 불가능하면 -1 출력
	    if (path2 == -1) {
	        System.out.println(-1);
	        return;
	    }
	    
	    //v1→v2를 거치는 두 가지 경로 계산
	    int route1 = (path1 == -1 || path3 == -1) ? Integer.MAX_VALUE : path1 + path2 + path3;
	    int route2 = (path4 == -1 || path6 == -1) ? Integer.MAX_VALUE : path4 + path5 + path6;

	    //도달할 수 없는 경우 -1 처리
	    int result = Math.min(route1, route2);
	    System.out.println(result == Integer.MAX_VALUE ? -1:result);
	}

}
