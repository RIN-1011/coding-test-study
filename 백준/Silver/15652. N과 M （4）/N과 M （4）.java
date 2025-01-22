import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb;
	static int N, M;
	static int[] number; //완성된 수열
	
	static void comb(int cnt) {
		if(cnt==M) { //수열 완성
			for(int n:number) {
				sb.append(n+" ");
			}
			sb.append("\n");
		}
		else {
			for(int i=1; i<=N; i++) {
				if(cnt > 0) {
					if(number[cnt-1] > i) { //비내림차순 아닐 경우
						continue; //패스
					}
					number[cnt] = i; //비내림차순일 경우 저장
				}
				else { //수열 첫 번째 수는 바로 저장
					number[cnt] = i;
				}
				comb(cnt+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //자연수
		M = Integer.parseInt(st.nextToken()); //선택 개수
		
		number = new int[M]; //초기화
		
		comb(0);
		
		System.out.println(sb);
		
	}

}
