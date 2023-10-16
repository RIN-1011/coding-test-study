import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static char[][] chess;
	//비교할 체스판 경우 2가지
	static char[][] ori1 = {{'W','B','W','B','W','B','W','B'}, {'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'}, {'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'}, {'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'}, {'B','W','B','W','B','W','B','W'}};
	static char[][] ori2 = {{'B','W','B','W','B','W','B','W'}, {'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'}, {'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'}, {'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'}, {'W','B','W','B','W','B','W','B'}};
	static int min; //다시 칠해야 하는 정사각형 개수 최솟값
	
	public static void check(int x, int y) {
		int cnt1 = 0, cnt2 = 0; //칠해야 하는 개수
		
		//첫번째 체스판과 비교
		int k=0, w=0;
		for (int i = x; i < x+8; i++) {
			for (int j = y; j < y+8; j++) {
				//체스판을 칠해야 할 경우 카운트 증가
				if(chess[i][j]!=ori1[k][w]) {
					cnt1++;
				}
				w++;
			}
			w=0;
			k++;
		}
		//두번째 체스판과 비교
		k=0; w=0;
		for (int i = x; i < x+8; i++) {
			for (int j = y; j < y+8; j++) {
				//체스판을 칠해야 할 경우 카운트 증가
				if(chess[i][j]!=ori2[k][w]) {
					cnt2++;
				}
				w++;
			}
			w=0;
			k++;
		}
		//최솟값 구하기
		int tmp = Math.min(cnt1, cnt2);
		min = Math.min(min, tmp);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //행
		int M = Integer.parseInt(st.nextToken()); //열
		
		chess = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				chess[i][j] = str.charAt(j);
			}
		}
		
		min = Integer.MAX_VALUE;
		//브루트포스
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				check(i, j);
			}
		}
		
		System.out.println(min);
	}

}
