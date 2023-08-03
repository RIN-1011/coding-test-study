import java.util.*;
import java.io.*;

public class Main {
	static int N, M; //배추밭 세로, 가로
	static int b[][]; //배추밭
	static boolean visited[][]; //방문 여부 판단
	//상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void dfs(int i, int j) {
		visited[i][j] = true; //방문
		
		//상하좌우 인접한 노드 방문
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			//범위 안에 있고 배추가 존재하며 아직 방문 안했을 경우 방문
			if(nx>=0 && nx<N && ny>=0 && ny<M && b[nx][ny]==1 && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //배추밭 가로
			N = Integer.parseInt(st.nextToken()); //배추밭 세로
			int K = Integer.parseInt(st.nextToken());
			
			b = new int[N][M]; //배추밭
			visited = new boolean[N][M]; //방문 여부 판단
			int cnt = 0; //배추흰지렁이 마리 수
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				b[y][x] = 1; //배추 심은 위치 표시
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//배추밭에 배추가 있고 방문하지 않았으면 방문
					if(b[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						cnt++; //dfs 다 돌았으면 카운트 증가
					}
				}
			}
			System.out.println(cnt);
		}
	
	}

}
