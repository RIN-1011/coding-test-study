import java.util.*;
import java.io.*;

class Move {
	int i;
	int j;
	int cnt; //이동 거리
	boolean wall; //벽 부쉈는지 체크
	
	Move(int i, int j, int cnt, boolean wall){
		this.i = i;
		this.j = j;
		this.cnt = cnt;
		this.wall = wall;
	}
}
public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	//상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result;
	
	static void bfs() {
		Queue<Move> q = new LinkedList<>();
		//시작점
		q.add(new Move(0, 0, 1, false));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Move now = q.poll();
			
			//도착했을 경우 결과 갱신
			if(now.i==N-1 && now.j==M-1) {
				result = now.cnt;
				break;
			}
			
			//상하좌우 탐색
			for(int k=0; k<4; k++) {
				int x = now.i+dx[k];
				int y = now.j+dy[k];
				
				//범위 벗어날 경우 패스
				if(x<0 || x>=N || y<0 || y>=M) {
					continue;
				}
				//벽이 아닐 경우
				if(map[x][y]==0) {
					//벽을 부순 적 없는 경우
					if(!now.wall && !visited[x][y][0]) {
						q.add(new Move(x, y, now.cnt+1, false));
						visited[x][y][0] = true;
					}
					
					//벽을 부순 적 있는 경우
					else if(now.wall && !visited[x][y][1]) {
						q.add(new Move(x, y, now.cnt+1, true));
						visited[x][y][1] = true;
					}
				}
				//벽일 경우
				else if(map[x][y]==1) {
					//벽을 부순 적 없는 경우
					if(!now.wall) {
						q.add(new Move(x, y, now.cnt+1, true));
						visited[x][y][1] = true;
					}
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		
		//맵 입력 받기
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = (int)(str.charAt(j)-'0');
			}
		}
		
		visited = new boolean[N][M][2];
		result = Integer.MAX_VALUE;
		bfs();
		
		System.out.println(result==Integer.MAX_VALUE ? -1:result);

	}

}
