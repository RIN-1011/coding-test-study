import java.util.*;
import java.io.*;

//[S/W 문제해결 기본] 10일차 - Contact
public class Solution {
	static ArrayList<ArrayList<Integer>> graph;
	static int visited[]; //방문 처리 배열
	static int result; //번호 큰 값
	static int maxDepth; //가장 깊은 깊이
	
	public static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start); //시작 노드 삽입
		visited[start] = 1; //초기 깊이 1
		
		while(!q.isEmpty()) {
			int p = q.remove();
			int max = 0; //같은 단계 최대값
			
			//p와 인접한 노드 모두 탐색 (같은 단계)
			for (int i = 0; i < graph.get(p).size(); i++) {
				//아직 방문 안했을 경우
				if(visited[graph.get(p).get(i)] == 0) {
					//큐 삽입
					q.add(graph.get(p).get(i));
					visited[graph.get(p).get(i)] = visited[p]+1; //방문처리 (이전 노드보다 깊이+1)
					maxDepth = Math.max(maxDepth, visited[graph.get(p).get(i)]); //가장 깊은 깊이 저장
				}
			}
		}
		//깊이 저장된 방문 배열 탐색
		for (int i = 0; i < visited.length; i++) {
			//가장 깊은 깊이인 노드 있을 경우
			if(visited[i] == maxDepth) {
				//가장 큰 번호로 갱신
				result = Math.max(result, i);
			}
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()); //데이터의 길이
			int start = Integer.parseInt(st.nextToken()); //시작점
			
			//초기화
			graph = new ArrayList<ArrayList<Integer>>();
			//부여될 수 있는 번호 최대 100이므로 그래프 크기 101로 선언
			for (int i = 0; i < 101; i++) {
				graph.add(new ArrayList<Integer>());
			}
			visited = new int[101]; //부여될 수 있는 번호 최대 100이므로 방문 처리 배열 크기 101로 선언
			result = Integer.MIN_VALUE;
			maxDepth = 1;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L/2; i++) {
				int a = Integer.parseInt(st.nextToken()); //from
				int b = Integer.parseInt(st.nextToken()); //to
				graph.get(a).add(b); //방향 인접 리스트
			}
			
			sb.append("#"+t+" "+bfs(start)+"\n");
		}
		System.out.println(sb);
	}

}
