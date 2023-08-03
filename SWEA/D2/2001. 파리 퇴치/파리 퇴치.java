import java.util.*;
import java.io.*;

//파리 퇴치
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //N*N 배열
			int M = Integer.parseInt(st.nextToken()); //영역
			
			int[][] arr = new int[N][N]; //파리 배열
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//최대 파리
			int max = Integer.MIN_VALUE;
			
			//시작 좌표
			for (int i = 0; i <= N-M; i++) {
				for (int j = 0; j <= N-M; j++) {
					int sum = 0; //잡은 파리 합
					//영역만큼 반복
					for (int i2 = i; i2 < i+M; i2++) {
						for (int j2 = j; j2 < j+M; j2++) {
							sum += arr[i2][j2];
						}
					}
					if(max<sum) { //최대 파리 수 갱신
						max = sum;
					}
				}
			}
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.println(sb);
	}

}
