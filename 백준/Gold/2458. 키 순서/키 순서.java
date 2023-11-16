import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][k]==1 && map[k][j]==1) {
						map[i][j]=1;
					}
				}
			}
		}
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int input = 0;
			int out = 0;
			for (int j = 1; j <= N; j++) {
				if(map[j][i]==1) {
					input++;
				}
				else if(map[i][j]==1) {
					out++;
				}
			}
			if(input+out==N-1) {
				result++;
			}
		}
		System.out.println(result);
	}

}
