import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //현재 활성화 된 앱
		int M = Integer.parseInt(st.nextToken()); //확보해야 하는 메모리
		
		//활성화 된 앱 메모리
		int[] memory = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		//앱 비활성화 했을 경우 비용
		int[] cost = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		//앱 비활성화 최소 비용 계산
		int maxCost = 100*N;
		int[][] dp = new int[N+1][maxCost+1];
		
		//활성화 앱 개수만큼 반복
		for(int i=1; i<=N; i++) {
			//비활성화 비용만큼 반복
			for(int j=0; j<=maxCost; j++) {
				//현재 드는 비용이 i번째 앱 비용보다 작을 경우
				if(j < cost[i]) {
					//현재 앱은 비활성화 못시키므로 전 결과 그대로 유지
					dp[i][j] = dp[i-1][j];
				}
				//현재 드는 비용이 i번째 앱 비용보다 크거나 같을 경우
				else {
					//전 결과 유지 or 현재 앱 비활성화
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]]+memory[i]);
				}
			}
		}
		
		//최소 비용 찾기
		int result = Integer.MAX_VALUE;
		for(int i=0; i<=maxCost; i++) {
			//메모리 확보했을 경우
			if(dp[N][i] >= M) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
