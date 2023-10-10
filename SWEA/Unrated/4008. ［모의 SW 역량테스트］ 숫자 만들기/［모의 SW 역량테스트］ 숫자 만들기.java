import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int cnt[]; //수식 개수 배열 (0: '+', 1: '-', 2: 'x', 3: '/')
	static int oper[]; //수식 순열 배열
	static int num[]; //숫자 배열
	static int max; //최댓값
	static int min; //최솟값
	
	//수식 순열
	public static void per(int count) {
		//순열 다 완성됐을 경우 계산
		if(count == N-1) {
			cal();
		}
		else{
			//사칙연산
			for (int i = 0; i < 4; i++) {
				//수식 개수 남아있을 경우
				if(cnt[i]>0) {
					oper[count] = i;
					cnt[i]--; //개수 차감
					per(count+1);
					cnt[i]++; //백트래킹
				}
			}
		}
	}
	//수식 계산
	public static void cal() {
		int result = num[0];
		int idx = 0;
		
		//연산자 수만큼 계산
		for (int i = 0; i < N-1; i++) {
			switch(oper[i]) {
			case 0: //'+'일 경우
				result += num[++idx];
				break;
			case 1: //'-'일 경우
				result -= num[++idx];
				break;
			case 2: //'x'일 경우
				result *= num[++idx];
				break;
			case 3: //'/'일 경우
				result /= num[++idx];
				break;
			}
		}
		//최댓값, 최솟값 갱신
		max = Math.max(max, result);
		min = Math.min(min, result);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테케 개수
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); //숫자 개수
			
			cnt = new int[4]; //수식 배열
			oper = new int[N-1]; //수식 순열 배열
			num = new int[N]; //숫자 배열
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cnt[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE; //최댓값
			min = Integer.MAX_VALUE; //최솟값
			
			per(0);
			
			sb.append("#").append(t).append(" ").append(max-min).append("\n");
		}
		System.out.println(sb);
	}

}
