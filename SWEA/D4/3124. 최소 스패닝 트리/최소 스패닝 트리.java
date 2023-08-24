import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{ //간선 정보
	int from; //출발
	int to; //도착
	int weight; //간선 비용
	
	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight); //오름차순 정렬
	}
}

//최소 스패닝 트리
public class Solution {
	static Edge[] edgeList;
	static int V, E;
	static int[] parents;
	
	static void make() {
		for (int i = 0; i < V+1; i++) {
			parents[i] = i;
		}
	}
	static int find(int a) { //루트 노드 찾기
		if(parents[a] == a) return a; //자기 자신일 경우 반환
		return parents[a] = find(parents[a]); //경로 압축
	}
	static boolean union(int a, int b) { //집합 합치기
		//정점 a, b 루트 노드 찾기
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; //이미 같은 집합일 경우 (싸이클 발생 의미로 해석)
		parents[bRoot] = aRoot; //원소 b의 루트 노드를 루트 a로 변경
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); //정점의 개수
			E = Integer.parseInt(st.nextToken()); //간선의 개수
			
			//초기화
			edgeList = new Edge[E];
			parents = new int[V+1];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken()); //A 정점
				int B = Integer.parseInt(st.nextToken()); //B 정점
				int C = Integer.parseInt(st.nextToken()); //가중치 C인 간선
				
				edgeList[i] = new Edge(A, B, C); //간선 정보 등록
			}
			
			//간선리스트를 가중치 기준으로 오름차순 정렬
			Arrays.sort(edgeList);
			
			//V개의 정점으로 make set 작업 (정점 초기화)
			make();
			
			long result = 0; //MST 비용
			int count = 0; //연결된 간선 개수
			for (Edge edge : edgeList) { //주어진 간선 이어보면서
				if(union(edge.from, edge.to)) { //싸이클 형성 안될 경우
					//해당 간선 사용
					result += edge.weight;
					//정점-1 개의 간선이 이어졌다면 MST 완료
					if(++count == V-1) {
						break;
					}
				}
			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb);
	}

}
