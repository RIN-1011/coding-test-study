import java.util.*;
import java.io.*;

class State {
	int h; //높이
	int n; //세로
	int m; //가로
	int date; //날짜
	
	State(int h, int n, int m, int date){
		this.h = h;
		this.n = n;
		this.m = m;
		this.date = date;
	}
}
public class Main {
	static int[][][] box;
	static int M, N, H; //가로, 세로, 높이
	static int f, result; //안익은 토마토 개수, 최소 일수
	static Queue<State> q;
	//위,아래,상,하,좌,우
	static int[] dz = {-1, 1, 0, 0, 0, 0};
	static int[] dx = {0, 0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, 0, -1, 1};
	
	static void bfs() {
		while(!q.isEmpty()) {
			State now = q.poll();
			
			//6방향 체크
			for(int k=0; k<6; k++) {
				int z = now.h + dz[k];
				int x = now.n + dx[k];
				int y = now.m + dy[k];
				
				//범위 벗어나는 경우 패스
				if(z<0 || z>=H || x<0 || x>=N || y<0 || y>=M) {
					continue;
				}
				//토마토 없거나 이미 익은 경우 패스
				if(box[z][x][y]==-1 || box[z][x][y]==1) {
					continue;
				}
				//안익은 경우
				q.add(new State(z, x, y, (now.date+1))); //큐 삽입
				box[z][x][y] = 1; //익히기
				f -= 1; //안익은 토마토 개수 차감
				
				//토마토 다 익었을 경우
				if(f==0) {
					result = now.date+1;
					break;
				}
			}
		}
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
		H = Integer.parseInt(st.nextToken()); //높이
		
		//초기화
		box = new int[H][N][M];
		f = 0;
		result = 0;
		q = new LinkedList<>();
		
		//박스 입력 받기
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					
					//안익은 토마토 개수 카운트
					if(box[i][j][k]==0) f++;
					//익은 토마토 큐 삽입
					else if(box[i][j][k]==1) q.add(new State(i, j, k, 0));
				}
			}
		}
		//모든 토마토 익어있는 경우
		if(f==0) {
			System.out.println(0);
		}
		else {
			bfs();
			System.out.println(result);
		}
	}

}
