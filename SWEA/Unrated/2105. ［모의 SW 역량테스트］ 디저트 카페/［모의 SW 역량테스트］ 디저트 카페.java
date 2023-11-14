import java.util.*;
import java.io.*;

public class Solution {
    static int N, startX, startY;
    static int[][] map;
    //대각선 사각형
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};
    static boolean[] isChecked;
    static int max;
    
    //시작 좌표, 방향, 디저트 먹은 횟수
    public static void dfs(int x, int y, int d, int cnt) {
        //4방향 이동 (이전 방향 다음부터)
        for (int i = d; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            //지역을 벗어날 경우 패스
            if(nx<0 || nx>=N || ny<0 || ny>=N) {
                continue;
            }
            //출발점으로 돌아온 경우
            if(nx==startX && ny==startY && cnt>=3) {
            	//최댓값 갱신
                max = Math.max(max, cnt);
                return;
            }
            //이미 먹은 디저트인 경우 패스
            if(isChecked[map[nx][ny]]) {
                continue;
            }
            
            isChecked[map[nx][ny]] = true;
            dfs(nx, ny, i, cnt+1);
            isChecked[map[nx][ny]] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); //테케 개수
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); //한 변의 길이
            map = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            max = -1;
            //사각형이 가능한 범위 내에서 함수 호출
            for (int i = 0; i < N-2; i++) {
                for (int j = 1; j < N-1; j++) {
                    //시작점 저장 및 방문처리
                    startX = i;
                    startY = j;
                    isChecked = new boolean[101];
                    isChecked[map[i][j]] = true;
                    dfs(i, j, 0, 1);
                }
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

}

