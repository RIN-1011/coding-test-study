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
		
		int maxCost = Arrays.stream(cost).sum(); //앱 비활성화 최악 비용 계산
		int[] dp = new int[maxCost+1]; //1차원 DP
		
		
		//거꾸로 탐색
		for(int i=1; i<=N; i++) {
			for(int j=maxCost; j>=cost[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-cost[i]] + memory[i]);
			}
		}
		
		//최소 비용 출력
		for(int i=0; i<=maxCost; i++) {
			if(dp[i]>=M) {
				System.out.println(i);
				break;
			}
		}
	}
}
