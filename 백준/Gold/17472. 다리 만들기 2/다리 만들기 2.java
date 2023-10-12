import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
	int a;
	int b;
	int w;
	
	public Edge(int a, int b, int w) {
		super();
		this.a = a;
		this.b = b;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		//가중치 오름차순 정렬
		return this.w - o.w;
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	//상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int V; //전체 섬 개수 (정점)
	static ArrayList<Edge> list = new ArrayList<>();
	static int[] p;
	static int result = 0; //최솟값
	
	//섬 구분해주기
	public static void division() {
		boolean[][] visited = new boolean[N][M]; //방문배열
		V = 1; //구별 인덱스
		Queue<int[]> q;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//아직 방문하지 않았고 섬이라면 bfs
				if(!visited[i][j] && map[i][j]==1) {
					q = new ArrayDeque<>();
					q.add(new int[] {i, j});
					//방문처리
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						int[] p = q.remove();
						int x = p[0];
						int y = p[1];
						
						map[x][y] = V;
						
						//상하좌우 인접 섬 탐색
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							//범위 벗어나거나 이미 방문했을 경우 패스
							if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]) {
								continue;
							}
							//인접한 섬일 경우 큐 삽입
							if(map[nx][ny]==1) {
								 q.add(new int[] {nx, ny});
								 visited[nx][ny] = true;
							}
						}
					}
					V++;
				}
			}
		}
	}
	
	//연결 가능한 길 찾기
	public static void findPath(int i, int j, int idx) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		
		for (int k = 0; k < 4; k++) {
			//시작점
			q.add(new int[] {i, j, 0}); //좌표, 가중치
			visited[i][j] = true; //방문 처리
			
			//가로, 세로 방향으로 직진 이동
			while(!q.isEmpty()) {
				int[] p = q.remove();
				int x = p[0];
				int y = p[1];
				int cnt = p[2]; //가중치
				
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				//범위 벗어나거나 같은 섬일 경우 멈춤
				if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny]==idx) {
					break;
				}
				//다른 섬일 경우
				else if(map[nx][ny]!=0) {
					//길이가 2 미만일 경우 틀린 방법
					if(cnt<2) {
						break;
					}
					else {
						//그래프 등록(시작 섬, 도착 섬, 가중치)
						list.add(new Edge(idx, map[nx][ny], cnt));
					}
				}
				//바다일 경우 계속 직진
				else if(map[nx][ny]==0) {
					q.add(new int[] {nx, ny, cnt+1});
				}
			}
		}
	}
	
	//크루스칼
	public static int find(int a) {
		if(p[a] == a) {
			return a;
		}
		return p[a] = find(p[a]);
	}
	public static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		//이미 같은 그룹인 경우
		if(pa==pb) {
			return false;
		}
		
		if(pa <= pb) {
			p[pb] = pa;
		}
		else {
			p[pa] = pb;
		}
		return true;
	}
	
	public static void mst() {
		//가중치 오름차순 정렬
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			if(union(list.get(i).a, list.get(i).b)) {
				result += list.get(i).w;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //행
		M = Integer.parseInt(st.nextToken()); //열
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//섬 구별
		division();
		V -= 1;
		
		//연결 가능한 길 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				findPath(i, j, map[i][j]);				
			}
		}
		
		//최소 길이 찾기 (MST)
		//make-set
		p = new int[V+1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		mst();
		
		//모든 섬 연결되었는지 체크
		for (int i = 1; i <= V; i++) {
			find(i);
		}
		
		int check = p[1];
		int c;
		for (c = 2; c <= V; c++) {
			if(p[c]!=check) {
				break;
			}
		}
		
		//모든 섬 연결되었을 경우
		if(c==V+1) {
			System.out.println(result);			
		}
		else {
			System.out.println(-1);
		}
	}

}
