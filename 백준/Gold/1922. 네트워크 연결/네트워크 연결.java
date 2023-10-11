import java.util.*;
import java.io.*;

class Graph implements Comparable<Graph>{
	//a와 b 연결
	int a;
	int b;
	//비용
	int weight;
	
	public Graph(int a, int b, int weight) {
		super();
		this.a = a;
		this.b = b;
		this.weight = weight;
	}

	@Override
	public int compareTo(Graph o) {
		//비용 오름차순
		return this.weight-o.weight;
	}
}
public class Main {
	static List<Graph> list;
	static int[] p; //루트노드
	
	public static int find(int a) {
		if(p[a] == a) {
			return a;
		}
		return p[a] = find(p[a]);
	}
	
	public static boolean union(int a, int b) {
		//루트노드 찾기
		int pa = find(a);
		int pb = find(b);
		
		//이미 같은 그룹일 경우
		if(pa==pb) {
			return false;
		}
		//다른 그룹이면 union
		p[pa] = pb;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //컴퓨터의 수 (노드) 
		int M = Integer.parseInt(br.readLine()); //선의 수 (간선)
		
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Graph(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		//비용 적은 순서대로 정렬
		Collections.sort(list);
		
		//make-set
		p = new int[N+1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		//크루스칼
		int cost = 0;
		for (int i = 0; i < list.size(); i++) {
			//사이클이 아닐 경우 연결하기
			if(union(list.get(i).a, list.get(i).b)) {
				cost += list.get(i).weight;
			}
		}
		System.out.println(cost);
	}

}
