import java.util.*;
import java.io.*;

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	//좌상,상,우상,우,우하,하,좌하,좌
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[][] arr;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();

	static void bfs(int w, int h) {
		int cnt = 0; //섬 개수
		Queue<Point> q = new LinkedList<>();
		
		//섬 체크
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				//아직 방문하지 않았고 땅일 경우
				if(arr[i][j]==1 && !visited[i][j]) {
					//방문
					visited[i][j] = true;
					q.add(new Point(i, j));
					
					//큐 비어있지 않을 때까지
					while(!q.isEmpty()) {
						//기준점
						Point p = q.remove();
						
						//8방향 땅 체크
						int xi = p.x;
						int yj = p.y;
						
						for(int k=0; k<8; k++) {
							//가야할 방향
							int x = xi+dx[k];
							int y = yj+dy[k];
							
							//범위 벗어났을 경우
							if(x<0 || x>=h || y<0 || y>=w) {
								continue; //패스
							}
							//바다이거나 이미 방문했을 경우
							if(arr[x][y]==0 || visited[x][y]) {
								continue; //패스
							}
							
							//방문 체크 후 큐 삽입
							visited[x][y] = true;
							q.add(new Point(x, y));
						}
					}
					cnt++; //섬 개수 증가
				}
			}
		}
		sb.append(cnt).append("\n");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()); //너비
			int h = Integer.parseInt(st.nextToken()); //높이
			
			//종료
			if(w==0 && h==0) {
				break;
			}
			
			//초기화
			arr = new int[h][w];
			visited = new boolean[h][w];
			
			//지도 입력
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(w, h);
		}
		System.out.println(sb);
	}

}
