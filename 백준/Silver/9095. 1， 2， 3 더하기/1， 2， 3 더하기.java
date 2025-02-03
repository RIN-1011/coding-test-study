import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine()); //정수
			//dp 초기화
			int[] dp = new int[Math.max(N+1, 4)]; //N이 4보다 작을 경우 대비
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			//N이 3보다 작으면 초기화 된 값 그대로 출력
			if(N<=3) {
				sb.append(dp[N]).append("\n");
			}
			else {
				for(int j=4; j<=N; j++) {
					//j-1값에서 1더하기 + j-2값에서 2더하기 + j-3값에서 3더하기
					dp[j] = dp[j-1]+dp[j-2]+dp[j-3];
				}
				sb.append(dp[N]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
