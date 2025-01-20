import java.util.*;
import java.io.*;

public class Main {
	//좌상,상,우상,좌,우,좌하,하,우하
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[][] arr;
	static boolean[][] visited;
	
	static void dfs(int h, int w, int xi, int yj) {
		//8방향 탐색
		for(int k=0; k<8; k++) {
			//이동할 방향
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
			
			visited[x][y] = true;
			dfs(h, w, x, y);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
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
			int cnt = 0;
			
			//지도 입력
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
					
			//섬 체크
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					//땅이고 방문 안했을 경우
					if(arr[i][j]==1 && !visited[i][j]) {
						visited[i][j] = true; //방문 체크
						dfs(h, w, i, j); //탐색 시작
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
