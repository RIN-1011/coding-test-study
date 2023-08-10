import java.io.*;
import java.util.*;

class Knight {
	int x;
	int y;
	int move; //이동 수
	Knight(int x, int y, int move){
		this.x = x;
		this.y = y;
		this.move = move;
	}
	
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine()); //체스판 한 변의 길이
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); //출발 x 좌표
			int y = Integer.parseInt(st.nextToken()); //출발 y 좌표
			
			st = new StringTokenizer(br.readLine());
			int fx = Integer.parseInt(st.nextToken()); //목적지 x 좌표
			int fy = Integer.parseInt(st.nextToken()); //목적지 y 좌표
			
			//상하좌우
			int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
			int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};
			
			int minMove = Integer.MAX_VALUE; //최소 이동 수
			boolean visited[][] = new boolean[N][N]; //방문 배열 (방문했던 곳 재방문 방지)
			
			Queue<Knight> q = new LinkedList<>();
			q.add(new Knight(x, y, 0));
			
			//출발 좌표에서 모든 경우의 수 탐색 (bfs 8방 탐색)
			//목적지 좌표 도달하면 minMove 값 비교해서 더 작으면 갱신
			while(!q.isEmpty()) {
				Knight knight = q.remove();
				
				//목적지에 도달했을 경우
				if(knight.x == fx && knight.y == fy) {
					//최소 이동 횟수 갱신 가능하면 갱신
					if(minMove > knight.move) {
						minMove = knight.move;
					}
				}
				//8방 탐색
				for(int i=0; i<8; i++) {
					int nx = knight.x + dx[i];
					int ny = knight.y + dy[i];
					
					//이동하려는 곳이 범위 안에 있고 아직 방문을 안했으며 현재 최소 이동 횟수보다 작을 경우(방문 했으면 다시 방문할 필요 X, 이미 최소 이동 횟수를 넘어가면 더 이동할 필요 X)
					if(nx>=0 && nx<N && ny>=0 && ny<N && visited[nx][ny] == false && knight.move < minMove) {
						//큐에 삽입하고 이동 횟수 증가
						q.add(new Knight(nx, ny, knight.move+1));
						visited[nx][ny] = true; //방문처리
					}
				}
			}
			sb.append(minMove+"\n");
		}
		System.out.println(sb);
	}

}
