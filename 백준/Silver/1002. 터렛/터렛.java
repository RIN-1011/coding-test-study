import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테케 개수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			//원1
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			//원2
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			//중심거리
			int d = (int)(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));

			//두 원의 위치 관계
			
			//중심 좌표 같고 반지름도 같을 경우
			if(x1==x2 && y1==y2 && r1==r2) {
				sb.append(-1).append("\n");
			}
			//한 점에서 만날 경우 (외접, 내접)
			else if(Math.pow(r1+r2,2)==d || Math.pow(r1-r2, 2)==d) {
				sb.append(1).append("\n");
			}
			//만나지 않을 경우(외부, 내부)
			else if(Math.pow(r1+r2,2)<d || Math.pow(r1-r2, 2)>d) {
				sb.append(0).append("\n");
			}
			//두 점에서 만날 경우
			else {
				sb.append(2).append("\n");
			}
		}
		System.out.println(sb);
	}

}
