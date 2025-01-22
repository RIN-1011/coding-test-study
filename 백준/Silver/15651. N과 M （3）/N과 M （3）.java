import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb;
	static int N, M;
	static int[] number;
	
	static void comb(int cnt) { //중복 조합
		if(cnt == M) { //조합 완료
			for(int n:number) {
				sb.append(n+" ");
			}
			sb.append("\n");
		}
		else {
			for(int i=0; i<N; i++) {
				number[cnt] = i+1;
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
