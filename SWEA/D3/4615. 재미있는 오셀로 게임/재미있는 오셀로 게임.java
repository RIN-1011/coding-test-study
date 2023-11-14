import java.util.*;
import java.io.*;

public class Solution {
    static int N, M;
    static int[][] map; //1:흑, 2:백
    //8방 탐색
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public static void bfs(int x, int y, int c) {
        int nx, ny;
        //8방 탐색
        for (int i = 0; i < 8; i++) {
            nx = x+dx[i];
            ny = y+dy[i];
            
            //범위 벗어났을 경우, 돌 없는 경우
            if(nx<0 || nx>=N || ny<0 || ny>=N || map[nx][ny]==0) {
                continue;
            }
            //자신의 색이랑 같은 경우
            if(map[nx][ny]==c) {
                continue;
            }
            
            loopOut:
            while(true) {
                //범위 벗어났을 경우, 돌 없는 경우
                if(nx<0 || nx>=N || ny<0 || ny>=N || map[nx][ny]==0) {
                    break;
                }
                //현재 돌과 같은 색인 경우
                else if(map[nx][ny]==c) {
                    //사이에 있는 돌 색깔 바꾸기
                    while(true) {
                        //원래 좌표로 돌아오면 멈추기
                        if(nx==x && ny==y) {
                            break loopOut;
                        }
                        map[nx][ny] = c;
                        //후진하고 색 바꾸기
                        nx -= dx[i];
                        ny -= dy[i];
                    }
                }
                //현재 놓은 돌 색깔과 반대인 경우 계속 직진
                nx += dx[i];
                ny += dy[i];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); //테케 개수
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //한 변의 길이
            M = Integer.parseInt(st.nextToken()); //돌을 놓는 횟수
            
            map = new int[N][N];
            //초기 배치
            map[N/2-1][N/2-1] = 2;
            map[N/2][N/2] = 2;
            map[N/2-1][N/2] = 1;
            map[N/2][N/2-1] = 1;
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                //돌 놓는 좌표
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());
                
                map[x-1][y-1] = color;
                bfs(x-1, y-1, color);
            }
            
            int bcnt = 0;
            int wcnt = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j]==1) {
                        bcnt++;
                    }
                    else if(map[i][j]==2){
                        wcnt++;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(bcnt).append(" ").append(wcnt).append("\n");
        }
        System.out.println(sb);
    }

}