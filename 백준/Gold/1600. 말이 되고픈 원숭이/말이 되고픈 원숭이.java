import java.util.*;
import java.io.*;

class Point {
	int x;
	int y;
	int dep; //이동 횟수
	int cnt; //말처럼 이동하는 횟수
	
	public Point(int x, int y, int dep, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.dep = dep;
		this.cnt = cnt;
	}
}
public class Main {
	static int K, W, H;
	static int[][] map;
	//말 이동방식
	static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hy = {-1, 1, -2, 2, -2, 2, -1, 1};
	//원숭이 이동방식
	static int[] mx = {-1, 1, 0, 0};
	static int[] my = {0, 0, -1, 1};
	//방문 배열 (x, y, k번 이동한 횟수) : 원숭이 또는 말 이동에 따른 방문 구별
	static boolean visited[][][];
	//최소 동작 수
	static int min = Integer.MAX_VALUE;
	
	public static void algorithm() {
		Queue<Point> q = new ArrayDeque<>();
		//시작점
		q.add(new Point(0, 0, 0, K));
		visited[0][0][K] = true;
		
		while(!q.isEmpty()) {
			Point p = q.remove();
			
			//도착 지점 도착하면 최솟값 갱신
			if(p.x == H-1 && p.y == W-1) {
				min = Math.min(min, p.dep);
			}
			
			//원숭이 이동, 말 이동(남아있을 경우) 모두 시도해보기
			//원숭이 이동
			for (int i = 0; i < 4; i++) {
				int nx = p.x + mx[i];
				int ny = p.y + my[i];
				
				//범위 벗어나면 패스
				if(nx<0 || nx>=H || ny<0 || ny>=W) {
					continue;
				}
				//장애물 있거나 이미 방문한 경우 패스
				if(map[nx][ny]==1 || visited[nx][ny][p.cnt]==true) {
					continue;
				}
				
				visited[nx][ny][p.cnt] = true; //방문처리
				q.add(new Point(nx, ny, p.dep+1, p.cnt));
			}
			
			//말처럼 이동하는 횟수가 아직 남아있을 경우
			//말 이동
			if(p.cnt > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = p.x + hx[i];
					int ny = p.y + hy[i];
					
					//범위 벗어나면 패스
					if(nx<0 || nx>=H || ny<0 || ny>=W) {
						continue;
					}
					//장애물 있거나 이미 방문한 경우 패스
					if(map[nx][ny]==1 || visited[nx][ny][p.cnt-1]==true) {
						continue;
					}
					
					visited[nx][ny][p.cnt-1] = true; //방문처리
					//말처럼 이동하는 횟수 감소
					q.add(new Point(nx, ny, p.dep+1, p.cnt-1));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine()); //말처럼 움직일 수 있는 횟수
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); //열
		H = Integer.parseInt(st.nextToken()); //행
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		algorithm();
		
		//갈 수 없는 경우
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}

}
