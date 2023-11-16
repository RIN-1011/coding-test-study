import java.util.*;
import java.io.*;


class CCTV{
    int x;
    int y;
    int n; //cctv 종류
    
    public CCTV(int x, int y, int n) {
        super();
        this.x = x;
        this.y = y;
        this.n = n;
    }
}
public class Main {
    static int N, M;
    static int[][] map;
    //상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<CCTV> list;
    static int min;
    
    //상하좌우 체크 (좌표, 방향, 백트래킹 여부)
    public static void move(int x, int y, int d, boolean back) {
        //초기 좌표
        int nx = x;
        int ny = y;
        
        while(true) {
            //정해진 방향대로 직진
            nx += dx[d];
            ny += dy[d];
            //범위 벗어나면 멈춤
            if(nx<0 || nx>=N || ny<0 || ny>=M) {
                break;
            }
            //벽일경우 멈춤
            if(map[nx][ny]==6) {
                break;
            }
            
            //CCTV는 제외해야함
            if(map[nx][ny]<=0) {
            	//백트래킹일 경우
            	if(back) {
            		//되돌리기
            		map[nx][ny]++;
            	}
            	else {
            		map[nx][ny]--;
            	}
            }
        }
    }
    //사각지대 카운트
    public static void check() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0) {
                    cnt++;
                }
            }
        }
        
        min = Math.min(min, cnt);
        
//        for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]+"\t");
//			}
//			System.out.println();
//		}
//        System.out.println("---------------");
    }
    public static void dfs(int cnt) {
        if(cnt == list.size()) {
            check();
            return;
        }
        else {
            //cctv 정보 가져오기
            int x = list.get(cnt).x;
            int y = list.get(cnt).y;
            int n = list.get(cnt).n;
            
            switch(n) {
            case 1:
                for (int k = 0; k < 4; k++) {
                    move(x, y, k, false);
                    dfs(cnt+1);
                    move(x, y, k, true);
                }
                break;
                
            case 2:
                for (int k = 0; k < 2; k++) {
                    move(x, y, k, false);
                    move(x, y, k+2, false);
                    dfs(cnt+1);
                    move(x, y, k, true);
                    move(x, y, k+2, true);
                }
                break;
                
            case 3:
                for (int k = 0; k < 4; k++) {
                    int pair = k+1;
                    if(pair>3) {
                        pair = 0;
                    }
                    move(x, y, k, false);
                    move(x, y, pair, false);
                    dfs(cnt+1);
                    move(x, y, k, true);
                    move(x, y, pair, true);
                }
                break;
                
            case 4:
                //상우좌
                move(x, y, 0, false);
                move(x, y, 1, false);
                move(x, y, 3, false);
                dfs(cnt+1);
                move(x, y, 0, true);
                move(x, y, 1, true);
                move(x, y, 3, true);
                
                //우하상
                move(x, y, 0, false);
                move(x, y, 1, false);
                move(x, y, 2, false);
                dfs(cnt+1);
                move(x, y, 0, true);
                move(x, y, 1, true);
                move(x, y, 2, true);
                
                //하좌우
                move(x, y, 1, false);
                move(x, y, 2, false);
                move(x, y, 3, false);
                dfs(cnt+1);
                move(x, y, 1, true);
                move(x, y, 2, true);
                move(x, y, 3, true);
                
                //좌상하
                move(x, y, 0, false);
                move(x, y, 2, false);
                move(x, y, 3, false);
                dfs(cnt+1);
                move(x, y, 0, true);
                move(x, y, 2, true);
                move(x, y, 3, true);
                break;
                
            case 5:
                move(x, y, 0, false);
                move(x, y, 1, false);
                move(x, y, 2, false);
                move(x, y, 3, false);
                dfs(cnt+1);
                move(x, y, 0, true);
                move(x, y, 1, true);
                move(x, y, 2, true);
                move(x, y, 3, true);
                break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열
        
        map = new int[N][M];
        list = new ArrayList<>();
        min = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //CCTV일 경우 리스트 삽입
                if(map[i][j]>=1 && map[i][j]<=5) {
                    list.add(new CCTV(i, j, map[i][j]));
                }
                //빈 공간 세기
                if(map[i][j]==0) {
                    min++;
                }
            }
        }
        dfs(0);
        System.out.println(min);
    }

}