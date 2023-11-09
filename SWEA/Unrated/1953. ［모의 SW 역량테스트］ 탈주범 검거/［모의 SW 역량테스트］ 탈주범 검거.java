import java.util.*;
import java.io.*;

class Point {
	int x;
	int y;
	int depth;
	
	public Point(int x, int y, int depth) {
		super();
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}

public class Solution {
	static int N, M, R, C, L;
	static int map[][];
	//상우하좌
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	//종류별 터널 뚫렸는지 여부
	static int[][] isMovable = {
			{0, 0, 0, 0},
			{1, 1, 1, 1},
			{1, 0, 1, 0},
			{0, 1, 0, 1},
			{1, 1, 0, 0},
			{0, 1, 1, 0},
			{0, 0, 1, 1},
			{1, 0, 0, 1}
	};
	
	static boolean[][] visited; //방문배열
	static int result; //결과
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new ArrayDeque<>();
		//시작 (한시간)
		visited[x][y] = true;
		q.add(new Point(x, y, 1));
		result+=1;
		
		while(!q.isEmpty()) {
			Point p = q.remove();
			
			//더 들어가면 시간 초과
			if(p.depth>=L) {
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				//현재 터널이 뚫려있지 않은 방향은 패스
				if(isMovable[map[p.x][p.y]][i]==0) continue;

				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				//범위 벗어나면 패스
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				//이동하려는 칸 터널 없는 경우 패스
				if(map[nx][ny]==0) continue;
				//이미 방문했으면 패스
				if(visited[nx][ny]) continue;
				
				//터널이 서로 뚫려있는 경우 (이동 가능)
				if(isMovable[map[nx][ny]][(i+2)%4]==1) {
					visited[nx][ny] = true; //방문 체크
					q.add(new Point(nx, ny, p.depth+1));
					result+=1; //탈주범 위치 카운트 증가
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테케 개수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //세로
			M = Integer.parseInt(st.nextToken()); //가로
			R = Integer.parseInt(st.nextToken()); //맨홀 세로 위치
			C = Integer.parseInt(st.nextToken()); //맨홀 가로 위치
			L = Integer.parseInt(st.nextToken()); //탈출 후 소요된 시간
			
			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = 0;
			bfs(R, C);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		
	}

}
