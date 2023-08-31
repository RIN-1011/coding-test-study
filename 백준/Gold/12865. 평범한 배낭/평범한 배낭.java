import java.util.*;
import java.io.*;

//평범한 배낭
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //물품의 수
		int K = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게
		
		int W[] = new int[N+1]; //물건의 무게
		int V[] = new int[N+1]; //물건의 가치
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[][] = new int[N+1][K+1]; //이전 값을 더하므로 여유있게 +1 크기 더해줌
		for (int obj = 1; obj <= N; obj++) {
			for (int w = 1; w <= K; w++) {
				//obj:물건(0~N), w:무게(0~K)
				//배낭에 물건 넣는 경우 or 안넣는 경우
				if(W[obj] <= w) { //현재 물건의 무게가 버틸 수 있는 무게를 초과하지 않는 경우 물건 넣음
					dp[obj][w] = Math.max(dp[obj-1][w], dp[obj-1][w-W[obj]]+V[obj]);
				}
				else { //물건 안넣음
					dp[obj][w] = dp[obj-1][w];
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}
