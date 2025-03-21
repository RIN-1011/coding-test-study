import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		//LCS 최대 길이
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		
		for(int i=1; i<=str1.length(); i++) {
			for(int j=1; j<=str2.length(); j++) {
				//알파벳 같을 경우
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					//대각선 이전 값에서 1 더하기
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				//알파벳 다를 경우
				else {
					//이전 결과 중 더 큰 값
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[str1.length()][str2.length()]);
	}

}
