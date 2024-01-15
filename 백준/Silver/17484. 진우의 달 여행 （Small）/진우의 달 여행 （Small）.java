import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	//대각선 왼쪽 아래, 아래, 대각선 오른쪽 아래
	static int[] dx = {1, 1, 1};
	static int[] dy = {-1, 0, 1};
	static int min; //최소 연료 값
	
	public static void dfs(int i, int j, int sum, int d) {
		//도착
		if(i==N-1) {
			//최솟값 갱신
			min = Math.min(min,  sum);
			return;
		}
		
		//3방향 이동
		for (int k = 0; k < 3; k++) {
			//같은 방향으로 이동 불가
			if(k==d) {
				continue;
			}
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			//범위 안에 있을 경우
			if(nx>=0 && nx<N && ny>=0 && ny<M) {
				dfs(nx, ny, sum+map[nx][ny], k);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			dfs(0, i, map[0][i], -1);
		}
		System.out.println(min);
	}

}
