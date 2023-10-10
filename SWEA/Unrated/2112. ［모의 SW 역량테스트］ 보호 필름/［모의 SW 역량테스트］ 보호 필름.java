import java.util.*;
import java.io.*;

public class Solution {
	static int D, W, K;
	static int[][] map;
	static int[][] copy;
	static boolean[] isSelected; //약품 투입 유무 결정
	static int result; //결과
	
	//약품 투입 막을 선택하기 위한 부분집합
	public static void subset(int cnt) {
		//모두 선택했을 경우 약물 투여
		if(cnt == D) {
			dfs(0, 0);
			//배열 원래대로 돌려놓기
			back();
			return;
		}
		else {
			isSelected[cnt] = true;
			subset(cnt+1);
			isSelected[cnt] = false;
			subset(cnt+1);
		}
	}
	
	//약물 투여 (횟수, 투여할 행)
	public static void dfs(int cnt, int i) {
		//약물 투여 횟수가 K를 넘어가는 경우 더 돌릴 필요 없음
		if(cnt >= K) {
			return;
		}
		//모두 돌았을 경우
		if(i == D) {
			//유효성 검사
			if (check()) {
				result = Math.min(result, cnt);
			}
			return;
		}
		
		//약물 투여하는 셀일 경우
		if(isSelected[i]) {
			//A 약물 투여
			Arrays.fill(map[i], 0);
			dfs(cnt+1, i+1);
			
			//B 약물 투여
			Arrays.fill(map[i], 1);
			dfs(cnt+1, i+1);
		}
		else {
			dfs(cnt, i+1);
		}
	}
	
	public static boolean check() {
		for (int i = 0; i < W; i++) {
			int cnt = 1; //시작점 포함하여 카운트
			int start = map[0][i]; //비교할 시작점
			boolean flag = false; //유효성 여부
			
			for (int j = 1; j < D; j++) {
				//시작점과 셀 특성이 같을 경우 카운트 증가
				if(start == map[j][i]) {
					cnt++;
				}
				//시작점과 셀 특성 다를 경우 카운트 초기화, 시작점 재설정
				else {
					cnt = 1;
					start = map[j][i];
				}
				//합격기준 달성할 경우
				if(cnt == K) {
					flag = true;
					break;
				}
			}
			//한 열이라도 합격기준 달성 못했을 경우 실패
			if(flag == false) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void back() {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = copy[i][j];
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
			D = Integer.parseInt(st.nextToken()); //두께(행)
			W = Integer.parseInt(st.nextToken()); //가로크기(열)
			K = Integer.parseInt(st.nextToken()); //합격기준
			
			result = K; //약품 최소 투입 횟수는 최대 K
			
			map = new int[D][W];
			copy = new int[D][W];
			isSelected = new boolean[D];
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = copy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//약품 투입 안해도 유효성 검사 통과할 경우
			if(check()) {
				sb.append("#").append(t).append(" ").append(0).append("\n");
			}
			else {
				subset(0);
				sb.append("#").append(t).append(" ").append(result).append("\n");				
			}
		}
		System.out.println(sb);
	}

}
