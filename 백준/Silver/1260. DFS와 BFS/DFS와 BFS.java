import java.util.*;
import java.io.*;

public class Main {
	static LinkedList<Integer>[] graph;
	static StringBuilder sb;
	static boolean visited[];
	
	static void dfs(int v) {
		sb.append(v+" "); //결과
		visited[v] = true; //방문 체크
		
		//현재 방문한 정점과 연결된 정점 확인
		for(int n : graph[v]) {
			if(!visited[n]) { //아직 방문 안했을 경우
				dfs(n); //방문
			}
		}
	}
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v); //시작 정점
		visited[v] = true; //방문 체크
		
		while(!q.isEmpty()) { //큐가 비어있지 않을 때까지
			int n = q.remove(); //기준 정점
			sb.append(n+" ");
			
			//현재 방문한 정점과 연결된 정점 확인
			for(int m : graph[n]) {
				if(!visited[m]) { //아직 방문 안했을 경우
					q.add(m); //큐 삽입
					visited[m] = true; //방문 체크
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수
		int V = Integer.parseInt(st.nextToken()); //정점의 번호
		
		//그래프 초기화
		graph = new LinkedList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new LinkedList<>();
		}
		//간선 정보
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		//오름차순 정렬
		for(int i=0; i<N+1; i++) {
			Collections.sort(graph[i]);
		}
		
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
	}

}
