import java.util.*;
import java.awt.List;
import java.io.*;

public class Main {
	static int R, C; //행, 열
	static int[][] arr; //알파벳 int형으로 저장
	static boolean visited[] = new boolean[26];; //알파벳 방문 여부
	static int result = 0; //지날 수 있는 최대 칸 수
	//상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void dfs(int x, int y, int count) {
		//이미 방문한 알파벳일 경우
		if(visited[arr[x][y]]) {
			result = Math.max(result, count); //최대값 갱신
			return;
		}
		else { //아직 방문 안했을 경우 dfs
			visited[arr[x][y]] = true; //알파벳 방문 처리
			for (int i = 0; i < 4; i++) {
				//4방향 이동
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				//범위 안에 있을 경우
				if(nx>=0 && nx<R && ny>=0 && ny<C) {
					dfs(nx, ny, count+1);
				}
			}
			visited[arr[x][y]] = false; //알파벳 방문 처리
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //행
		C = Integer.parseInt(st.nextToken()); //열
		arr = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j) - 'A'; //int형으로 변환
			}
		}
		dfs(0, 0, 0);
		
		System.out.println(result);
	}

}
