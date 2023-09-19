import java.io.*;
import java.util.*;

public class Solution {
	//상우하좌
	static int[] dx= {-1, 0, 1, 0};
	static int[] dy= {0, 1, 0, -1};
	static int N, map[][], start[], end[];
	static boolean[][] visited;
	
	static int bfs(int x, int y, int time) { //x, y좌표와 시간
		Queue<int[]> q = new ArrayDeque<>(); //LinkedList보다 빠름
		visited[x][y] = true;
		q.offer(new int[] {x, y, time}); //시작점
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			x = now[0];
			y = now[1];
			time = now[2];
			
			if(x==end[0] && y==end[1]) { //도착했을 경우 시간 반환
				return time;
			}
			
			//상우하좌 탐색
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				//범위 체크
				if(nx<0 || nx>=N || ny<0 || ny>=N) {
					continue;
				}
				//장애물이 있거나 이미 방문한 경우
				if(map[nx][ny]==1 || visited[nx][ny]) {
					continue;
				}
				//소용돌이일 경우(2초 대기)
				if(map[nx][ny]==2) {
					if(time%3==2) { //2초 후 지나갈 수 있음
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny, time+1});
					}
					else { //나머지 대기
						q.offer(new int[] {x, y, time+1});
					}
				}
				//바다일 경우(지나갈 수 있음)
				else {
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny, time+1});
				}
			}
		}
		
		return -1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			start = new int[2]; //시작위치
			end = new int[2]; //도착위치
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			
			sb.append("#").append(t).append(" ").append(bfs(start[0], start[1], 0)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
