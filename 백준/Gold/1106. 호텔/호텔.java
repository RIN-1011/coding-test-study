import java.util.*;
import java.io.*;

//호텔
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); //늘릴 고객 수
		int N = Integer.parseInt(st.nextToken()); //도시의 개수
		
		int cost[] = new int[N+1]; //홍보 비용
		int cus[] = new int[N+1]; //얻는 고객 수
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			cus[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[][] = new int[N+1][C+1]; //비용 저장 dp배열
		
		for (int i = 0; i < N+1; i++) {
			Arrays.fill(dp[i], 999999999);
		}

//		for (int i = 1; i <= 100; i++) {
//			System.out.print(i + "\t");
//		}
//		System.out.println();
//		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 1; i <= N; i++) {
			for (int c = 1; c <= C; c++) {
				if(c-cus[i]<=0) { //배열 범위 벗어나는 것 방지
					dp[i][c] = Math.min(dp[i-1][c], cost[i]); //이미 고객 수가 넘치므로 현재 비용과 i-1 비용 비교
				}
				else {
					dp[i][c] = Math.min(dp[i-1][c], Math.min(dp[i][c-cus[i]]+cost[i], dp[i-1][c-cus[i]]+cost[i]));
				}
				if(dp[i][c] == 0) { //min값이 0이 되는 것 방지
					dp[i][c] = dp[i][c-cus[i]]+cost[i];
				}
//				System.out.print(dp[i][c] + "\t");
			}
//			System.out.println();
		}
		System.out.println(dp[N][C]);
	}

}
