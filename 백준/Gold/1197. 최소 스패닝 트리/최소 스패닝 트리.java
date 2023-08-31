import java.util.*;
import java.io.*;

//최소 스패닝 트리
class Node implements Comparable<Node>{
	int from;
	int to;
	int weight;
	
	public Node(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	//가중치 오름차순 정렬
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.weight, o.weight);
	}
}
public class Main {
	static int[] parent; //부모 정점
	
	public static boolean union(int a, int b) {
		int pa = find(a); //a 루트노드 찾기
		int pb = find(b); //b 루트노드 찾기
		
		//서로 루트 노드가 같지 않을 경우 연결되어있지 않다는 의미(사이클X)
		if(pa != pb) {
			parent[pb] = pa; //가장 최상단 노드(=루트)를 union 해주어야 함!
			return true;
		}
		return false;
	}
	public static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]); //경로 압축
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); //정점의 개수
		int E = Integer.parseInt(st.nextToken()); //간선의 개수
		
		//루트 노드
		parent = new int[V+1];
		for (int i = 1; i < V+1; i++) {
			parent[i] = i; //루트 노드 본인으로 초기화
		}
				
		Node[] graph = new Node[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[i] = new Node(a, b, c); //가중치 적은 순으로 삽입됨
		}
		//가중치 오름차순 정렬
		Arrays.sort(graph);
		
		long result = 0; //최소 스패닝 트리 가중치
		for (int i = 0; i < E; i++) {
			Node node = graph[i]; //가중치 적은 노드부터 꺼내기
			if(union(node.from,node.to)) { //두 노드 union
				result += node.weight; //가중치 더해주기
			}
		}
		System.out.println(result);
	}

}