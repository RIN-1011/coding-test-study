import java.util.*;
import java.io.*;

public class Main {
	//북동남서
	static int[] dx= {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	//청소하는 칸 개수
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //세로
		int M = Integer.parseInt(st.nextToken()); //가로
		
		st = new StringTokenizer(br.readLine());
		//처음 로봇 청소기가 있는 좌표
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken()); 
		//처음 로봇 청소기가 바라보는 방향
		int d = Integer.parseInt(st.nextToken());
		
		//방의 상태
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int x = r;
		int y = c;
		while(true) {
			//현재 칸 청소
			if(map[x][y] == 0) {
				map[x][y] = 2;
				result++; //청소 칸 카운트 증가
			}
			
			int i;
			//상하좌우 탐색
			for (i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				//범위 벗어나면 패스
				if(nx<0 || nx>=N || ny<0 || ny>=M) {
					continue;
				}
				//청소되지 않은 빈 칸 있는 경우 break
				if(map[nx][ny]==0) {
					break;
				}
			}
			//청소되지 않은 빈 칸이 없는 경우
			if(i==4) {
				//바라보는 방향을 유지한 채로 한 칸 후진
				if(d==0){ //북쪽
					int nx = x+dx[2];
					int ny = y+dy[2];
					//후진할 수 없는 경우 작동 멈춤
					if(map[nx][ny]==1) {
						break;
					}
					x = nx;
					y = ny;
					continue;
				}
				else if(d==1){ //동쪽
					int nx = x+dx[3];
					int ny = y+dy[3];
					//후진할 수 없는 경우 작동 멈춤
					if(map[nx][ny]==1) {
						break;
					}
					x = nx;
					y = ny;
					continue;			
				}
				else if(d==2){ //남쪽
					int nx = x+dx[0];
					int ny = y+dy[0];
					//후진할 수 없는 경우 작동 멈춤
					if(map[nx][ny]==1) {
						break;
					}
					x = nx;
					y = ny;
					continue;
				}
				else if(d==3){ //서쪽
					int nx = x+dx[1];
					int ny = y+dy[1];
					//후진할 수 없는 경우 작동 멈춤
					if(map[nx][ny]==1) {
						break;
					}
					x = nx;
					y = ny;
					continue;
				}
			}
			//청소되지 않은 빈 칸이 있는 경우
			else {
				//반시계 방향으로 90도 회전
				switch(d) {
				case 0: //북
					d = 3;
					break;
				case 1: //동
					d = 0;
					break;
				case 2: //남
					d = 1;
					break;
				case 3: //서
					d = 2;
					break;
				}
				//바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(map[nx][ny]==0) {
					x = nx;
					y = ny;
				}
			}
		}
		System.out.println(result);
	}

}
