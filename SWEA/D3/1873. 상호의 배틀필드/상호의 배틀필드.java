import java.util.*;
import java.io.*;

//상호의 배틀필드
public class Solution {
	static int H, W; //맵 높이, 너비
	static char map[][]; //맵
	static int x, y; //초기 전차 위치
	static int look; //0:상, 1:하, 2:좌, 3:우
	static int[] shootX = {-1, 1, 0, 0};
	static int[] shootY = {0, 0, -1, 1};
	
	public static void battlefield(char c) {
		if(c == 'U') { //전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 그 칸으로 이동
			//전차가 바라보는 방향 바꾸기
			map[x][y] = '^';
			look = 0;
			int nx = x-1;
			int ny = y;
			//맵 범위 안에 있을 경우
			if(nx >= 0 && nx < H && ny >= 0 && ny < W) {
				//한 칸 위 칸이 평지라면
				if(map[nx][ny] == '.') {
					//그 칸으로 이동
					map[x][y] = '.';
					map[nx][ny] = '^';
					//전차 위치 옮겨주기
					x = nx;
					y = ny;
				}
			}
		}
		else if(c == 'D') { //전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동
			//전차가 바라보는 방향 바꾸기
			map[x][y] = 'v';
			look = 1;
			int nx = x+1;
			int ny = y;
			//맵 범위 안에 있을 경우
			if(nx >= 0 && nx < H && ny >= 0 && ny < W) {
				//한 칸 아래 칸이 평지라면
				if(map[nx][ny] == '.') {
					//그 칸으로 이동
					map[x][y] = '.';
					map[nx][ny] = 'v';
					//전차 위치 옮겨주기
					x = nx;
					y = ny;
				}
			}
		}
		else if(c == 'L') { //전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동
			//전차가 바라보는 방향 바꾸기
			map[x][y] = '<';
			look = 2;
			int nx = x;
			int ny = y-1;
			//맵 범위 안에 있을 경우
			if(nx >= 0 && nx < H && ny >= 0 && ny < W) {
				//한 칸 왼쪽 칸이 평지라면
				if(map[nx][ny] == '.') {
					//그 칸으로 이동
					map[x][y] = '.';
					map[nx][ny] = '<';
					//전차 위치 옮겨주기
					x = nx;
					y = ny;
				}
			}
		}
		else if(c == 'R') { //전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동
			//전차가 바라보는 방향 바꾸기
			map[x][y] = '>';
			look = 3;
			int nx = x;
			int ny = y+1;
			//맵 범위 안에 있을 경우
			if(nx >= 0 && nx < H && ny >= 0 && ny < W) {
				//한 칸 오른쪽 칸이 평지라면
				if(map[nx][ny] == '.') {
					//그 칸으로 이동
					map[x][y] = '.';
					map[nx][ny] = '>';
					//전차 위치 옮겨주기
					x = nx;
					y = ny;
				}
			}
		}
		else if(c == 'S') { //전차가 현재 바라보고 있는 방향으로 포탄을 발사
			int tmpX = x;
			int tmpY = y;
			while(true) {
				//바라보는 방향으로 한 칸 이동
				int nx = tmpX + shootX[look];
				int ny = tmpY + shootY[look];
				//범위 안에 있을 경우
				if(nx >= 0 && nx < H && ny >= 0 && ny < W) {
					if(map[nx][ny] == '#') { //강철일 경우
						break; //아무 일도 일어나지 않음
					}
					else if(map[nx][ny] == '*') { //벽돌일 경우
						map[nx][ny] = '.'; //평지가 됨
						break;
					}
					else { //평지일 경우
						//포탄 직진
						tmpX = nx;
						tmpY = ny;
					}
				}
				//포탄이 맵 밖을 벗어나면 반복문 종료
				else {
					break;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); //맵 높이
			W = Integer.parseInt(st.nextToken()); //맵 너비
			//맵
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if(str.charAt(j) == '^') { //위쪽을 바라보는 전차
						x = i;
						y = j;
						look = 0;
					}
					else if(str.charAt(j) == 'v') { //아래쪽을 바라보는 전차
						x = i;
						y = j;
						look = 1;
					}
					else if(str.charAt(j) == '<') { //왼쪽을 바라보는 전차
						x = i;
						y = j;
						look = 2;
					}
					else if(str.charAt(j) == '>') { //오른쪽을 바라보는 전차
						x = i;
						y = j;
						look = 3;
					}
				}
			}
			
			//사용자 입력
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int i = 0; i < N; i++) {
				battlefield(str.charAt(i));
			}
			
			//결과 출력
			sb.append("#"+t+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
