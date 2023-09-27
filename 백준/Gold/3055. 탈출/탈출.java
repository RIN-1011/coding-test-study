import java.io.*;
import java.util.*;

class Point {
	int x; //현재 행 좌표
	int y; //현재 열 좌표
	int time; //소요 시간
	
	public Point(int x, int y, int time) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class Main {
	static int R, C; //행, 열
	static char[][] map; //지도
	//상하좌우
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int result = Integer.MAX_VALUE; //가장 빠른 이동 시간
	static Queue<int[]> floodQ = new ArrayDeque<>(); //물 위치
	static Queue<Point> q = new ArrayDeque<>(); //고슴도치 위치
	
	//홍수
	public static void flood(){
		//매 분마다 물이 상하좌우 비어있는 칸으로 한 칸씩 이동하므로 큐 사이즈만큼만 반복해야 함
		int len = floodQ.size();
		for (int i = 0; i < len; i++) {
			int[] water = floodQ.poll();
			
			//상하좌우 물 채우기
			for (int j = 0; j < 4; j++) {
				int nx = water[0] + dx[j];
				int ny = water[1] + dy[j];
				//범위 안에 있고 물 이동 가능할 경우
				if(nx>=0 && nx<R && ny>=0 && ny<C) {
					if(map[nx][ny]=='.') {
						//물 채우기
						map[nx][ny] = '*';
						//새로운 물 좌표 큐 삽입
						floodQ.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
	
	public static void move() {
		//고슴도치가 상하좌우로 이동하면서 동시에 시간도 1초 증가하므로 큐 사이즈만큼만 반복해야 함
		int len = q.size();
		for (int i = 0; i < len; i++) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int time = p.time;
			
			//고슴도치 상하좌우 이동
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				
				//범위 안에 있고
				if(nx>=0 && nx<R && ny>=0 && ny<C) {
					//비버 굴에 도착했을 경우
					if(map[nx][ny]=='D') {
						//최소 이동 시간 갱신
						result = Math.min(result, time+1);
						return;
					}
					//이동할 수 있는 경우
					else if(map[nx][ny]=='.'){
						map[nx][ny] = 'S';
						q.add(new Point(nx, ny, time+1));
					}
				}
			}
		}
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			//물 채우기
			flood();
			//고슴도치 이동
			move();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //행
		C = Integer.parseInt(st.nextToken()); //열
		
		map = new char[R][C]; //티떱숲 지도
		int x=0, y=0; //초기 고슴도치 위치
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				
				//고슴도치 시작 위치 큐에 삽입
				if(map[i][j]=='S') {
					q.add(new Point(i, j, 0));
				}
				//물 차있을 경우 큐에 삽입
				else if(map[i][j]=='*') {
					floodQ.add(new int[] {i, j});
				}
			}
		}
		
		bfs();
		
		//탈출 불가능할 경우
		if(result==Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		}
		//탈출 했을 경우
		else {
			System.out.println(result);
		}
	}

}
