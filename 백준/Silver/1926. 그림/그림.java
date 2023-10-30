import java.util.*;
import java.io.*;

public class Main {
	static int n, m; //세로, 가로
	static int[][] map; //도화지
	static int count, max, tmp;
	static boolean[][] visited;
	//상하좌우
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i, j});
		
		visited[i][j] = true; //방문 처리
		count++; //그림 개수 증가
		tmp = 0; //넓이 카운트 초기화
		
		while(!q.isEmpty()) {
			int[] p = q.remove();
			int x = p[0];
			int y = p[1];
			tmp++; //넓이 카운트
			
			//상하좌우 확인
			for (int k = 0; k < 4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				//범위 벗어났거나 이미 방문한 경우 패스
				if(nx<0 || nx>=n || ny<0 || ny>=m || visited[nx][ny]==true) {
					continue;
				}
				//그림인 경우 큐 삽입
				if(map[nx][ny]==1) {
					q.add(new int[] {nx, ny});
					visited[nx][ny] = true; //방문처리
				}
			}
		}
		
		max = Math.max(max, tmp); //최댓값 구하기
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //세로
		m = Integer.parseInt(st.nextToken()); //가로
		
		map = new int[n][m]; //도화지
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count = 0; //그림의 개수
		max = 0; //가장 넓은 그림의 넓이
		
		visited = new boolean[n][m]; //방문 배열
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==1 && visited[i][j]==false) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
	}

}
