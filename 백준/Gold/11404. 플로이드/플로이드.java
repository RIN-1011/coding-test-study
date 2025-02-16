import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); //도시 개수
		int m = Integer.parseInt(br.readLine()); //버스 개수
		
		int[][] dist = new int[n+1][n+1]; //최소 거리
		//초기화
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				//자기 자신은 0
				if(i==j) {
					dist[i][j] = 0;
				}
				//나머지 무한
				else {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		//버스 입력
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //시작 도시
			int b = Integer.parseInt(st.nextToken()); //도착 도시
			int c = Integer.parseInt(st.nextToken()); //비용
			
			//단방향
			dist[a][b] = Math.min(dist[a][b], c);
		}
		//플로이드 워셜
		for(int k=1; k<=n; k++) { //거쳐갈 도시
			for(int i=1; i<=n; i++) { //시작 도시
				for(int j=1; j<=n; j++) { //도착 도시
					if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE) {
						//거쳐가는게 더 빠를 경우 갱신
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
		}
		//결과 출력
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				sb.append(dist[i][j]==Integer.MAX_VALUE ? 0:dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
