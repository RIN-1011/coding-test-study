import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); //가로
		int N = Integer.parseInt(st.nextToken()); //세로
		
		int[][] arr = new int[N][M]; //토마토 상자
		int[][] date = new int[N][M]; //날짜
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//초기부터 모든 토마토 익어있을 경우
		int c;
		loopOut:
		for(c=0; c<N; c++) {
			for(int j=0; j<M; j++) {
				if(arr[c][j]==0) { //안익은 토마토 발견할 경우
					break loopOut; //반복문 탈출
				}
			}
		}
		if(c==N) { //반복문 끝까지 다 돌았으면 모든 토마토가 익은 것이므로
			System.out.println(0);
			return; //0 출력하고 종료
		}
		
		
		//상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[]> q = new LinkedList<>();
		//초기 익은 토마토 큐 삽입
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==1) { //익었으면
					q.add(new int[] {i, j}); //큐에 삽입
				}
			}
		}
		
		//bfs
		while(!q.isEmpty()) { //큐가 비어있지 않을 때까지 bfs
			int[] p = q.remove(); //후입선출
			int x = p[0]; //x 좌표
			int y = p[1]; //y 좌표
			int time = date[x][y]; //최소 일수
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				//가려고 하는 곳이 범위 안에 있고 토마토가 들어있으며 아직 방문하지 않은 경우
				if(nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny]==0) {
					date[nx][ny] += time+1; //하루 더해주기
					arr[nx][ny] = 1; //방문 처리
					q.add(new int[] {nx, ny}); //큐에 삽입
				}
			}
		}
		
		//토마토 모두 익지 못하는 상황 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==0) { //안익은 토마토 있을 경우
					System.out.println(-1);
					return; //-1 출력하고 종료
				}
			}
		}
		
		
		int minDate = 0; //최소 날짜 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(minDate<date[i][j]) {
					minDate = date[i][j];
				}
			}
		}
		System.out.println(minDate);
	}

}
