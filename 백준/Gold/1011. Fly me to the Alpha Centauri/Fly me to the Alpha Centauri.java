import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int dis = y-x; //거리
			int max = (int)Math.sqrt(dis); //최대 이동거리
			int count = 0; //개수
			
			//거리 루트값과 최대 이동거리가 정확히 일치할 경우
			if(max == Math.sqrt(dis)) {
				count = max*2-1;
			}
			//거리가 최대 제곱+최대보다 같거나 작을 경우
			else if(dis <= max*max+max) {
				count = max*2;
			}
			//그 외
			else {
				count = max*2+1;
			}
			
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

}
