import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //계단 개수
		
		//계단 점수 정보 입력
		int[] stairs = new int[Math.max(N+1, 4)];
		for(int i=1; i<=N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[Math.max(N+1, 4)];
		//DP 배열 값 초기화
		dp[1] = stairs[1]; //첫번째 계단
		dp[2] = stairs[1] + stairs[2]; //두번째 계단
		dp[3] = Math.max(stairs[1], stairs[2])+stairs[3]; //세번째 계단
		
		//네번째 계단 부터 점수 계산
		for(int i=4; i<=N; i++) {
			//-3,-1,본인 or -2,본인 계단 거쳐가는 것 중 더 큰 값 저장
			//-1 계단은 어떤 계단을 거쳐갔는지 알 수 없으므로 stairs 배열 값으로 더함
			dp[i] = Math.max(dp[i-2], dp[i-3]+stairs[i-1]) + stairs[i];
		}
		
		System.out.println(dp[N]);
	}

}
