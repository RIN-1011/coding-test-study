import java.util.*;
import java.io.*;

//장훈이의 높은 선반
public class Solution {
	static int N, B; //점원 명 수, 선반 높이
	static int input[]; //탑 높이
	static boolean isSelected[]; //부분집합 포함 여부
	static int min; //차이 최솟값
	
	public static void subSet(int cnt) {
		//부분 집합 완성된 경우
		if(cnt == N) {
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				//부분집합에 포함되면 탑 높이 더하기
				if(isSelected[i]) {
					sum += input[i];
				}
			}
			//탑 높이가 선반 높이 이상인 경우
			if(sum>=B) {
				min = Math.min(min, sum-B); //최솟값 갱신
			}
			return;
		}
		else {
			isSelected[cnt] = true;
			subSet(cnt+1);
			isSelected[cnt] = false;
			subSet(cnt+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //점원 명 수
			B = Integer.parseInt(st.nextToken()); //선반 높이
			
			//초기화
			input = new int[N];
			isSelected = new boolean[N];
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			//탑 높이
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			//부분 집합
			subSet(0);
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb);
	}

}
