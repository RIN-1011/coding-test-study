import java.util.*;
import java.io.*;

class Wormhole {
	int x;
	int y;
	
	public Wormhole(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class Solution {
	static int N, max;
	static int[][] map;
	static ArrayList<Wormhole>[] list;
	//상우하좌
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int[][] block = {
			 {},
	         {2, 3, 1, 0},
	         {1, 3, 0, 2},
	         {3, 2, 0, 1},
	         {2, 0, 3, 1},
	         {2, 3, 0, 1}
	};
	
	//시작 좌표, 방향
	public static int pinball(int startX, int startY, int d) {
		int cnt = 0;
		
		int x = startX;
		int y = startY;
		
		//정해진 방향대로 직진
		while(true) {
			x = x + dx[d];
			y = y + dy[d];
			
			//벽에 부딪힌 경우
			if(x<0 || x>=N || y<0 || y>=N) {
//				//방향 반대로 전환
//				d = block[5][d];
//				//돌아가기
//				x = x + dx[d];
//				y = y + dy[d];
//				//카운트 증가
//				cnt++;
				cnt = cnt*2+1;
				break;
			}
			//핀볼이 출발 위치로 돌아온 경우
			if(x == startX && y == startY) {
				break;
			}
			//블랙홀에 빠진 경우
			if(map[x][y]==-1) {
				break;
			}
			//빈공간일 경우 직진
			if(map[x][y]==0) {
				continue;
			}
			//웜홀에 빠진 경우
			if(map[x][y]>=6 && map[x][y]<=10) {
				//같은 웜홀 찾기
				Wormhole one = list[map[x][y]-6].get(0);
				Wormhole two = list[map[x][y]-6].get(1);
				
				//위치 이동
				if(x==one.x && y==one.y) {
					x = two.x;
					y = two.y;
				}
				else {
					x = one.x;
					y = one.y;
				}
			}
			//블록에 부딪힌 경우
			if(map[x][y]>=1 && map[x][y]<=5) {
				//방향 반대로 바뀌는 경우 왔던길 되돌아가므로 수식으로 처리
				if((d+2)%4==block[map[x][y]][d]) {
					cnt = cnt*2+1;
					break;
				}
				
				//블록에 맞게 방향 전환
				d = block[map[x][y]][d];
				//카운트 증가
				cnt++;
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim()); //정사각형 한 변의 길이
			
			map = new int[N][N];
			list = new ArrayList[5];
			for (int i = 0; i < 5; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					//웜홀일 경우
					if(map[i][j]>=6 && map[i][j]<=10) {
						list[map[i][j]-6].add(new Wormhole(i, j));
					}
				}
			}
			max = 0;
			//모든 위치와 방향 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < 4; k++) {
						//빈공간에서 출발
						if(map[i][j] == 0) {
							int cnt = pinball(i, j, k);
							//최댓값 갱신
							max = Math.max(max, cnt);							
						}
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
