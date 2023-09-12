import java.util.*;
import java.io.*;

class Room implements Comparable<Room>{
	int x; //행 좌표
	int y; //열 좌표
	int cnt; //벽 부순 개수
	
	Room(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	//벽 부신 개수 오름차순 정렬 (적게 부순 순서대로)
	@Override
	public int compareTo(Room o) {
		return this.cnt-o.cnt;
	}
}
public class Main {
	static int N, M; //행, 열
	static int[][] map; //미로
	static int result = Integer.MAX_VALUE; //결과
	static boolean[][] visited; //방문 여부 배열
	//상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static int bfs(int x, int y) {
		//벽 적게 부신 순서대로 이동하기 위한 우선순위 큐
		PriorityQueue<Room> q = new PriorityQueue<>();
		//시작 위치 방문 및 초기화
		visited[x][y] = true;
		q.add(new Room(x, y, 0));
		
		while(!q.isEmpty()) {
			Room room = q.remove();
			
			//도착 위치에 왔을 경우
			if(room.x==N && room.y==M) {
				return room.cnt;
			}
			//사방탐색
			for (int i = 0; i < 4; i++) {
				int nx = room.x+dx[i];
				int ny = room.y+dy[i];
				//범위 넘어가면 패스
				if(nx<1 || nx>N || ny<1 || ny>M) {
					continue;
				}
				//이동하려는 곳이 아직 방문 안헀을 경우
				if(!visited[nx][ny]) {
					//방문처리
					visited[nx][ny] = true;
					//지금까지 벽 부신 횟수+이동할 때 벽 부신 횟수
					q.add(new Room(nx, ny, room.cnt+map[nx][ny]));
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //열
		N = Integer.parseInt(st.nextToken()); //행
		
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		System.out.println(bfs(1,1));
	}

}
