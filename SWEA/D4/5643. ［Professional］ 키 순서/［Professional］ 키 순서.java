import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트케이스 개수
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); //학생들의 수
			int M = Integer.parseInt(br.readLine()); //키 비교 횟수
			
			int[][] arr = new int[N+1][N+1]; //인접행렬
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				//번호가 a인 학생이 번호가 b인 학생보다 키가 작음
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a][b] = 1;
			}
			//플로이드워샬
			//자신보다 큰 학생 모두 체크
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if(arr[i][k]==1 && arr[k][j]==1) {
							arr[i][j] = 1;
						}
					}
				}
			}
			
			int result = 0; //최종 결과
			for (int i = 1; i <= N; i++) {
				int lCnt = 0; //자신보다 키 작은 학생 수
				int hCnt = 0; //자신보다 키 큰 학생 수
				for (int j = 1; j <= N; j++) {
					//자신보다 키 큰 학생 수
					if(arr[i][j] == 1) {
						lCnt++;
					}
					//자신보다 키 작은 학생 수
					else if(arr[j][i] == 1) {
						hCnt++;
					}
				}
				//자신보다 키 큰,작은 학생수 합이 전체 학생수-1이면 자신의 키가 몇 번째인지 알 수 있음
				if(lCnt+hCnt == N-1) {
					result++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
