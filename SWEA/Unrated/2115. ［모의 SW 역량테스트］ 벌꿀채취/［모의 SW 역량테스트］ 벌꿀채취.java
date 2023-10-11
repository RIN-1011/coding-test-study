import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, C;
	static int[][] pooh;
	static int hap, max; //일꾼 한명 당 채취양, 최대 수익
	
	public static void cal(int x, int y, int yM, int c, int cc) {
		//채취 가능한 양 초과했을 경우 패스
		if(c>C) {
			return;
		}
		//최댓값 갱신
		hap = Math.max(hap, cc);
		for (int i = y; i < yM; i++) {
			cal(x, i+1, yM, c+pooh[x][i], cc+(pooh[x][i]*pooh[x][i]));
		}
	}
	
	//벌통 고르는 조합 (일꾼 수, 벌통 인덱스(작업 위치), 채취양)
	public static void comb(int cnt, int index, int sum) {
		//일꾼 2명 선택했을 경우
		if(cnt == 2) {
			max = Math.max(max, sum);
			return;
		}
		else {
			for (int i = index; i < N*N; i++) {
				int x = i/N; //행
				int y = i%N; //열
				//가로로 연속되지 않을 경우 패스
				if(y > N-M) {
					continue;
				}
				hap = 0;
				//일꾼 당 채취양 계산 (행, 시작 열, 끝 열, 양, 양*양)
				cal(x, y, y+M, 0, 0);
				//일꾼들끼리 겹치게 벌통 선택 불가하므로 i+M
				comb(cnt+1, i+M, sum+hap);
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테케 개수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //벌통 크기
			M = Integer.parseInt(st.nextToken()); //선택할 수 있는 벌통 개수
			C = Integer.parseInt(st.nextToken()); //채취 가능한 최대 양
			
			pooh = new int[N][N]; //벌통
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					pooh[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = Integer.MIN_VALUE;
			comb(0, 0, 0);
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
