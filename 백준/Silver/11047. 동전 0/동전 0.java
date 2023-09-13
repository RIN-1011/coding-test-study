import java.util.*;
import java.io.*;

//동전 0
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //동전 종류
		int K = Integer.parseInt(st.nextToken()); //동전 합
		
		//동전 가치
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0; //동전 개수 최솟값
		//가치가 큰 순서대로 동전 사용하기
		for (int i = N-1; i >= 0; i--) {
			if(K/a[i]>0) {
				result += K/a[i]; //동전 개수 카운트
				K = K%a[i]; //남은 K값
			}
		}
		System.out.println(result);
	}

}
