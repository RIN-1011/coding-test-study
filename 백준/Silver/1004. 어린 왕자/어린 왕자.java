import java.util.*;
import java.io.*;

public class Main {
	public static boolean checked(int x1, int y1, int x2, int y2, int r) {
		//원 중심과 출발점or도착점 사이의 거리가 반지름보다 작을 경우
		if(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2)<r*r) {
			return true;
		}
		return false;
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); //테케 개수
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            //출발점
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            //도착점
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int n = Integer.parseInt(br.readLine()); //행성계의 개수
            int planet[][] = new int[n][3];
            
            int cnt = 0; //어린 왕자가 거쳐야 할 행성계 횟수
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                //행성계 중점
                planet[i][0] = Integer.parseInt(st.nextToken());
                planet[i][1] = Integer.parseInt(st.nextToken());
                //행성계 반지름
                planet[i][2] = Integer.parseInt(st.nextToken());
                
                //점이 원 안에 들어가있으면 반드시 거쳐야 함
                if(checked(x1, y1, planet[i][0], planet[i][1], planet[i][2]) || checked(x2, y2, planet[i][0], planet[i][1], planet[i][2])) {
                	if(checked(x1, y1, planet[i][0], planet[i][1], planet[i][2]) && checked(x2, y2, planet[i][0], planet[i][1], planet[i][2])) {
                		//둘 다 포함되어있으면 거치지 않아도 됨
                	}
                	else {
                		cnt++;
                	}
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

}
