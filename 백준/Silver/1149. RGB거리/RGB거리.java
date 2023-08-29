import java.util.*;
import java.io.*;

//RGB거리
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //집의 수
		int[][] arr = new int[N][3]; //RGB 비용
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] cost = new int[N][3];//RGB 비용
		//f(n)=1인 경우 초기화
		cost[0][0] = arr[0][0];
		cost[0][1] = arr[0][1];
		cost[0][2] = arr[0][2];
		//DP
		for (int i = 1; i < N; i++) {
			//현재 최소 비용은 색 같지 않은 경우에서 최소 비용 + 현재 비용
			cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + arr[i][0];
			cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + arr[i][1];
			cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + arr[i][2];
		}
		System.out.println(Math.min(Math.min(cost[N-1][0], cost[N-1][1]), cost[N-1][2]));
	}

}
