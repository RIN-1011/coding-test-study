import java.io.*;
import java.util.*;

public class Solution {
	static int N, B; //점원 수, 탑의 높이
	static int h[];
	static boolean isSelected[]; //부분집합 포함 여부
	static int min = Integer.MAX_VALUE; //탑 높이 최소 차
	
	//부분집합
	public static void subset(int cnt) {
		if(cnt == N) {
			int sum = 0; //점원 키 합
			for (int i = 0; i < N; i++) {
				//부분집합에 포함되는 원소만 합 구하기
				if(isSelected[i]) {
					sum += h[i];
				}
			}
			//높이가 B 이상인 탑 중에서 높이가 가장 낮은 탑 구하기
			if(sum>=B) {
				//최소 차 구하기
				min = Math.min(min, sum-B);
				return;
			}
		}
		else {
			isSelected[cnt] = true;
			subset(cnt+1);
			isSelected[cnt] = false;
			subset(cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //점원 수
			B = Integer.parseInt(st.nextToken()); //탑의 높이
			
			h = new int[N]; //점원 키
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			
			isSelected = new boolean[N];
			min = Integer.MAX_VALUE;
			
			subset(0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

}
