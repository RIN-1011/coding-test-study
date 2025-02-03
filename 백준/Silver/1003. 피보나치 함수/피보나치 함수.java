import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine()); //자연수 or 0
			
			int[][] dp = new int[2][Math.max(N+1, 2)]; //행:0,1호출 횟수   열:0~N 자연수
			//자연수 0 호출 횟수 초기화
			dp[0][0] = 1;
			dp[1][0] = 0;
			//자연수 1 호출 횟수 초기화
			dp[0][1] = 0;
			dp[1][1] = 1;
			
			//N이 1보다 작거나 같은 경우 초기화 값 출력
			if(N<=1) {
				sb.append(dp[0][N]+" "+dp[1][N]).append("\n");
			}
			else {
				for(int j=2; j<=N; j++) {
					//0 호출 횟수 = 이전 자연수 0 호출 횟수 + 2번째 전 자연수 0 호출 횟수
					dp[0][j] = dp[0][j-1] + dp[0][j-2];
					//1 호출 횟수 = 이전 자연수 1 호출 횟수 + 2번째 전 자연수 1 호출 횟수
					dp[1][j] = dp[1][j-1] + dp[1][j-2];
				}
				sb.append(dp[0][N]+" "+dp[1][N]).append("\n");
			}
		}
		System.out.println(sb);
	}

}
