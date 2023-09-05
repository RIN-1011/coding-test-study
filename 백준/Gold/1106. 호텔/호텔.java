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
		
		int dp[] = new int[C+101]; //비용 저장 dp배열
		//초기화
		Arrays.fill(dp, 999999999);
		dp[0] = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken()); //홍보 비용
			int cus = Integer.parseInt(st.nextToken()); //얻는 고객 수
			for (int j = cus; j < C+101; j++) {
				//현재 dp에 저장된 값과 새로운 값 비교
				dp[j] = Math.min(dp[j], dp[j-cus]+cost);
			}
		}
		//적어도 C명의 고객 이상 확보했을 때 최소 비용 찾기
		int result = Integer.MAX_VALUE;
		for (int i = C; i < C+101; i++) {
			result = Math.min(result, dp[i]);
		}
		System.out.println(result);
	}

}
