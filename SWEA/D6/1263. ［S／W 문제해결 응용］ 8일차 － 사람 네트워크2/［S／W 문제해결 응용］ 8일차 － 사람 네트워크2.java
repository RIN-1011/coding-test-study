import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테케 개수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					//자기 자신이 아니고 인접해있지 않을 경우 INF
					if(i!=j && map[i][j]==0) {
						map[i][j] = 9999999;
					}
				}
			}
			
			for (int k = 0; k < N; k++) {
				//경유지 없는 경우 패스
				for (int i = 0; i < N; i++) {
					if(i==k) continue;
					for (int j = 0; j < N; j++) {
						//출도착 지점 같거나 경유지 없는 경우 패스
						if(i==j || k==j) continue;
						
						//경유지를 거쳐가는게 더 최단 경로일 경우
						if(map[i][j]>map[i][k]+map[k][j]) {
							//최단경로 갱신
							map[i][j] = map[i][k]+map[k][j];
						}
					}
				}
			}
			
			//모든 정점에 대한 최단경로 합 계산 -> 최솟값 찾기
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += map[i][j];
				}
				min= Math.min(min, sum);
			}
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

}
