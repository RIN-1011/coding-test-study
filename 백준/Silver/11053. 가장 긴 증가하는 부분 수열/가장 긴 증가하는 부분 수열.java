import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //크기
		
		int[] a = new int[N]; //수열
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N]; //dp
		Arrays.fill(dp, 1); //초기화
		
		for(int i=0; i<N; i++) {
			dp[i] = 1;
			
			for(int j=0; j<i; j++) {
				//현재 값보다 이전 값이 작고
				//작은 값 길이에서 +1한게 더 클 경우
				if(a[j]<a[i] && dp[i]<dp[j]+1) {
					dp[i] = dp[j]+1; //갱신
				}
			}
		}
		
		//최댓값 탐색
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
