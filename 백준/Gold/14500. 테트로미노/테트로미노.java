import java.util.*;
import java.io.*;

public class Main {
	static int N, M; //세로, 가로
	static int[][] arr;
	//테트로미노
	static int[][] dx = {
		{0, 0, 0, 0}, {0, 1, 2, 3}, {0, 0, 1, 1}, {0, 1, 2, 2},
		{0, 0, 0, 1}, {0, 0, 1, 2}, {0, 0, 0, -1}, {0, 0, -1, -2},
		{0, 1, 1, 1}, {0, 0, 1, 2}, {0, 0, 0, 1}, {0, 1, 1, 2},
		{0, 0, -1, -1}, {0, 0, -1, 1}, {0, 0, 1, 1}, {0, 0, 0, 1},
		{0, 1, 1, 2}, {0, -1, 0, 0}, {0, 1, 1, 2}
	};
	static int[][] dy = {
		{0, 1, 2, 3}, {0, 0, 0, 0}, {0, 1, 0, 1}, {0, 0, 0, 1},
		{0, 1, 2, 0}, {0, 1, 1, 1}, {0, 1, 2, 2}, {0, 1, 1, 1},
		{0, 0, 1, 2}, {0, 1, 0, 0}, {0, 1, 2, 2}, {0, 0, 1, 1},
		{0, 1, 1, 2}, {0, 1, 1, 0}, {0, 1, 1, 2}, {0, 1, 2, 1},
		{0, 0, -1, 0}, {0, 1, 1, 2}, {0, 0, 1, 0}
	};
	static int result; //최댓값
	
	static void sum(int a, int b) {
		for(int i=0; i<19; i++) {
			int max = 0;
			int j;
			for(j=0; j<4; j++) {
				int x = a+dx[i][j];
				int y = b+dy[i][j];
				
				//범위 벗어날 경우 다음 테트로미노로
				if(x<0 || x>=N || y<0 || y>=M) {
					break;
				}
				//값 더하기
				max += arr[x][y];
			}
			if(j==4) {
				//최댓값 갱신
				result = Math.max(result, max);
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = Integer.MIN_VALUE;
		
		//모든 경우 확인
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sum(i, j);
			}
		}
		System.out.println(result);
	}

}
