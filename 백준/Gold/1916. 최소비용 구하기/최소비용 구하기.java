import java.util.*;
import java.io.*;

class Bus implements Comparable<Bus> {
	int index; //정점
	int w; //비용
	
	public Bus(int index, int w) {
		this.index = index;
		this.w = w;
	}
	
	@Override
	public int compareTo(Bus o) {
		return this.w - o.w; //오름차순 정렬
	}
}

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] distance;
	static int start, end;
	static boolean[] visited;
	
	static void dijkstra() {
		PriorityQueue<Bus> q = new PriorityQueue<>();
		distance[start] = 0; //시작 정점
		q.add(new Bus(start, 0));
		
		while(!q.isEmpty()) {
			Bus now = q.poll();
			
			if(visited[now.index]) { //이미 방문했을 경우 패스
				continue;
			}
			visited[now.index] = true; //방문 처리
			
			//연결된 도시 확인
			for(int i=1; i<=N; i++) {
				//연결된 경우만, 현재 거리보다 거쳐가는 거리가 더 짧을 경우
				if(arr[now.index][i]!=Integer.MAX_VALUE && distance[i] > distance[now.index]+arr[now.index][i]) {
					//비용 갱신
					distance[i] = distance[now.index]+arr[now.index][i];
					q.add(new Bus(i, distance[i]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); //도시의 개수
		M = Integer.parseInt(br.readLine()); //버스의 개수
		
		//인접 행렬로 다익스트라 구현
		arr = new int[N+1][N+1];
		//인접 행렬 값 초기화
		for(int i=0; i<=N; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}
		
		//버스 비용 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arr[a][b] = Math.min(arr[a][b], cost);
		}
		
		//시작, 도착 정점 입력
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		//거리 배열 초기화
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		//방문 배열 선언
		visited = new boolean[N+1];
		
		dijkstra();
		
		System.out.println(distance[end]);
	}

}
