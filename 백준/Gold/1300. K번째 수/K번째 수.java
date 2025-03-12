import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //배열의 크기
		int k = Integer.parseInt(br.readLine()); //찾아야 하는 순서
		
		int left = 1; //최소 숫자
		int right = k; //최대 숫자
		
		while(left<right) {
			int mid = (left+right)/2;
			
			//mid보다 작거나 같은 값 개수 계산
			int cnt=0;
			for(int i=1; i<=N; i++) {
				//i*j<=mid, j<=mid/i
				cnt += Math.min(mid/i, N); //배열 크기를 넘을 수는 없음
			}
			//개수가 k보다 크거나 같을 경우 right 감소
			if(k<=cnt) {
				right = mid;
			}
			//개수가 k보다 작을 경우 left 증가
			else {
				left = mid+1;
			}
		}
		System.out.println(left);
	}

}
