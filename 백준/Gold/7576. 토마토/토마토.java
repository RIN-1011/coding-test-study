import java.util.*;
import java.io.*;

class State {
	int i;
	int j;
	int date; //날짜
	
	State(int i, int j, int date){
		this.i = i;
		this.j = j;
		this.date = date;
	}
}

public class Main {
	static int[][] box;
	static int M, N; //가로, 세로
	static int f; //안익은 토마토 개수
	static int result; //최소 일수
	static Queue<State> q;
	//상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void bfs() {
		while(!q.isEmpty()) {
			State now = q.poll();
			
			//상하좌우 체크
			for(int k=0; k<4; k++) {
				//이동할 위치
				int x = dx[k] + now.i;
				int y = dy[k] + now.j;
				
				//범위 벗어나면 패스
				if(x<0 || x>=N || y<0 || y>=M) {
					continue;
				}
				//토마토 없거나 이미 익었으면 패스
				if(box[x][y]==-1 || box[x][y]==1) {
					continue;
				}
				//아직 안익었을 경우
				q.add(new State(x, y, (now.date+1))); //큐 삽입
				box[x][y] = 1; //익히기
				f -= 1; //안익은 토마토 개수 줄이기
				
				//토마토 다 익었을 경우
				if(f==0) {
					result = now.date+1;
					break;
				}
			}
		}
		//토마토 모두 안익었을 경우
		if(f!=0) {
			result = -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //가로
		N = Integer.parseInt(st.nextToken()); //세로
		
		//초기화
		box = new int[N][M];
		f = 0;
		result = 0;
		q = new LinkedList<>();
		
		//상자 상태
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				//안익은 토마토 카운트
				if(box[i][j]==0) f++;
				//익은 토마토 큐 저장
				else if(box[i][j]==1) q.add(new State(i, j, 0));
			}
		}
		
		//모든 토마토가 익어있는 경우
		if(f==0) {
			System.out.println(0);
		}
		else {
			bfs();
			System.out.println(result);
		}
		
	}

}
