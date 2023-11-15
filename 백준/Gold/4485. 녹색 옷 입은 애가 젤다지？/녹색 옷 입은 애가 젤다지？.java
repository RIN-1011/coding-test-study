import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
	int x;
	int y;
	int w;
	
	public Node(int x, int y, int w) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
	
}
public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int cnt = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine()); //동굴 크기
			
			if(N==0) {
				break;
			}
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] distance = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			
			//시작점 설정
			distance[0][0] = map[0][0];
			PriorityQueue<Node> q = new PriorityQueue<>();
			q.offer(new Node(0, 0, map[0][0]));
			
			
			while(!q.isEmpty()) {
				Node now = q.poll();

				//사방탐색
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					//범위 벗어나면 패스
					if(nx<0 || nx>=N || ny<0 || ny>=N) {
						continue;
					}
					
					if(distance[nx][ny] > distance[now.x][now.y] + map[nx][ny]) {
						distance[nx][ny] = distance[now.x][now.y] + map[nx][ny];
						q.add(new Node(nx, ny, distance[nx][ny]));
					}
				}
			}
			
			
			sb.append("Problem ").append(cnt++).append(": ").append(distance[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}

}
