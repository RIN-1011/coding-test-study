import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //크기
		
		//수열 A 입력
		int[] a = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ldp = new int[N]; //왼쪽 오름차순
		int[] rdp = new int[N]; //오른쪽 오름차순
		
		//왼쪽 오름차순
		for(int i=0; i<N; i++) {
			ldp[i] = 1;
			for(int j=0; j<i; j++) {
				//현재 숫자보다 이전 숫자가 더 작고
				//현재 dp보다 작은 숫자+1 값이 더 큰 경우
				if(a[j]<a[i] && ldp[i]<ldp[j]+1) {
					ldp[i] = ldp[j]+1; //갱신
				}
			}
		}
		
		//오른쪽 오름차순
		for(int i=N-1; i>=0; i--) {
			rdp[i] = 1;
			for(int j=N-1; j>i; j--) {
				//현재 숫자보다 이전 숫자가 더 작고
				//현재 dp보다 작은 숫자+1 값이 더 큰 경우
				if(a[j]<a[i] && rdp[i]<rdp[j]+1) {
					rdp[i] = rdp[j]+1; //갱신
				}
			}
		}
		
		//오름차순 합치기 (바이토닉 수열)
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			dp[i] = ldp[i]+rdp[i]-1;
		}
		
		//최댓값 구하기
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		
	}

}
