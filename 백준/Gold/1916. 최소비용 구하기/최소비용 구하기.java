import java.util.*;
import java.io.*;

class Edge{
	int v;
	int w;
	
	public Edge(int v, int w) {
		super();
		this.v = v;
		this.w = w;
	}
}

public class Main {
	static ArrayList<ArrayList<Edge>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //도시 개수 (정점)
		int M = Integer.parseInt(br.readLine()); //버스 개수 (간선)
		
		list = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.get(Integer.parseInt(st.nextToken())).add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N+1]; //방문 배열
		int[] distance = new int[N+1]; //거리 배열
		//거리 초기화
		for (int i = 0; i <= N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		//시작 정점
		distance[start] = 0;
		//모든 정점 돌면 끝
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE; //현재 기준 가장 가중치 적은 간선
			int minV = 0; //가중치 적은 정점
			for (int j = 0; j <= N; j++) {
				//아직 방문하지 않았고 최솟값인 경우
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					minV = j;
				}
			}
			//방문처리
			visited[minV] = true;
			
			//인접 정점 탐색
			for(Edge e : list.get(minV)) {
				//선택된 노드 가중치 > 현재 노드 거쳐서 선택된 노드 가는 경우 비교
				if(distance[e.v] > distance[minV]+e.w) {
					distance[e.v] = distance[minV]+e.w;
				}
			}
			
		}
		System.out.println(distance[end]);
	}

}
