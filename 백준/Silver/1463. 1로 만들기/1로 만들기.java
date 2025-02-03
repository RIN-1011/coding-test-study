import java.util.*;
import java.io.*;

public class Main {
	static int min;
	
	static void dfs(int N, int cnt) {
		if(N == 1) { //1이 만들어졌을 경우
			min = Math.min(min, cnt); //연산 최솟값 비교
			return;
		}
		if(cnt >= min) { //cnt가 최솟값보다 크거나 같을 경우 더 탐색 안함
			return;
		}
		else {
			if(N%3==0) { //3으로 나누어 떨어질 경우
				dfs(N/3, cnt+1); //3으로 나누기
			}
			if(N%2==0) { //2로 나누어 떨어질 경우
				dfs(N/2, cnt+1); //2로 나누기
			}
			dfs(N-1, cnt+1); //1 빼기
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //정수 N
		
		min = Integer.MAX_VALUE; //연산 최솟값
		
		dfs(N, 0);
		
		System.out.println(min);
	}

}
