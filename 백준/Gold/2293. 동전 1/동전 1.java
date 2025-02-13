import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //동전 종류
		int k = Integer.parseInt(st.nextToken()); //가치의 합
		
		//동전 종류 입력 받기
		int[] coin = new int[n];
		for(int i=0; i<n; i++){
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		//dp 배열
		int[] dp = new int[k+1];
		
		//초기화
		dp[0] = 0;
		for(int i=1; i<=k; i++) {
			//가치가 동전 단위보다 크거나 같은 경우
			if(coin[0]<=i) {
				if(i%coin[0]==0) {
					dp[i] = 1;
				}
			}
		}
		
		//동전 종류별로 가짓수 체크
		for(int i=1; i<n; i++) {
			for(int j=1; j<=k; j++) {
				//가치가 동전 단위보다 크거나 같은 경우
				if(coin[i]<=j) {
					//동전 단위와 가치가 일치할 경우
					if(coin[i]==j) {
						dp[j]++; //가짓수 증가
					}
					else {
						//이전 단위에서 체크한 가짓수 + 동전 단위만큼 차감한 가짓수
						dp[j] = dp[j] + dp[j-coin[i]];
					}
				}
			}
		}
		System.out.println(dp[k]);
	}

}
