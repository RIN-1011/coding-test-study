import java.util.*;
import java.io.*;

class Iceberg{
	int x;
	int y;
	
	public Iceberg(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
    static int N, M; //행, 열
    static int arr[][]; //빙산
    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 0, year = 0; //빙산 분리 체크 카운트, 빙산 분리 최소 시간
    static boolean visited[][]; //방문 여부
    
    //빙산 분리 확인
    public static int checked() {
    	visited = new boolean[N][M];
    	cnt = 0;
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//아직 방문하지 않았고 빙산인 경우
				if(!visited[i][j] && arr[i][j]!=0) {
					//탐색
					dfs(i, j);
					cnt++;
				}
			}
		}
    	return cnt;
    }
    public static void dfs(int x, int y) {
    	visited[x][y] = true; //방문 처리
    	
    	//상하좌우 빙하 탐색
    	for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			//범위 안에 있고
			if(nx>=0 && nx<N && ny>=0 && ny<M) {
				//아직 방문하지 않았으며 빙산일 경우
				if(!visited[nx][ny] && arr[nx][ny]!=0) {
					dfs(nx, ny);
				}
			}
		}
    }
    //빙산 녹이기
    public static void bfs() {
    	boolean isVisited[][] = new boolean[N][M];
    	Queue<Iceberg> q = new LinkedList<>();
    	
    	//빙산 탐색
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//빙산일 경우
				if(arr[i][j]!=0) {
					//큐 삽입 후 방문 처리
					q.add(new Iceberg(i, j));
					isVisited[i][j] = true;
				}
			}
		}
    	
    	while(!q.isEmpty()) {
    		Iceberg iceberg = q.remove();
    		int sum = 0;
    		
    		//상하좌우 바닷물 탐색
    		for (int i = 0; i < 4; i++) {
				int nx = iceberg.x + dx[i];
				int ny = iceberg.y + dy[i];
				
				//범위 밖이면 다른 방향 탐색
				if (nx<0 || ny<0 || nx>=N || ny>=M) {
					continue;
	            }
				
				//아직 방문 안했으며 바닷물인 경우
				if(!isVisited[nx][ny] && arr[nx][ny]==0) {
					sum++;
				}
			}
    		//바닷물 개수만큼 빙산 녹이기
    		arr[iceberg.x][iceberg.y] -= sum;
    		//높이는 0보다 줄어들지 않음
    		if(arr[iceberg.x][iceberg.y] < 0) {
    			arr[iceberg.x][iceberg.y] = 0;
    		}
    	}
    	
    	
    	
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //행 크기
        M = Integer.parseInt(st.nextToken()); //열 크기

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //빙산 분리되기 전까지 빙산 녹이기
        while((cnt=checked())<2) {
        	//분리되기 전에 빙산 다 녹아버린 경우
        	if(cnt == 0) {
        		year = 0;
        		break;
        	}
        	//빙산 녹이기
        	bfs();
        	year++;
        }
        System.out.println(year);
    }

}