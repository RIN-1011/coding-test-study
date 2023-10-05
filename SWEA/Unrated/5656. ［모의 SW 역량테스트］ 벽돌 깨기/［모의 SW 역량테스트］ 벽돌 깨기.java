import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    int range;
    
    public Point(int x, int y, int range) {
        super();
        this.x = x;
        this.y = y;
        this.range = range;
    }
}
public class Solution {
    static int N, W, H; //구슬 쏠 횟수, 열, 행
    static int[][] map;
    static int[] numbers; //구슬 쏘는 위치 중복순열 배열
    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min; //남은 벽돌 개수
    
    //구슬 쏘는 위치 정하기 위한 중복 순열
    public static void perm(int cnt) {
        if(cnt==N) {
            int[][] copy = new int[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    copy[i][j] = map[i][j];
                }
            }
            breakBricks(copy);
        }
        else {
            for (int i = 0; i < W; i++) {
                numbers[cnt] = i;
                perm(cnt+1);
            }
        }
    }
    //깰 벽돌 위치 찾기
    public static Point findPoints(int[][] copy, int n) {
        for (int i = 0; i < H; i++) {
            //정해진 열에 맨 위 벽돌 찾기
            if(copy[i][numbers[n]]!=0) {
                return new Point(i, numbers[n], copy[i][numbers[n]]);
            }
        }
        return null;
    }
    //벽돌 재배치
    public static int[][] relocation(int[][] copy){
        for (int k = 0; k < W; k++) {
            for (int i = H-1; i >= 0; i--) {
                for (int j = i-1; j >= 0; j--) {
                	//벽돌 아래로 밀기
                    if(copy[i][k] == 0) {
                        if(copy[j][k] != 0) {
                            copy[i][k] = copy[j][k];
                            copy[j][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
        return copy;
    }
    //남은 벽돌 세기
    public static void count(int[][] copy) {
        int cnt = 0;
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(copy[i][j]!=0) {
                    cnt++;
                }
            }
        }
        //남은 벽돌 최소 개수 갱신
        min = Math.min(min, cnt);
    }
    //벽돌 깨기
    public static void breakBricks(int[][] copy) {
        //구슬 쏘는 횟수만큼 반복
        for (int i = 0; i < N; i++) {
            Point first = findPoints(copy, i);
            //벽돌 없으면 넘어가기
            if(first == null) {
                continue;
            }
            Queue<Point> q = new ArrayDeque<>();
            q.add(first); //첫번째 쏠 벽돌 큐 삽입
            while(!q.isEmpty()) {
                Point p = q.remove();
                int x = p.x;
                int y = p.y;
                int r = p.range;
                
                copy[x][y] = 0;
                
                if(r>1) {
                	//상하좌우 벽돌 깨기
                    for (int k = 0; k < 4; k++) {
                        //범위만큼 폭발
                        for (int j = 1; j < r; j++) {
                            int nx = x + dx[k]*j;
                            int ny = y + dy[k]*j;
                            //범위 벗어나면 패스
                            if(nx<0 || nx>=H || ny<0 || ny>=W) {
                                break;
                            }
                            //벽돌 존재할 경우 큐에 삽입
                            if(copy[nx][ny]!=0) {
                                q.add(new Point(nx, ny, copy[nx][ny]));
                                copy[nx][ny] = 0; //벽돌 폭발
                            }
                        }
                    }
                }
            }
            //벽돌 재배치
            copy = relocation(copy);
        }
        //남은 벽돌 수 카운트
        count(copy);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //구슬 쏠 횟수
            W = Integer.parseInt(st.nextToken()); //열
            H = Integer.parseInt(st.nextToken()); //행
            
            map = new int[H][W];
            numbers = new int[N];
            min = 0;
            
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    //벽돌 개수 세기
                    if(map[i][j]!=0) {
                        min++;
                    }
                }
            }
            
            perm(0);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

}