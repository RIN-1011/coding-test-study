import java.util.*;
import java.io.*;


public class Main {
	static int R, C; //세로, 가로
	static char[][] arr;
	static boolean visited[]; //알파벳 방문 배열
	//상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result; //최대 이동 횟수
	
	static void dfs(int i, int j, int cnt) {
		visited[arr[i][j]-'A'] = true; //방문처리
		result = Math.max(result, cnt); //최대값 갱신
		
		//상하좌우 탐색
		for(int k=0; k<4; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			
			//범위 벗어날 경우 패스
			if(x<0 || x>=R || y<0 || y>=C) {
				continue;
			}
			//이미 방문했을 경우 패스
			if(visited[arr[x][y]-'A']) {
				continue;
			}
			
			//경로 더 탐색
			dfs(x, y, cnt+1);
		}
		//다른 경로 더 탐색하기 위한 백트래킹
		visited[arr[i][j]-'A'] = false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //세로
		C = Integer.parseInt(st.nextToken()); //가로
		
		//보드 입력 받기
		arr = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		visited = new boolean[26];
		result = 0;
		
		dfs(0, 0, 1);
		
		System.out.println(result);
	}

}
