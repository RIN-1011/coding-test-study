import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			int cnt = 1; //달팽이 숫자
			int x = 0, y = 0; //처음 좌표
			int d = 0; //방향
			//우하좌상
			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1, 0};
			
			arr[x][y] = 1; //초기 위치 초기화
			
			while(true) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				//범위 벗어나거나 이미 값 있는 경우
				if(nx<0 || nx>=N || ny<0 || ny>=N || arr[nx][ny]!=0) {
					d += 1; //방향 전환
					if(d==4) {
						d=0;
					}
				}
				else {
					arr[nx][ny] = ++cnt; //달팽이 숫자 삽입
					//위치 이동
					x = nx;
					y = ny;
				}
				if(cnt==N*N) { //다 돌았으면 끝
					break;
				}
			}
			
			sb = new StringBuilder();
			sb.append("#"+t+"\n");
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}
	}

}
